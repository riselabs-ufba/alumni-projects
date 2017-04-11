<?php /* BeginFeature:Ticket */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Delete') . ' ' . $model->label(), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model->id), 'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('admin')),
        /* BeginFeature:JSON */
        array('label'=>Yii::t('app', 'Export to JSON'), 'url'=>array('toJson', 'id' => $model->id),'linkOptions'=>array('target'=>'_blank')),
        /* EndFeature:JSON */
        /* BeginFeature:XML */
        array('label'=>Yii::t('app', 'Export to XML'), 'url'=>array('toXml', 'id' => $model->id),'linkOptions'=>array('target'=>'_blank')),
        /* EndFeature:XML */    
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
                'idTravel.idLine',
		/* BeginFeature:Travel */
array(
			'name' => 'idTravel',
			'type' => 'raw',
			'value' => $model->idTravel !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idTravel)), array('travel/view', 'id' => GxActiveRecord::extractPkValue($model->idTravel, true))) : null,
			),
		/* EndFeature:Travel */
		/* BeginFeature:Passenger */
array(
			'name' => 'idPassenger',
			'type' => 'raw',
			'value' => $model->idPassenger !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idPassenger)), array('passenger/view', 'id' => GxActiveRecord::extractPkValue($model->idPassenger, true))) : null,
			),
		/* EndFeature:Passenger */
'total_price',
		/* BeginFeature:Station */
array(
			'name' => 'idStationDeparture',
			'type' => 'raw',
			'value' => $model->idStationDeparture !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idStationDeparture)), array('station/view', 'id' => GxActiveRecord::extractPkValue($model->idStationDeparture, true))) : null,
			),
		/* EndFeature:Station */
		/* BeginFeature:Station */
array(
			'name' => 'idStationArrival',
			'type' => 'raw',
			'value' => $model->idStationArrival !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idStationArrival)), array('station/view', 'id' => GxActiveRecord::extractPkValue($model->idStationArrival, true))) : null,
			),
		/* EndFeature:Station */
	),
));
$modelTicketSegment = new TicketSegment();
$modelTicketSegment->id_ticket = $model->id;
$this->renderPartial('application.views.ticketSegment.admin',array('model' => $modelTicketSegment));
/* EndFeature:Ticket*/