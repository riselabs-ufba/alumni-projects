//#if ${BugTrack} == "T" or  ${Categoria} == "T" or  ${Cupom} == "T" or  ${Endereco} == "T" or ${FormaPagament} == "T" or ${FormaPagamento} == "T" or  ${Mensagem} == "T" or  ${Perfil} == "T" or  ${Produto} == "T" or  ${SituacaoBug} == "T" or  ${StatusUsuario} == "T" or  ${StatusVenda} == "T" or  ${TipoMensagem} == "T" or  ${UnidadeMedida} == "T" or  ${UsuarioCupom} == "T" or  ${Usuario} == "T" or  ${Venda} == "T" or  ${VendaProduto} == "T" or  ${VendaProdutoEmbbed} == "T" or  ${CarrinhoCheckout} == "T"   
/**
 * 
 */
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author webstore
 *
 */
public abstract class GenericDao<T, I> {

	//private static final String NAME_DB = "webstoreDB";
	
	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected GenericDao(EntityManager entityManager, Class<T> persistedClass) {
		this(entityManager);
		this.persistedClass = persistedClass;
	}

	public T insert(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public T update(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public void remove(I id) {
		T entity = find(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

	public List<T> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	public T find(I id) {
		return entityManager.find(persistedClass, id);
	}
}
//#endif