<?php /* BeginFeature:VehicleSeat*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'vehicle-seat-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<?php /* BeginFeature:Vehicle */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle'); ?>
		<?php echo $model->idVehicle; ?>
		<?php echo $form->error($model,'id_vehicle'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Vehicle */ ?>
		<?php /* BeginFeature:SeatType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_seat_type'); ?>
		<?php echo $form->dropDownList($model, 'id_seat_type', GxHtml::listDataEx(SeatType::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_seat_type'); ?>
		</div><!-- row -->
		<?php /* EndFeature:SeatType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'code'); ?>
		<?php echo $form->textField($model, 'code', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'code'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'position'); ?>
		<?php echo $form->textField($model, 'position'); ?>
		<?php echo $form->error($model,'position'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'description'); ?>
		<?php echo $form->textField($model, 'description', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'description'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:VehicleSeat */