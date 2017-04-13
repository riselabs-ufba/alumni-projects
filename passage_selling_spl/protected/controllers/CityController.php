<?php /* BeginFeature:City */

class CityController extends GxController {

        public $defaultAction = 'admin';

	public function actionView($id) {
		$this->render('view', array(
			'model' => $this->loadModel($id, 'City'),
		));
	}

	public function actionCreate() {
		$model = new City;

		$this->performAjaxValidation($model, 'city-form');

		if (isset($_POST['City'])) {
			$model->setAttributes($_POST['City']);

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
		$model = $this->loadModel($id, 'City');

		$this->performAjaxValidation($model, 'city-form');

		if (isset($_POST['City'])) {
			$model->setAttributes($_POST['City']);

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
			$this->loadModel($id, 'City')->delete();

			if (!Yii::app()->getRequest()->getIsAjaxRequest())
				$this->redirect(array('admin'));
		} else
			throw new CHttpException(400, Yii::t('app', 'Your request is invalid.'));
	}

	public function actionAdmin() {
		$model = new City('search');
		$model->unsetAttributes();

		if (isset($_GET['City']))
			$model->setAttributes($_GET['City']);

		$this->render('admin', array(
			'model' => $model,
		));
	}
        
        /* BeginFeature:State */
        public function actionGetAllByState() {
            $post = array_values($_POST);
            $models = City::model()->findAll('id_state=:id_state', array(':id_state' => (int) $post[0]['id_state']));

            $data = CHtml::listData($models, 'id', 'name');
            echo CHtml::tag('option', array('value' => ''), CHtml::encode('Select'), true);
            foreach ($data as $value => $name) {
                echo CHtml::tag('option', array('value' => $value), CHtml::encode($name), true);
            }
        }
        /* EndFeature:State */                

}
/* EndFeature:City */