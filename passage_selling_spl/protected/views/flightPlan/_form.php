<?php /* BeginFeature:FlightPlan*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'flight-plan-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<?php /* BeginFeature:Travel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_travel'); ?>
		<?php echo $form->dropDownList($model, 'id_travel', GxHtml::listDataEx(Travel::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_travel'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Travel */ ?>
		<?php /* BeginFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_station_alternative_airport'); ?>
		<?php echo $form->dropDownList($model, 'id_station_alternative_airport', GxHtml::listDataEx(Station::model()->airport()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_station_alternative_airport'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'type'); ?>
		<?php echo $form->textField($model, 'type', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'type'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'route'); ?>
		<?php echo $form->textField($model, 'route', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'route'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'pilot_name'); ?>
		<?php echo $form->textField($model, 'pilot_name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'pilot_name'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'pilot_contact'); ?>
		<?php echo $form->textField($model, 'pilot_contact', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'pilot_contact'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'fuel_on_board'); ?>
		<?php echo $form->textField($model, 'fuel_on_board'); ?>
		<?php echo $form->error($model,'fuel_on_board'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:FlightPlan */