<?php /* BeginFeature:BatchRegistration */ ?>
<?php
$this->breadcrumbs = array(
    $model->label(2) => array('admin'),
    Yii::t('app', 'Batch'),
);

$this->menu = array(
    array('label' => Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url' => array('vehicle/view', 'id' => $model->id_vehicle)),
);
?>

<h1><?php echo Yii::t('app', 'Create') . ' ' . GxHtml::encode($model->label()). ' - Batch Registration'; ?></h1>

<div class="form">


    <?php
    $form = $this->beginWidget('GxActiveForm', array(
        'id' => 'vehicle-seat-form',
        'enableAjaxValidation' => true,
    ));
    ?>

    <p class="note">
        <?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
    </p>

    <?php echo $form->errorSummary($model); ?>

    <?php /* BeginFeature:Vehicle */ ?>
    <div class="row">
        <?php echo $form->labelEx($model, 'id_vehicle'); ?>
        <?php echo $model->idVehicle; ?>
        <?php echo $form->error($model, 'id_vehicle'); ?>
    </div><!-- row -->
    <?php /* EndFeature:Vehicle */ ?>
    <?php /* BeginFeature:SeatType */ ?>
    <div class="row">
        <?php echo $form->labelEx($model, 'id_seat_type'); ?>
        <?php echo $form->dropDownList($model, 'id_seat_type', GxHtml::listDataEx(SeatType::model()->findAllAttributes(null, true)), array('empty' => Yii::t('app', 'Select'))); ?>
        <?php echo $form->error($model, 'id_seat_type'); ?>
    </div><!-- row -->
    <?php /* EndFeature:SeatType */ ?>
    <div class="row">
        <?php echo $form->labelEx($model, 'quantity'); ?>
        <?php echo $form->textField($model, 'quantity'); ?>
        <?php echo $form->error($model, 'quantity'); ?>
    </div><!-- row -->

    <?php
    echo GxHtml::submitButton(Yii::t('app', 'Save'));
    $this->endWidget();
    ?>
</div><!-- form -->
<?php 
/* EndFeature:BatchRegistration */