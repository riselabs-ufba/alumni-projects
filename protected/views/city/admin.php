<?php /* BeginFeature:City */ ?>
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
	$.fn.yiiGridView.update('city-grid', {
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
	'id' => 'city-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Country */
		array(
				'name'=>'id_country',
				'value'=>'$data->idState->idCountry->name',
				'filter'=>GxHtml::listDataEx(Country::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Country*/            
		/* BeginFeature:State */
		array(
				'name'=>'id_state',
				'value'=>'GxHtml::valueEx($data->idState)',
				'filter'=>GxHtml::listDataEx(State::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:State*/
		'name',
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:City */