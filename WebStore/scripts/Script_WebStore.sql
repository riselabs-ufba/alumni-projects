drop schema if exists webstoreDB ;
create schema webstoreDB;
use webstoreDB;

CREATE TABLE webstoreDB.Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsCategoria VARCHAR(255) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE webstoreDB.Cupom (
  idCupom INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsCupom VARCHAR(255) NULL,
  dtCupomValidade DATETIME NULL,
  PRIMARY KEY(idCupom)
);

CREATE TABLE webstoreDB.FormaPagamento (
  idFormaPagamento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsFormaPagamento VARCHAR(255) NULL,
  PRIMARY KEY(idFormaPagamento)
);

CREATE TABLE webstoreDB.Perfil (
  idPerfil INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsPerfil VARCHAR(255) NULL,
  PRIMARY KEY(idPerfil)
);

CREATE TABLE webstoreDB.SituacaoBug (
  idSituacaoBug INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsSituacaoBug VARCHAR(255) NULL,
  PRIMARY KEY(idSituacaoBug)
);

CREATE TABLE webstoreDB.StatusUsuario (
  idStatusUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsStatusUsuario VARCHAR(255) NULL,
  PRIMARY KEY(idStatusUsuario)
);

CREATE TABLE webstoreDB.StatusVenda (
  idStatusVenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsStatusVenda VARCHAR(255) NULL,
  PRIMARY KEY(idStatusVenda)
);

CREATE TABLE webstoreDB.TipoMensagem (
  idTipoMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsTipoMensagem VARCHAR(255) NULL,
  PRIMARY KEY(idTipoMensagem)
);

CREATE TABLE webstoreDB.UnidadeMedida (
  idUnidadeMedida INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsUnidadeMedida VARCHAR(255) NULL,
  PRIMARY KEY(idUnidadeMedida)
);

CREATE TABLE webstoreDB.Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idStatusUsuario INTEGER UNSIGNED NULL,
  idPerfil INTEGER UNSIGNED NOT NULL,
  dsNome VARCHAR(255) NULL,
  dsEmail VARCHAR(255) NOT NULL,
  dsLogin varchar(50) UNIQUE NOT NULL,
  dsSenha VARCHAR(50) NOT NULL,
  dtNascimento DATE NULL,
  nrUsuarioTelefone VARCHAR(50) NULL,
  dtUsuarioInclusao DATETIME NOT NULL,
  PRIMARY KEY(idUsuario),
  FOREIGN KEY(idPerfil) REFERENCES webstoreDB.Perfil(idPerfil),
  FOREIGN KEY(idStatusUsuario) REFERENCES webstoreDB.StatusUsuario(idStatusUsuario)
);

CREATE TABLE webstoreDB.Endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INTEGER UNSIGNED NOT NULL,
  nmEnderecoLogradouro VARCHAR(255) NULL,
  nrEndereco VARCHAR(255) NULL,
  dsEnderecoBairro VARCHAR(255) NULL,
  dsEnderecoCep VARCHAR(10) NULL,
  dsEnderecoCidade VARCHAR(255) NULL,
  dsEnderecoUF VARCHAR(255) NULL,
  PRIMARY KEY(idEndereco),
  FOREIGN KEY(idUsuario) REFERENCES webstoreDB.Usuario(idUsuario)
);

CREATE TABLE webstoreDB.UsuarioCupom (
  idUsuarioCupom INTEGER UNSIGNED NOT NULL,
  idCupom INTEGER UNSIGNED NOT NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  flUsado BOOL NULL,
  PRIMARY KEY(idUsuarioCupom),
  FOREIGN KEY(idUsuario) REFERENCES webstoreDB.Usuario(idUsuario),
  FOREIGN KEY(idCupom) REFERENCES webstoreDB.Cupom(idCupom)
);

CREATE TABLE webstoreDB.Venda (
  idVenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idStatusVenda INTEGER UNSIGNED NOT NULL,
  idUsuarioVenda INTEGER UNSIGNED NOT NULL,
  idUsuarioCupom INTEGER UNSIGNED NULL,-- modificado para null
  idFormaPagamento INTEGER UNSIGNED NOT NULL,
  dtVenda DATETIME NOT NULL,
  vlVendaTotal DECIMAL NOT NULL,
  PRIMARY KEY(idVenda),
  FOREIGN KEY(idFormaPagamento) REFERENCES webstoreDB.FormaPagamento(idFormaPagamento),
  FOREIGN KEY(idUsuarioVenda) REFERENCES webstoreDB.Usuario(idUsuario),
  FOREIGN KEY(idUsuarioCupom) REFERENCES webstoreDB.UsuarioCupom(idUsuarioCupom),
  FOREIGN KEY(idStatusVenda) REFERENCES webstoreDB.StatusVenda(idStatusVenda)
);

CREATE TABLE webstoreDB.Produto (
  idProduto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  idUnidadeMedida INTEGER UNSIGNED NOT NULL,
  nrProdutoCodigo INTEGER UNSIGNED NULL,
  dsProduto VARCHAR(1000) NULL,
  vlProduto DECIMAL NOT NULL,
  PRIMARY KEY(idProduto),
  FOREIGN KEY(idUnidadeMedida) REFERENCES webstoreDB.UnidadeMedida(idUnidadeMedida),
  FOREIGN KEY(idCategoria) REFERENCES webstoreDB.Categoria(idCategoria)
);

CREATE TABLE webstoreDB.VendaProduto (
  idProduto INTEGER UNSIGNED NOT NULL,
  idVenda INTEGER UNSIGNED NOT NULL,
  nrQuantidadeProduto DECIMAL NOT NULL,
  vlProdutoUnitario DECIMAL NOT NULL,
  PRIMARY KEY(idProduto, idVenda),
  FOREIGN KEY(idProduto) REFERENCES webstoreDB.Produto(idProduto),
  FOREIGN KEY(idVenda) REFERENCES webstoreDB.Venda(idVenda)
);

CREATE TABLE webstoreDB.BugTrack (
  idBugTrack INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarioResponde INTEGER UNSIGNED NULL, -- modificado para null
  idUsuarioRegistro INTEGER UNSIGNED NOT NULL,
  idSituacaoBug INTEGER UNSIGNED NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  dsBUG VARCHAR(1000) NOT NULL,
  dtRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
  dsResposta VARCHAR(1000) NULL,
  dtResposta DATETIME NULL,
  PRIMARY KEY(idBugTrack),
  FOREIGN KEY(idSituacaoBug) REFERENCES webstoreDB.SituacaoBug(idSituacaoBug),
  FOREIGN KEY(idUsuarioRegistro) REFERENCES webstoreDB.Usuario(idUsuario),
  FOREIGN KEY(idUsuarioResponde) REFERENCES webstoreDB.Usuario(idUsuario)
);

CREATE TABLE webstoreDB.Mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarioResposta INTEGER UNSIGNED NULL, -- modificado para null
  idUsuarioRegistro INTEGER UNSIGNED NOT NULL,
  idTipoMensagem INTEGER UNSIGNED NOT NULL,
  dsMensagem VARCHAR(1000) NULL,
  dtMensagemRegistro DATETIME NOT NULL,
  dsMensagemResposta VARCHAR(1000) NULL,
  dtMensagemResposta DATETIME NULL,
  PRIMARY KEY(idMensagem),
  FOREIGN KEY(idTipoMensagem) REFERENCES webstoreDB.TipoMensagem(idTipoMensagem),
  FOREIGN KEY(idUsuarioRegistro) REFERENCES webstoreDB.Usuario(idUsuario),
  FOREIGN KEY(idUsuarioResposta) REFERENCES webstoreDB.Usuario(idUsuario)
);


CREATE TABLE webstoreDB.FAQ (
	idFaq INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
	dsFaq VARCHAR(1000) NULL,
	dsFaqResposta VARCHAR(1000) NULL,
  PRIMARY KEY(idFaq)
  
);

INSERT INTO webstoreDB.Perfil (`idPerfil`, `dsPerfil`) VALUES
(1, 'Admin'),
(2, 'Cliente');

INSERT INTO webstoreDB.Usuario (idUsuario, idStatusUsuario, idPerfil, dsNome, dsLogin, dsEmail, dsSenha, dtNascimento, nrUsuarioTelefone, dtUsuarioInclusao) VALUES
(1, null, 1, 'Admin', 'Admin','admin@gmail.com','123456', '1970-01-01', '71999999999', NOW()),
(2, null, 2, 'Cliente', 'Cliente','cliente@gmail.com','123456', '1970-01-01', '71999999999', NOW());
  
INSERT INTO webstoreDB.SituacaoBug (`idSituacaoBug`, `dsSituacaoBug`) VALUES
(1, 'Aberto'),
(2, 'Em andamento'),
(3, 'Fechado');

INSERT INTO webstoreDB.unidademedida (idUnidadeMedida,dsUnidadeMedida) VALUES (1,'KG');
INSERT INTO webstoreDB.unidademedida (idUnidadeMedida,dsUnidadeMedida) VALUES (2,'UN');
INSERT INTO webstoreDB.unidademedida (idUnidadeMedida,dsUnidadeMedida) VALUES (3,'CX');

insert into statususuario(idStatusUsuario, dsStatusUsuario) value(1,'Ativo')	
insert into statususuario(idStatusUsuario, dsStatusUsuario) value(2,'Inativo')

insert into webstoredb.statusvenda (dsStatusVenda) values ("Carrinho");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Finalizada");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Confirmando Pagamento");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Pagamento Realizado");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Enviado para depósito");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Enviado para transportadora");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Em trânsito para destino");
insert into webstoredb.statusvenda (dsStatusVenda) values ("Entregue");

insert into webstoredb.formapagamento (dsFormaPagamento) values ("Boleto Bancário");
insert into webstoredb.formapagamento (dsFormaPagamento) values ("Depósito Bancário");
insert into webstoredb.formapagamento (dsFormaPagamento) values ("Cartão Master Card");
insert into webstoredb.formapagamento (dsFormaPagamento) values ("Cartão Visa");
insert into webstoredb.formapagamento (dsFormaPagamento) values ("Cartão Dinners");
insert into webstoredb.formapagamento (dsFormaPagamento) values ("Cartão Amex");
