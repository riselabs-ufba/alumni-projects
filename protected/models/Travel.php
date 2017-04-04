<?php /* BeginFeature:Travel */
Yii::import('application.models._base.BaseTravel');

class Travel extends BaseTravel
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function behaviors() {
        return array(
            'DatetimeI18NBehavior' =>
            'ext.DateTimeI18NBehavior',
        );
    }    
    
    public function rules() {
        $parentRules = parent::rules();
        $childRules = array(
            array('start_date, end_date', 'date', 'format' => 'M/d/yyyy H:m:s'),
            array('end_date',
                'ext.EDateCompare',
                'compareAttribute' => 'start_date',
                'dateFormat' => 'm/d/Y H:i:s',
                'operator' => '>',
            ),
            array('start_date',
                'ext.EDateCompare',
                'compareValue' => date('m/d/Y H:i'),
                'dateFormat' => 'm/d/Y H:i:s',
                'operator' => '>',
            ),            
        );
        return CMap::mergeArray($parentRules, $childRules);
    }

    /* BeginFeature:PrintPassenger */
    public function getPassengerListPerSegment(){
        $query = 'select sd.name departure, sa.name arrival, p.name passenger, vs.code vehicle_seat
                from ticket t 
                join ticket_segment ts on t.id = ts.id_ticket
                left join vehicle_seat vs on vs.id = ts.id_vehicle_seat
                join segment s on s.id = ts.id_segment
                join station sd on sd.id = s.id_station_departure
                join station sa on sa.id = s.id_station_arrival
                join passenger p on p.id = t.id_passenger
                where t.id_travel = :id_travel
                order by s.sequence_number, p.name';
        
        return Yii::app()->db->createCommand($query)->queryAll(true, array(':id_travel' => $this->id));
    }
    /* EndFeature:PrintPassenger */
    
}
/* EndFeature:Travel */