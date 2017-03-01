<?php /* @var $this Controller */ ?>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="language" content="en">

	<!-- blueprint CSS framework -->
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/screen.css" media="screen, projection">
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/print.css" media="print">
	<!--[if lt IE 8]>
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/ie.css" media="screen, projection">
	<![endif]-->

	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/main.css">
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/form.css">

	<title><?php echo CHtml::encode($this->pageTitle); ?></title>
</head>

<body>

<div class="container" id="page">

	<div id="header">
		<div id="logo"><?php echo CHtml::encode(Yii::app()->name); ?></div>
	</div><!-- header -->

	<div id="mainmenu">
		<?php $this->widget('zii.widgets.CMenu',array(
			'items'=>array(
				array('label'=>'Home', 'url'=>array('/site/index')),
                                /* BeginFeature:City */
                                array('label'=>'City', 'url'=>array('/city'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:City */
                                /* BeginFeature:Country */
                                array('label'=>'Country', 'url'=>array('/country'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:Country */
                                /* BeginFeature:DocumentType */
                                array('label'=>'Document Type', 'url'=>array('/documentType'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:DocumentType */                            
                                /* BeginFeature:Manufacturer */
                                array('label'=>'Manufacturer', 'url'=>array('/manufacturer'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:Manufacturer */
                                /* BeginFeature:SeatType */
                                array('label'=>'Seat Type', 'url'=>array('/seatType'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:SeatType */                            
                                /* BeginFeature:State */
                                array('label'=>'State', 'url'=>array('/state'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:State */
                                /* BeginFeature:Station */
                                array('label'=>'Station', 'url'=>array('/station'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:Station */                            
                                /* BeginFeature:Vehicle */
                                array('label'=>'Vehicle', 'url'=>array('/vehicle'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:Vehicle */                              
                                /* BeginFeature:VehicleModel */
                                array('label'=>'Vehicle Model', 'url'=>array('/vehicleModel'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:VehicleModel */                            
                                /* BeginFeature:VehicleType */
                                array('label'=>'Vehicle Type', 'url'=>array('/vehicleType'), 'visible'=>!Yii::app()->user->isGuest),
                                /* EndFeature:VehicleType */                            
				array('label'=>'Contact', 'url'=>array('/site/contact')),
				array('label'=>'Login', 'url'=>array('/site/login'), 'visible'=>Yii::app()->user->isGuest),
				array('label'=>'Logout ('.Yii::app()->user->name.')', 'url'=>array('/site/logout'), 'visible'=>!Yii::app()->user->isGuest)
			),
		)); ?>
	</div><!-- mainmenu -->
	<?php if(isset($this->breadcrumbs)):?>
		<?php $this->widget('zii.widgets.CBreadcrumbs', array(
			'links'=>$this->breadcrumbs,
		)); ?><!-- breadcrumbs -->
	<?php endif?>

	<?php echo $content; ?>

	<div class="clear"></div>

	<div id="footer">
		Copyright &copy; <?php echo date('Y'); ?> by My Company.<br/>
		All Rights Reserved.<br/>
		<?php echo Yii::powered(); ?>
	</div><!-- footer -->

</div><!-- page -->

</body>
</html>
