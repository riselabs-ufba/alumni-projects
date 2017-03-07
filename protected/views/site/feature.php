<?php
$this->breadcrumbs = array(
    $model->label() => array('admin'),
    Yii::t('app', 'Generate'),
);

$this->menu = array(
    array('label' => Yii::t('app', 'Manage') . ' ' . $model->label(), 'url' => array('admin')),
);
?>

<h1><?php echo GxHtml::encode($model->label()); ?></h1>

<div class="form">


    <?php
    $form = $this->beginWidget('GxActiveForm', array(
        'id' => 'feature-form',
        'enableAjaxValidation' => true,
    ));
    ?>

    <p class="note">
<?php echo Yii::t('app', 'Fields with'); ?> <span class="required">*</span> <?php echo Yii::t('app', 'are required'); ?>.
    </p>

<?php echo $form->errorSummary($model); ?>

    <div class="row">
        <?php echo $form->labelEx($model, 'toKeep'); ?>
        <?php echo $form->checkboxList($model, 'toKeep', array_column($model->getOptionalFeatures(), 'label'), array('separator' => '', 'uncheckValue' => '-1')); ?>
<?php echo $form->error($model, 'toKeep'); ?>
    </div><!-- row -->

    <?php
    echo GxHtml::submitButton(Yii::t('app', 'Generate'));
    $this->endWidget();
    ?>
</div><!-- form -->
