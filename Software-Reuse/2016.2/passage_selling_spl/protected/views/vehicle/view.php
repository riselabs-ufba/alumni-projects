<?php /* BeginFeature:Vehicle */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Delete') . ' ' . $model->label(), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model->id), 'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('admin')),
        /* BeginFeature:VehicleSeat*/
        array('label'=>Yii::t('app', 'Create') . ' ' . VehicleSeat::label(), 'url'=>array('vehicleSeat/create', 'id' => $model->id)),
        /* EndFeature:VehicleSeat*/
        /* BeginFeature:BatchRegistration*/
        array('label'=>Yii::t('app', 'Create') . ' ' . VehicleSeat::label().' - Batch Registration', 'url'=>array('vehicleSeat/batchRegistration', 'id' => $model->id)),
        /* EndFeature:BatchRegistration*/        
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
'code',
		/* BeginFeature:VehicleType */
array(
			'name' => 'idVehicleType',
			'type' => 'raw',
			'value' => $model->idVehicleType !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleType)), array('vehicleType/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleType, true))) : null,
			),
		/* EndFeature:VehicleType */
		/* BeginFeature:VehicleModel */
array(
			'name' => 'idVehicleModel',
			'type' => 'raw',
			'value' => $model->idVehicleModel !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleModel)), array('vehicleModel/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleModel, true))) : null,
			),
		/* EndFeature:VehicleModel */
'capacity',
'active:boolean',
'manufacturing_year',
'fuel_capacity',
'color',
/* BeginFeature:Bus*/
'bus_plate',
/* EndFeature:Bus*/            
/* BeginFeature:Plane*/
'plane_true_airspeed_knots',
'plane_cruising_altitude',
/* EndFeature:Plane*/            
	),
));
/* BeginFeature:VehicleSeat*/
$modelSeat = new VehicleSeat();
$modelSeat->id_vehicle = $model->id;
$this->renderPartial('application.views.vehicleSeat.admin',array('model' => $modelSeat));
/* EndFeature:VehicleSeat*/
/* EndFeature:Vehicle*/