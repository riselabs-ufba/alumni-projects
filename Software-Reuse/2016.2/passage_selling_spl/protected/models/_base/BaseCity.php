<?php /* BeginFeature:City */
/**
 * This is the model base class for the table "city".
 * DO NOT MODIFY THIS FILE! It is automatically generated by giix.
 * If any changes are necessary, you must set or override the required
 * property or method in class "City".
 *
 * Columns in table "city" available as properties of the model,
 * followed by relations of table "city" available as properties of the model.
 *
 * @property integer $id    
 * BeginFeature:State    
 * @property integer $id_state
 * EndFeature:State    
 * @property string $name    
 *
 * BeginFeature:State
 * @property State $idState
 * EndFeature:State
 * BeginFeature:Passenger
 * @property Passenger[] $passengers
 * EndFeature:Passenger
 * BeginFeature:Station
 * @property Station[] $stations
 * EndFeature:Station
 */
abstract class BaseCity extends GxActiveRecord {

	public static function model($className=__CLASS__) {
		return parent::model($className);
	}

	public function tableName() {
		return 'city';
	}

	public static function label($n = 1) {
		return Yii::t('app', 'City|Cities', $n);
	}

	public static function representingColumn() {
		return 'name';
	}

	public function rules() {
		return array(
			array(
			/* BeginFeature:State */
			'id_state, '.
			/* EndFeature:State */
			'name', 'required'),
			array('id_state', 'numerical', 'integerOnly'=>true),
			array('name', 'length', 'max'=>45),
			array('id, id_state, name', 'safe', 'on'=>'search'),
		);
	}

	public function relations() {
		return array(
            		/* BeginFeature:State */
			'idState' => array(self::BELONGS_TO, 'State', 'id_state'),
            		/* EndFeature:State */
            		/* BeginFeature:Passenger */
			'passengers' => array(self::HAS_MANY, 'Passenger', 'id_city'),
            		/* EndFeature:Passenger */
            		/* BeginFeature:Station */
			'stations' => array(self::HAS_MANY, 'Station', 'id_city'),
            		/* EndFeature:Station */
		);
	}

	public function pivotModels() {
		return array(
		);
	}

	public function attributeLabels() {
		return array(
			'id' => Yii::t('app', 'ID'),
			/* BeginFeature:State */
			'id_state' => null,
			/* EndFeature:State */
			'name' => Yii::t('app', 'Name'),
			/* BeginFeature:State */
			'idState' => null,
			/* EndFeature:State */
			/* BeginFeature:Passenger */
			'passengers' => null,
			/* EndFeature:Passenger */
			/* BeginFeature:Station */
			'stations' => null,
			/* EndFeature:Station */
		);
	}

	public function search() {
		$criteria = new CDbCriteria;

		$criteria->compare('id', $this->id);
		/* BeginFeature:State */
		$criteria->compare('id_state', $this->id_state);
		/* EndFeature:State */
		$criteria->compare('name', $this->name, true);

		return new CActiveDataProvider($this, array(
			'criteria' => $criteria,
		));
	}
}
/* EndFeature:City */