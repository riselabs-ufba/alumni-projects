<?php /* BeginFeature:Luggage */
Yii::import('application.models._base.BaseLuggage');

class Luggage extends BaseLuggage
{
    /* BeginFeature:Passenger */
    public $id_passenger;
    /* EndFeature:Passenger */
    
    public static function model($className=__CLASS__) {
            return parent::model($className);
    }
    
    protected function afterFind() {
        /* BeginFeature:Passenger */
        if (!$this->isNewRecord) {
            $this->id_passenger = isset($this->idTicket) ? $this->idTicket->id_passenger : null;
        }
        /* EndFeature:Passenger */
        parent::afterFind();
    }    
    
    public function rules() {
        $b = parent::rules();
        $a = array(
            /* BeginFeature:Passenger */
            array('id_passenger','safe'),
            /* EndFeature:Passenger */            
        );
        
        return CMap::mergeArray($a, $b);
    }
    
    public function attributeLabels() {
        $b = parent::attributeLabels();
        $a = array(
            /* BeginFeature:Passenger */
            'id_passenger' => 'Passenger',
            /* EndFeature:Passenger */
        );
        return CMap::mergeArray($a, $b);
    }    

    public function search() {
            $criteria = new CDbCriteria;

            $criteria->compare('id', $this->id);
            /* BeginFeature:Ticket */
            $criteria->compare('id_ticket', $this->id_ticket);
            /* EndFeature:Ticket */
            $criteria->compare('code', $this->code);
            $criteria->compare('description', $this->description, true);
            $criteria->compare('weight', $this->weight);
            $criteria->compare('special', $this->special);
            $criteria->compare('animal', $this->animal);
            $criteria->compare('music_instrument', $this->music_instrument);
            $criteria->compare('out_of_dimensions', $this->out_of_dimensions);

            /* BeginFeature:Passenger */
            $criteria->with = array('idTicket');
            $criteria->compare('idTicket.id_passenger', $this->id_passenger);
            /* EndFeature:Passenger */                

            return new CActiveDataProvider($this, array(
                    'criteria' => $criteria,
            ));
    }    
}
/* EndFeature:Luggage */