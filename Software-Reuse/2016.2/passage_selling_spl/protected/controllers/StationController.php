<?php /* BeginFeature:Station */

class StationController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Station'),
		));
	}

	public function actionCreate() {
		$model = new Station;

		$this->performAjaxValidation($model, 'station-form');

		if (isset($_POST['Station'])) {
			$model->setAttributes($_POST['Station']);

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
		$model = $this->loadModel($id, 'Station');

		$this->performAjaxValidation($model, 'station-form');

		if (isset($_POST['Station'])) {
			$model->setAttributes($_POST['Station']);

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
			$this->loadModel($id, 'Station')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Station('search');
		$model->unsetAttributes();

		if (isset($_GET['Station']))
			$model->setAttributes($_GET['Station']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Station */