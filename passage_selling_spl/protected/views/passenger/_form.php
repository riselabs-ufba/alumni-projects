<?php /* BeginFeature:Passenger*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'passenger-form',
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
		<div class="row">
		<?php echo $form->labelEx($model,'title'); ?>
		<?php echo $form->textField($model, 'title', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'title'); ?>
		</div><!-- row -->
		<?php /* BeginFeature:DocumentType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_document_type'); ?>
		<?php echo $form->dropDownList($model, 'id_document_type', GxHtml::listDataEx(DocumentType::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_document_type'); ?>
		</div><!-- row -->
		<?php /* EndFeature:DocumentType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'document'); ?>
		<?php echo $form->textField($model, 'document', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'document'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'address'); ?>
		<?php echo $form->textField($model, 'address', array('maxlength' => 255, 'size' => 60)); ?>
		<?php echo $form->error($model,'address'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'phone'); ?>
                <?php
                $this->widget('CMaskedTextField', array(
                'model' => $model,
                'attribute' => 'phone',
                'mask' => '+999999999999?9',
                ));
                ?>
		<?php echo $form->error($model,'phone'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'alternative_phone'); ?>
                <?php
                $this->widget('CMaskedTextField', array(
                'model' => $model,
                'attribute' => 'alternative_phone',
                'mask' => '+999999999999?9',
                ));
                ?>                    
		<?php echo $form->error($model,'alternative_phone'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'email'); ?>
		<?php echo $form->textField($model, 'email', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'email'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Passenger */