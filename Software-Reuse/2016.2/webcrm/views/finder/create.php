<?php

use yii\helpers\Html;


/* @var $this yii\web\View */
/* @var $model app\models\Finder */

$this->title = 'Create Finder';
$this->params['breadcrumbs'][] = ['label' => 'Finders', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="finder-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
