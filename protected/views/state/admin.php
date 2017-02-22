<?php /* BeginFeature:State */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('index'),
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
	$.fn.yiiGridView.update('state-grid', {
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
	'id' => 'state-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Country */
		array(
				'name'=>'id_country',
				'value'=>'GxHtml::valueEx($data->idCountry)',
				'filter'=>GxHtml::listDataEx(Country::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Country*/
		'code',
		'name',
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:State */