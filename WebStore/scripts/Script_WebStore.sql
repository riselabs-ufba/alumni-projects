/*drop schema webstoreDB;
  create schema webstoreDB;*/

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
  idStatusUsuario INTEGER UNSIGNED NOT NULL,
  idPerfil INTEGER UNSIGNED NOT NULL,
  dsNome VARCHAR(255) NULL,
  dsEmail VARCHAR(255) NOT NULL,
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
  idUsuarioResponde INTEGER UNSIGNED NOT NULL,
  idUsuarioRegistro INTEGER UNSIGNED NULL, -- modificado para null
  idSituacaoBug INTEGER UNSIGNED NOT NULL,
  dsBUG VARCHAR(1000) NULL,
  dtRegistro DATETIME NOT NULL,
  dsResposta VARCHAR(1000) NULL,
  dtResposta DATETIME NULL,
  PRIMARY KEY(idBugTrack),
  FOREIGN KEY(idSituacaoBug) REFERENCES webstoreDB.SituacaoBug(idSituacaoBug),
  FOREIGN KEY(idUsuarioRegistro) REFERENCES webstoreDB.Usuario(idUsuario),
  FOREIGN KEY(idUsuarioResponde) REFERENCES webstoreDB.Usuario(idUsuario)
);

CREATE TABLE webstoreDB.Mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarioResposta INTEGER UNSIGNED NOT NULL,
  idUsuarioRegistro INTEGER UNSIGNED NULL, -- modificado para null
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
