<?php /* BeginFeature:Vehicle */
Yii::import('application.models._base.BaseVehicle');

class Vehicle extends BaseVehicle
{
    /* BeginFeature:Manufacturer */   
    public $id_manufacturer;
    /* EndFeature:Manufacturer */
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    protected function afterFind() {
        /* BeginFeature:Manufacturer */
        if (!$this->isNewRecord) {
            $this->id_manufacturer = isset($this->idVehicleModel) ? $this->idVehicleModel->id_manufacturer : null;
        }
        /* EndFeature:Manufacturer */
        parent::afterFind();
    }    
    
    public function attributeLabels() {
        $b = parent::attributeLabels();
        $a = array(
            /* BeginFeature:Manufacturer */
            'id_manufacturer' => 'Manufacturer',
            /* EndFeature:Manufacturer */
        );
        return CMap::mergeArray($a, $b);
    }    
    
    public function rules() {
        $b = parent::rules();
        $a = array(            
            array('code','unique'),
            /* BeginFeature:Manufacturer */
            array('id_manufacturer','safe'),
            /* EndFeature:Manufacturer */            
        );
        
        return CMap::mergeArray($a, $b);
    }    
}
/* EndFeature:Vehicle */