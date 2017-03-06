<?php /* BeginFeature:Segment */
Yii::import('application.models._base.BaseSegment');

class Segment extends BaseSegment
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function attributeLabels() {
        $a = parent::attributeLabels();
        $b = array(
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
            array('sequence_number','ext.UniqueAttributesValidator','with' => 'id_line'),
            array('id_station_departure','ext.UniqueAttributesValidator','with' => 'id_line'),
            array('sequence_number','ext.UniqueAttributesValidator','with' => 'id_line'),
            /* EndFeature:Line */
        );
        
        return CMap::mergeArray($a, $b);
    }
}
/* EndFeature:Segment */