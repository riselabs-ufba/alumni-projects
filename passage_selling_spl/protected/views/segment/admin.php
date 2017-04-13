<?php /* BeginFeature:MultiSegment */ ?>

<h1><?php echo Yii::t('app', 'Manage') . ' ' . GxHtml::encode($model->label(2)); ?></h1>

<?php $this->widget('zii.widgets.grid.CGridView', array(
	'id' => 'segment-grid',
        'ajaxUrl' => array('segment/admin'),
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Station */
		array(
				'name'=>'id_station_departure',
				'value'=>'GxHtml::valueEx($data->idStationDeparture)',
				'filter'=>GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Station*/
		/* BeginFeature:Station */
		array(
				'name'=>'id_station_arrival',
				'value'=>'GxHtml::valueEx($data->idStationArrival)',
				'filter'=>GxHtml::listDataEx(Station::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Station*/
		'sequence_number',
		'estimated_time',
		array(
			'class' => 'CButtonColumn',
                        'buttons' => array(
                                'view' => array(
                                    'url' => 'Yii::app()->createUrl("segment/view", array("id"=>$data->id))',       
                                ),                            
                                'update' => array(
                                    'url' => 'Yii::app()->createUrl("segment/update", array("id"=>$data->id))',       
                                ),                            
                                'delete' => array(
                                    'url' => 'Yii::app()->createUrl("segment/delete", array("id"=>$data->id))',       
                                ),                        
                        ),
                    
		),
	),
)); 
/* EndFeature:MultiSegment */