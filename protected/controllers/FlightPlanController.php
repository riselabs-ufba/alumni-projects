<?php /* BeginFeature:FlightPlan */

class FlightPlanController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'FlightPlan'),
		));
	}

	public function actionCreate() {
		$model = new FlightPlan;

		$this->performAjaxValidation($model, 'flight-plan-form');

		if (isset($_POST['FlightPlan'])) {
			$model->setAttributes($_POST['FlightPlan']);

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
		$model = $this->loadModel($id, 'FlightPlan');

		$this->performAjaxValidation($model, 'flight-plan-form');

		if (isset($_POST['FlightPlan'])) {
			$model->setAttributes($_POST['FlightPlan']);

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
			$this->loadModel($id, 'FlightPlan')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new FlightPlan('search');
		$model->unsetAttributes();

		if (isset($_GET['FlightPlan']))
			$model->setAttributes($_GET['FlightPlan']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:FlightPlan */