<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\Poc */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="poc-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'previous_duration')->textInput() ?>

    <?= $form->field($model, 'real_duration')->textInput() ?>

    <?= $form->field($model, 'person_name')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'fk_oportunity')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'final_status')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'product_id')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton($model->isNewRecord ? 'Create' : 'Update', ['class' => $model->isNewRecord ? 'btn btn-success' : 'btn btn-primary']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
