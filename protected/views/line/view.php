<?php /* BeginFeature:Line */ ?>
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
        array('label'=>Yii::t('app', 'Register') . ' ' . Segment::label(), 'url'=>array('segment/create', 'id' => $model->id)),
);
?>

<h1><?php echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
'name',
		/* BeginFeature:Station */
array(
			'name' => 'idStationDeparture',
			'type' => 'raw',
			'value' => $model->idStationDeparture !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idStationDeparture)), array('station/view', 'id' => GxActiveRecord::extractPkValue($model->idStationDeparture, true))) : null,
			),
		/* EndFeature:Station */
		/* BeginFeature:Station */
array(
			'name' => 'idStationArrival',
			'type' => 'raw',
			'value' => $model->idStationArrival !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idStationArrival)), array('station/view', 'id' => GxActiveRecord::extractPkValue($model->idStationArrival, true))) : null,
			),
		/* EndFeature:Station */
'active:boolean',
	),
));
/* BeginFeature:MultiSegment */
$segment = new Segment();
$segment->id_line = $model->id;
$this->renderPartial('application.views.segment.admin', array('model' => $segment));
/* EndFeature:MultiSegment */
/* EndFeature:Line*/