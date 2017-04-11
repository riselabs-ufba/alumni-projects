<?php /* BeginFeature:Travel */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<?php /* BeginFeature:Line */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_line'); ?>
		<?php echo $form->dropDownList($model, 'id_line', GxHtml::listDataEx(Line::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Line */ ?>

	<?php /* BeginFeature:Vehicle */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_vehicle'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle', GxHtml::listDataEx(Vehicle::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Vehicle */ ?>

	<div class="row">
		<?php echo $form->label($model, 'start_date'); ?>
		<?php echo $form->textField($model, 'start_date'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'end_date'); ?>
		<?php echo $form->textField($model, 'end_date'); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Travel */