<?php /* BeginFeature:Ticket */
/**
 * This is the model base class for the table "ticket".
 * DO NOT MODIFY THIS FILE! It is automatically generated by giix.
 * If any changes are necessary, you must set or override the required
 * property or method in class "Ticket".
 *
 * Columns in table "ticket" available as properties of the model,
 * followed by relations of table "ticket" available as properties of the model.
 *
 * @property integer $id    
 * BeginFeature:Travel    
 * @property integer $id_travel
 * EndFeature:Travel    
 * BeginFeature:Passenger    
 * @property integer $id_passenger
 * EndFeature:Passenger    
 * @property double $total_price    
 * BeginFeature:Station    
 * @property integer $id_station_departure
 * EndFeature:Station    
 * BeginFeature:Station    
 * @property integer $id_station_arrival
 * EndFeature:Station    
 *
 * BeginFeature:Luggage
 * @property Luggage[] $luggages
 * EndFeature:Luggage
 * BeginFeature:Station
 * @property Station $idStationArrival
 * EndFeature:Station
 * BeginFeature:Station
 * @property Station $idStationDeparture
 * EndFeature:Station
 * BeginFeature:Passenger
 * @property Passenger $idPassenger
 * EndFeature:Passenger
 * BeginFeature:Travel
 * @property Travel $idTravel
 * EndFeature:Travel
 * BeginFeature:TicketSegment
 * @property TicketSegment[] $ticketSegments
 * EndFeature:TicketSegment
 */
abstract class BaseTicket extends GxActiveRecord {

	public static function model($className=__CLASS__) {
		return parent::model($className);
	}

	public function tableName() {
		return 'ticket';
	}

	public static function label($n = 1) {
		return Yii::t('app', 'Ticket|Tickets', $n);
	}

	public static function representingColumn() {
		return 'id';
	}

	public function rules() {
		return array(
			array(
			/* BeginFeature:Travel */
			'id_travel, '.
			/* EndFeature:Travel */
			
			/* BeginFeature:Passenger */
			'id_passenger, '.
			/* EndFeature:Passenger */
			'total_price, '.
			/* BeginFeature:Station */
			'id_station_departure, '.
			/* EndFeature:Station */
			'id_station_arrival', 'required'),
			array(
			/* BeginFeature:Travel */
			'id_travel, '.
			/* EndFeature:Travel */
			
			/* BeginFeature:Passenger */
			'id_passenger, '.
			/* EndFeature:Passenger */
			
			/* BeginFeature:Station */
			'id_station_departure, '.
			/* EndFeature:Station */
			'id_station_arrival', 'numerical', 'integerOnly'=>true),
			array('total_price', 'numerical'),
			array('id, '.
			/* BeginFeature:Travel */
			'id_travel, '.
			/* EndFeature:Travel */
			
			/* BeginFeature:Passenger */
			'id_passenger, '.
			/* EndFeature:Passenger */
			'total_price, '.
			/* BeginFeature:Station */
			'id_station_departure, '.
			/* EndFeature:Station */
			'id_station_arrival', 'safe', 'on'=>'search'),
		);
	}

	public function relations() {
		return array(
            		/* BeginFeature:Luggage */
			'luggages' => array(self::HAS_MANY, 'Luggage', 'id_ticket'),
            		/* EndFeature:Luggage */
            		/* BeginFeature:Station */
			'idStationArrival' => array(self::BELONGS_TO, 'Station', 'id_station_arrival'),
            		/* EndFeature:Station */
            		/* BeginFeature:Station */
			'idStationDeparture' => array(self::BELONGS_TO, 'Station', 'id_station_departure'),
            		/* EndFeature:Station */
            		/* BeginFeature:Passenger */
			'idPassenger' => array(self::BELONGS_TO, 'Passenger', 'id_passenger'),
            		/* EndFeature:Passenger */
            		/* BeginFeature:Travel */
			'idTravel' => array(self::BELONGS_TO, 'Travel', 'id_travel'),
            		/* EndFeature:Travel */
            		/* BeginFeature:TicketSegment */
			//'ticketSegments' => array(self::HAS_MANY, 'TicketSegment', 'id_ticket'),
            		/* EndFeature:TicketSegment */
		);
	}

	public function pivotModels() {
		return array(
		);
	}

	public function attributeLabels() {
		return array(
			'id' => Yii::t('app', 'ID'),
			/* BeginFeature:Travel */
			'id_travel' => null,
			/* EndFeature:Travel */
			/* BeginFeature:Passenger */
			'id_passenger' => null,
			/* EndFeature:Passenger */
			'total_price' => Yii::t('app', 'Total Price'),
			/* BeginFeature:Station */
			'id_station_departure' => null,
			/* EndFeature:Station */
			/* BeginFeature:Station */
			'id_station_arrival' => null,
			/* EndFeature:Station */
			/* BeginFeature:Luggage */
			'luggages' => null,
			/* EndFeature:Luggage */
			/* BeginFeature:Station */
			'idStationArrival' => null,
			/* EndFeature:Station */
			/* BeginFeature:Station */
			'idStationDeparture' => null,
			/* EndFeature:Station */
			/* BeginFeature:Passenger */
			'idPassenger' => null,
			/* EndFeature:Passenger */
			/* BeginFeature:Travel */
			'idTravel' => null,
			/* EndFeature:Travel */
			/* BeginFeature:TicketSegment */
			'ticketSegments' => null,
			/* EndFeature:TicketSegment */
		);
	}

	public function search() {
		$criteria = new CDbCriteria;

		$criteria->compare('id', $this->id);
		/* BeginFeature:Travel */
		$criteria->compare('id_travel', $this->id_travel);
		/* EndFeature:Travel */
		/* BeginFeature:Passenger */
		$criteria->compare('id_passenger', $this->id_passenger);
		/* EndFeature:Passenger */
		$criteria->compare('total_price', $this->total_price);
		/* BeginFeature:Station */
		$criteria->compare('id_station_departure', $this->id_station_departure);
		/* EndFeature:Station */
		/* BeginFeature:Station */
		$criteria->compare('id_station_arrival', $this->id_station_arrival);
		/* EndFeature:Station */

		return new CActiveDataProvider($this, array(
			'criteria' => $criteria,
		));
	}
}
/* EndFeature:Ticket */