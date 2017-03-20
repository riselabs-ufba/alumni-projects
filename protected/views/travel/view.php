<?php /* BeginFeature:Travel */ ?>
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
		/* BeginFeature:Line */
array(
			'name' => 'idLine',
			'type' => 'raw',
			'value' => $model->idLine !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idLine)), array('line/view', 'id' => GxActiveRecord::extractPkValue($model->idLine, true))) : null,
			),
		/* EndFeature:Line */
		/* BeginFeature:Vehicle */
array(
			'name' => 'idVehicle',
			'type' => 'raw',
			'value' => $model->idVehicle !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicle)), array('vehicle/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicle, true))) : null,
			),
		/* EndFeature:Vehicle */
'start_date',
'end_date',
	),
));
/* EndFeature:Travel*/