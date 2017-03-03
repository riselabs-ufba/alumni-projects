<?php /* BeginFeature:VehicleSeat */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('index'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create', 'id' => $model->id_vehicle)),
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Delete') . ' ' . $model->label(), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model->id), 'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('vehicle/view','id' => $model->id_vehicle)),
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
		/* BeginFeature:Vehicle */
array(
			'name' => 'idVehicle',
			'type' => 'raw',
			'value' => $model->idVehicle !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicle)), array('vehicle/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicle, true))) : null,
			),
		/* EndFeature:Vehicle */
		/* BeginFeature:SeatType */
array(
			'name' => 'idSeatType',
			'type' => 'raw',
			'value' => $model->idSeatType !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idSeatType)), array('seatType/view', 'id' => GxActiveRecord::extractPkValue($model->idSeatType, true))) : null,
			),
		/* EndFeature:SeatType */
'code',
'position',
'description',
	),
));
/* EndFeature:VehicleSeat*/