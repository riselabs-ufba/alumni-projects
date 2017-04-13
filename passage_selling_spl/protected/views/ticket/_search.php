<?php /* BeginFeature:Ticket */ ?>
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

	<?php /* BeginFeature:Passenger */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_passenger'); ?>
		<?php echo $form->dropDownList($model, 'id_passenger', GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Passenger */ ?>

	<div class="row">
		<?php echo $form->label($model, 'total_price'); ?>
		<?php echo $form->textField($model, 'total_price'); ?>
	</div>

	<?php /* BeginFeature:Station */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_station_departure'); ?>
		<?php echo $form->dropDownList($model, 'id_station_departure', GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Station */ ?>

	<?php /* BeginFeature:Station */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_station_arrival'); ?>
		<?php echo $form->dropDownList($model, 'id_station_arrival', GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:Station */ ?>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Ticket */