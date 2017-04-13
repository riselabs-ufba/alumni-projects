<?php /* BeginFeature:Passenger */
Yii::import('application.models._base.BasePassenger');

class Passenger extends BasePassenger
{
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:DocumentType */
            array('document','ext.UniqueAttributesValidator','with' => 'id_document_type'),
            /* EndFeature:DocumentType */
            array('email','email'),
        );
        
        return CMap::mergeArray($a, $b);
    }    
}
/* EndFeature:Passenger */