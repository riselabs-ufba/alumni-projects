<?php /* BeginFeature:Passenger */ ?>
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
	$.fn.yiiGridView.update('passenger-grid', {
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
	'id' => 'passenger-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		'name',
		'title',
		/* BeginFeature:DocumentType */
		array(
				'name'=>'id_document_type',
				'value'=>'GxHtml::valueEx($data->idDocumentType)',
				'filter'=>GxHtml::listDataEx(DocumentType::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:DocumentType*/
		'document',
		'address',
		'phone',
		/*
		'alternative_phone',
		'email',
		*/
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Passenger */