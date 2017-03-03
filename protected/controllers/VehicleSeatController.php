<?php /* BeginFeature:VehicleSeat */

class VehicleSeatController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'VehicleSeat'),
		));
	}

	public function actionCreate($id) {                
                $this->loadModel($id, 'Vehicle');                            
		$model = new VehicleSeat();
                $model->id_vehicle = $id;

		$this->performAjaxValidation($model, 'vehicle-seat-form');

		if (isset($_POST['VehicleSeat'])) {
			$model->setAttributes($_POST['VehicleSeat']);

			if ($model->save()) {
				if (Yii::app()->getRequest()->getIsAjaxRequest())
					Yii::app()->end();
				else
					$this->redirect(array('view', 'id' => $model->id));
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'VehicleSeat');

		$this->performAjaxValidation($model, 'vehicle-seat-form');

		if (isset($_POST['VehicleSeat'])) {
			$model->setAttributes($_POST['VehicleSeat']);

			if ($model->save()) {
				$this->redirect(array('view', 'id' => $model->id));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
                        $model = $this->loadModel($id, 'VehicleSeat');
                        $vehicleId = $model->id_vehicle;
			$model->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('vehicle/view','id' => $vehicleId));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new VehicleSeat('search');
		$model->unsetAttributes();

		if (isset($_GET['VehicleSeat']))
			$model->setAttributes($_GET['VehicleSeat']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:VehicleSeat */