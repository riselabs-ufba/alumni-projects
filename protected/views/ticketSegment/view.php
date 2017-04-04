<?php /* BeginFeature:TicketSegment */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(), 'url'=>array('update', 'id' => $model->id)),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('ticket/view','id' => $model->id_ticket)),
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
		/* BeginFeature:Ticket */
array(
			'name' => 'idTicket',
			'type' => 'raw',
			'value' => $model->idTicket !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idTicket)), array('ticket/view', 'id' => GxActiveRecord::extractPkValue($model->idTicket, true))) : null,
			),
		/* EndFeature:Ticket */
		/* BeginFeature:Segment */
array(
			'name' => 'idSegment',
			'type' => 'raw',
			'value' => $model->idSegment !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idSegment)), array('segment/view', 'id' => GxActiveRecord::extractPkValue($model->idSegment, true))) : null,
			),
		/* EndFeature:Segment */
		/* BeginFeature:VehicleSeat */ /* BeginFeature:ChooseSeat */
array(
			'name' => 'idVehicleSeat',
			'type' => 'raw',
			'value' => $model->idVehicleSeat !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleSeat)), array('vehicleSeat/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleSeat, true))) : null,
			),
		/* EndFeature:VehicleSeat */ /* EndFeature:ChooseSeat */
	),
));
/* EndFeature:TicketSegment*/