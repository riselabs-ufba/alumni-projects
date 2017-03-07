<?php

/**
 * Description of Feature
 *
 * @author user
 */
class Feature extends CFormModel {
    
    const MANUFACTURER = 0;
    const VEHICLE_MODEL = 1;
    const VEHICLE_SEAT = 2;
    const SEAT_TYPE = 3;
    
    public $toKeep = array();
    
    public function label(){
        return 'Feature Manager';
    }
    
    public function attributeLabels() {
        return array(
            'toKeep' => 'Select optional features: '
        );
    }
    
    public function rules() {
        return array(
            array('toKeep','validateDependencies'),
        );
    }
    
    public function getOptionalFeatures(){
        return array(
            self::MANUFACTURER => array(
                'label' => Manufacturer::label(),
                'annotation' => get_class(Manufacturer::model()), 
                'requires' => array(
                    self::VEHICLE_MODEL
                ),
            ),
            self::VEHICLE_MODEL => array(
                'label' => VehicleModel::label(),
                'annotation' => get_class(VehicleModel::model()), 
                'requires' => array(),
            ), 
            self::VEHICLE_SEAT => array(
                'label' => VehicleSeat::label(),
                'annotation' => get_class(VehicleSeat::model()),
                'requires' => array(),
            ),               
            self::SEAT_TYPE => array(
                'label' => SeatType::label(),
                'annotation' => get_class(SeatType::model()),
                'requires' => array(
                    self::VEHICLE_SEAT,
                ),
            ),              
        );
    }
    
    public function validateDependencies($attribute, $params){
        $optionalFeatures = $this->getOptionalFeatures();
        $toRemove = array_diff(array_keys($optionalFeatures), (array) $this->toKeep);
        foreach ((array) $this->toKeep as $featureToKeep) {
            foreach ($toRemove as $featureToRemove) {
                if (array_search($featureToRemove, $optionalFeatures[$featureToKeep]['requires'])!==false) {
                    $error = "The feature {$optionalFeatures[$featureToKeep]['label']} needs feature {$optionalFeatures[$featureToRemove]['label']}.";
                    $this->addError($attribute, $error);
                }
            }
        }
    }

    public function deploy() {
        $optionalFeatures = $this->getOptionalFeatures();
        $toRemove = array_diff(array_keys($optionalFeatures), (array) $this->toKeep);
        
        $root = str_replace('protected', '*', Yii::app()->getBasePath());
        $rootTemp = str_replace('/protected', '-temp', Yii::app()->getBasePath());
        
        shell_exec("rm -R {$rootTemp}/*");
        shell_exec("cp -R {$root} {$rootTemp}");
        shell_exec("rm -R {$rootTemp}/nbproject");        
        shell_exec("rm -R {$rootTemp}/assets/*");
        shell_exec("rm -R {$rootTemp}/protected/runtime/*");
        
        foreach ($toRemove as $feature) {
            $annotation = $optionalFeatures[$feature]['annotation'];
            echo shell_exec("find {$rootTemp} -type f -print0 | xargs -0 sed -i '/BeginFeature:{$annotation}/,/EndFeature:{$annotation}/d'");    
        }
        
        shell_exec("find {$rootTemp} -size  0 -print0 | xargs -0 rm");
        shell_exec("find {$rootTemp}/protected/controllers -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/models -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/views -type d -empty -delete");
        
        return true;
    }

}
