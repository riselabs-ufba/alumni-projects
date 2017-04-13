<?php /* BeginFeature:Line */ ?>
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
	$.fn.yiiGridView.update('line-grid', {
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
	'id' => 'line-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		'name',
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
					'name' => 'active',
					'value' => '($data->active === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Line */