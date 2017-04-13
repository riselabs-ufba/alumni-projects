<?php
/**
 * The following variables are available in this template:
 * - $this: the CrudCode object
 */
echo "<?php /* BeginFeature:{$this->modelClass} */ ?>\n";
?>
<?php
echo "<?php
\$this->breadcrumbs = array(
	\$model->label(2) => array('admin'),
	Yii::t('app', 'Create'),
);\n";
?>

$this->menu = array(
	array('label'=>Yii::t('app', 'Manage') . ' ' . $model->label(2), 'url' => array('admin')),
);
?>

<h1><?php echo '<?php'; ?> echo Yii::t('app', 'Create') . ' ' . GxHtml::encode($model->label()); ?></h1>

<?php echo "<?php\n"; ?>
$this->renderPartial('_form', array(
		'model' => $model,
		'buttons' => 'create'));
<?php echo "/* EndFeature:{$this->modelClass} */";
