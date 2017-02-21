<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
echo "<?php /*BeginFeature:{$this->modelClass}*/ ?>\n";
?>
<div class="wide form">

<?php echo "<?php \$form = \$this->beginWidget('GxActiveForm', array(
	'action' => Yii::app()->createUrl(\$this->route),
	'method' => 'get',
)); ?>\n"; ?>

<?php foreach($this->tableSchema->columns as $column): ?>
<?php
	$field = $this->generateInputField($this->modelClass, $column);
	if (strpos($field, 'password') !== false)
		continue;
        
        if ($column->isForeignKey) {
            $relatedModelClass = $this->findRelation($this->modelClass, $column)[3];
            echo "\t<?php /*BeginFeature:{$relatedModelClass}*/ ?>\n";
        }        
?>
	<div class="row">
		<?php echo "<?php echo \$form->label(\$model, '{$column->name}'); ?>\n"; ?>
		<?php echo "<?php " . $this->generateSearchField($this->modelClass, $column)."; ?>\n"; ?>
	</div>
<?php
        if ($column->isForeignKey) {            
            echo "\t<?php /*EndFeature:{$relatedModelClass}*/ ?>\n";
        }
?>

<?php endforeach; ?>
	<div class="row buttons">
		<?php echo "<?php echo GxHtml::submitButton(Yii::t('app', 'Search')); ?>\n"; ?>
	</div>

<?php echo "<?php \$this->endWidget(); ?>\n"; ?>

</div><!-- search-form -->
<?php echo "<?php /*EndFeature:{$this->modelClass}*/";