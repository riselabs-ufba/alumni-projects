<?php $this->pageTitle = Yii::app()->name; ?>

<h1>Welcome to <i><?php echo CHtml::encode(Yii::app()->name); ?></i> Dashboard</h1>
<div class="span-23 showgrid">
    <div class="dashboardIcons span-16">
        <?php /* BeginFeature:Line */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-move.png' />", array('/line')); ?>            
            <div class="dashIconText "><?php echo CHtml::link('Line', array('/line')); ?></div>
        </div>
        <?php /* EndFeature:Line */ ?>        
        <?php /* BeginFeature:Manufacturer */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-tools.png' />", array('/manufacturer')); ?>            
            <div class="dashIconText "><?php echo CHtml::link('Manufacturer', array('/manufacturer')); ?></div>
        </div>
        <?php /* EndFeature:Manufacturer */ ?>
        <?php /* BeginFeature:Passenger */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-person.png' />", array('/passenger')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Passenger', array('/passenger')); ?></div>
        </div>
        <?php /* EndFeature:Passenger */ ?>
        <?php /* BeginFeature:Station */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-directions2.png' />", array('/station')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Station', array('/station')); ?></div>
        </div>
        <?php /* EndFeature:Station */ ?>
        <?php /* BeginFeature:Ticket */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-tag-cash.png' />", array('/ticket')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Ticket', array('/ticket')); ?></div>
        </div>
        <?php /* EndFeature:Ticket */ ?>        
        <?php /* BeginFeature:Travel */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-clock2.png' />", array('/travel')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Travel', array('/travel')); ?></div>
        </div>
        <?php /* EndFeature:Travel */ ?>        
        <?php /* BeginFeature:Vehicle */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-car.png' />", array('/vehicle')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Vehicle', array('/vehicle')); ?></div>
        </div>
        <?php /* EndFeature:Vehicle */ ?>
        <?php /* BeginFeature:VehicleModel */ ?>
        <div class="dashIcon span-3">
            <?php echo CHtml::link("<img src='" . Yii::app()->theme->baseUrl . "/images/big_icons/icon-brush.png' />", array('/vehicleModel')); ?>
            <div class="dashIconText"><?php echo CHtml::link('Vehicle Model', array('/vehicleModel')); ?></div>
        </div>  
        <?php /* EndFeature:VehicleModel */ ?>        
    </div><!-- END OF .dashIcons -->
</div>