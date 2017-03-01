<?php /* BeginFeature:Vehicle */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<div class="row">
		<?php echo $form->label($model, 'code'); ?>
		<?php echo $form->textField($model, 'code', array('maxlength' => 45)); ?>
	</div>

	<?php /* BeginFeature:VehicleType */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_vehicle_type'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_type', GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:VehicleType */ ?>

	<?php /* BeginFeature:VehicleModel */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_vehicle_model'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_model', GxHtml::listDataEx(VehicleModel::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:VehicleModel */ ?>

	<div class="row">
		<?php echo $form->label($model, 'capacity'); ?>
		<?php echo $form->textField($model, 'capacity'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'active'); ?>
		<?php echo $form->dropDownList($model, 'active', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Vehicle */