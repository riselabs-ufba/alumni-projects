package br.com.webstore.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//#if ${Comunicacao} == "T"
//#if ${BugTrack} == "T"
//#if ${BugTrackCadastrar} == "T" or ${BugTrackConsultar} == "T" or ${BugTrackExcluir} == "T" or ${BugTrackAlterar} == "T"
import br.com.webstore.dao.BugTrackDao;
import br.com.webstore.model.BugTrack;
//#endif
//#endif
//#if ${FAQ} == "T"
//#if ${FAQCadastrar} == "T" or ${FAQConsultar} == "T" or ${FAQExcluir} == "T" or ${FAQAlterar} == "T" or ${FAQDetalhar} == "T" 
import br.com.webstore.dao.FaqDao;
import br.com.webstore.model.Faq;
//#endif
//#endif
//#endif


//#if ${Categoria} == "T"
import br.com.webstore.dao.CategoriaDao;
//#endif


import br.com.webstore.dao.CupomDao;


import br.com.webstore.dao.EnderecoDao;





import br.com.webstore.dao.FormaPagamentDao;



import br.com.webstore.dao.MensagemDao;


//#if ${Usuario} == "T"
import br.com.webstore.dao.PerfilDao;
//#endif

//#if ${Produto} == "T"
import br.com.webstore.dao.ProdutoDao;
//#endif


import br.com.webstore.dao.SituacaoBugDao;


//#if ${Usuario} == "T"
//#if ${UsuarioStatus} == "T"
import br.com.webstore.dao.StatusUsuarioDao;
//#endif
//#endif


//#if ${CarrinhoCompras} == "T"
import br.com.webstore.dao.StatusVendaDao;
//#endif


import br.com.webstore.dao.TipoMensagemDao;



import br.com.webstore.dao.UnidadeMedidaDao;


//#if ${Usuario} == "T"
import br.com.webstore.dao.UsuarioDao;
import br.com.webstore.dao.UsuarioCupomDao;
//#endif

//#if ${CarrinhoCompras} == "T"
import br.com.webstore.dao.VendaDao;
//#endif


import br.com.webstore.dao.VendaProdutoDao;



import br.com.webstore.dao.VendaProdutoEmbbedDao;


//#if ${Categoria} == "T"
import br.com.webstore.model.Categoria;
//#endif


import br.com.webstore.model.Cupom;



import br.com.webstore.model.Endereco;




import br.com.webstore.model.FormaPagamento;



import br.com.webstore.model.Mensagem;


//#if ${Usuario} == "T"
import br.com.webstore.model.Perfil;
//#endif

//#if ${Produto} == "T"
import br.com.webstore.model.Produto;
//#endif


import br.com.webstore.model.SituacaoBug;


//#if ${Usuario} == "T"
//#if ${UsuarioStatus} == "T"
import br.com.webstore.model.StatusUsuario;
//#endif
//#endif

//#if ${CarrinhoCompras} == "T"
import br.com.webstore.model.StatusVenda;
//#endif


import br.com.webstore.model.TipoMensagem;



import br.com.webstore.model.UnidadeMedida;


//#if ${Usuario} == "T"
import br.com.webstore.model.Usuario;
import br.com.webstore.model.UsuarioCupom;
//#endif


//#if ${CarrinhoCompras} == "T"
import br.com.webstore.model.Venda;
//#endif


import br.com.webstore.model.VendaProduto;



import br.com.webstore.model.VendaProdutoEmbbed;


/**
 * @author webstore
 *
 */
public class GenericFacade {

	
	public GenericFacade() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstoreDB");
		EntityManager entityManager = factory.createEntityManager();
		
		//#if ${Comunicacao} == "T"
		//#if ${BugTrack} == "T"
		//#if ${BugTrackCadastrar} == "T" or ${BugTrackConsultar} == "T" or ${BugTrackExcluir} == "T" or ${BugTrackAlterar} == "T"
		bugTrackDao = new BugTrackDao(entityManager);
		//#endif
		//#endif
		
		//#if ${FAQ} == "T"
		//#if ${FAQCadastrar} == "T" or ${FAQConsultar} == "T" or ${FAQExcluir} == "T" or ${FAQAlterar} == "T" 
		faqDataProvider=new FaqDao(entityManager);
		//#endif
		//#endif
		
		//#endif
		
		
		//#if ${Produto} == "T"
		produtoDataProvider = new ProdutoDao(entityManager);
		//#endif
		
		
		
		//#if ${Categoria} == "T"
		categoriaDataProvider=new CategoriaDao(entityManager);
		//#endif
		
		
	//	cupomDataProvider = new CupomDao(entityManager);
		
		

		enderecoDataProvider=new  EnderecoDao(entityManager);

		
		
		formaPagamentDataProvider=new FormaPagamentDao(entityManager);
		
		
		
		mensagemDao=new MensagemDao(entityManager);
		
		
		//#if ${Usuario} == "T"
		perfilDataProvider=new PerfilDao(entityManager);
		//#endif
		

		situacaoBugDataProvider= new SituacaoBugDao(entityManager);

		
		//#if ${Usuario} == "T"
		//#if ${UsuarioStatus} == "T"
		statusUsuarioDataProvider = new StatusUsuarioDao(entityManager);
		//#endif
		//#endif
		
		//#if ${CarrinhoCompras} == "T"
		statusVendaDataProvider=new StatusVendaDao(entityManager);
		//#endif
		
		
		tipoMensagemDataProvider = new TipoMensagemDao(entityManager);
	
		
		//#if ${Usuario} == "T"
		usuarioDataProvider = new UsuarioDao(entityManager);
		//#endif
		

		//#if ${CarrinhoCompras} == "T"
		vendaDao = new VendaDao(entityManager);
		//#endif
		
		
	    vendaProdutoEmbbedDao = new VendaProdutoEmbbedDao(entityManager);
	   


	  	vendaProdutoDao = new VendaProdutoDao(entityManager);

	  	

	  	unidadeMedidaDao=new  UnidadeMedidaDao(entityManager);
		

	    
	}
	
	//#if ${Comunicacao} == "T"
	//#if ${BugTrack} == "T"
	//#if ${BugTrackCadastrar} == "T" or ${BugTrackConsultar} == "T" or ${BugTrackExcluir} == "T" or ${BugTrackAlterar} == "T"
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
	//#endif
	//#endif
	
		//#if ${Comunicacao} == "T"
		//#if ${FAQ} == "T"
		//#if ${FAQCadastrar} == "T" or ${FAQConsultar} == "T" or ${FAQExcluir} == "T" or ${FAQAlterar} == "T"  or ${FAQDetalhar} == "T" or ${FAQListar} == "T"
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
	//#endif
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
		
		
		/*private CupomDao cupomDataProvider;
	
		public Cupom insertCupom(Cupom cupom) {
			
			return cupomDataProvider.insert(cupom);
		}

		public void updateCupom(Cupom cupom) {
			cupomDataProvider.update(cupom);
			
		}

		public List<Cupom> findCupom(Cupom query) {
			return cupomDataProvider.getList();
		}*/
		
	

		
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
		
		public FormaPagamento findFormaPagamentoByNome(String nome){
			return formaPagamentDataProvider.findByNome(nome);
		}
		

		
	
	
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
		
		
	
		//#if ${Usuario} == "T"
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
		
		public List<Produto> getProdutos() {
			return this.produtoDataProvider.getProdutos();
		}
		
		//#endif
		
	

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

		
		//#if ${Usuario} == "T"
		//#if ${UsuarioStatus} == "T"
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
		//#endif
		
	
		//#if ${CarrinhoCompras} == "T"
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
		
		public StatusVenda findStatusVendabyName(String nome){
			return statusVendaDataProvider.findByName(nome);
		}
		//#endif
		
		
		private TipoMensagemDao tipoMensagemDataProvider;

		public TipoMensagem findTipoMensagem(Integer id) {
			return tipoMensagemDataProvider.find(id);		
		}

		public List<TipoMensagem> listTipoMensagem() {
			return tipoMensagemDataProvider.getList();
		}
		
		

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

		
	
		//#if ${Usuario} == "T"
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
		//#endif
		
		//Venda
		//#if ${CarrinhoCompras} == "T"
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
		
		//#if ${Usuario} == "T"
		public List<Venda> findVendaByUser(Usuario usuario, StatusVenda statusvenda){
			return vendaDao.getVendaByUser(usuario, statusvenda);
		}
		//#endif
		//#endif
		
		
		//VendaProdutoEmbbed
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

		
		//VendaProduto

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

}
