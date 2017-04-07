-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Mar-2017 às 14:34
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webcrm`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `auth_assignment`
--

CREATE TABLE `auth_assignment` (
  `item_name` varchar(64) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `auth_item`
--

CREATE TABLE `auth_item` (
  `name` varchar(64) NOT NULL,
  `type` int(11) NOT NULL,
  `description` text,
  `rule_name` varchar(64) DEFAULT NULL,
  `data` text,
  `created_at` int(11) DEFAULT NULL,
  `updated_at` int(11) DEFAULT NULL,
  `group_code` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `auth_item`
--

INSERT INTO `auth_item` (`name`, `type`, `description`, `rule_name`, `data`, `created_at`, `updated_at`, `group_code`) VALUES
('/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//controller', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//crud', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//extension', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//form', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//model', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('//module', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/asset/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/asset/compress', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/asset/template', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/cache/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/cache/flush', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/cache/flush-all', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/cache/flush-schema', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/cache/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/debug/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/db-explain', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/download-mail', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/toolbar', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/debug/default/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/feature/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/feature/feature-configuration', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/create', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/delete', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/index', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/update', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/finder/view', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/fixture/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/fixture/load', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/fixture/unload', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/action', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/diff', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/preview', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/gii/default/view', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/hello/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/hello/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/help/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/help/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/item/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/item/create', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/item/delete', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/item/index', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/item/update', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/item/view', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/main/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/message/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/message/config', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/message/config-template', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/message/extract', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/create', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/down', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/history', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/mark', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/new', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/redo', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/to', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/migrate/up', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/opportunity/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/opportunity/create', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/opportunity/delete', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/opportunity/index', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/opportunity/update', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/opportunity/view', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/create', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/delete', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/index', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/update', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/partner/view', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/*', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/create', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/delete', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/index', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/update', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/poc/view', 3, NULL, NULL, NULL, 1488592532, 1488592532, NULL),
('/product/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/product/create', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/product/delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/product/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/product/update', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/product/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/serve/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/serve/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/site/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/about', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/captcha', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/contact', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/error', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/login', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/site/logout', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/*', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/auth-item-group/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/bulk-activate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/bulk-deactivate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/bulk-delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/create', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/grid-page-size', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/grid-sort', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/toggle-attribute', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/update', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth-item-group/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/captcha', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/change-own-password', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/auth/confirm-email', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/confirm-email-receive', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/confirm-registration-email', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/login', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/logout', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/password-recovery', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/password-recovery-receive', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/auth/registration', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/bulk-activate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/bulk-deactivate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/bulk-delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/create', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/grid-page-size', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/grid-sort', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/refresh-routes', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/set-child-permissions', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/set-child-routes', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/toggle-attribute', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/update', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/permission/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/bulk-activate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/bulk-deactivate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/bulk-delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/create', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/grid-page-size', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/grid-sort', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/set-child-permissions', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/set-child-roles', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/toggle-attribute', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/update', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/role/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-permission/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-permission/set', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user-permission/set-roles', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user-visit-log/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/bulk-activate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/bulk-deactivate', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/bulk-delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/create', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/delete', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/grid-page-size', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/grid-sort', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/index', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/toggle-attribute', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/update', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user-visit-log/view', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user/*', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user/bulk-activate', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/bulk-deactivate', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/bulk-delete', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/change-password', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/create', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/delete', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/grid-page-size', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/grid-sort', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user/index', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/toggle-attribute', 3, NULL, NULL, NULL, 1488591271, 1488591271, NULL),
('/user-management/user/update', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('/user-management/user/view', 3, NULL, NULL, NULL, 1486086883, 1486086883, NULL),
('Admin', 1, 'Admin', NULL, NULL, 1486086883, 1486086883, NULL),
('assignRolesToUsers', 2, 'Assign roles to users', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('bindUserToIp', 2, 'Bind user to IP', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('changeOwnPassword', 2, 'Change own password', NULL, NULL, 1486086883, 1486086883, 'userCommonPermissions'),
('changeUserPassword', 2, 'Change user password', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('cm', 2, 'CommonFeatures', NULL, NULL, 1488591513, 1488592967, NULL),
('commonPermission', 2, 'Common permission', NULL, NULL, 1486086883, 1486086883, NULL),
('createUsers', 2, 'Create users', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('deleteUsers', 2, 'Delete users', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('editUserEmail', 2, 'Edit user email', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('editUsers', 2, 'Edit users', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('viewRegistrationIp', 2, 'View registration IP', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('viewUserEmail', 2, 'View user email', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('viewUserRoles', 2, 'View user roles', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('viewUsers', 2, 'View users', NULL, NULL, 1486086883, 1486086883, 'userManagement'),
('viewVisitLog', 2, 'View visit log', NULL, NULL, 1486086883, 1486086883, 'userManagement');

-- --------------------------------------------------------

--
-- Estrutura da tabela `auth_item_child`
--

CREATE TABLE `auth_item_child` (
  `parent` varchar(64) NOT NULL,
  `child` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `auth_item_child`
--

INSERT INTO `auth_item_child` (`parent`, `child`) VALUES
('Admin', 'assignRolesToUsers'),
('Admin', 'changeOwnPassword'),
('Admin', 'changeUserPassword'),
('Admin', 'cm'),
('Admin', 'createUsers'),
('Admin', 'deleteUsers'),
('Admin', 'editUsers'),
('Admin', 'viewUsers'),
('assignRolesToUsers', '/user-management/user-permission/set'),
('assignRolesToUsers', '/user-management/user-permission/set-roles'),
('assignRolesToUsers', 'viewUserRoles'),
('assignRolesToUsers', 'viewUsers'),
('changeOwnPassword', '/user-management/auth/change-own-password'),
('changeUserPassword', '/user-management/user/change-password'),
('changeUserPassword', 'viewUsers'),
('cm', '/product/create'),
('cm', '/product/delete'),
('cm', '/product/index'),
('cm', '/product/update'),
('cm', '/product/view'),
('cm', '/site/index'),
('cm', '/site/login'),
('commonPermission', '/site/logout'),
('createUsers', '/user-management/user/create'),
('createUsers', 'viewUsers'),
('deleteUsers', '/user-management/user/bulk-delete'),
('deleteUsers', '/user-management/user/delete'),
('deleteUsers', 'viewUsers'),
('editUserEmail', 'viewUserEmail'),
('editUsers', '/user-management/user/bulk-activate'),
('editUsers', '/user-management/user/bulk-deactivate'),
('editUsers', '/user-management/user/update'),
('editUsers', 'viewUsers'),
('viewUsers', '/user-management/user/grid-page-size'),
('viewUsers', '/user-management/user/index'),
('viewUsers', '/user-management/user/view');

-- --------------------------------------------------------

--
-- Estrutura da tabela `auth_item_group`
--

CREATE TABLE `auth_item_group` (
  `code` varchar(64) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` int(11) DEFAULT NULL,
  `updated_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `auth_item_group`
--

INSERT INTO `auth_item_group` (`code`, `name`, `created_at`, `updated_at`) VALUES
('userCommonPermissions', 'User common permission', 1486086883, 1486086883),
('userManagement', 'User management', 1486086883, 1486086883);

-- --------------------------------------------------------

--
-- Estrutura da tabela `auth_rule`
--

CREATE TABLE `auth_rule` (
  `name` varchar(64) NOT NULL,
  `data` text,
  `created_at` int(11) DEFAULT NULL,
  `updated_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `finder`
--

CREATE TABLE `finder` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `partner_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `groups`
--

CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `opportunity_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `migration`
--

CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `migration`
--

INSERT INTO `migration` (`version`, `apply_time`) VALUES
('m000000_000000_base', 1486086872),
('m140608_173539_create_user_table', 1486086882),
('m140611_133903_init_rbac', 1486086882),
('m140808_073114_create_auth_item_group_table', 1486086882),
('m140809_072112_insert_superadmin_to_user', 1486086883),
('m140809_073114_insert_common_permisison_to_auth_item', 1486086883),
('m141023_141535_create_user_visit_log', 1486086883),
('m141116_115804_add_bind_to_ip_and_registration_ip_to_user', 1486086883),
('m141121_194858_split_browser_and_os_column', 1486086883),
('m141201_220516_add_email_and_email_confirmed_to_user', 1486086883),
('m141207_001649_create_basic_user_permissions', 1486086883);

-- --------------------------------------------------------

--
-- Estrutura da tabela `opportunity`
--

CREATE TABLE `opportunity` (
  `id` bigint(20) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `person_name` varchar(45) DEFAULT NULL,
  `person_email` varchar(45) DEFAULT NULL,
  `person_tel` varchar(45) DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `next_contact_date` datetime DEFAULT NULL,
  `note` text,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `partner`
--

CREATE TABLE `partner` (
  `id` bigint(20) NOT NULL,
  `social_name` varchar(255) DEFAULT NULL,
  `fancy_name` varchar(255) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `poc`
--

CREATE TABLE `poc` (
  `id` bigint(20) NOT NULL,
  `previous_duration` int(11) DEFAULT NULL,
  `real_duration` int(11) DEFAULT NULL,
  `person_name` varchar(45) DEFAULT NULL,
  `fk_oportunity` bigint(20) NOT NULL,
  `final_status` varchar(45) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `auth_key` varchar(32) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `superadmin` smallint(6) DEFAULT '0',
  `created_at` int(11) NOT NULL,
  `updated_at` int(11) NOT NULL,
  `registration_ip` varchar(15) DEFAULT NULL,
  `bind_to_ip` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `email_confirmed` smallint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `username`, `auth_key`, `password_hash`, `confirmation_token`, `status`, `superadmin`, `created_at`, `updated_at`, `registration_ip`, `bind_to_ip`, `email`, `email_confirmed`) VALUES
(1, 'superadmin', 'n9wiAZgvUFObUCJ8f3MRkD7fPTviuAil', '$2y$13$O8/.fPd7tNA7RRUhAOJGB.K570tTG2AU/PFENtLQJav3YLIAFOqX.', NULL, 1, 1, 1486086883, 1486086883, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_visit_log`
--

CREATE TABLE `user_visit_log` (
  `id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `ip` varchar(15) NOT NULL,
  `language` char(2) NOT NULL,
  `user_agent` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `visit_time` int(11) NOT NULL,
  `browser` varchar(30) DEFAULT NULL,
  `os` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user_visit_log`
--

INSERT INTO `user_visit_log` (`id`, `token`, `ip`, `language`, `user_agent`, `user_id`, `visit_time`, `browser`, `os`) VALUES
(1, '5893e433c8b48', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', 1, 1486087219, 'Chrome', 'Linux'),
(2, '5893f8ea068a2', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', NULL, 1486092522, 'Chrome', 'Linux'),
(3, '5893f91b1c747', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', 1, 1486092571, 'Chrome', 'Linux'),
(4, '58947b60a16e0', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', 1, 1486125920, 'Chrome', 'Linux'),
(5, '58947b76cc4b8', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', NULL, 1486125942, 'Chrome', 'Linux'),
(6, '58947b9f5122e', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36', 1, 1486125983, 'Chrome', 'Linux'),
(7, '5896483ec9c15', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1486243902, 'Chrome', 'Linux'),
(8, '58964b47158ca', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1486244679, 'Chrome', 'Linux'),
(9, '58964d8aecc9d', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1486245258, 'Chrome', 'Linux'),
(10, '58964eb6b9499', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1486245558, 'Chrome', 'Linux'),
(11, '589893bf52283', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1486394303, 'Chrome', 'Linux'),
(12, '58a4e6e31d2e1', '127.0.0.1', 'pt', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1487202019, 'Chrome', 'Linux'),
(13, '58aa341e1d720', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1487549470, 'Chrome', 'Windows'),
(14, '58b75d474403a', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488411975, 'Chrome', 'Windows'),
(15, '58b75d9663779', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488412054, 'Chrome', 'Windows'),
(16, '58b765ec0f7df', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488414188, 'Chrome', 'Windows'),
(17, '58b76c327227a', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488415794, 'Chrome', 'Windows'),
(18, '58b8bcce2a3dd', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488501966, 'Chrome', 'Windows'),
(19, '58ba1312b5de4', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488589586, 'Chrome', 'Windows'),
(20, '58ba18beb4573', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488591038, 'Chrome', 'Windows'),
(21, '58ba18f02bb43', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591088, 'Chrome', 'Windows'),
(22, '58ba1a40ba76a', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591424, 'Chrome', 'Windows'),
(23, '58ba1a549a473', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591444, 'Chrome', 'Windows'),
(24, '58ba1a6f95d6b', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591471, 'Chrome', 'Windows'),
(25, '58ba1aea758d3', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488591594, 'Chrome', 'Windows'),
(26, '58ba1b04f22b6', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591620, 'Chrome', 'Windows'),
(27, '58ba1b2caf345', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488591660, 'Chrome', 'Windows'),
(28, '58ba1b709857c', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488591728, 'Chrome', 'Windows'),
(29, '58ba1bdd1ef30', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488591837, 'Chrome', 'Windows'),
(30, '58ba1e3be51f8', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488592443, 'Chrome', 'Windows'),
(31, '58ba1e54090a3', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488592468, 'Chrome', 'Windows'),
(32, '58ba1eb85f077', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488592568, 'Chrome', 'Windows'),
(33, '58ba1ec5bda5f', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488592581, 'Chrome', 'Windows'),
(34, '58ba1efa255fb', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488592634, 'Chrome', 'Windows'),
(35, '58ba1f22e4ac5', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488592674, 'Chrome', 'Windows'),
(36, '58ba1f40397bd', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488592704, 'Chrome', 'Windows'),
(37, '58ba1f553a756', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', NULL, 1488592725, 'Chrome', 'Windows'),
(38, '58ba1f718fb16', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488592753, 'Chrome', 'Windows'),
(39, '58ba1fb2657b3', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488592818, 'Edge', 'Windows'),
(40, '58ba207862460', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593016, 'Edge', 'Windows'),
(41, '58ba20a07411a', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593056, 'Edge', 'Windows'),
(42, '58ba20d77e708', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593111, 'Edge', 'Windows'),
(43, '58ba210082ac1', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593152, 'Edge', 'Windows'),
(44, '58ba211298b90', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593170, 'Edge', 'Windows'),
(45, '58ba21455f0b2', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393', NULL, 1488593221, 'Edge', 'Windows'),
(46, '58bb3e77d67b2', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488666231, 'Chrome', 'Windows'),
(47, '58bb597c2d8e5', '::1', 'pt', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 1, 1488673148, 'Chrome', 'Windows');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth_assignment`
--
ALTER TABLE `auth_assignment`
  ADD PRIMARY KEY (`item_name`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `auth_item`
--
ALTER TABLE `auth_item`
  ADD PRIMARY KEY (`name`),
  ADD KEY `rule_name` (`rule_name`),
  ADD KEY `idx-auth_item-type` (`type`),
  ADD KEY `fk_auth_item_group_code` (`group_code`);

--
-- Indexes for table `auth_item_child`
--
ALTER TABLE `auth_item_child`
  ADD PRIMARY KEY (`parent`,`child`),
  ADD KEY `child` (`child`);

--
-- Indexes for table `auth_item_group`
--
ALTER TABLE `auth_item_group`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `auth_rule`
--
ALTER TABLE `auth_rule`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `finder`
--
ALTER TABLE `finder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_finder_partner1_idx` (`partner_id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_item_opportunity1_idx` (`opportunity_id`),
  ADD KEY `fk_item_product1_idx` (`product_id`);

--
-- Indexes for table `migration`
--
ALTER TABLE `migration`
  ADD PRIMARY KEY (`version`);

--
-- Indexes for table `opportunity`
--
ALTER TABLE `opportunity`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_oportunidade_user1_idx` (`user_id`);

--
-- Indexes for table `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `poc`
--
ALTER TABLE `poc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_oportunidade_idx` (`fk_oportunity`),
  ADD KEY `fk_poc_product1_idx` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_visit_log`
--
ALTER TABLE `user_visit_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `finder`
--
ALTER TABLE `finder`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `opportunity`
--
ALTER TABLE `opportunity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `partner`
--
ALTER TABLE `partner`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `poc`
--
ALTER TABLE `poc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_visit_log`
--
ALTER TABLE `user_visit_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `auth_assignment`
--
ALTER TABLE `auth_assignment`
  ADD CONSTRAINT `auth_assignment_ibfk_1` FOREIGN KEY (`item_name`) REFERENCES `auth_item` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `auth_assignment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `auth_item`
--
ALTER TABLE `auth_item`
  ADD CONSTRAINT `auth_item_ibfk_1` FOREIGN KEY (`rule_name`) REFERENCES `auth_rule` (`name`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_auth_item_group_code` FOREIGN KEY (`group_code`) REFERENCES `auth_item_group` (`code`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limitadores para a tabela `auth_item_child`
--
ALTER TABLE `auth_item_child`
  ADD CONSTRAINT `auth_item_child_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `auth_item` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `auth_item_child_ibfk_2` FOREIGN KEY (`child`) REFERENCES `auth_item` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `finder`
--
ALTER TABLE `finder`
  ADD CONSTRAINT `fk_finder_partner1` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `fk_item_opportunity1` FOREIGN KEY (`opportunity_id`) REFERENCES `opportunity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_item_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `poc`
--
ALTER TABLE `poc`
  ADD CONSTRAINT `fk_oportunidade` FOREIGN KEY (`fk_oportunity`) REFERENCES `opportunity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_poc_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user_visit_log`
--
ALTER TABLE `user_visit_log`
  ADD CONSTRAINT `user_visit_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
