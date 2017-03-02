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

    <div class="box-body" style="margin-bottom: 3%">
        <select multiple="multiple" class="multi-select" id="my_multi_select2" name="my_multi_select2[]">
            <optgroup label="Catalog">
                <option>Static</option>
                <option>Dynamic</option>
            </optgroup>
            <optgroup label="Customer">
                <option>Login</option>
                <option>Sign up</option>
            </optgroup>
            <optgroup label="Purchase">
                <option>Payment</option>
                <option>Shipment</option>
                <option>Order</option>
            </optgroup>
            <optgroup label="Reports">
                <option>Spending</option>
                <option>Balance</option>
            </optgroup>
        </select>
    </div>

    <div style="clear: both"></div>
    <div class="box-footer clearfix">

        <?= \yii\helpers\Html::button('Aplicar', ['class' => 'btn btn-sm btn-info btn-flat pull-left']) ?>
    </div>
</div>

<?php
$js = <<<JS
$('#my_multi_select2').multiSelect({
  selectableHeader: "<div class='custom-header'>Features disponíveis</div>",
  selectionHeader: "<div class='custom-header'>Features escolhidas</div>"
})
JS;

$this->registerJs($js);
?>
