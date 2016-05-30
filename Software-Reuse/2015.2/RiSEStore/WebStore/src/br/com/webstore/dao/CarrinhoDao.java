//#if ${CarrinhoCompras} == "T"
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.webstore.features.CarrinhoCheckout;

/**
 * @author webstore
 *
 */
public class CarrinhoDao extends GenericDao<CarrinhoCheckout, Integer>{
	public CarrinhoDao(EntityManager entityManager){
		super(entityManager, CarrinhoCheckout.class);
	}
	
	public List<CarrinhoCheckout> findByNome(String nome) {
		/*TypedQuery<Faq> query = this.entityManager.createQuery("from Venda  v where v.descricao like :descricao", Faq.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();*/
		return null;
	}

}
//#endif
