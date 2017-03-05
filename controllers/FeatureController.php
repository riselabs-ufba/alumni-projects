<?php
/**
 * Created by PhpStorm.
 * User: lucas
 * Date: 2/4/17
 * Time: 6:51 PM
 */


namespace app\controllers;

use Yii;


class FeatureController extends MainController
{
    public $freeAccess = true;
    private $webRoot = "C:/xampp/htdocs/";

    public function actionFeatureConfiguration()
    {
        $this->layout = 'feature-selection';
        if (!empty(Yii::$app->request->post())) {
            //var_dump(Yii::$app->request->post());
            $menuArray = '';
            foreach ($_POST['features'] as $feature) {
                $labelMenu = explode('-', $feature);
                if ($labelMenu[0] != 'user' && $labelMenu[0] != 'report')
                    $menuArray .= "[
                        'label' => '<i class=" . '"fa fa-building"' . "></i> $labelMenu[0]',
                        'url' => '#',
                        'items' => [
                            ['label' => '<i class=" . '"fa fa-circle-o"' . "></i> Management', 'url' => ['/$labelMenu[0]/']],
                            ['label' => '<i class=" . 'fa fa-circle-o"' . "></i> New', 'url' => ['/$labelMenu[0]/create']],
                        ]
                    ],";
            }

            $this->mountMenu($menuArray);
            $this->commonFeatures(Yii::$app->request->post('productName'));
        }
        return $this->render('feature');
    }

    private function mountMenu($featuresSelected)
    {
        $stringMenu = '<?php
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
                    </div>';

        $stringMenu .= "    
                    <?=
                    GhostMenu::widget([
                        'encodeLabels' => false,
                        'activateParents' => true,
                        'options' => ['class' => 'sidebar-menu'],
                        'submenuTemplate' => '" . '"\n<ul class="treeview-menu" {show}>\n{items}\n</ul>\n"' . "',
                        'items' => [
                            [
                                'label' => '<i class=\"fa fa-users\"></i> ' . 'Management Control Access',
                                'url' => '#',
                                'items' => [
                                    ['label' => '<i class=\"fa fa-circle-o\"></i> ' . UserManagementModule::t('back', 'Users'), 'url' => ['/user-management/user/index']],
                                    ['label' => '<i class=\"fa fa-circle-o\"></i> ' . UserManagementModule::t('back', 'Roles'), 'url' => ['/user-management/role/index']],
                                    ['label' => '<i class=\"fa fa-circle-o\"></i> ' . UserManagementModule::t('back', 'Permissions'), 'url' => ['/user-management/permission/index']],
                                    ['label' => '<i class=\"fa fa-circle-o\"></i> ' . UserManagementModule::t('back', 'Permission groups'), 'url' => ['/user-management/auth-item-group/index']],
                                    ['label' => '<i class=\"fa fa-circle-o\"></i> ' . UserManagementModule::t('back', 'Visit log'), 'url' => ['/user-management/user-visit-log/index']],
                                ]
                            ]," .
            $featuresSelected . "
                        ],
                    ]);
                    ?>
                </section>
            
            </aside>";

        $file = fopen('left.php', 'w');
        fwrite($file, $stringMenu);
        fclose($file);
    }

    private function commonFeatures($productName)
    {

        $basePath = Yii::getAlias('@webroot') . '/../';
        $destinationFolder = $this->webRoot . $productName;
        $folders = ['assets', 'commands', 'config', 'controllers', 'mail', 'models', 'runtime', 'tests', 'views', 'web'];
        $subFolder = ['web' => ['assets', 'css', 'plugins'], 'views' => ['product', 'site', 'layouts']];
        $files = [
            'assets' => [
                'AppAsset'
            ],
            'commands' => [
                'HelloController'
            ],
            'config' => [
                'console', 'params', 'test', 'test_db', 'web'
            ],
            'controllers' => [
                'ProductController', 'SiteController', 'MainController'
            ],
            'models' => [
                'Product', 'ProductSearch'
            ],
            'web' => [
                '.htaccess', 'favicon.ico', 'index.php', 'index-test.php', 'robots.txt'
            ],
            '.' => [
                '.bowerrc', '.gitignore', '.htaccess', 'codeception.yml', 'composer.json',
                'composer.lock', 'LICENSE.md', 'README.md', 'requirements.php', 'yii', 'yii.bat',
                'vendor.zip'
            ]
        ];

        $views = [
            'product' => [
                '_form', '_search', 'create', 'index', 'update', 'view'
            ],
            'site' => [
                'index', 'error', 'login'
            ],
            'layouts' => [
                'content', 'header', 'main', 'main-login'
            ]
        ];
        if (!is_dir($destinationFolder)) {
            /*CRIA A PASTA RAIZ*/
            mkdir($destinationFolder);
            /*CRIA PASTAS*/
            foreach ($folders as $folder) {
                mkdir($destinationFolder . '/' . $folder);
            }
            /*CRIA SUBPASTAS*/
            foreach ($subFolder as $key => $item) {
                foreach ($item as $sub) {
                    mkdir($destinationFolder . '/' . $key . '/' . $sub);
                }
            }
            /*COPIA OS ARQUIVOS PARA DENTRO DA PASTAS CORRESPONDENTES*/
            foreach ($files as $folder => $arrFiles) {
                if ($folder != '.' && $folder != "web") {
                    foreach ($arrFiles as $file) {
                        copy($basePath . $folder . '/' . $file . '.php', $destinationFolder . '/' . $folder . '/' . $file . '.php');
                    }
                } else {
                    foreach ($arrFiles as $file) {
                        copy($basePath . $folder . '/' . $file, $destinationFolder . '/' . $folder . '/' . $file);
                    }
                }
            }

            /*COPIA AS VIEWS PARA DENTRO DA PASTAS CORRESPONDENTES*/
            foreach ($views as $folder => $arrFiles) {
                foreach ($arrFiles as $file) {
                    copy($basePath . 'views/' . $folder . '/' . $file . '.php', $destinationFolder . '/views/' . $folder . '/' . $file . '.php');
                }
            }

            /*EXTRAI A PASTA VENDOR PARA O NOVO PRODUTO*/
            if (!is_dir('vendor')) {
                $zip = new \ZipArchive();
                if ($zip->open($basePath . 'vendor.zip') === TRUE) {
                    $zip->extractTo($destinationFolder);
                    $zip->close();
                    echo 'ok';
                } else {
                    echo 'failed';
                }
            }

            copy('left.php', $destinationFolder . '/views/layouts/left.php');
            unlink('left.php');

            $this->createDbFile($productName, $destinationFolder);
            $this->createDbSchema($productName);

        }
    }

    private function createDbFile($productName, $destinationFolder)
    {
        $config = "<?php
                return [
                    'class' => 'yii\\db\\Connection',
                    'dsn' => 'mysql:host=localhost;dbname=" . $productName . "',
                    'username' => 'root',
                    'password' => '',
                    'charset' => 'utf8',
                ];";
        $file = fopen('db.php', 'w');
        fwrite($file, $config);
        fclose($file);
        copy('db.php', $destinationFolder . '/config/db.php');
        unlink('db.php');
    }

    private function createDbSchema($productName)
    {
        $sqlNewDatabase = "CREATE DATABASE IF NOT EXISTS `$productName` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;";
        $connection = Yii::$app->getDb();
        $command = $connection->createCommand($sqlNewDatabase);
        $command->execute();

        $sqlCreateAuthTables = "  USE `$productName`;";
        $sqlCreateAuthTables .= file_get_contents(Yii::getAlias('@app') . '/scripts/auths-tables.sql');
        $command = $connection->createCommand($sqlCreateAuthTables);
        $command->execute();

        $sqlGeneralTable = "  USE `$productName`;";
        $sqlGeneralTable .= file_get_contents(Yii::getAlias('@app') . '/scripts/general-tables.sql');
        $command = $connection->createCommand($sqlGeneralTable);
        $command->execute();

        $sqlInsertAuthItem = "  USE `$productName`;";
        $sqlInsertAuthItem .= file_get_contents(Yii::getAlias('@app') . '/scripts/insert-auth-item.sql');
        $command = $connection->createCommand($sqlInsertAuthItem);
        $command->execute();

        $sqlInsertAuthItemChild = "  USE `$productName`;";
        $sqlInsertAuthItemChild .= file_get_contents(Yii::getAlias('@app') . '/scripts/insert-auth-item-child.sql');
        $command = $connection->createCommand($sqlInsertAuthItemChild);
        $command->execute();

        $insertAuthItemGroup = "  USE `$productName`;";
        $insertAuthItemGroup .= file_get_contents(Yii::getAlias('@app') . '/scripts/insert-auth-item-group.sql');
        $command = $connection->createCommand($insertAuthItemGroup);
        $command->execute();

        $insertUser = "  USE `$productName`;";
        $insertUser .= file_get_contents(Yii::getAlias('@app') . '/scripts/insert-user.sql');
        $command = $connection->createCommand($insertUser);
        $command->execute();

        $sqlAlterTable = "  USE `$productName`;";
        $sqlAlterTable .= file_get_contents(Yii::getAlias('@app') . '/scripts/alter-tables.sql');
        $command = $connection->createCommand($sqlAlterTable);
        $command->execute();

    }


}