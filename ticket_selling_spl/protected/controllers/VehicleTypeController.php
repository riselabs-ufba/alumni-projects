<?php /* BeginFeature:VehicleType */

class VehicleTypeController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'VehicleType'),
		));
	}

	public function actionCreate() {
		$model = new VehicleType;

		$this->performAjaxValidation($model, 'vehicle-type-form');

		if (isset($_POST['VehicleType'])) {
			$model->setAttributes($_POST['VehicleType']);

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
		$model = $this->loadModel($id, 'VehicleType');

		$this->performAjaxValidation($model, 'vehicle-type-form');

		if (isset($_POST['VehicleType'])) {
			$model->setAttributes($_POST['VehicleType']);

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
			$this->loadModel($id, 'VehicleType')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new VehicleType('search');
		$model->unsetAttributes();

		if (isset($_GET['VehicleType']))
			$model->setAttributes($_GET['VehicleType']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:VehicleType */