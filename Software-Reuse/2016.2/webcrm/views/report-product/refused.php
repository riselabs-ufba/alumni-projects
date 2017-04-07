<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 12/03/2017
 * Time: 13:03
 */

use miloschuman\highcharts\Highcharts;

$this->title = 'Refused Products';
$this->params['breadcrumbs'][] = $this->title;

echo Highcharts::widget([
    'options' => [
        'chart' => [
            'type' => 'pie'
        ],
        'title' => ['text' => 'Products Status'],
        'series' => [
            [
                'name' => 'Products',
                'colorByPoint' => 'true',
                'data' => [
                    ['name' => 'Pending', 'y' => 5],
                    ['name' => 'Refused', 'y' => 3]
                ]
            ],

        ]
    ]
]);