<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 2/2/17
 * Time: 10:56 PM
 */

namespace app\controllers;


use yii\base\Controller;

class MainController extends Controller
{
    public function behaviors()
    {
        return [
            'ghost-access' => [
                'class' => 'webvimark\modules\UserManagement\components\GhostAccessControl',
            ],
        ];
    }
}