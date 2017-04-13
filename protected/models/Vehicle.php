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
    
    public static function label($n = 1) {                    
                    /* BeginFeature:Boat*/
                    $label = 'Boat|Boat'; 
                    /* EndFeature:Boat*/                    
                    /* BeginFeature:Bus*/
                    $label = 'Bus|Bus'; 
                    /* EndFeature:Bus*/
                    /* BeginFeature:Plane*/
                    $label = 'Plane|Planes'; 
                    /* EndFeature:Plane*/  
                    /* BeginFeature:FeatureManager*/
                    $label = 'Vehicle|Vehicles'; 
                    /* EndFeature:FeatureManager*/
            return Yii::t('app', $label, $n);
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