//#if ${CarrinhoCompras} == "T"
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webstore.model.Produto;
import br.com.webstore.model.StatusVenda;
//#if ${Usuario} == "T"
import br.com.webstore.model.Usuario;
//#endif
import br.com.webstore.model.Venda;

public class VendaDao extends GenericDao<Venda, Integer>{
	
	public VendaDao(EntityManager entityManager) {
		super(entityManager, Venda.class);
	}

	//#if ${Usuario} == "T"
	public List<Venda> getVendaByUser(Usuario usuario, StatusVenda statusvenda){
		entityManager.clear();
		String qry = "from Venda v where v.idUsuario = :user";
		if(statusvenda.getId()>0){
			qry = qry + " and v.idStatusVenda = : stVenda";
		}		
		
		TypedQuery<Venda> query = this.entityManager.createQuery(qry, Venda.class);
		
		query.setParameter("user", usuario.getId());
		query.setParameter("stVenda", statusvenda.getId());
		return query.getResultList();
	}
	//#endif
}
//#endif