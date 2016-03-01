CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsCategoria VARCHAR(255) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Cupom (
  idCupom INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsCupom VARCHAR(255) NULL,
  dtCupomValidade DATETIME NULL,
  PRIMARY KEY(idCupom)
);

CREATE TABLE FormaPagamento (
  idFormaPagamento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsFormaPagamento VARCHAR(255) NULL,
  PRIMARY KEY(idFormaPagamento)
);

CREATE TABLE Perfil (
  idPerfil INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsPerfil VARCHAR(255) NULL,
  PRIMARY KEY(idPerfil)
);

CREATE TABLE SituacaoBug (
  idSituacaoBug INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsSituacaoBug VARCHAR(255) NULL,
  PRIMARY KEY(idSituacaoBug)
);

CREATE TABLE StatusUsuario (
  idStatusUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsStatusUsuario VARCHAR(255) NULL,
  PRIMARY KEY(idStatusUsuario)
);

CREATE TABLE StatusVenda (
  idStatusVenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsStatusVenda VARCHAR(255) NULL,
  PRIMARY KEY(idStatusVenda)
);

CREATE TABLE TipoMensagem (
  idTipoMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsTipoMensagem VARCHAR(255) NULL,
  PRIMARY KEY(idTipoMensagem)
);

CREATE TABLE UnidadeMedida (
  idUnidadeMedida INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dsUnidadeMedida VARCHAR(255) NULL,
  PRIMARY KEY(idUnidadeMedida)
);

CREATE TABLE Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idStatusUsuario INTEGER UNSIGNED NOT NULL,
  idPerfil INTEGER UNSIGNED NOT NULL,
  dsNome VARCHAR(255) NULL,
  dsEmail VARCHAR(255) NULL,
  dsSenha VARCHAR(50) NULL,
  dtNascimento DATE NULL,
  nrUsuarioTelefone VARCHAR(50) NULL,
  dtUsuarioInclusao DATETIME NULL,
  PRIMARY KEY(idUsuario),
  FOREIGN KEY(idPerfil) REFERENCES Perfil(idPerfil),
  FOREIGN KEY(idStatusUsuario) REFERENCES StatusUsuario(idStatusUsuario)
);

CREATE TABLE Endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INTEGER UNSIGNED NOT NULL,
  nmEnderecoLogradouro VARCHAR(255) NULL,
  nrEndereco VARCHAR(255) NULL,
  dsEnderecoBairro VARCHAR(255) NULL,
  dsEnderecoCep VARCHAR(10) NULL,
  dsEnderecoCidade VARCHAR(255) NULL,
  dsEnderecoUF VARCHAR(255) NULL,
  PRIMARY KEY(idEndereco),
  FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE UsuarioCupom (
  idUsuarioCupom INTEGER UNSIGNED NOT NULL,
  idCupom INTEGER UNSIGNED NOT NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  flUsado BOOL NULL,
  PRIMARY KEY(idUsuarioCupom),
  FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario),
  FOREIGN KEY(idCupom) REFERENCES Cupom(idCupom)
);

CREATE TABLE Venda (
  idVenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idStatusVenda INTEGER UNSIGNED NOT NULL,
  idUsuarioVenda INTEGER UNSIGNED NOT NULL,
  idUsuarioCupom INTEGER UNSIGNED NOT NULL,
  idFormaPagamento INTEGER UNSIGNED NULL,
  dtVenda DATETIME NULL,
  vlVendaTotal DECIMAL NULL,
  PRIMARY KEY(idVenda),
  FOREIGN KEY(idFormaPagamento) REFERENCES FormaPagamento(idFormaPagamento),
  FOREIGN KEY(idUsuarioVenda) REFERENCES Usuario(idUsuario),
  FOREIGN KEY(idUsuarioCupom) REFERENCES UsuarioCupom(idUsuarioCupom),
  FOREIGN KEY(idStatusVenda) REFERENCES StatusVenda(idStatusVenda)
);

CREATE TABLE Produto (
  idProduto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  idUnidadeMedida INTEGER UNSIGNED NOT NULL,
  nrProdutoCodigo INTEGER UNSIGNED NULL,
  dsProduto VARCHAR(1000) NULL,
  vlProduto DECIMAL NOT NULL,
  PRIMARY KEY(idProduto),
  FOREIGN KEY(idUnidadeMedida) REFERENCES UnidadeMedida(idUnidadeMedida),
  FOREIGN KEY(idCategoria) REFERENCES Categoria(idCategoria)
);

CREATE TABLE VendaProduto (
  idProduto INTEGER UNSIGNED NOT NULL,
  idVenda INTEGER UNSIGNED NOT NULL,
  nrQuantidadeProduto DECIMAL NULL,
  vlProdutoUnitario DECIMAL NULL,
  PRIMARY KEY(idProduto, idVenda),
  FOREIGN KEY(idProduto) REFERENCES Produto(idProduto)
);

CREATE TABLE BugTrack (
  idBugTrack INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarioResponde INTEGER UNSIGNED NOT NULL,
  idUsuarioRegistro INTEGER UNSIGNED NOT NULL,
  idSituacaoBug INTEGER UNSIGNED NOT NULL,
  dsBUG VARCHAR(1000) NULL,
  dtRegistro DATETIME NULL,
  dsResposta VARCHAR(1000) NULL,
  dtResposta DATETIME NULL,
  PRIMARY KEY(idBugTrack),
  FOREIGN KEY(idSituacaoBug) REFERENCES SituacaoBug(idSituacaoBug),
  FOREIGN KEY(idUsuarioRegistro) REFERENCES Usuario(idUsuario),
  FOREIGN KEY(idUsuarioResponde) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarioResposta INTEGER UNSIGNED NOT NULL,
  idUsuarioRegistro INTEGER UNSIGNED NOT NULL,
  idTipoMensagem INTEGER UNSIGNED NOT NULL,
  dsMensagem VARCHAR(1000) NULL,
  dtMensagemRegistro DATETIME NOT NULL,
  dsMensagemResposta VARCHAR(1000) NULL,
  dtMensagemResposta DATETIME NULL,
  PRIMARY KEY(idMensagem),
  FOREIGN KEY(idTipoMensagem) REFERENCES TipoMensagem(idTipoMensagem),
  FOREIGN KEY(idUsuarioRegistro) REFERENCES Usuario(idUsuario),
  FOREIGN KEY(idUsuarioResposta) REFERENCES Usuario(idUsuario)
);
