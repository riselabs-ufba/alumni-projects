<?php /* BeginFeature:State */
Yii::import('application.models._base.BaseState');

class State extends BaseState
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:Country */
            array('code','ext.UniqueAttributesValidator','with' => 'id_country')
            /* EndFeature:Country */
        );
        
        return CMap::mergeArray($a, $b);
    }
}
/* EndFeature:State */