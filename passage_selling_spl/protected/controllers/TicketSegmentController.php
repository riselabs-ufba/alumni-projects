<?php /* BeginFeature:TicketSegment */

class TicketSegmentController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'TicketSegment'),
		));
	}

	public function actionCreate() {
		$model = new TicketSegment;

		$this->performAjaxValidation($model, 'ticket-segment-form');

		if (isset($_POST['TicketSegment'])) {
			$model->setAttributes($_POST['TicketSegment']);

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
		$model = $this->loadModel($id, 'TicketSegment');

		$this->performAjaxValidation($model, 'ticket-segment-form');

		if (isset($_POST['TicketSegment'])) {
			$model->setAttributes($_POST['TicketSegment']);

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
			$this->loadModel($id, 'TicketSegment')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new TicketSegment('search');
		$model->unsetAttributes();

		if (isset($_GET['TicketSegment']))
			$model->setAttributes($_GET['TicketSegment']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:TicketSegment */