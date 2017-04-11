<?php /* BeginFeature:Line */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<div class="row">
		<?php echo $form->label($model, 'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
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

	<div class="row">
		<?php echo $form->label($model, 'active'); ?>
		<?php echo $form->dropDownList($model, 'active', array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:Line */