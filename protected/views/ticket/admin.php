<?php /* BeginFeature:Ticket */ ?>
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
	$.fn.yiiGridView.update('ticket-grid', {
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
	'id' => 'ticket-grid',
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
		/* BeginFeature:Passenger */
		array(
				'name'=>'id_passenger',
				'value'=>'GxHtml::valueEx($data->idPassenger)',
				'filter'=>GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Passenger*/
		'total_price',
		/* BeginFeature:Station */
		array(
				'name'=>'id_station_departure',
				'value'=>'GxHtml::valueEx($data->idStationDeparture)',
				'filter'=>GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Station*/
		/* BeginFeature:Station */
		array(
				'name'=>'id_station_arrival',
				'value'=>'GxHtml::valueEx($data->idStationArrival)',
				'filter'=>GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Station*/
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Ticket */