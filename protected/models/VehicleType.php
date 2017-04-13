<?php /* BeginFeature:VehicleType */
Yii::import('application.models._base.BaseVehicleType');

class VehicleType extends BaseVehicleType
{    
    const BUS = 1;
    const PLANE = 2;    
    const BOAT = 3;  
    
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
/* EndFeature:VehicleType */