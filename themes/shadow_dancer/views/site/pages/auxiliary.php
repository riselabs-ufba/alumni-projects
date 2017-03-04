<?php $this->pageTitle = Yii::app()->name; ?>

<h1>Welcome to <i><?php echo CHtml::encode(Yii::app()->name); ?></i> Dashboard</h1>
<div class="span-23 showgrid">
    <div class="dashboardIcons span-16">
        <?php /* BeginFeature:City */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-map.png' />", array('/city')); ?>            
            <div class="dashIconText "><?php echo CHtml::link('City', array('/city')); ?></div>
        </div>
        <?php /* EndFeature:City */ ?>
        <?php /* BeginFeature:Country */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-earth.png' />", array('/country')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Country', array('/country')); ?></div>
        </div>
        <?php /* EndFeature:Country */ ?>
        <?php /* BeginFeature:DocumentType */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-file.png' />", array('/documentType')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Document Type', array('/documentType')); ?></div>
        </div>        
        <?php /* EndFeature:DocumentType */ ?>
        <?php /* BeginFeature:State */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-map2.png' />", array('/state')); ?>
            <div class="dashIconText"><?php echo CHtml::link('State', array('/state')); ?></div>
        </div>
        <?php /* EndFeature:State */ ?>
        <?php /* BeginFeature:SeatType */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-chair.png' />", array('/seatType')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Seat Type', array('/seatType')); ?></div>
        </div>  
        <?php /* EndFeature:SeatType */ ?>
        <?php /* BeginFeature:VehicleType */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-key.png' />", array('/vehicleType')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Vehicle Type', array('/vehicleType')); ?></div>
        </div>          
        <?php /* EndFeature:VehicleType */ ?>
    </div><!-- END OF .dashIcons -->
</div>