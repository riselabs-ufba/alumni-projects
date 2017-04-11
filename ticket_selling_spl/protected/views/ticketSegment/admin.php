<?php /* BeginFeature:TicketSegment */ ?>


<h1><?php echo Yii::t('app', 'Manage') . ' ' . GxHtml::encode($model->label(2)); ?></h1>



<?php
$template = '{view}';
/* BeginFeature:ChooseSeat */
$template .= '{update}';
/* EndFeature:ChooseSeat */

$this->widget('zii.widgets.grid.CGridView', array(
    'id' => 'ticket-segment-grid',
    'ajaxUrl' => array('/ticketSegment/admin'),
    'dataProvider' => $model->search(),
    'columns' => array(
        /* BeginFeature:Segment */
        'idSegment.idStationDeparture',
        'idSegment.idStationArrival',
        /* EndFeature:Segment */        
        /* BeginFeature:VehicleSeat */
        array(
            'name' => 'id_vehicle_seat',
            'value' => 'GxHtml::valueEx($data->idVehicleSeat)',
            'filter' => GxHtml::listDataEx(VehicleSeat::model()->findAllAttributes(null, true)),
        ),
        /* EndFeature:VehicleSeat */
        array(
            'class' => 'CButtonColumn',
            'template' => $template,
            'buttons' => array(
                    'view' => array(
                        'url' => 'Yii::app()->createUrl("ticketSegment/view", array("id"=>$data->id))',       
                    ),                            
                    /* BeginFeature:ChooseSeat */
                    'update' => array(
                        'url' => 'Yii::app()->createUrl("ticketSegment/update", array("id"=>$data->id))',       
                    ),    
                    /* EndFeature:ChooseSeat */
            ),
        ),
    ),
));
/* EndFeature:TicketSegment */