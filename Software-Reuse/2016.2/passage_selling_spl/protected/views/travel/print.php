<?php /* BeginFeature:PrintPassenger */
$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	GxHtml::valueEx($model),
);

$this->menu=array(
	array('label'=>Yii::t('app', 'View') . ' ' . $model->label(), 'url'=>array('view', 'id' => $model->id)),
);

$columnsArray = array('departure','arrival','passenger','vehicle_seat');
$rowsArray = $model->getPassengerListPerSegment();
 
$this->widget('ext.htmltableui.htmlTableUi',array(
    'collapsed'=>false,
    'enableSort'=>true,
    'title'=>'Print Passenger Per Segment',
    'subtitle'=>$model->idLine->name.': '.$model->start_date,
    'columns'=>$columnsArray,
    'rows'=>$rowsArray,
    'footer'=>'Total rows: '.count($rowsArray)
));

/* EndFeature:PrintPassenger */