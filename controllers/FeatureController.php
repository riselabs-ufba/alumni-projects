<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 2/4/17
 * Time: 6:51 PM
 */

namespace app\controllers;


class FeatureController extends MainController
{
    public $freeAccess = true;

    public function actionFeatureConfiguration()
    {
        $this->layout = 'feature-selection';
        return $this->render('feature');
    }


}