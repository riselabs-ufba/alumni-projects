<?php /* BeginFeature:Vehicle */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('index'),
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
'code',
    /* BeginFeature:Manufacturer */
    array(
        'name' => 'id_manufacturer',
        'value' => $model->idVehicleModel->idManufacturer,
    ),    
    /* EndFeature:Manufacturer */            
		/* BeginFeature:VehicleType */
array(
			'name' => 'idVehicleType',
			'type' => 'raw',
			'value' => $model->idVehicleType !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleType)), array('vehicleType/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleType, true))) : null,
			),
		/* EndFeature:VehicleType */
		/* BeginFeature:VehicleModel */
array(
			'name' => 'idVehicleModel',
			'type' => 'raw',
			'value' => $model->idVehicleModel !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleModel)), array('vehicleModel/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleModel, true))) : null,
			),
		/* EndFeature:VehicleModel */
'capacity',
'active:boolean',
	),
));
/* EndFeature:Vehicle*/