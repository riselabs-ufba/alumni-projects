<?php
use webvimark\modules\UserManagement\components\GhostMenu;
use webvimark\modules\UserManagement\UserManagementModule;

?>
<aside class="main-sidebar">

    <section class="sidebar">

        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<?= $directoryAsset ?>/img/user2-160x160.jpg" class="img-circle" alt="User Image"/>
            </div>
            <div class="pull-left info">
                <p><?= \webvimark\modules\UserManagement\models\User::getCurrentUser()->username ?></p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form -->
        <!--        <form action="#" method="get" class="sidebar-form">-->
        <!--            <div class="input-group">-->
        <!--                <input type="text" name="q" class="form-control" placeholder="Search..."/>-->
        <!--                <span class="input-group-btn">-->
        <!--                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i>-->
        <!--                </button>-->
        <!--              </span>-->
        <!--            </div>-->
        <!--        </form>-->
        <!-- /.search form -->


        <?=
        GhostMenu::widget([
            'encodeLabels' => false,
            'activateParents' => true,
            'options' => ['class' => 'sidebar-menu'],
            'submenuTemplate' => "\n<ul class='treeview-menu' {show}>\n{items}\n</ul>\n",
            'items' => [
                [
                    'label' => '<i class="fa fa-users"></i> ' . 'Management Control Access',
                    'url' => '#',
                    'items' => [
                        ['label' => '<i class="fa fa-circle-o"></i> ' . UserManagementModule::t('back', 'Users'), 'url' => ['/user-management/user/index']],
                        ['label' => '<i class="fa fa-circle-o"></i> ' . UserManagementModule::t('back', 'Roles'), 'url' => ['/user-management/role/index']],
                        ['label' => '<i class="fa fa-circle-o"></i> ' . UserManagementModule::t('back', 'Permissions'), 'url' => ['/user-management/permission/index']],
                        ['label' => '<i class="fa fa-circle-o"></i> ' . UserManagementModule::t('back', 'Permission groups'), 'url' => ['/user-management/auth-item-group/index']],
                        ['label' => '<i class="fa fa-circle-o"></i> ' . UserManagementModule::t('back', 'Visit log'), 'url' => ['/user-management/user-visit-log/index']],
                    ]
                ],
            ],
        ]);
        ?>
    </section>

</aside>
