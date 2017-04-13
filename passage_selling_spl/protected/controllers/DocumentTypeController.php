<?php /* BeginFeature:DocumentType */

class DocumentTypeController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'DocumentType'),
		));
	}

	public function actionCreate() {
		$model = new DocumentType;

		$this->performAjaxValidation($model, 'document-type-form');

		if (isset($_POST['DocumentType'])) {
			$model->setAttributes($_POST['DocumentType']);

			if ($model->save()) {
				if (Yii::app()->getRequest()->getIsAjaxRequest())
					Yii::app()->end();
				else
					$this->redirect(array('view', 'id' => $model->id_document_type));
			}
		}

		$this->render('create', array( 'model' => $model));
	}

	public function actionUpdate($id) {
		$model = $this->loadModel($id, 'DocumentType');

		$this->performAjaxValidation($model, 'document-type-form');

		if (isset($_POST['DocumentType'])) {
			$model->setAttributes($_POST['DocumentType']);

			if ($model->save()) {
				$this->redirect(array('view', 'id' => $model->id_document_type));
			}
		}

		$this->render('update', array(
				'model' => $model,
				));
	}

	public function actionDelete($id) {
		if (Yii::app()->getRequest()->getIsPostRequest()) {
			$this->loadModel($id, 'DocumentType')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new DocumentType('search');
		$model->unsetAttributes();

		if (isset($_GET['DocumentType']))
			$model->setAttributes($_GET['DocumentType']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:DocumentType */