<?php /* BeginFeature:SeatType */
Yii::import('application.models._base.BaseSeatType');

class SeatType extends BaseSeatType
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            array('name','unique'),
        );
        return CMap::mergeArray($a, $b);
    }
    
}
/* EndFeature:SeatType */