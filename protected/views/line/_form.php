<?php /* BeginFeature:Line*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'line-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<div class="row">
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'name'); ?>
		</div><!-- row -->
		<?php /* BeginFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_station_departure'); ?>
		<?php echo $form->dropDownList($model, 'id_station_departure', GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_station_departure'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Station */ ?>
		<?php /* BeginFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_station_arrival'); ?>
		<?php echo $form->dropDownList($model, 'id_station_arrival', GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_station_arrival'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Station */ ?>
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
<?php /* EndFeature:Line */