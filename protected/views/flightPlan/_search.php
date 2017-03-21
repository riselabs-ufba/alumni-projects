<?php /* BeginFeature:FlightPlan */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<?php /* BeginFeature:Travel */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_travel'); ?>
		<?php echo $form->dropDownList($model, 'id_travel', GxHtml::listDataEx(Travel::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Travel */ ?>

	<?php /* BeginFeature:Station */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_station_alternative_airport'); ?>
		<?php echo $form->dropDownList($model, 'id_station_alternative_airport', GxHtml::listDataEx(Station::model()->airport()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Station */ ?>

	<div class="row">
		<?php echo $form->label($model, 'type'); ?>
		<?php echo $form->textField($model, 'type', array('maxlength' => 45)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'route'); ?>
		<?php echo $form->textField($model, 'route', array('maxlength' => 45)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'pilot_name'); ?>
		<?php echo $form->textField($model, 'pilot_name', array('maxlength' => 45)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'pilot_contact'); ?>
		<?php echo $form->textField($model, 'pilot_contact', array('maxlength' => 45)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'fuel_on_board'); ?>
		<?php echo $form->textField($model, 'fuel_on_board'); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:FlightPlan */