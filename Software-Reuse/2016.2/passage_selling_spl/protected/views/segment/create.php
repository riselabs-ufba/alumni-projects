<?php /* BeginFeature:MultiSegment */ ?>
<?php
$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	Yii::t('app', 'Create'),
);

$this->menu = array(
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url' => array('line/view','id' => $model->id_line)),
);
?>

<h1><?php echo Yii::t('app', 'Create') . ' ' . GxHtml::encode($model->label()); ?></h1>

<?php
$this->renderPartial('_form', array(
		'model' => $model,
		'buttons' => 'create'));
/* EndFeature:MultiSegment */