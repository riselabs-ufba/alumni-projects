<?php /* BeginFeature:FlightPlan */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	Yii::t('app', 'Manage'),
);

$this->menu = array(
		array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	);

Yii::app()->clientScript->registerScript('search', "
$('.search-form').hide();
$('.search-button').click(function(){
	$('.search-form').toggle();
	return false;
});
$('.search-form form').submit(function(){
	$.fn.yiiGridView.update('flight-plan-grid', {
		data: $(this).serialize()
	});
	return false;
});
");
?>

<h1><?php echo Yii::t('app', 'Manage') . ' ' . GxHtml::encode($model->label(2)); ?></h1>

<?php echo GxHtml::link(Yii::t('app', 'Advanced Search'), '#', array('class' => 'search-button')); ?>
<div class="search-form">
<?php $this->renderPartial('_search', array(
	'model' => $model,
)); ?>
</div><!-- search-form -->

<?php $this->widget('zii.widgets.grid.CGridView', array(
	'id' => 'flight-plan-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Travel */
		array(
				'name'=>'id_travel',
				'value'=>'GxHtml::valueEx($data->idTravel)',
				'filter'=>GxHtml::listDataEx(Travel::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Travel*/
		/* BeginFeature:Station */
		array(
				'name'=>'id_station_alternative_airport',
				'value'=>'GxHtml::valueEx($data->idStationAlternativeAirport)',
				'filter'=>GxHtml::listDataEx(Station::model()->airport()->findAllAttributes(null, true)),
				),
		/* EndFeature:Station*/
		'type',
		'route',
		'pilot_name',
		'pilot_contact',
		/*
		'fuel_on_board',
		*/
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:FlightPlan */