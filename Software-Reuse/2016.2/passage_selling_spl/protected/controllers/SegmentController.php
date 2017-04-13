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
        
        /* BeginFeature:Line */
        public function actionGetAllDepartureByLine() {
            $post = array_values($_POST);
            $travel = Travel::model()->findByPk((int) $post[0]['id_travel']);
            $models = Segment::model()->with('idStationDeparture')->findAll('id_line=:id_line', array(':id_line' => $travel->id_line));

            $data = CHtml::listData($models, 'idStationDeparture.id', 'idStationDeparture.name');
            echo CHtml::tag('option', array('value' => ''), CHtml::encode('Select'), true);
            foreach ($data as $value => $name) {
                echo CHtml::tag('option', array('value' => $value), CHtml::encode($name), true);
            }
        }
        /* EndFeature:Line */  
        
        
        public function actionGetAllArrivalByDeparture() {
            $post = array_values($_POST);
            $segment = Segment::model()->findByAttributes(array('id_line' => (int) $post[0]['id_line'],'id_station_departure' => (int) $post[0]['id_station_departure']));            
            $models = Segment::model()->with('idStationArrival')->findAll('id_line=:id_line and sequence_number >= :sequence_number', array(':id_line' => $segment->id_line,':sequence_number' => $segment->sequence_number));

            $data = CHtml::listData($models, 'idStationArrival.id', 'idStationArrival.name');
            echo CHtml::tag('option', array('value' => ''), CHtml::encode('Select'), true);
            foreach ($data as $value => $name) {
                echo CHtml::tag('option', array('value' => $value), CHtml::encode($name), true);
            }
        }
        /* EndFeature:Line */        

}
/* EndFeature:MultiSegment */