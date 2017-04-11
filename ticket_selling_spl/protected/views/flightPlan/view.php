<?php /* BeginFeature:FlightPlan */ ?>
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
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
		/* BeginFeature:Travel */
array(
			'name' => 'idTravel',
			'type' => 'raw',
			'value' => $model->idTravel !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idTravel)), array('travel/view', 'id' => GxActiveRecord::extractPkValue($model->idTravel, true))) : null,
			),
		/* EndFeature:Travel */
		/* BeginFeature:Station */
array(
			'name' => 'idStationAlternativeAirport',
			'type' => 'raw',
			'value' => $model->idStationAlternativeAirport !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idStationAlternativeAirport)), array('station/view', 'id' => GxActiveRecord::extractPkValue($model->idStationAlternativeAirport, true))) : null,
			),
		/* EndFeature:Station */
'type',
'route',
'pilot_name',
'pilot_contact',
'fuel_on_board',
	),
));
/* EndFeature:FlightPlan*/