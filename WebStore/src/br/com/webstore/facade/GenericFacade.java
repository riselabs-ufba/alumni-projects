package br.com.webstore.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

//#if ${FAQ} == "T"
import br.com.webstore.dao.FaqDao;
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

//#if ${FAQ} == "T"
import br.com.webstore.model.Faq;
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
	
	
	public GenericFacade() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstoreDB");
		EntityManager entityManager = factory.createEntityManager();
		
		//#if ${BugTrack} == "T"
		bugTrackDao = new BugTrackDao(entityManager);
		//#endif
		
		//#if ${Produto} == "T"
		produtoDataProvider = new ProdutoDao(entityManager);
		//#endif
		
		//#if ${FAQ} == "T"
		faqDataProvider=new FaqDao(entityManager);
		//#endif		
		
		//#if ${Categoria} == "T"
		categoriaDataProvider=new CategoriaDao(entityManager);
		//#endif
		
		//#if ${Cupom} == "T"
		cupomDataProvider = new CupomDao(entityManager);
		//#endif
		
		//#if ${Endereco} == "T"
		enderecoDataProvider=new  EnderecoDao(entityManager);
		//#endif
		
		//#if ${FormaPagamento} == "T"
		formaPagamentDataProvider=new FormaPagamentDao(entityManager);
		//#endif
		
		//#if ${Mensagem} == "T"
		mensagemDao=new MensagemDao(entityManager);
		//#endif
		
		//#if ${Perfil} == "T"
		perfilDataProvider=new PerfilDao(entityManager);
		//#endif
		
		//#if ${SituacaoBug} == "T"
		situacaoBugDataProvider= new SituacaoBugDao(entityManager);
		//#endif
		
		//#if ${StatusUsuario} == "T"
		statusUsuarioDataProvider = new StatusUsuarioDao(entityManager);
		//#endif
		
		//#if ${StatusVenda} == "T"
		statusVendaDataProvider=new StatusVendaDao(entityManager);
		//#endif
		
		//#if ${TipoMensagem} == "T"
		tipoMensagemDataProvider = new TipoMensagemDao(entityManager);
		//#endif
		
		//#if ${Usuario} == "T"
		usuarioDataProvider = new UsuarioDao(entityManager);
		//#endif
		
		//#if ${VendaProdutoEmbbed} == "T"
	    vendaProdutoEmbbedDao = new VendaProdutoEmbbedDao(entityManager);
	   //#endif

	    //#if ${VendaProduto} == "T"
	  	vendaProdutoDao = new VendaProdutoDao(entityManager);
	  	//#endif
	  	
	  	//#if ${UnidadeMedida} == "T"
	  	unidadeMedidaDao=new  UnidadeMedidaDao(entityManager);
	  	//#endif		

	    
	}
	
	//#if ${BugTrack} == "T"
	private BugTrackDao bugTrackDao;
	
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
	
	
	
		//#if ${FAQ} == "T"
			private FaqDao faqDataProvider;

			public Faq insertFaq(Faq faq) {
				return this.faqDataProvider.insert(faq);
			}

			public void updateFaq(Faq faq) {
				this.faqDataProvider.update(faq);

			}

			public List<Faq> findFaq(String descricao) {
				return this.faqDataProvider.findByNome(descricao);
			}

			public Faq getFaqById(int id) {
				return this.faqDataProvider.find(id);
			}

			public void removerFaq(int id) {
				this.faqDataProvider.remove(id);
			}
	//#endif

	
	
	
	
	 
	//#if ${Categoria} == "T"
		private CategoriaDao categoriaDataProvider;
		
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

		private CupomDao cupomDataProvider;
	
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
		
		private EnderecoDao enderecoDataProvider;
	
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
		
		//#if ${FormaPagamento} == "T"
		private FormaPagamentDao formaPagamentDataProvider;
	
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
		
	
		//#if ${Mensagem} == "T"
		private MensagemDao mensagemDao;
		
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
		
	
		//#if ${Perfil} == "T"
		private PerfilDao perfilDataProvider;
		
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
		
	
		//#if ${Produto} == "T"
		private ProdutoDao produtoDataProvider;

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
		
	
		//#if ${SituacaoBug} == "T"
		private SituacaoBugDao situacaoBugDataProvider;

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
		
	
		//#if ${StatusUsuario} == "T"
		private StatusUsuarioDao statusUsuarioDataProvider;

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
		
	
		//#if ${StatusVenda} == "T"
		private StatusVendaDao statusVendaDataProvider;

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
		
		//#if ${TipoMensagem} == "T"
		private TipoMensagemDao tipoMensagemDataProvider;

		public TipoMensagem findTipoMensagem(Integer id) {
			return tipoMensagemDataProvider.find(id);		
		}

		public List<TipoMensagem> listTipoMensagem() {
			return tipoMensagemDataProvider.getList();
		}
		//#endif
		
	
		//#if ${UnidadeMedida} == "T"
		private UnidadeMedidaDao unidadeMedidaDao;

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
		
		
	
		//#if ${Usuario} == "T"
		
		private UsuarioDao usuarioDataProvider;
		
		public Usuario insertUsuario(Usuario usuario) {
			return usuarioDataProvider.insert(usuario);
		}

		public void updateUsuario(Usuario usuario) {
			usuarioDataProvider.update(usuario);		
		}

		public List<Usuario> findUsuario(String email) {
			return usuarioDataProvider.findByEmail(email);
		}

		public void removeUsuario(Integer id)
		{
			usuarioDataProvider.remove(id);
		}

		public Usuario getUsuarioById(Integer id)
		{
			return usuarioDataProvider.find(id);
		}
		
		public List<Usuario> getUsuarioByLoginSenha(String Login, String Senha)
		{
			return usuarioDataProvider.getUsuarioByLoginSenha(Login, Senha);
		}
		
		public Usuario getUsuarioByLogin(String login){
			return usuarioDataProvider.findByLogin(login);
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
		private VendaProdutoEmbbedDao vendaProdutoEmbbedDao;

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
		private VendaProdutoDao vendaProdutoDao;
		
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
