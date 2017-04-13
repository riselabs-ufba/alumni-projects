<?php /* BeginFeature:MultiSegment*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'segment-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<?php /* BeginFeature:Line */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_line'); ?>
		<?php echo $model->idLine; ?>
		<?php echo $form->error($model,'id_line'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Line */ ?>
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
		<?php echo $form->labelEx($model,'sequence_number'); ?>
		<?php echo $form->textField($model, 'sequence_number'); ?>
		<?php echo $form->error($model,'sequence_number'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'estimated_time'); ?>
		<?php echo $form->textField($model, 'estimated_time'); ?>
		<?php echo $form->error($model,'estimated_time'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:MultiSegment */