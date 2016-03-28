-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 28-Mar-2016 às 00:10
-- Versão do servidor: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webstoredb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bugtrack`
--

DROP TABLE IF EXISTS `bugtrack`;
CREATE TABLE IF NOT EXISTS `bugtrack` (
  `idBugTrack` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idUsuarioResponde` int(10) UNSIGNED DEFAULT NULL,
  `idUsuarioRegistro` int(10) UNSIGNED NOT NULL,
  `idSituacaoBug` int(10) UNSIGNED NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `dsBUG` varchar(1000) NOT NULL,
  `dtRegistro` datetime DEFAULT CURRENT_TIMESTAMP,
  `dsResposta` varchar(1000) DEFAULT NULL,
  `dtResposta` datetime DEFAULT NULL,
  `dtMensagemRegistro` date NOT NULL,
  PRIMARY KEY (`idBugTrack`),
  KEY `FK1qh10xhmu3qawc606on8811as` (`idUsuarioRegistro`),
  KEY `FK5evspv8elf3g93jenbssdifdj` (`idUsuarioResponde`),
  KEY `FK2imk1208b9mhk3f1vcjqphpoh` (`idSituacaoBug`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsCategoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `dsCategoria`) VALUES
(1, 'Artigos 1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cupom`
--

DROP TABLE IF EXISTS `cupom`;
CREATE TABLE IF NOT EXISTS `cupom` (
  `idCupom` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsCupom` varchar(255) DEFAULT NULL,
  `dtCupomValidade` datetime DEFAULT NULL,
  PRIMARY KEY (`idCupom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE IF NOT EXISTS `endereco` (
  `idEndereco` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idUsuario` int(10) UNSIGNED NOT NULL,
  `nmEnderecoLogradouro` varchar(255) DEFAULT NULL,
  `nrEndereco` varchar(255) DEFAULT NULL,
  `dsEnderecoBairro` varchar(255) DEFAULT NULL,
  `dsEnderecoCep` varchar(10) DEFAULT NULL,
  `dsEnderecoCidade` varchar(255) DEFAULT NULL,
  `dsEnderecoUF` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `idUsuario` (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `formapagamento`
--

DROP TABLE IF EXISTS `formapagamento`;
CREATE TABLE IF NOT EXISTS `formapagamento` (
  `idFormaPagamento` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsFormaPagamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idFormaPagamento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
CREATE TABLE IF NOT EXISTS `mensagem` (
  `idMensagem` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idUsuarioResposta` int(10) UNSIGNED DEFAULT NULL,
  `idUsuarioRegistro` int(10) UNSIGNED NOT NULL,
  `idTipoMensagem` int(10) UNSIGNED NOT NULL,
  `dsMensagem` varchar(1000) DEFAULT NULL,
  `dtMensagemRegistro` datetime NOT NULL,
  `dsMensagemResposta` varchar(1000) DEFAULT NULL,
  `dtMensagemResposta` datetime DEFAULT NULL,
  PRIMARY KEY (`idMensagem`),
  KEY `FKnlkgbu77drus9oqryosfo74i` (`idTipoMensagem`),
  KEY `FKjwiaf3almf20jdd87567g7yvd` (`idUsuarioRegistro`),
  KEY `FKhi5gkfs8m36n5n8o49h3aj5b9` (`idUsuarioResposta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `idPerfil` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsPerfil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`idPerfil`, `dsPerfil`) VALUES
(1, 'Admin'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `idProduto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idCategoria` int(10) UNSIGNED NOT NULL,
  `idUnidadeMedida` int(10) UNSIGNED NOT NULL,
  `nrProdutoCodigo` int(10) UNSIGNED DEFAULT NULL,
  `dsProduto` text,
  `vlProduto` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `FKepq2ej9rmp5weln4b0iwenjca` (`idCategoria`),
  KEY `FKpvidi0hf0kno0iy6w2rxdv095` (`idUnidadeMedida`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `idCategoria`, `idUnidadeMedida`, `nrProdutoCodigo`, `dsProduto`, `vlProduto`) VALUES
(1, 1, 1, 1, 'Produto 1', '10');

-- --------------------------------------------------------

--
-- Estrutura da tabela `situacaobug`
--

DROP TABLE IF EXISTS `situacaobug`;
CREATE TABLE IF NOT EXISTS `situacaobug` (
  `idSituacaoBug` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsSituacaoBug` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idSituacaoBug`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `situacaobug`
--

INSERT INTO `situacaobug` (`idSituacaoBug`, `dsSituacaoBug`) VALUES
(1, 'Aberto'),
(2, 'Em andamento'),
(3, 'Fechado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `statususuario`
--

DROP TABLE IF EXISTS `statususuario`;
CREATE TABLE IF NOT EXISTS `statususuario` (
  `idStatusUsuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsStatusUsuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idStatusUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `statusvenda`
--

DROP TABLE IF EXISTS `statusvenda`;
CREATE TABLE IF NOT EXISTS `statusvenda` (
  `idStatusVenda` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsStatusVenda` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idStatusVenda`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipomensagem`
--

DROP TABLE IF EXISTS `tipomensagem`;
CREATE TABLE IF NOT EXISTS `tipomensagem` (
  `idTipoMensagem` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsTipoMensagem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipoMensagem`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidademedida`
--

DROP TABLE IF EXISTS `unidademedida`;
CREATE TABLE IF NOT EXISTS `unidademedida` (
  `idUnidadeMedida` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dsUnidadeMedida` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUnidadeMedida`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `unidademedida`
--

INSERT INTO `unidademedida` (`idUnidadeMedida`, `dsUnidadeMedida`) VALUES
(1, 'KG'),
(2, 'UN'),
(3, 'CX');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idStatusUsuario` int(10) UNSIGNED DEFAULT NULL,
  `idPerfil` int(10) UNSIGNED NOT NULL,
  `dsNome` varchar(255) DEFAULT NULL,
  `dsEmail` varchar(255) NOT NULL,
  `dsSenha` varchar(50) NOT NULL,
  `dtNascimento` date DEFAULT NULL,
  `nrUsuarioTelefone` varchar(50) DEFAULT NULL,
  `dtUsuarioInclusao` datetime NOT NULL,
  `dsLogin` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FKph6qs3u4cig6kibplh25sf8kq` (`idPerfil`),
  KEY `FKofegc8x2bkui5p9icndsmv6qb` (`idStatusUsuario`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `idStatusUsuario`, `idPerfil`, `dsNome`, `dsEmail`, `dsSenha`, `dtNascimento`, `nrUsuarioTelefone`, `dtUsuarioInclusao`, `dsLogin`) VALUES
(1, NULL, 1, 'Administrador', 'admin@gmail.com', '123456', '1970-01-01', '71999999999', '2016-03-27 19:24:09', 'Admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuariocupom`
--

DROP TABLE IF EXISTS `usuariocupom`;
CREATE TABLE IF NOT EXISTS `usuariocupom` (
  `idUsuarioCupom` int(10) UNSIGNED NOT NULL,
  `idCupom` int(10) UNSIGNED NOT NULL,
  `idUsuario` int(10) UNSIGNED NOT NULL,
  `flUsado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuarioCupom`),
  KEY `FKmg0f3nm0ckymnm3b92xcat7rd` (`idCupom`),
  KEY `FK5hh11qxx4s7knkkvbaeatoeht` (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `idVenda` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idStatusVenda` int(10) UNSIGNED NOT NULL,
  `idUsuarioVenda` int(10) UNSIGNED NOT NULL,
  `idUsuarioCupom` int(10) UNSIGNED DEFAULT NULL,
  `idFormaPagamento` int(10) UNSIGNED NOT NULL,
  `dtVenda` datetime NOT NULL,
  `vlVendaTotal` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `FKe01tpr97ld6oweun1xywegjw7` (`idFormaPagamento`),
  KEY `FK1ccf6yd0pvgrceuvpb8q9x6uc` (`idStatusVenda`),
  KEY `FK921t2gd1vj4auaytn20oxsjna` (`idUsuarioCupom`),
  KEY `FKjrmubmjuewyjhwnkacaho3afc` (`idUsuarioVenda`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
CREATE TABLE IF NOT EXISTS `vendaproduto` (
  `idProduto` int(10) UNSIGNED NOT NULL,
  `idVenda` int(10) UNSIGNED NOT NULL,
  `nrQuantidadeProduto` decimal(10,0) NOT NULL,
  `vlProdutoUnitario` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idProduto`,`idVenda`),
  KEY `idVenda` (`idVenda`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
