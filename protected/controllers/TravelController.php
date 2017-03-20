<?php /* BeginFeature:Travel */

class TravelController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Travel'),
		));
	}

	public function actionCreate() {
		$model = new Travel;

		$this->performAjaxValidation($model, 'travel-form');

		if (isset($_POST['Travel'])) {
			$model->setAttributes($_POST['Travel']);

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
		$model = $this->loadModel($id, 'Travel');
                
		$this->performAjaxValidation($model, 'travel-form');

		if (isset($_POST['Travel'])) {
			$model->setAttributes($_POST['Travel']);

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
			$this->loadModel($id, 'Travel')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Travel('search');
		$model->unsetAttributes();

		if (isset($_GET['Travel']))
			$model->setAttributes($_GET['Travel']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Travel */