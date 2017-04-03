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

	<div class="row">
		<?php echo $form->label($model, 'manufacturing_year'); ?>
		<?php echo $form->textField($model, 'manufacturing_year', array('maxlength' => 4)); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'fuel_capacity'); ?>
		<?php echo $form->textField($model, 'fuel_capacity'); ?>
	</div>

	<div class="row">
		<?php echo $form->label($model, 'color'); ?>
		<?php echo $form->textField($model, 'color', array('maxlength' => 45)); ?>
	</div>        
        <?php /* BeginFeature:Bus */ ?>
	<div class="row">
		<?php echo $form->label($model, 'bus_plate'); ?>
		<?php echo $form->textField($model, 'bus_plate', array('maxlength' => 20)); ?>
	</div>
        <?php /* EndFeature:Bus */ ?>
        <?php /* BeginFeature:Plane */ ?>
	<div class="row">
		<?php echo $form->label($model, 'plane_true_airspeed_knots'); ?>
		<?php echo $form->textField($model, 'plane_true_airspeed_knots'); ?>
	</div>
        
	<div class="row">
		<?php echo $form->label($model, 'plane_cruising_altitude'); ?>
		<?php echo $form->textField($model, 'plane_cruising_altitude'); ?>
	</div>
        <?php /* EndFeature:Plane */ ?>
	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Vehicle */