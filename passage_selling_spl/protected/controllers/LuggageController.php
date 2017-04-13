<?php /* BeginFeature:Luggage */

class LuggageController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Luggage'),
		));
	}

	public function actionCreate() {
		$model = new Luggage;

		$this->performAjaxValidation($model, 'luggage-form');

		if (isset($_POST['Luggage'])) {
			$model->setAttributes($_POST['Luggage']);

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
		$model = $this->loadModel($id, 'Luggage');

		$this->performAjaxValidation($model, 'luggage-form');

		if (isset($_POST['Luggage'])) {
			$model->setAttributes($_POST['Luggage']);

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
			$this->loadModel($id, 'Luggage')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Luggage('search');
		$model->unsetAttributes();

		if (isset($_GET['Luggage']))
			$model->setAttributes($_GET['Luggage']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:Luggage */