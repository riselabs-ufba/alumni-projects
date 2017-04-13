<?php /* BeginFeature:Travel */ ?>
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
	$.fn.yiiGridView.update('travel-grid', {
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
	'id' => 'travel-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Line */
		array(
				'name'=>'id_line',
				'value'=>'GxHtml::valueEx($data->idLine)',
				'filter'=>GxHtml::listDataEx(Line::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Line*/
		/* BeginFeature:Vehicle */
		array(
				'name'=>'id_vehicle',
				'value'=>'GxHtml::valueEx($data->idVehicle)',
				'filter'=>GxHtml::listDataEx(Vehicle::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Vehicle*/
		'start_date',
		'end_date',
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Travel */