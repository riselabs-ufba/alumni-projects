<?php /* BeginFeature:Station */ ?>
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
                /* BeginFeature:Country */
                array(
                    'name' => 'id_country',
                    'value' => $model->idCity->idState->idCountry,
                ),
                /* EndFeature:Country */            
                /* BeginFeature:State */
                array(
                    'name' => 'id_state',
                    'value' => $model->idCity->idState,
                ),
                /* EndFeature:State */
		/* BeginFeature:City */
array(
			'name' => 'idCity',
			'type' => 'raw',
			'value' => $model->idCity !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idCity)), array('city/view', 'id' => GxActiveRecord::extractPkValue($model->idCity, true))) : null,
			),
		/* EndFeature:City */
		/* BeginFeature:VehicleType */
array(
			'name' => 'idVehicleType',
			'type' => 'raw',
			'value' => $model->idVehicleType !== null ? GxHtml::link(GxHtml::encode(GxHtml::valueEx($model->idVehicleType)), array('vehicleType/view', 'id' => GxActiveRecord::extractPkValue($model->idVehicleType, true))) : null,
			),
		/* EndFeature:VehicleType */
'name',
	),
));
/* EndFeature:Station*/