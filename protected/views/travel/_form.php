<?php /* BeginFeature:Travel*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'travel-form',
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
		<?php echo $form->dropDownList($model, 'id_line', GxHtml::listDataEx(Line::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_line'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Line */ ?>
		<?php /* BeginFeature:Vehicle */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle', GxHtml::listDataEx(Vehicle::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Vehicle */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'start_date'); ?>
                <?php
                $this->widget('CMaskedTextField', array(
                'model' => $model,
                'attribute' => 'start_date',
                'mask' => '99/99/9999 99:99:99',
                ));
                ?>
		<?php echo $form->error($model,'start_date'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'end_date'); ?>
                <?php
                $this->widget('CMaskedTextField', array(
                'model' => $model,
                'attribute' => 'end_date',
                'mask' => '99/99/9999 99:99:99',
                ));
                ?>                    
		<?php echo $form->error($model,'end_date'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Travel */