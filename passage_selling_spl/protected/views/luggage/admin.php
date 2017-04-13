<?php /* BeginFeature:Luggage */ ?>
<?php

$this->breadcrumbs = array(
	$model->label(2) => array('admin'),
	Yii::t('app', 'Manage'),
);

$this->menu = array(
		array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	);

Yii::app()->clientScript->registerScript('search', "
$('.search-form').hide();
$('.search-button').click(function(){
	$('.search-form').toggle();
	return false;
});
$('.search-form form').submit(function(){
	$.fn.yiiGridView.update('luggage-grid', {
		data: $(this).serialize()
	});
	return false;
});
");
?>

<h1><?php echo Yii::t('app', 'Manage') . ' ' . GxHtml::encode($model->label(2)); ?></h1>

<?php echo GxHtml::link(Yii::t('app', 'Advanced Search'), '#', array('class' => 'search-button')); ?>
<div class="search-form">
<?php $this->renderPartial('_search', array(
	'model' => $model,
)); ?>
</div><!-- search-form -->

<?php $this->widget('zii.widgets.grid.CGridView', array(
	'id' => 'luggage-grid',
	'dataProvider' => $model->search(),
	'filter' => $model,
	'columns' => array(
		/* BeginFeature:Passenger */
		array(
				'name'=>'id_passenger',
				'value'=>'GxHtml::valueEx($data->idTicket->idPassenger)',
                                'filter'=>GxHtml::listDataEx(Passenger::model()->findAllAttributes(null, true)),                    
                ),
		/* EndFeature:Passenger*/            
		/* BeginFeature:Ticket */
		array(
				'name'=>'id_ticket',
				'value'=>'GxHtml::valueEx($data->idTicket)',
				'filter'=>GxHtml::listDataEx(Ticket::model()->findAllAttributes(null, true)),
				),
		/* EndFeature:Ticket*/
		'code',
		'description',
		'weight',
		array(
					'name' => 'special',
					'value' => '($data->special === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		array(
					'name' => 'animal',
					'value' => '($data->animal === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		/*
		array(
					'name' => 'music_instrument',
					'value' => '($data->music_instrument === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		array(
					'name' => 'out_of_dimensions',
					'value' => '($data->out_of_dimensions === 0) ? Yii::t(\'app\', \'No\') : Yii::t(\'app\', \'Yes\')',
					'filter' => array('0' => Yii::t('app', 'No'), '1' => Yii::t('app', 'Yes')),
					),
		*/
		array(
			'class' => 'CButtonColumn',
		),
	),
)); 
/* EndFeature:Luggage */