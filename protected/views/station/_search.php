<?php /* BeginFeature:Station */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<?php /* BeginFeature:City */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_city'); ?>
		<?php echo $form->dropDownList($model, 'id_city', GxHtml::listDataEx(City::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:City */ ?>

	<?php /* BeginFeature:VehicleType */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_vehicle_type'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_type', GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:VehicleType */ ?>

	<div class="row">
		<?php echo $form->label($model, 'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Station */