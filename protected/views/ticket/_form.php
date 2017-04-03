<?php /* BeginFeature:Ticket*/ ?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'ticket-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>
		<?php /* BeginFeature:Line */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_line'); ?>
		<?php echo $form->dropDownList($model, 'id_line', GxHtml::listDataEx(Line::model()->findAllAttributes(null, true)),array(
                        'empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('travel/getAllByLine'),
                            'update'=>'#Ticket_id_travel',
                        ),
                    )); ?>
		<?php echo $form->error($model,'id_line'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Line */ ?>        
		<?php /* BeginFeature:Travel */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_travel'); ?>
		<?php echo $form->dropDownList($model, 'id_travel',array(),array(
                        'empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('segment/getAllDepartureByLine'),
                            'update'=>'#Ticket_id_station_departure',
                        ),
                    )); ?>
		<?php echo $form->error($model,'id_travel'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Travel */ ?>                
		<?php /* BeginFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_station_departure'); ?>
		<?php echo $form->dropDownList($model, 'id_station_departure', array(),array('empty' => Yii::t('app', 'Select'),
                        'ajax' => array(
                            'type'=>'POST',
                            'url'=>$this->createUrl('segment/getAllArrivalByDeparture'),
                            'update'=>'#Ticket_id_station_arrival',
                        ),                    
                    )); ?>
		<?php echo $form->error($model,'id_station_departure'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Station */ ?>
		<?php /* BeginFeature:Station */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_station_arrival'); ?>
		<?php echo $form->dropDownList($model, 'id_station_arrival', array(),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_station_arrival'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Station */ ?>                
		<?php /* BeginFeature:Passenger */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_passenger'); ?>
		<?php echo $form->dropDownList($model, 'id_passenger', GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_passenger'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Passenger */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'total_price'); ?>
		<?php echo $form->textField($model, 'total_price'); ?>
		<?php echo $form->error($model,'total_price'); ?>
		</div><!-- row -->

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:Ticket */