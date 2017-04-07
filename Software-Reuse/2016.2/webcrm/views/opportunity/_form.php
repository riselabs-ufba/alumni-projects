<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/* @var $this yii\web\View */
/* @var $model app\models\Opportunity */
/* @var $form yii\widgets\ActiveForm */
?>

<div class="opportunity-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'company')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'person_name')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'person_email')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'person_tel')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'open_date')->textInput() ?>

    <?= $form->field($model, 'next_contact_date')->textInput() ?>

    <?= $form->field($model, 'note')->textarea(['rows' => 6]) ?>

    <?= $form->field($model, 'user_id')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton($model->isNewRecord ? 'Create' : 'Update', ['class' => $model->isNewRecord ? 'btn btn-success' : 'btn btn-primary']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
