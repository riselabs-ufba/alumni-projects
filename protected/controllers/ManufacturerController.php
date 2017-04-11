<?php /* BeginFeature:Manufacturer */

class ManufacturerController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Manufacturer'),
		));
	}

	public function actionCreate() {
		$model = new Manufacturer;

		$this->performAjaxValidation($model, 'manufacturer-form');

		if (isset($_POST['Manufacturer'])) {
			$model->setAttributes($_POST['Manufacturer']);

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
		$model = $this->loadModel($id, 'Manufacturer');

		$this->performAjaxValidation($model, 'manufacturer-form');

		if (isset($_POST['Manufacturer'])) {
			$model->setAttributes($_POST['Manufacturer']);

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
			$this->loadModel($id, 'Manufacturer')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Manufacturer('search');
		$model->unsetAttributes();

		if (isset($_GET['Manufacturer']))
			$model->setAttributes($_GET['Manufacturer']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Manufacturer */