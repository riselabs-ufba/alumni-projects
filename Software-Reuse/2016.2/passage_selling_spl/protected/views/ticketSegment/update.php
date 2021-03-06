<?php /* BeginFeature:TicketSegment */ /* BeginFeature:ChooseSeat */?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	GxHtml::valueEx($model) => array('view', 'id' => GxActiveRecord::extractPkValue($model, true)),
	Yii::t('app', 'Update'),
);

$this->menu = array(
	array('label' => Yii::t('app', 'View') . ' ' . $model->label(), 'url'=>array('view', 'id' => GxActiveRecord::extractPkValue($model, true))),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('ticket/view','id' => $model->id_ticket)),
);
?>

<h1><?php echo Yii::t('app', 'Update') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php
$this->renderPartial('_form', array(
		'model' => $model));
/* EndFeature:TicketSegment */ /* EndFeature:ChooseSeat */