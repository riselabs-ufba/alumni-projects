<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
echo "<?php //BeginFeature:{$this->modelClass} ?>\n";
?>
<div class="view">

	<?php echo '<?php'; ?> echo GxHtml::encode($data->getAttributeLabel('<?php echo $this->tableSchema->primaryKey; ?>')); <?php echo '?>'; ?>:
	<?php echo '<?php'; ?> echo GxHtml::link(GxHtml::encode($data-><?php echo $this->tableSchema->primaryKey; ?>), array('view', 'id' => $data-><?php echo $this->tableSchema->primaryKey; ?>)); <?php echo "?>\n"; ?>
	<br />

<?php
$count=0;
foreach ($this->tableSchema->columns as $column):
	if ($column->isPrimaryKey)
		continue;
	if (++$count == 7)
		echo "\t<?php /*\n";
?>
<?php 
if ($column->isForeignKey) {
    $relations = $this->findRelation($this->modelClass, $column);
    $relationName = $relations[0];    
    echo "\t<?php //BeginFeature:{$relations[3]} ?>\n";    
}
        echo "\t<?php"; ?> echo GxHtml::encode($data->getAttributeLabel('<?php echo $column->name; ?>')); <?php echo '?>'; ?>:
<?php if (!$column->isForeignKey): ?>
	<?php echo '<?php'; ?> echo GxHtml::encode($data-><?php echo $column->name; ?>); <?php echo "?>\n"; ?>
        <br />
<?php else: ?>
	<?php echo '<?php'; ?> echo GxHtml::encode(GxHtml::valueEx($data-><?php echo $relationName; ?>)); <?php echo "?>\n"; ?>
        <br />
        <?php echo "<?php //EndFeature:{$relations[3]} ?>\n"; ?>
<?php endif; ?>	
<?php endforeach; ?>
<?php
if($count>=7)
	echo "\t*/ ?>\n";
?>

</div>
<?php echo "<?php //EndFeature:{$this->modelClass}";