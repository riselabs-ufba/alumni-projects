<?php

/* @var $this yii\web\View */

$this->title = 'WebCRM';
?>
<?php if (Yii::$app->session->hasFlash('success')): ?>
    <div class="alert alert-success alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4><i class="icon fa fa-check"></i> Alerta</h4>
        Produto criado com sucesso, para acessar o seu sistema clique neste <a target="_blank"
                                                                               href="<?= $link ?>">link</a>
    </div>
<?php endif; ?>

<?php if (Yii::$app->session->hasFlash('error')): ?>
    <div class="alert alert-danger alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4><i class="icon fa fa-check"></i> Alerta</h4>

        <?= Yii::$app->session->getFlash("error") ?>
    </div>
<?php endif; ?>

<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Configuração do Produto</h3>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
        </div>
    </div>
    <?= \yii\bootstrap\Html::beginForm('', '', ['id' => 'form-selection']) ?>

    <div class="form-group col-lg-3">
        <label>Produto</label>
        <input id="productName" class="form-control " name="productName">
    </div>
    <div style="clear: both"></div>
    <div class="form-group col-lg-6">
        <?php echo \yii\bootstrap\Html::label('Tipo de Produto'); ?>
        <?php echo \yii\bootstrap\Html::radioList('features', array(), array('smallBusiness' => 'Small Business', 'standardBusiness' => 'Standard Business', 'professionalBusiness' => 'Professional Business', 'enterpriseBusiness' => 'Enterprise Business')); ?>
    </div>
    <div style="clear: both"></div>
    <div id="smallBusiness" style="display: none" class="descFeature form-group-6 ">
        <h5>Features disponíveis</h5>
        <ul>
            <li>User -> Executive</li>
            <li>Product -> Static</li>
            <li>Opportunities -> Proof of Concept</li>
            <li>Reports - Acquired Products</li>
            <li>Reports - Refused Products</li>
        </ul>
    </div>
    <div id="standardBusiness" style="display: none" class="descFeature form-group-6">
        <h5>Features disponíveis</h5>
        <ul>
            <li>User -> Executive</li>
            <li>Product -> Static</li>
            <li>Opportunities -> Partner</li>
            <li>Reports - Acquired Products</li>
            <li>Reports - Refused Products</li>
            <li>Reports - Closed Opportunities</li>
            <li>Reports - Refused Opportunities</li>
        </ul>
    </div>
    <div id="professionalBusiness" style="display: none" class="descFeature form-group-6">
        <h5>Features disponíveis</h5>
        <ul>
            <li>User -> Director</li>
            <li>User -> Executive</li>
            <li>Product -> Dynamic</li>
            <li>Opportunities -> Partner</li>
            <li>Opportunities -> Finder</li>
            <li>Reports - Acquired Products</li>
            <li>Reports - Refused Products</li>
            <li>Reports - Closed Opportunities</li>
            <li>Reports - Refused Opportunities</li>
        </ul>
    </div>
    <div id="enterpriseBusiness" style="display: none" class="descFeature form-group-6">
        <h5>Features disponíveis</h5>
        <ul>
            <li>User -> Director</li>
            <li>User -> Executive</li>
            <li>Product -> Dynamic</li>
            <li>Opportunities -> Partner</li>
            <li>Opportunities -> Finder</li>
            <li>Opportunities -> Proof of Concept</li>
            <li>Reports - Acquired Products</li>
            <li>Reports - Refused Products</li>
            <li>Reports - Closed Opportunities</li>
            <li>Reports - Refused Opportunities</li>
        </ul>
    </div>

    <div style="clear: both"></div>
    <div class="box-footer clearfix">

        <?= \yii\helpers\Html::button('Aplicar', ['class' => 'confirm-selection btn btn-sm btn-info btn-flat pull-left']) ?>
    </div>
    <?= \yii\bootstrap\Html::endForm() ?>
</div>

<?php
$js = <<<JS

$("input:radio[name=features]").on("change",function() {
    var feature = $(this).val();
    $('.descFeature').hide();
    $("#"+feature).show();
});

$(".confirm-selection").on('click', function() {
    $("#form-selection").submit();
})
JS;

$this->registerJs($js);
?>
