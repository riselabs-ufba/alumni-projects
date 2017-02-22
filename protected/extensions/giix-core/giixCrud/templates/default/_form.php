<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
echo "<?php /* BeginFeature:{$this->modelClass}*/ ?>\n";
?>
<div class="form">

<?php $ajax = ($this->enable_ajax_validation) ? 'true' : 'false'; ?>

<?php echo '<?php '; ?>
$form = $this->beginWidget('GxActiveForm', array(
	'id' => '<?php echo $this->class2id($this->modelClass); ?>-form',
	'enableAjaxValidation' => <?php echo $ajax; ?>,
));
<?php echo '?>'; ?>


	<p class="note">
		<?php echo "<?php echo Yii::t('app', 'Fields with'); ?> <span class=\"required\">*</span> <?php echo Yii::t('app', 'are required'); ?>"; ?>.
	</p>

	<?php echo "<?php echo \$form->errorSummary(\$model); ?>\n"; ?>

<?php foreach ($this->tableSchema->columns as $column): ?>
<?php if (!$column->autoIncrement): ?>
<?php
                if ($column->isForeignKey) {
                    $relatedModelClass = $this->findRelation($this->modelClass, $column)[3];
                    echo "\t\t<?php /* BeginFeature:{$relatedModelClass} */ ?>\n";
                }
?>
		<div class="row">
		<?php echo "<?php echo " . $this->generateActiveLabel($this->modelClass, $column) . "; ?>\n"; ?>
		<?php echo "<?php " . $this->generateActiveField($this->modelClass, $column) . "; ?>\n"; ?>
		<?php echo "<?php echo \$form->error(\$model,'{$column->name}'); ?>\n"; ?>
		</div><!-- row -->
<?php
                if ($column->isForeignKey) {            
                    echo "\t\t<?php /* EndFeature:{$relatedModelClass} */ ?>\n";
                }
?>
<?php endif; ?>
<?php endforeach; ?>

<?php echo "<?php
echo GxHtml::submitButton(Yii::t('app', 'Save'));
\$this->endWidget();
?>\n"; ?>
</div><!-- form -->
<?php echo "<?php /* EndFeature:{$this->modelClass} */";