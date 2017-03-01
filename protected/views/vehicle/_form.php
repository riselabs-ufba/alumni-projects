<?php /* BeginFeature:Vehicle*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'vehicle-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<div class="row">
		<?php echo $form->labelEx($model,'code'); ?>
		<?php echo $form->textField($model, 'code', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'code'); ?>
		</div><!-- row -->
		<?php /* BeginFeature:VehicleType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_type'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_type', GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_type'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleType */ ?>
		<?php /* BeginFeature:Manufacturer */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_manufacturer'); ?>
		<?php echo $form->dropDownList($model, 'id_manufacturer', GxHtml::listDataEx(Manufacturer::model()->findAllAttributes(null, true)),array(
                    'empty' => Yii::t('app', 'Select'),
                    'ajax' => array(
                        'type'=>'POST',
                        'url'=>$this->createUrl('vehicleModel/getAllByManufacturer'),
                        'update'=>'#Vehicle_id_vehicle_model',
                    ),                    
                    )); ?>
		<?php echo $form->error($model,'id_manufacturer'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Manufacturer */ ?>                
		<?php /* BeginFeature:VehicleModel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_model'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_model', GxHtml::listDataEx(VehicleModel::model()->findAllAttributes(null, true
                        /* BeginFeature:Manufacturer */
                         , 'id_manufacturer = :id_manufacturer', array(':id_manufacturer' => $model->id_manufacturer)
                        /* EndFeature:Manufacturer */                        
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_model'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleModel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'capacity'); ?>
		<?php echo $form->textField($model, 'capacity'); ?>
		<?php echo $form->error($model,'capacity'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'active'); ?>
		<?php echo $form->checkBox($model, 'active'); ?>
		<?php echo $form->error($model,'active'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Vehicle */