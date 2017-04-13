<?php /* BeginFeature:Passenger */

class PassengerController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Passenger'),
		));
	}

	public function actionCreate() {
		$model = new Passenger;

		$this->performAjaxValidation($model, 'passenger-form');

		if (isset($_POST['Passenger'])) {
			$model->setAttributes($_POST['Passenger']);

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
		$model = $this->loadModel($id, 'Passenger');

		$this->performAjaxValidation($model, 'passenger-form');

		if (isset($_POST['Passenger'])) {
			$model->setAttributes($_POST['Passenger']);

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
			$this->loadModel($id, 'Passenger')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Passenger('search');
		$model->unsetAttributes();

		if (isset($_GET['Passenger']))
			$model->setAttributes($_GET['Passenger']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Passenger */