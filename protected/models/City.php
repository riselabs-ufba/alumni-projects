<?php /* BeginFeature:City */
Yii::import('application.models._base.BaseCity');

class City extends BaseCity
{
    /* BeginFeature:Country */
    public $id_country;    
    /* EndFeature:Country */
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:Country */
            array('id_country','safe'),
            /* EndFeature:Country */            
            /* BeginFeature:State */
            array('name','ext.UniqueAttributesValidator','with' => 'id_state'),
            /* EndFeature:State */
        );
        
        return CMap::mergeArray($a, $b);
    }    
    
    protected function afterFind() {
        /* BeginFeature:Country */
        if (!$this->isNewRecord) {
            $this->id_country = isset($this->idState) ? $this->idState->id_country : null;
        }
        /* EndFeature:Country */
        parent::afterFind();
    }
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function attributeLabels() {
        $b = parent::attributeLabels();
        $a = array(
            /* BeginFeature:Country */
            'id_country' => 'Country',
            /* EndFeature:Country */
        );
        return CMap::mergeArray($a, $b);
    }
    
    public function search() {
            $criteria = new CDbCriteria;

            $criteria->compare('id', $this->id);
            /* BeginFeature:State */
            $criteria->compare('id_state', $this->id_state);
            /* EndFeature:State */
            $criteria->compare('name', $this->name, true);
            
            /* BeginFeature:Country */
            $criteria->with = array('idState');
            $criteria->compare('id_country', $this->id_country);
            /* EndFeature:Country */            

            return new CActiveDataProvider($this, array(
                    'criteria' => $criteria,
            ));
    }    
}
/* EndFeature:City */