<?php

/* @var $this yii\web\View */

$this->title = 'WebCRM';
?>
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
        <label>Nome da empresa</label>
        <input id="productName" class="form-control " name="productName">
    </div>
    <div style="clear: both"></div>
    <div class="box-body" style="margin-bottom: 3%">
        <select multiple="multiple" class="multi-select" id="my_multi_select2" name="my_multi_select2[]">
            <optgroup label="User">
                <option selected>Executive</option>
                <option>Director</option>
            </optgroup>
            <optgroup label="Products">
                <option selected>Static</option>
                <option>Dynamic</option>
            </optgroup>
            <optgroup label="Opportunities">
                <option>Proof of concept</option>
                <option>Finders</option>
                <option>Business Accreditation</option>
            </optgroup>
            <optgroup label="Reports">
                <option>Closed Opportunities</option>
                <option>Refused Opportunities</option>
                <option selected>Acquired Products</option>
                <option selected>Refused Products</option>
            </optgroup>
        </select>
    </div>

    <div style="clear: both"></div>
    <div class="box-footer clearfix">

        <?= \yii\helpers\Html::button('Aplicar', ['class' => 'confirm-selection btn btn-sm btn-info btn-flat pull-left']) ?>
    </div>
    <?= \yii\bootstrap\Html::endForm() ?>
</div>

<?php
$js = <<<JS
$('#my_multi_select2').multiSelect({
  selectableHeader: "<div class='custom-header'>Features disponíveis</div>",
  selectionHeader: "<div class='custom-header'>Features escolhidas</div>"
});

$(".confirm-selection").on('click', function() {
    $("#form-selection").submit();
})
JS;

$this->registerJs($js);
?>
