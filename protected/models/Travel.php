<?php /* BeginFeature:Travel */
Yii::import('application.models._base.BaseTravel');

class Travel extends BaseTravel
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function behaviors() {
        return array(
            'DatetimeI18NBehavior' =>
            'ext.DateTimeI18NBehavior',
        );
    }    
    
    public function rules() {
        $parentRules = parent::rules();
        $childRules = array(
            array('start_date, end_date', 'date', 'format' => 'M/d/yyyy H:m'),
            array('end_date',
                'ext.EDateCompare',
                'compareAttribute' => 'start_date',
                'dateFormat' => 'm/d/Y H:i',
                'operator' => '>',
            ),
            array('start_date',
                'ext.EDateCompare',
                'compareValue' => date('m/d/Y H:i'),
                'dateFormat' => 'm/d/Y H:i',
                'operator' => '>',
            ),            
        );
        return CMap::mergeArray($parentRules, $childRules);
    }    
}
/* EndFeature:Travel */