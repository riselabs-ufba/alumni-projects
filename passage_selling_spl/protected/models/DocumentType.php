<?php /* BeginFeature:DocumentType */
Yii::import('application.models._base.BaseDocumentType');

class DocumentType extends BaseDocumentType
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
/* EndFeature:DocumentType */