<?php /* BeginFeature:Luggage */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<?php /* BeginFeature:Ticket */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_ticket'); ?>
		<?php echo $form->dropDownList($model, 'id_ticket', GxHtml::listDataEx(Ticket::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Ticket */ ?>

	<div class="row">
		<?php echo $form->label($model, 'code'); ?>
		<?php echo $form->textField($model, 'code'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'description'); ?>
		<?php echo $form->textField($model, 'description', array('maxlength' => 45)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'weight'); ?>
		<?php echo $form->textField($model, 'weight'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'special'); ?>
		<?php echo $form->dropDownList($model, 'special', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'animal'); ?>
		<?php echo $form->dropDownList($model, 'animal', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'music_instrument'); ?>
		<?php echo $form->dropDownList($model, 'music_instrument', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'out_of_dimensions'); ?>
		<?php echo $form->dropDownList($model, 'out_of_dimensions', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
    
        <?php /* BeginFeature:Passenger */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_passenger'); ?>
		<?php echo $form->dropDownList($model, 'id_passenger', GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
        <?php /* EndFeature:Passenger */ ?>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Luggage */