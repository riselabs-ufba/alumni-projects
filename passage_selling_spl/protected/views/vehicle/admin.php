<?php /* BeginFeature:Vehicle */ ?>
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
	$.fn.yiiGridView.update('vehicle-grid', {
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
	'id' => 'vehicle-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		'code',
		/* BeginFeature:VehicleType */
		array(
				'name'=>'id_vehicle_type',
				'value'=>'GxHtml::valueEx($data->idVehicleType)',
				'filter'=>GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:VehicleType*/
		/* BeginFeature:VehicleModel */
		array(
				'name'=>'id_vehicle_model',
				'value'=>'GxHtml::valueEx($data->idVehicleModel)',
				'filter'=>GxHtml::listDataEx(VehicleModel::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:VehicleModel*/
		'capacity',
		array(
					'name' => 'active',
					'value' => '($data->active === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		'manufacturing_year',
		/*
		'fuel_capacity',
		'color',
		'bus_plate',
		'plane_true_airspeed_knots',
		'plane_cruising_altitude',
		*/
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Vehicle */