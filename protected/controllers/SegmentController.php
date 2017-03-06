<?php /* BeginFeature:MultiSegment */

class SegmentController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Segment'),
		));
	}

	public function actionCreate($id) {
                $this->loadModel($id, 'Line');
		$model = new Segment;
                $model->id_line = $id;

		$this->performAjaxValidation($model, 'segment-form');

		if (isset($_POST['Segment'])) {
			$model->setAttributes($_POST['Segment']);

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
		$model = $this->loadModel($id, 'Segment');

		$this->performAjaxValidation($model, 'segment-form');

		if (isset($_POST['Segment'])) {
			$model->setAttributes($_POST['Segment']);

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
                        $model = $this->loadModel($id, 'Segment');
                        $lineId = $model->id_line;
			$model->delete();
                        
			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('line/view','id' => $lineId));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Segment('search');
		$model->unsetAttributes();

		if (isset($_GET['Segment']))
			$model->setAttributes($_GET['Segment']);

		$this->render('admin', array(
			'model' => $model,
		));
	}

}
/* EndFeature:MultiSegment */