<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 12/03/2017
 * Time: 13:03
 */

use miloschuman\highcharts\Highcharts;

$this->title = 'Closed Opportunities';
$this->params['breadcrumbs'][] = $this->title;

echo Highcharts::widget([
    'options' => [
        'chart' => [
            'type' => 'pie'
        ],
        'title' => ['text' => 'Opportunities Status'],
        'series' => [
            [
                'name' => 'Opportunities',
                'colorByPoint' => 'true',
                'data' => [
                    ['name' => 'Pending', 'y' => 5],
                    ['name' => 'Closed', 'y' => 3]
                ]
            ],

        ]
    ]
]);