<?php /* BeginFeature:TicketSegment*/ /* BeginFeature:ChooseSeat */?>
<div class="form">


<?php $form = $this->beginWidget('GxActiveForm', array(
	'id' => 'ticket-segment-form',
	'enableAjaxValidation' => true,
));
?>

	<p class="note">
		<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
	</p>

	<?php echo $form->errorSummary($model); ?>

		<?php /* BeginFeature:Ticket */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_ticket'); ?>
		<?php echo $model->id_ticket; ?>
		<?php echo $form->error($model,'id_ticket'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Ticket */ ?>
		<?php /* BeginFeature:Segment */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_segment'); ?>
		<?php echo $model->idSegment->idStationDeparture.' / '.$model->idSegment->idStationArrival; ?>
		<?php echo $form->error($model,'id_segment'); ?>
		</div><!-- row -->
		<?php /* EndFeature:Segment */ ?>
		<?php /* BeginFeature:VehicleSeat */ ?>
		<div class="row">
		<?php echo $form->labelEx($model,'id_vehicle_seat'); ?>
		<?php echo $form->dropDownList($model, 'id_vehicle_seat', GxHtml::listDataEx(VehicleSeat::model()->findAllAttributes(null, true, 'id_vehicle = :id_vehicle',array(':id_vehicle' => $model->idTicket->idTravel->id_vehicle))),array('empty' => Yii::t('app', 'Select'))); ?>
		<?php echo $form->error($model,'id_vehicle_seat'); ?>
		</div><!-- row -->
		<?php /* EndFeature:VehicleSeat */ ?>

<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
$this->endWidget();
?>
</div><!-- form -->
<?php /* EndFeature:TicketSegment */ /* EndFeature:ChooseSeat */