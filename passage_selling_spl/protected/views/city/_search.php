<?php /* BeginFeature:City */ ?>
<div class="wide form">

<?php $form = $this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl($this->route),
	'method' => 'get',
)); ?>

	<?php /* BeginFeature:State */ ?>
	<div class="row">
		<?php echo $form->label($model, 'id_state'); ?>
		<?php echo $form->dropDownList($model, 'id_state', GxHtml::listDataEx(State::model()->findAllAttributes(null, true)), array('prompt' => Yii::t('app', 'All'))); ?>
	</div>
	<?php /* EndFeature:State */ ?>

	<div class="row">
		<?php echo $form->label($model, 'name'); ?>
		<?php echo $form->textField($model, 'name', array('maxlength' => 45)); ?>
	</div>

	<div class="row buttons">
		<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- search-form -->
<?php /* EndFeature:City */