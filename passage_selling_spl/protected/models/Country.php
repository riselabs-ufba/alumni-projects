<?php /* BeginFeature:Country */
Yii::import('application.models._base.BaseCountry');

class Country extends BaseCountry
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
/* EndFeature:Country */