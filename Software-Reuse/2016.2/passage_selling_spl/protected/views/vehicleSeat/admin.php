<?php /* BeginFeature:VehicleSeat */ ?>
<h1><?php echo Yii::t('app', 'Manage') . ' ' . GxHtml::encode($model->label(2)); ?></h1>
<?php $this->widget('zii.widgets.grid.CGridView', array(
	'id' => 'vehicle-seat-grid',
        'ajaxUrl' => array('/vehicleSeat/admin'),
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:SeatType */
		array(
				'name'=>'id_seat_type',
				'value'=>'GxHtml::valueEx($data->idSeatType)',
				'filter'=>GxHtml::listDataEx(SeatType::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:SeatType*/
		'code',
		'position',
		'description',
		array(
			'class' => 'CButtonColumn',
                        'buttons' => array(
                                'view' => array(
                                    'url' => 'Yii::app()->createUrl("vehicleSeat/view", array("id"=>$data->id))',       
                                ),                            
                                'update' => array(
                                    'url' => 'Yii::app()->createUrl("vehicleSeat/update", array("id"=>$data->id))',       
                                ),                            
                                'delete' => array(
                                    'url' => 'Yii::app()->createUrl("vehicleSeat/delete", array("id"=>$data->id))',       
                                ),                        
                        ),
                    
		),
	),
)); 
/* EndFeature:VehicleSeat */