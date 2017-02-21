<?php

/**
 * Description of Feature
 *
 * @author user
 */
class Feature extends CFormModel {
    
    public $toRemove = array();

    public function deploy() {
        $root = str_replace('/protected', '', Yii::app()->getBasePath());
        $rootTemp = str_replace('/protected', '-temp', Yii::app()->getBasePath());

        shell_exec("rm -R {$rootTemp}/");
        shell_exec("rm -R {$rootTemp}/nbproject");
        shell_exec("cp -R {$root} {$rootTemp}");
        shell_exec("rm -R {$rootTemp}/assets/*");
        shell_exec("rm -R {$rootTemp}/protected/runtime/*");
        foreach ($this->toRemove as $feature) {
            shell_exec("find {$rootTemp} -type f -print0 | xargs -0 sed -i '/BeginFeature:{$feature}/,/EndFeature:{$feature}/d'");    
        }        
        shell_exec("find {$rootTemp} -size  0 -print0 | xargs -0 rm");
        shell_exec("find {$rootTemp}/protected/controllers -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/models -type d -empty -delete");
        shell_exec("find {$rootTemp}/protected/views -type d -empty -delete");
    }

}
