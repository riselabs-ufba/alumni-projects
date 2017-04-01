<?php /* BeginFeature:Ticket */

class TicketController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'Ticket'),
		));
	}

	public function actionCreate() {
		$model = new Ticket;

		$this->performAjaxValidation($model, 'ticket-form');

		if (isset($_POST['Ticket'])) {
			$model->setAttributes($_POST['Ticket']);

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
		$model = $this->loadModel($id, 'Ticket');

		$this->performAjaxValidation($model, 'ticket-form');

		if (isset($_POST['Ticket'])) {
			$model->setAttributes($_POST['Ticket']);

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
			$this->loadModel($id, 'Ticket')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new Ticket('search');
		$model->unsetAttributes();

		if (isset($_GET['Ticket']))
			$model->setAttributes($_GET['Ticket']);

		$this->render('admin', array(
			'model' => $model,
		));
	}
        
        /* BeginFeature:Passenger */
        public function actionGetAllByPassenger() {
            $post = array_values($_POST);
            $models = Ticket::model()->findAll('id_passenger=:id_passenger', array(':id_passenger' => (int) $post[0]['id_passenger']));

            $data = CHtml::listData($models, 'id', 'id');
            echo CHtml::tag('option', array('value' => ''), CHtml::encode('Select'), true);
            foreach ($data as $value => $name) {
                echo CHtml::tag('option', array('value' => $value), CHtml::encode($name), true);
            }
        }
        /* EndFeature:Passenger */        

}
/* EndFeature:Ticket */