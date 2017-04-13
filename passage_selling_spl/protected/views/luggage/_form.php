<?php /* BeginFeature:Luggage*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'luggage-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>
		<?php /* BeginFeature:Passenger */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_passenger'); ?>
		<?php echo $form->dropDownList($model, 'id_passenger', GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)),array(
                        'empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('ticket/getAllByPassenger'),
                            'update'=>'#Luggage_id_ticket',
                        ),
                    )); ?>
		<?php echo $form->error($model,'id_passenger'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Passenger */ ?>
		<?php /* BeginFeature:Ticket */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_ticket'); ?>
		<?php echo $form->dropDownList($model, 'id_ticket', GxHtml::listDataEx(Ticket::model()->findAllAttributes(null, true
                        /* BeginFeature:Passenger */
                         , 'id_passenger = :id_passenger', array(':id_passenger' => $model->id_passenger)
                        /* EndFeature:Passenger */
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_ticket'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Ticket */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'code'); ?>
		<?php echo $form->textField($model, 'code'); ?>
		<?php echo $form->error($model,'code'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'description'); ?>
		<?php echo $form->textField($model, 'description', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'description'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'weight'); ?>
		<?php echo $form->textField($model, 'weight'); ?>
		<?php echo $form->error($model,'weight'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'special'); ?>
		<?php echo $form->checkBox($model, 'special'); ?>
		<?php echo $form->error($model,'special'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'animal'); ?>
		<?php echo $form->checkBox($model, 'animal'); ?>
		<?php echo $form->error($model,'animal'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'music_instrument'); ?>
		<?php echo $form->checkBox($model, 'music_instrument'); ?>
		<?php echo $form->error($model,'music_instrument'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'out_of_dimensions'); ?>
		<?php echo $form->checkBox($model, 'out_of_dimensions'); ?>
		<?php echo $form->error($model,'out_of_dimensions'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Luggage */