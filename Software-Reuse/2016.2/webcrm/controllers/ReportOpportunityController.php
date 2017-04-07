<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 12/03/2017
 * Time: 12:56
 */

namespace app\controllers;


class ReportOpportunityController extends MainController
{
    public function actionRefused()
    {
        return $this->render('refused');
    }

    public function actionClosed()
    {
        return $this->render('closed');
    }
}