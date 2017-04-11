<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
echo "<?php /* BeginFeature:{$this->modelClass} */ ?>\n";
?>
<?php
echo "<?php\n
\$this->breadcrumbs = array(
	\$model->label(2) => array('admin'),
	GxHtml::valueEx(\$model),
);\n";
?>

$this->menu=array(
	array('label'=>Yii::t('app', 'Create') . ' ' . $model->label(), 'url'=>array('create')),
	array('label'=>Yii::t('app', 'Update') . ' ' . $model->label(), 'url'=>array('update', 'id' => $model-><?php echo $this->tableSchema->primaryKey; ?>)),
	array('label'=>Yii::t('app', 'Delete') . ' ' . $model->label(), 'url'=>'#', 'linkOptions' => array('submit' => array('delete', 'id' => $model-><?php echo $this->tableSchema->primaryKey; ?>), 'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url'=>array('admin')),
);
?>

<h1><?php echo '<?php'; ?> echo Yii::t('app', 'View') . ' ' . GxHtml::encode($model->label()) . ' ' . GxHtml::encode(GxHtml::valueEx($model)); ?></h1>

<?php echo '<?php'; ?> $this->widget('zii.widgets.CDetailView', array(
	'data' => $model,
	'attributes' => array(
<?php
foreach ($this->tableSchema->columns as $column){
        if ($column->autoIncrement) continue;
        if ($column->isForeignKey) {
            $relatedModelClass = $this->findRelation($this->modelClass, $column)[3];
            echo "\t\t/* BeginFeature:{$relatedModelClass} */\n";
        }
		echo $this->generateDetailViewAttribute($this->modelClass, $column) . ",\n";
        if ($column->isForeignKey) {            
            echo "\t\t/* EndFeature:{$relatedModelClass} */\n";
        }                
}
?>
	),
));
<?php echo "/* EndFeature:{$this->modelClass}*/";