<?php

/* @var $this yii\web\View */

$this->title = 'My Yii Application';
?>
<div class="site-index">

    <div class="col-md-9">
        <select multiple="multiple" class="multi-select" id="my_multi_select2" name="my_multi_select2[]"
                style="position: absolute; left: -9999px;">
            <optgroup label="NFC EAST">
                <option>Dallas Cowboys</option>
                <option>New York Giants</option>
                <option>Philadelphia Eagles</option>
                <option>Washington Redskins</option>
            </optgroup>
            <optgroup label="NFC NORTH">
                <option>Chicago Bears</option>
                <option>Detroit Lions</option>
                <option>Green Bay Packers</option>
                <option>Minnesota Vikings</option>
            </optgroup>
            <optgroup label="NFC SOUTH">
                <option>Atlanta Falcons</option>
                <option>Carolina Panthers</option>
                <option>New Orleans Saints</option>
                <option>Tampa Bay Buccaneers</option>
            </optgroup>
            <optgroup label="NFC WEST">
                <option>Arizona Cardinals</option>
                <option>St. Louis Rams</option>
                <option>San Francisco 49ers</option>
                <option>Seattle Seahawks</option>
            </optgroup>
        </select>
        <div class="ms-container" id="ms-my_multi_select2">
            <div class="ms-selectable">
                <ul class="ms-list" tabindex="-1">
                    <li class="ms-optgroup-container" id="optgroup-selectable-NFC_EAST">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label"><span>NFC EAST</span></li>
                            <li class="ms-elem-selectable ms-selected" id="Dallas_Cowboys-selectable"
                                style="display: none;"><span>Dallas Cowboys</span></li>
                            <li class="ms-elem-selectable ms-selected" id="New_York_Giants-selectable"
                                style="display: none;"><span>New York Giants</span></li>
                            <li class="ms-elem-selectable ms-hover" id="Philadelphia_Eagles-selectable"><span>Philadelphia Eagles</span>
                            </li>
                            <li class="ms-elem-selectable" id="Washington_Redskins-selectable">
                                <span>Washington Redskins</span></li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selectable-NFC_NORTH">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label"><span>NFC NORTH</span></li>
                            <li class="ms-elem-selectable ms-selected" id="Chicago_Bears-selectable"
                                style="display: none;"><span>Chicago Bears</span></li>
                            <li class="ms-elem-selectable" id="Detroit_Lions-selectable"><span>Detroit Lions</span></li>
                            <li class="ms-elem-selectable" id="Green_Bay_Packers-selectable">
                                <span>Green Bay Packers</span></li>
                            <li class="ms-elem-selectable" id="Minnesota_Vikings-selectable">
                                <span>Minnesota Vikings</span></li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selectable-NFC_SOUTH">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label"><span>NFC SOUTH</span></li>
                            <li class="ms-elem-selectable" id="Atlanta_Falcons-selectable"><span>Atlanta Falcons</span>
                            </li>
                            <li class="ms-elem-selectable" id="Carolina_Panthers-selectable">
                                <span>Carolina Panthers</span></li>
                            <li class="ms-elem-selectable" id="New_Orleans_Saints-selectable">
                                <span>New Orleans Saints</span></li>
                            <li class="ms-elem-selectable" id="Tampa_Bay_Buccaneers-selectable"><span>Tampa Bay Buccaneers</span>
                            </li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selectable-NFC_WEST">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label"><span>NFC WEST</span></li>
                            <li class="ms-elem-selectable" id="Arizona_Cardinals-selectable">
                                <span>Arizona Cardinals</span></li>
                            <li class="ms-elem-selectable" id="St_Louis_Rams-selectable"><span>St. Louis Rams</span>
                            </li>
                            <li class="ms-elem-selectable" id="San_Francisco_49ers-selectable">
                                <span>San Francisco 49ers</span></li>
                            <li class="ms-elem-selectable" id="Seattle_Seahawks-selectable">
                                <span>Seattle Seahawks</span></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="ms-selection">
                <ul class="ms-list" tabindex="-1">
                    <li class="ms-optgroup-container" id="optgroup-selection-NFC_EAST">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label" style=""><span>NFC EAST</span></li>
                            <li class="ms-elem-selection ms-selected ms-hover" id="Dallas_Cowboys-selection" style="">
                                <span>Dallas Cowboys</span></li>
                            <li class="ms-elem-selection ms-selected" id="New_York_Giants-selection" style=""><span>New York Giants</span>
                            </li>
                            <li class="ms-elem-selection" id="Philadelphia_Eagles-selection" style="display: none;">
                                <span>Philadelphia Eagles</span></li>
                            <li class="ms-elem-selection" id="Washington_Redskins-selection" style="display: none;">
                                <span>Washington Redskins</span></li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selection-NFC_NORTH">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label" style=""><span>NFC NORTH</span></li>
                            <li class="ms-elem-selection ms-selected" id="Chicago_Bears-selection" style=""><span>Chicago Bears</span>
                            </li>
                            <li class="ms-elem-selection" id="Detroit_Lions-selection" style="display: none;"><span>Detroit Lions</span>
                            </li>
                            <li class="ms-elem-selection" id="Green_Bay_Packers-selection" style="display: none;"><span>Green Bay Packers</span>
                            </li>
                            <li class="ms-elem-selection" id="Minnesota_Vikings-selection" style="display: none;"><span>Minnesota Vikings</span>
                            </li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selection-NFC_SOUTH">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label" style="display: none;"><span>NFC SOUTH</span></li>
                            <li class="ms-elem-selection" id="Atlanta_Falcons-selection" style="display: none;"><span>Atlanta Falcons</span>
                            </li>
                            <li class="ms-elem-selection" id="Carolina_Panthers-selection" style="display: none;"><span>Carolina Panthers</span>
                            </li>
                            <li class="ms-elem-selection" id="New_Orleans_Saints-selection" style="display: none;">
                                <span>New Orleans Saints</span></li>
                            <li class="ms-elem-selection" id="Tampa_Bay_Buccaneers-selection" style="display: none;">
                                <span>Tampa Bay Buccaneers</span></li>
                        </ul>
                    </li>
                    <li class="ms-optgroup-container" id="optgroup-selection-NFC_WEST">
                        <ul class="ms-optgroup">
                            <li class="ms-optgroup-label" style="display: none;"><span>NFC WEST</span></li>
                            <li class="ms-elem-selection" id="Arizona_Cardinals-selection" style="display: none;"><span>Arizona Cardinals</span>
                            </li>
                            <li class="ms-elem-selection" id="St_Louis_Rams-selection" style="display: none;"><span>St. Louis Rams</span>
                            </li>
                            <li class="ms-elem-selection" id="San_Francisco_49ers-selection" style="display: none;">
                                <span>San Francisco 49ers</span></li>
                            <li class="ms-elem-selection" id="Seattle_Seahawks-selection" style="display: none;"><span>Seattle Seahawks</span>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="jumbotron">
        <h1>Congratulations!</h1>

        <p class="lead">You have successfully created your Yii-powered application.</p>

        <p><a class="btn btn-lg btn-success" href="http://www.yiiframework.com">Get started with Yii</a></p>
    </div>

    <div class="body-content">

        <div class="row">
            <div class="col-lg-4">
                <h2>Heading</h2>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                    et
                    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                    aliquip
                    ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                    dolore eu
                    fugiat nulla pariatur.</p>

                <p><a class="btn btn-default" href="http://www.yiiframework.com/doc/">Yii Documentation &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>Heading</h2>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                    et
                    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                    aliquip
                    ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                    dolore eu
                    fugiat nulla pariatur.</p>

                <p><a class="btn btn-default" href="http://www.yiiframework.com/forum/">Yii Forum &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>Heading</h2>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                    et
                    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                    aliquip
                    ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                    dolore eu
                    fugiat nulla pariatur.</p>

                <p><a class="btn btn-default" href="http://www.yiiframework.com/extensions/">Yii Extensions &raquo;</a>
                </p>
            </div>
        </div>

    </div>
</div>
