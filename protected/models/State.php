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
            array('code','ext.UniqueAttributesValidator','with' => 'id_country')
        );
        
        return CMap::mergeArray($a, $b);
    }
}
/* EndFeature:State */