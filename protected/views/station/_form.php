<?php /* BeginFeature:Station*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'station-form',
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
		<?php /* BeginFeature:Country */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_country'); ?>
		<?php echo $form->dropDownList($model, 'id_country', GxHtml::listDataEx(Country::model()->findAllAttributes(null, true)),array(
                        'empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('state/getAllByCountry'),
                            'update'=>'#Station_id_state',
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
                        )),array(
                            'empty' => Yii::t('app', 'Select'),
                            'ajax' => array(
                                'type'=>'POST',
                                'url'=>$this->createUrl('city/getAllByState'),
                                'update'=>'#Station_id_city',
                            ),                            
                    )); ?>
		<?php echo $form->error($model,'id_state'); ?>
		</div><!-- row -->
		<?php /* EndFeature:State */ ?>
		<?php /* BeginFeature:City */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_city'); ?>
		<?php echo $form->dropDownList($model, 'id_city', GxHtml::listDataEx(City::model()->findAllAttributes(null, true
                        /* BeginFeature:State */
                         , 'id_state = :id_state', array(':id_state' => $model->id_state)
                        /* EndFeature:State */
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_city'); ?>
		</div><!-- row -->
		<?php /* EndFeature:City */ ?>
		<?php /* BeginFeature:VehicleType */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_type'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_type', GxHtml::listDataEx(VehicleType::model()->findAllAttributes(null, true
                        , "id {$operator} :id", array(':id' => $param)                        
                        )),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_type'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleType */ ?>
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
<?php /* EndFeature:Station */