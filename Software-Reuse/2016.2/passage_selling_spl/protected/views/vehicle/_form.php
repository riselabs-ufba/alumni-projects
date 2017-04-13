<?php /* BeginFeature:Vehicle*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'vehicle-form',
	'enableAjaxValidation' => true,
));

        $operator = '='; 
        /* BeginFeature:Boat*/        
        $param = VehicleType::BOAT;
        /* EndFeature:Boat*/                    
        /* BeginFeature:Bus*/
        $param = VehicleType::BUS;
        /* EndFeature:Bus*/
        /* BeginFeature:Plane*/
        $param = VehicleType::PLANE; 
        /* EndFeature:Plane*/  
        /* BeginFeature:FeatureManager*/
        $param = 0; 
        $operator = '>';
        /* EndFeature:FeatureManager*/

?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<div class="row">
		<?php echo $form->labelEx($model,'code'); ?>
		<?php echo $form->textField($model, 'code', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'code'); ?>
		</div><!-- row -->
		<?php /* BeginFeature:VehicleType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_type'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_type', GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true
                        , "id {$operator} :id", array(':id' => $param)                        
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_type'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleType */ ?>
		<?php /* BeginFeature:VehicleModel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_model'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_model', GxHtml::listDataEx(VehicleModel::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_model'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleModel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'capacity'); ?>
		<?php echo $form->textField($model, 'capacity'); ?>
		<?php echo $form->error($model,'capacity'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'active'); ?>
		<?php echo $form->checkBox($model, 'active'); ?>
		<?php echo $form->error($model,'active'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'manufacturing_year'); ?>
		<?php echo $form->textField($model, 'manufacturing_year', array('maxlength' => 4)); ?>
		<?php echo $form->error($model,'manufacturing_year'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'fuel_capacity'); ?>
		<?php echo $form->textField($model, 'fuel_capacity'); ?>
		<?php echo $form->error($model,'fuel_capacity'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'color'); ?>
		<?php echo $form->textField($model, 'color', array('maxlength' => 45)); ?>
		<?php echo $form->error($model,'color'); ?>
		</div><!-- row -->
                <?php /* BeginFeature:Bus */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'bus_plate'); ?>
		<?php echo $form->textField($model, 'bus_plate', array('maxlength' => 20)); ?>
		<?php echo $form->error($model,'bus_plate'); ?>
		</div><!-- row -->
                <?php /* EndFeature:Bus */ ?>
                <?php /* BeginFeature:Plane */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'plane_true_airspeed_knots'); ?>
		<?php echo $form->textField($model, 'plane_true_airspeed_knots'); ?>
		<?php echo $form->error($model,'plane_true_airspeed_knots'); ?>
		</div><!-- row -->
		<div class="row">
		<?php echo $form->labelEx($model,'plane_cruising_altitude'); ?>
		<?php echo $form->textField($model, 'plane_cruising_altitude'); ?>
		<?php echo $form->error($model,'plane_cruising_altitude'); ?>
		</div><!-- row -->
                <?php /* EndFeature:Plane */ ?>

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Vehicle */