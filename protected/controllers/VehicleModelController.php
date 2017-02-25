<?php /* BeginFeature:VehicleModel */

class VehicleModelController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'VehicleModel'),
		));
	}

	public function actionCreate() {
		$model = new VehicleModel;

		$this->performAjaxValidation($model, 'vehicle-model-form');

		if (isset($_POST['VehicleModel'])) {
			$model->setAttributes($_POST['VehicleModel']);

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
		$model = $this->loadModel($id, 'VehicleModel');

		$this->performAjaxValidation($model, 'vehicle-model-form');

		if (isset($_POST['VehicleModel'])) {
			$model->setAttributes($_POST['VehicleModel']);

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
			$this->loadModel($id, 'VehicleModel')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new VehicleModel('search');
		$model->unsetAttributes();

		if (isset($_GET['VehicleModel']))
			$model->setAttributes($_GET['VehicleModel']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:VehicleModel */