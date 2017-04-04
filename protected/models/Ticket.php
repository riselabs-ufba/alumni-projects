<?php /* BeginFeature:Ticket */
Yii::import('application.models._base.BaseTicket');

class Ticket extends BaseTicket
{
    /* BeginFeature:Line */
    public $id_line;
    /* EndFeature:Line */
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    protected function beforeDelete() {
        $attributes = array('id_ticket' => $this->id);
        TicketSegment::model()->deleteAllByAttributes($attributes);
        Luggage::model()->deleteAllByAttributes($attributes);
        
        return parent::beforeDelete();
    }
    
    public function attributeLabels() {
        $a = parent::attributeLabels();
        $b = array(
            /* BeginFeature:Line */
            'id_line' => Line::label(),
            /* EndFeature:Line */            
            /* BeginFeature:Station */
            'id_station_arrival' => 'Arrival Station',
            'id_station_departure' => 'Departure Station',
            'idStationArrival' => 'Arrival Station',
            'idStationDeparture' => 'Departure Station',
            /* EndFeature:Station */
        );

        return CMap::mergeArray($a, $b);
    }
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:Line */
            array('id_line','safe'),
            /* EndFeature:Line */            
        );
        
        return CMap::mergeArray($a, $b);
    }
    
    public function save($runValidation = true, $attributes = null) {
        $validated = parent::save($runValidation, $attributes);
        $sqlDeparture = '(select sequence_number from segment where id_line = :id_line and id_station_departure = :id_station_departure)';
        $sqlArrival = '(select sequence_number from segment where id_line = :id_line and id_station_arrival = :id_station_arrival)';
        $condition = "id_line = :id_line and sequence_number between {$sqlDeparture} and {$sqlArrival}";
        $params = array(
            ':id_line' => $this->id_line,
            ':id_station_departure' => $this->id_station_departure,
            ':id_station_arrival' => $this->id_station_arrival,
        );
        $segments = Segment::model()->findAll($condition, $params);
        
        foreach ($segments as $segment) {
            $ticketSegment = new TicketSegment();
            $ticketSegment->id_ticket = $this->id;
            $ticketSegment->id_segment = $segment->id;
            $validated = $validated && $ticketSegment->save();
        }
        
        return $validated;
    }
    
}
/* EndFeature:Ticket */