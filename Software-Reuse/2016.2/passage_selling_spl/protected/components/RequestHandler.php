<?php

/**
 * @see http://www.larryullman.com/2010/07/20/forcing-login-for-all-pages-in-yii/
 */
class RequestHandler extends CBehavior {

    public static function handle($event) {
        if (Yii::app()->user->isGuest && isset($_GET['r']) && !in_array($_GET['r'], array('site/login', 'site/logout',))) {
            Yii::app()->user->loginRequired();
        }
    }

}


