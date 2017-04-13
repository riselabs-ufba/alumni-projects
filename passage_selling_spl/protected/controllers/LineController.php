<?php /* BeginFeature:Line */

class LineController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Line'),
		));
	}

	public function actionCreate() {
		$model = new Line;

		$this->performAjaxValidation($model, 'line-form');

		if (isset($_POST['Line'])) {
			$model->setAttributes($_POST['Line']);

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
		$model = $this->loadModel($id, 'Line');

		$this->performAjaxValidation($model, 'line-form');

		if (isset($_POST['Line'])) {
			$model->setAttributes($_POST['Line']);

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
			$this->loadModel($id, 'Line')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Line('search');
		$model->unsetAttributes();

		if (isset($_GET['Line']))
			$model->setAttributes($_GET['Line']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Line */