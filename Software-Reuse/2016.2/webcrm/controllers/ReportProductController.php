<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 12/03/2017
 * Time: 12:55
 */

namespace app\controllers;


class ReportProductController extends MainController
{

    public function actionRefused()
    {
        return $this->render('refused');
    }

    public function actionAcquired()
    {
        return $this->render('acquired');
    }
}