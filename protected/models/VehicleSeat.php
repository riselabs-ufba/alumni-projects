<?php /* BeginFeature:VehicleSeat */
Yii::import('application.models._base.BaseVehicleSeat');

class VehicleSeat extends BaseVehicleSeat
{
    /* BeginFeature:BatchRegistration */    
    public $quantity;
    /* EndFeature:BatchRegistration */
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            array('code','ext.UniqueAttributesValidator','with' => 'id_vehicle'),
            array('position','ext.UniqueAttributesValidator','with' => 'id_vehicle'),            
            /* BeginFeature:BatchRegistration */
            array('quantity','required', 'on' => 'batch'),
            array('quantity','numerical', 'integerOnly' => true),
            /* EndFeature:BatchRegistration */
        );
        
        return CMap::mergeArray($a, $b);
    }    
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    /* BeginFeature:BatchRegistration */    
    public function batchRegistration(){
        $query = 'select coalesce(max(id),0)+1 from vehicle_seat';
        $nextId = Yii::app()->db->createCommand($query)->queryScalar();
        for ($index = 0; $index < $this->quantity; $index++) {
            $model = new VehicleSeat();
            /* BeginFeature:SeatType */
            $model->id_seat_type = $this->id_seat_type;
            /* EndFeature:SeatType */
            $model->id_vehicle = $this->id_vehicle;
            $model->code = $nextId;
            $model->position = $nextId;
            
            $model->save();
            $nextId++;
        }
        
        return true;
    }
    /* EndFeature:BatchRegistration */    
}
/* EndFeature:VehicleSeat */