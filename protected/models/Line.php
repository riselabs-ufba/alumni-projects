<?php

/* BeginFeature:Line */
Yii::import('application.models._base.BaseLine');

class Line extends BaseLine {

    public static function model($className = __CLASS__) {
        return parent::model($className);
    }

    public function rules() {
        $b = parent::rules();
        $a = array(
            array('name', 'unique'),
            array('id_station_arrival', 'compare', 'compareAttribute' => 'id_station_departure', 'operator' => '!=', 'message' => '{attribute} must be different from Departure Station.'),
        );
        return CMap::mergeArray($a, $b);
    }

    public function attributeLabels() {
        $a = parent::attributeLabels();
        $b = array(
            /* BeginFeature:Station */
            'id_station_departure' => 'Departure Station ',
            /* EndFeature:Station */
            /* BeginFeature:Station */
            'id_station_arrival' => 'Arrival Station ',
                /* EndFeature:Station */
        );

        return CMap::mergeArray($a, $b);
    }

}

/* EndFeature:Line */