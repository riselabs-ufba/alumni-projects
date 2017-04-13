<?php /* BeginFeature:City*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'city-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>
		<?php /* BeginFeature:Country */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_country'); ?>
		<?php echo $form->dropDownList($model, 'id_country', GxHtml::listDataEx(Country::model()->findAllAttributes(null, true)),array(
                        'empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('state/getAllByCountry'),
                            'update'=>'#City_id_state',
                        ),
                    )); ?>
		<?php echo $form->error($model,'id_country'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Country */ ?>
		<?php /* BeginFeature:State */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_state'); ?>
		<?php echo $form->dropDownList($model, 'id_state', GxHtml::listDataEx(State::model()->findAllAttributes(null, true
                        /* BeginFeature:Country */
                         , 'id_country = :id_country', array(':id_country' => $model->id_country)
                        /* EndFeature:Country */
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_state'); ?>
		</div><!-- row -->
		<?php /* EndFeature:State */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'name'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:City */