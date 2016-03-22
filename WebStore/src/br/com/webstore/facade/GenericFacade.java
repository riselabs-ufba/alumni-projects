//#if ${BugTrack} == "T" or ${Categoria} == "T" or ${Cupom} == "T" or ${Endereco} == "T" or ${FormaPagament} == "T" or ${Mensagem} == "T" or ${Perfil} == "T" or ${Produto} == "T" or ${SituacaoBug} == "T" or ${StatusUsuario} == "T" or ${StatusVenda} == "T" or ${TipoMensagem} == "T" or ${UnidadeMedida} == "T" or ${UsuarioCupom} == "T" or ${UsuarioCupom} == "T" or ${Usuario} == "T" or ${Venda} == "T" or ${VendaProduto} == "T" or ${VendaProdutoEmbbed} == "T" 
package br.com.webstore.facade;

import java.util.List;
//#if ${BugTrack} == "T"
import br.com.webstore.dao.BugTrackDao;
//#endif

//#if ${Categoria} == "T"
import br.com.webstore.dao.CategoriaDao;
//#endif

//#if ${Cupom} == "T"
import br.com.webstore.dao.CupomDao;
//#endif

//#if ${Endereco} == "T"
import br.com.webstore.dao.EnderecoDao;
//#endif

//#if ${FormaPagamento} == "T"
import br.com.webstore.dao.FormaPagamentDao;
//#endif

//#if ${Mensagem} == "T"
import br.com.webstore.dao.MensagemDao;
//#endif

//#if ${Perfil} == "T"
import br.com.webstore.dao.PerfilDao;
//#endif

//#if ${Produto} == "T"
import br.com.webstore.dao.ProdutoDao;
//#endif

//#if ${SituacaoBug} == "T"
import br.com.webstore.dao.SituacaoBugDao;
//#endif

//#if ${StatusUsuario} == "T"
import br.com.webstore.dao.StatusUsuarioDao;
//#endif

//#if ${StatusVenda} == "T"
import br.com.webstore.dao.StatusVendaDao;
//#endif
//#if ${TipoMensagem} == "T"
import br.com.webstore.dao.TipoMensagemDao;
//#endif
//#if ${UnidadeMedida} == "T"
import br.com.webstore.dao.UnidadeMedidaDao;
//#endif
//#if ${UsuarioCupom} == "T"
import br.com.webstore.dao.UsuarioCupomDao;
//#endif

//#if ${Usuario} == "T"
import br.com.webstore.dao.UsuarioDao;
//#endif

//#if ${Venda} == "T"
import br.com.webstore.dao.VendaDao;
//#endif

//#if ${VendaProduto} == "T"
import br.com.webstore.dao.VendaProdutoDao;
//#endif

//#if ${VendaProdutoEmbbed} == "T"
import br.com.webstore.dao.VendaProdutoEmbbedDao;
//#endif

//#if ${BugTrack} == "T"
import br.com.webstore.model.BugTrack;
//#endif

//#if ${Categoria} == "T"
import br.com.webstore.model.Categoria;
//#endif

//#if ${Cupom} == "T"
import br.com.webstore.model.Cupom;
//#endif

//#if ${Endereco} == "T"
import br.com.webstore.model.Endereco;
//#endif

//#if ${FormaPagamento} == "T"
import br.com.webstore.model.FormaPagamento;
//#endif

//#if ${Mensagem} == "T"
import br.com.webstore.model.Mensagem;
//#endif

//#if ${Perfil} == "T"
import br.com.webstore.model.Perfil;
//#endif

//#if ${Produto} == "T"
import br.com.webstore.model.Produto;
//#endif

//#if ${SituacaoBug} == "T"
import br.com.webstore.model.SituacaoBug;
//#endif

//#if ${StatusUsuario} == "T"
import br.com.webstore.model.StatusUsuario;
//#endif

//#if ${StatusVenda} == "T"
import br.com.webstore.model.StatusVenda;
//#endif

//#if ${TipoMensagem} == "T"
import br.com.webstore.model.TipoMensagem;
//#endif

//#if ${UnidadeMedida} == "T"
import br.com.webstore.model.UnidadeMedida;
//#endif

//#if ${Usuario} == "T"
import br.com.webstore.model.Usuario;
//#endif

//#if ${UsuarioCupom} == "T"
import br.com.webstore.model.UsuarioCupom;
//#endif

//#if ${Venda} == "T"
import br.com.webstore.model.Venda;
//#endif

//#if ${VendaProduto} == "T"
import br.com.webstore.model.VendaProduto;
//#endif

//#if ${VendaProdutoEmbbed} == "T"
import br.com.webstore.model.VendaProdutoEmbbed;
//#endif

/**
 * @author webstore
 *
 */
public class GenericFacade {
	
	//#if ${BugTrack} == "T"
	private BugTrackDao bugTrackDao = new BugTrackDao();
	
	public BugTrack insertBugTrack(BugTrack bugTrack) {
		return bugTrackDao.insert(bugTrack);
	}

	public Boolean updateBugTrack(BugTrack bugTrack) {//TODO: remove retornar boolean
		bugTrackDao.update(bugTrack);
		return true;
	}

	public List<BugTrack> findBugTrack(BugTrack query) {
		return bugTrackDao.getList();
	}
	
	public List<BugTrack> findBugTrack(String titulo, SituacaoBug situacao) {	
		return this.bugTrackDao.findByTitulo(titulo, situacao);
	}
	public List<BugTrack> findBugTrack(String titulo) {	
		return this.bugTrackDao.findByTitulo(titulo);
	}
	
	public List<BugTrack> findBugTrack() {
		return bugTrackDao.getList();
	}
	
	public Boolean removeBugTrack(int id){ //TODO: remove retornar boolean
		bugTrackDao.remove(id);
		return true;	
	}
	
	public BugTrack getBugTrack(int id) {
		return bugTrackDao.find(id);
	}
	
	//#endif
	
	//Categoria 
	//#if ${Categoria} == "T"
		private CategoriaDao categoriaDataProvider = new CategoriaDao();
		
		public Categoria insertCategoria(Categoria categoria) {
			return this.categoriaDataProvider.insert(categoria);
			//replace		return categoriaDataProvider.insert(categoria);		
		}

		public void updateCategoria(Categoria categoria) {
			//replace	categoriaDataProvider.update(categoria);		
			this.categoriaDataProvider.update(categoria);
		}

		public List<Categoria> findCategoria(String nome) {	
			//replace	public List<Categoria> findCategoria() {
			//			return categoriaDataProvider.getList();
			return this.categoriaDataProvider.findByNome(nome);
		}
		
		public Categoria getById(int id) {
			return this.categoriaDataProvider.find(id);
		}
	
		public void removerCategoria(int id) {
			this.categoriaDataProvider.remove(id);
		}
		public List<Categoria> getListCategoria() {
			return categoriaDataProvider.getList();
		}
		//#endif
		
		//Cupom
		//#if ${Cupom} == "T"

		private CupomDao cupomDataProvider = new CupomDao();
	
		public Cupom insertCupom(Cupom cupom) {
			
			return cupomDataProvider.insert(cupom);
		}

		public void updateCupom(Cupom cupom) {
			cupomDataProvider.update(cupom);
			
		}

		public List<Cupom> findCupom(Cupom query) {
			return cupomDataProvider.getList();
		}
		//#endif
	
		//Endereco
		//#if ${Endereco} == "T"
		
		private EnderecoDao enderecoDataProvider = new EnderecoDao();
	
		public Endereco insertEndereco(Endereco endereco) {	
			return enderecoDataProvider.insert(endereco);
		}

		public void updateEndereco(Endereco endereco) {
			enderecoDataProvider.update(endereco);
			
		}

		public List<Endereco> findEndereco(Endereco query) {
			
			return enderecoDataProvider.getList();
		}
		//#endif
		
		//FormaPagamento
		//#if ${FormaPagamento} == "T"
		private FormaPagamentDao formaPagamentDataProvider = new FormaPagamentDao();
	
		public FormaPagamento insertFormaPagamento(FormaPagamento formaPagamento) {

			return formaPagamentDataProvider.insert(formaPagamento);
		}

		public void updateFormaPagamento(FormaPagamento formaPagamento) {
			formaPagamentDataProvider.update(formaPagamento);
			
		}

		public List<FormaPagamento> findFormaPagamento(FormaPagamento query) {
		
			return formaPagamentDataProvider.getList();
		}
		//#endif
		
		//Mensagem
		//#if ${Mensagem} == "T"
		private MensagemDao mensagemDao = new MensagemDao();
		
		public void insert(Mensagem mensagem) {
			this.mensagemDao.insert(mensagem);
		}

		public void update(Mensagem mensagem) {
			this.mensagemDao.update(mensagem);
		}

		public Mensagem find(Integer id) {
			return this.mensagemDao.find(id);
		}

		public List<Mensagem> list(Mensagem query) {
			return this.mensagemDao.getList();
		}
		//#endif
		
		//Perfil
		//#if ${Perfil} == "T"
		private PerfilDao perfilDataProvider = new PerfilDao();
		
		public Perfil insertPerfil(Perfil perfil) {
			return perfilDataProvider.insert(perfil);
		}

		public void savePerfil(Perfil perfil) {
			perfilDataProvider.update(perfil);
			
		}

		public List<Perfil> findPerfil(Perfil query) {
			return perfilDataProvider.getList();
		}
		//#endif
		
		//Produto
		//#if ${Produto} == "T"
		private ProdutoDao produtoDataProvider = new ProdutoDao();

		public Produto insertProduto(Produto produto) {
			return this.produtoDataProvider.insert(produto);
		}

		public void updateProduto(Produto produto) {
			this.produtoDataProvider.update(produto);

		}

		public List<Produto> findProduto(String nome) {
			return this.produtoDataProvider.findByNome(nome);
		}

		public Produto getProdutoById(int id) {
			return this.produtoDataProvider.find(id);
		}

		public void removerProduto(int id) {
			this.produtoDataProvider.remove(id);
		}
		//#endif
		
		//SituacaoBug
		//#if ${SituacaoBug} == "T"
		private SituacaoBugDao situacaoBugDataProvider= new SituacaoBugDao();

		public SituacaoBug insertSituacaoBug(SituacaoBug situacaoBug) {
			return situacaoBugDataProvider.insert(situacaoBug);
		}

		public void updateSituacaoBug(SituacaoBug situacaoBug) {
			situacaoBugDataProvider.update(situacaoBug);		
		}

		public List<SituacaoBug> findSituacaoBug(SituacaoBug query) {
			return situacaoBugDataProvider.getList();
		}
		
		public List<SituacaoBug> getListSituacaoBug() {
			return situacaoBugDataProvider.getList();
		}
		
		public SituacaoBug findSituacaoBug(int id){
			return situacaoBugDataProvider.find(id);
		}

		public SituacaoBugDao getDaoSituacaoBug(){
			return situacaoBugDataProvider;
		}
		//#endif
		
		//StatusUsuario
		//#if ${StatusUsuario} == "T"
		private StatusUsuarioDao statusUsuarioDataProvider = new StatusUsuarioDao();

		public StatusUsuario insertStatusUsuario(StatusUsuario statusUsuario) {
			return statusUsuarioDataProvider.insert(statusUsuario);
		}

		public void updateStatusUsuario(StatusUsuario statusUsuario) {
			statusUsuarioDataProvider.update(statusUsuario);		
		}

		public List<StatusUsuario> findStatusUsuario(StatusUsuario query) {
			return statusUsuarioDataProvider.getList();
		}
		//#endif
		
		//StatusVenda
		//#if ${StatusVenda} == "T"
		private StatusVendaDao statusVendaDataProvider = new StatusVendaDao();

		public StatusVenda insertStatusVenda(StatusVenda statusVenda) {
			return statusVendaDataProvider.insert(statusVenda);
		}

		public void updateStatusVenda(StatusVenda statusVenda) {
			statusVendaDataProvider.update(statusVenda);		
		}

		public List<StatusVenda> findStatusVenda(StatusVenda query) {
			return statusVendaDataProvider.getList();
		}
		//#endif
		
		//TipoMensagem
		//#if ${TipoMensagem} == "T"
		private TipoMensagemDao tipoMensagemDataProvider = new TipoMensagemDao();

		public TipoMensagem findTipoMensagem(Integer id) {
			return tipoMensagemDataProvider.find(id);		
		}

		public List<TipoMensagem> listTipoMensagem() {
			return tipoMensagemDataProvider.getList();
		}
		//#endif
		
		//UnidadeMedida
		//#if ${UnidadeMedida} == "T"
		private UnidadeMedidaDao unidadeMedidaDao = new UnidadeMedidaDao();

		public UnidadeMedida insertUnidadeMedida(UnidadeMedida unidadeMedida) {
			return unidadeMedidaDao.insert(unidadeMedida);
		}

		public void updateUnidadeMedida(UnidadeMedida unidadeMedida) {
			unidadeMedidaDao.update(unidadeMedida);		
		}

		public List<UnidadeMedida> findUnidadeMedida(UnidadeMedida unidadeMedida) {
			return unidadeMedidaDao.getList();
		}

		public List<UnidadeMedida> getListUnidadeMedida() {
			return unidadeMedidaDao.getList();
		}
		//#endif
		
		//UsuarioCupom
		//#if ${UsuarioCupom} == "T"
		private UsuarioCupomDao usuarioCupomDao;

		public UsuarioCupom insertUsuarioCupom(UsuarioCupom usuarioCupom) {
			return usuarioCupomDao.insert(usuarioCupom);
		}

		public void updateUsuarioCupom(UsuarioCupom usuarioCupom) {
			usuarioCupomDao.update(usuarioCupom);		
		}

		public List<UsuarioCupom> findUsuarioCupom(UsuarioCupom usuarioCupom) {
			return usuarioCupomDao.getList();
		}
		//#endif
		
		
		//Usuario
		//#if ${Usuario} == "T"
		private UsuarioDao usuarioDao = new UsuarioDao();

		public Usuario insertUsuario(Usuario usuario) {
			return usuarioDao.insert(usuario);
		}

		public void updateUsuario(Usuario usuario) {
			usuarioDao.update(usuario);		
		}

		public List<Usuario> findUsuario(Usuario usuario) {
			return usuarioDao.getList();
		}

		public void removeUsuario(Integer id)
		{
			usuarioDao.remove(id);
		}

		public Usuario getUsuarioById(Integer id)
		{
			return usuarioDao.find(id);
		}
		//#endif
		
		//Venda
		//#if ${Venda} == "T"
		private VendaDao vendaDao;

		public Venda insertVenda(Venda venda) {
			return vendaDao.insert(venda);
		}

		public void updateVenda(Venda venda) {
			vendaDao.update(venda);		
		}

		public List<Venda> findCategoria(Venda venda) {
			return vendaDao.getList();
		}
		//#endif
		
		//VendaProdutoEmbbed
		//#if ${VendaProdutoEmbbed} == "T"
		private VendaProdutoEmbbedDao vendaProdutoEmbbedDao = new VendaProdutoEmbbedDao();

		public VendaProdutoEmbbed insertVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
			return vendaProdutoEmbbedDao.insert(vendaProdutoEmbbed);
		}

		public void updateVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
			vendaProdutoEmbbedDao.update(vendaProdutoEmbbed);		
		}

		public List<VendaProdutoEmbbed> findVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
			return vendaProdutoEmbbedDao.getList();
		}
		//#endif
		
		//VendaProduto
		//#if ${VendaProduto} == "T"
		private VendaProdutoDao vendaProdutoDao = new VendaProdutoDao();
		
		public VendaProduto insertVendaProduto(VendaProduto vendaProduto) {
			return vendaProdutoDao.insert(vendaProduto);
		}

		public void updateVendaProduto(VendaProduto vendaProduto) {
			vendaProdutoDao.update(vendaProduto);		
		}

		public List<VendaProduto> findVendaProduto(VendaProduto vendaProduto) {
			return vendaProdutoDao.getList();
		}
		//#endif
}
//#endif
