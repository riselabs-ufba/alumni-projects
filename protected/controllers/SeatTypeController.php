<?php /* BeginFeature:SeatType */

class SeatTypeController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'SeatType'),
		));
	}

	public function actionCreate() {
		$model = new SeatType;

		$this->performAjaxValidation($model, 'seat-type-form');

		if (isset($_POST['SeatType'])) {
			$model->setAttributes($_POST['SeatType']);

			if ($model->save()) {
				if (Yii::app()->getRequest()->getIsAjaxRequest())
					Yii::app()->end();
				else
					$this->redirect(array('view', 'id' => $model->id_seat_type));
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'SeatType');

		$this->performAjaxValidation($model, 'seat-type-form');

		if (isset($_POST['SeatType'])) {
			$model->setAttributes($_POST['SeatType']);

			if ($model->save()) {
				$this->redirect(array('view', 'id' => $model->id_seat_type));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
			$this->loadModel($id, 'SeatType')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new SeatType('search');
		$model->unsetAttributes();

		if (isset($_GET['SeatType']))
			$model->setAttributes($_GET['SeatType']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:SeatType */