<?php /* BeginFeature:Station */
Yii::import('application.models._base.BaseStation');

class Station extends BaseStation
{
    
    /* BeginFeature:Country */
    public $id_country;    
    /* EndFeature:Country */
    /* BeginFeature:State */
    public $id_state;    
    /* EndFeature:State */ 
    
    protected function afterFind() {
        
        if (!$this->isNewRecord) {
            /* BeginFeature:Country */
            $this->id_country = isset($this->idCity) ? $this->idCity->idState->id_country : null;
            /* EndFeature:Country */
            /* BeginFeature:State */
            $this->id_state = isset($this->idCity) ? $this->idCity->id_state : null;
            /* EndFeature:State */            
        }
        
        parent::afterFind();
    }    
    
    public function attributeLabels() {
        $b = parent::attributeLabels();
        $a = array(
            /* BeginFeature:Country */
            'id_country' => 'Country',
            /* EndFeature:Country */
            /* BeginFeature:State */
            'id_state' => 'State',
            /* EndFeature:State */            
        );
        return CMap::mergeArray($a, $b);
    }    
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:Country */
            array('id_country','safe'),
            /* EndFeature:Country */            
            /* BeginFeature:State */
            array('id_state','safe'),
            /* EndFeature:State */             
            /* BeginFeature:State */
            array('name','ext.UniqueAttributesValidator','with' => 'id_city'),
            /* EndFeature:State */
        );
        
        return CMap::mergeArray($a, $b);
    }     
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function scopes() {
        return array(
            'airport' => array(
                'condition' => 'id_vehicle_type = :airport',
                'params' => array(
                    ':airport' => VehicleType::PLANE,
                ),                
            ),
        );
    }
}
/* EndFeature:Station */