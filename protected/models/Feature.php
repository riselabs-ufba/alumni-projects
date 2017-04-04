<?php

if (!function_exists("array_column")) {

    function array_column($array, $column_name) {
        return array_map(function($element) use($column_name) {
            return $element[$column_name];
        }, $array);
    }

}

/**
 * Description of Feature
 *
 * @author user
 */
class Feature extends CFormModel {

    const BATCH_REGISTRATION = 14;
    const CHOOSE_SEAT = 16;
    const CONTACT_US = 4;
    const EXPORT_JSON = 11;
    const EXPORT_XML = 12;
    const FEATURE_MANAGER = 6;
    const FLIGHT_PLAN = 7;
    const LUGGAGE = 13;
    const MANUFACTURER = 0;
    const VEHICLE_MODEL = 1;
    const VEHICLE_SEAT = 2;
    const VEHICLE_TYPE_BOAT = 8;
    const VEHICLE_TYPE_BUS = 9;
    const VEHICLE_TYPE_PLANE = 10;
    const PASSENGER = 5;
    const SEAT_TYPE = 3;
    const SEGMENT = 15;

    public $toKeep = array();
    public $vehicleType;

    public function label() {
        return 'Feature Manager';
    }

    public function attributeLabels() {
        return array(
            'toKeep' => 'Optional features: ',
            'vehicleType' => VehicleType::label(),
        );
    }

    public function rules() {
        return array(
            array('toKeep', 'validateDependencies'),
            array('vehicleType', 'required'),
        );
    }

    public function getVehicleTypeFeatures() {
        return array(
            self::VEHICLE_TYPE_BOAT => array(
                'label' => 'Boat',
                'annotation' => 'Boat',
                'requires' => array(),
            ),
            self::VEHICLE_TYPE_BUS => array(
                'label' => 'Bus',
                'annotation' => 'Bus',
                'requires' => array(),
            ),
            self::VEHICLE_TYPE_PLANE => array(
                'label' => 'Plane',
                'annotation' => 'Plane',
                'requires' => array(),
            ),
        );
    }

    public function getOptionalFeatures() {
        return array(
            self::BATCH_REGISTRATION => array(
                'label' => 'Batch Registration',
                'annotation' => 'BatchRegistration',
                'requires' => array(
                    self::VEHICLE_SEAT,
                ),
            ),  
            self::CHOOSE_SEAT => array(
                'label' => 'Choose Seat',
                'annotation' => 'ChooseSeat',
                'requires' => array(
                    self::VEHICLE_SEAT,
                ),
            ),            
            self::CONTACT_US => array(
                'label' => 'Contact Developer',
                'annotation' => 'ContactUs',
                'requires' => array(),
            ),
            self::EXPORT_JSON => array(
                'label' => 'Export to JSON',
                'annotation' => 'JSON',
                'requires' => array(),
            ),   
            self::EXPORT_XML => array(
                'label' => 'Export to XML',
                'annotation' => 'XML',
                'requires' => array(),
            ),            
            self::LUGGAGE => array(
                'label' => 'Luggage Registration',
                'annotation' => get_class(Luggage::model()),
                'requires' => array(
                    self::PASSENGER,
                ),
            ),            
            self::FLIGHT_PLAN => array(
                'label' => FlightPlan::label(),
                'annotation' => get_class(FlightPlan::model()),
                'requires' => array(
                    self::VEHICLE_TYPE_PLANE,
                ),
            ),
            self::PASSENGER => array(
                'label' => 'Register Passenger',
                'annotation' => get_class(Passenger::model()),
                'requires' => array(
                    self::VEHICLE_TYPE_PLANE,
                ),
            ),
            self::SEGMENT => array(
                'label' => 'Register Segment',
                'annotation' => get_class(Segment::model()),
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

    public function getFeaturesToList($features) {
        $list = array();
        foreach ($features as $key => $value) {
            $list[$key] = $value['label'];
        }
        return $list;
    }

    public function validateDependencies($attribute, $params) {

        if (empty($this->vehicleType) || $this->toKeep == '-1') {
            return;
        }
        
        $features = $this->getVehicleTypeFeatures()+$this->getOptionalFeatures();

        $vehicleTypeToRemove = array_diff(array_keys($this->getVehicleTypeFeatures()), (array) $this->vehicleType);
        $optionalFeatures = $this->getOptionalFeatures();
        $optionalFeaturesToRemove = array_diff(array_keys($optionalFeatures), (array) $this->toKeep);
        $toRemove = CMap::mergeArray($vehicleTypeToRemove,$optionalFeaturesToRemove);
        
        $this->toKeep[] = $this->vehicleType;

        foreach ((array) $this->toKeep as $featureToKeep) {
            foreach ($toRemove as $featureToRemove) {
                if (array_search($featureToRemove, $features[$featureToKeep]['requires']) !== false) {
                    $error = "The feature {$features[$featureToKeep]['label']} needs feature {$features[$featureToRemove]['label']}.";
                    $this->addError($attribute, $error);
                }
            }
        }
    }

    public function deploy() {
        $optionalFeatures = $this->getOptionalFeatures();
        $optionalFeatures[self::FEATURE_MANAGER]['annotation'] = 'FeatureManager';
        $vehicleTypeFeatures = $this->getVehicleTypeFeatures();

        $vehicleTypeToRemove = array_diff(array_keys($vehicleTypeFeatures), (array) $this->vehicleType);
        $optionalFeaturesToRemove = array_diff(array_keys($optionalFeatures), (array) $this->toKeep);
        $toRemove = CMap::mergeArray($vehicleTypeToRemove,$optionalFeaturesToRemove);

        $root = str_replace('protected', '*', Yii::app()->getBasePath());
        $rootTemp = str_replace('/protected', '-temp', Yii::app()->getBasePath());

        shell_exec("rm -R {$rootTemp}/*");
        shell_exec("cp -R {$root} {$rootTemp}");
        shell_exec("rm -R {$rootTemp}/nbproject");
        shell_exec("rm -R {$rootTemp}/assets/*");
        shell_exec("rm -R {$rootTemp}/protected/runtime/*");
        
        $features = $vehicleTypeFeatures+$optionalFeatures;

        foreach ($toRemove as $feature) {
            $annotation = $features[$feature]['annotation'];
            echo shell_exec("find {$rootTemp} -type f -print0 | xargs -0 sed -i '/BeginFeature:{$annotation}/,/EndFeature:{$annotation}/d'");
        }

        shell_exec("find {$rootTemp} -size  0 -print0 | xargs -0 rm");
        shell_exec("find {$rootTemp}/protected/controllers -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/models -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/views -type d -empty -delete");

        return true;
    }

}
