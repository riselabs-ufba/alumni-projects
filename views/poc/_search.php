<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\PocSearch */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="poc-search">

    <?php $form = ActiveForm::begin([
        'action' => ['index'],
        'method' => 'get',
    ]); ?>

    <?= $form->field($model, 'id') ?>

    <?= $form->field($model, 'previous_duration') ?>

    <?= $form->field($model, 'real_duration') ?>

    <?= $form->field($model, 'person_name') ?>

    <?= $form->field($model, 'fk_oportunity') ?>

    <?php // echo $form->field($model, 'final_status') ?>

    <?php // echo $form->field($model, 'product_id') ?>

    <div class="form-group">
        <?= Html::submitButton('Search', ['class' => 'btn btn-primary']) ?>
        <?= Html::resetButton('Reset', ['class' => 'btn btn-default']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
