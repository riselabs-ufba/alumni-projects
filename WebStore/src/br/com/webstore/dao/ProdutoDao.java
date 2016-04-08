//#if ${Produto} == "T"

package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

import br.com.webstore.model.Produto;


public class ProdutoDao extends GenericDao<Produto, Integer> {
	
	public ProdutoDao(EntityManager entityManager) {
		super(entityManager, Produto.class);
	}

	public List<Produto> findByNome(String nome) {
	entityManager.clear();
		TypedQuery<Produto> query = this.entityManager.createQuery("from Produto p where p.descricao like :descricao", Produto.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();
	}
	
	public DefaultTableModel getProdutos(){
		
		TypedQuery<Produto> query = this.entityManager.createQuery("from Produto p", Produto.class);
		List<Produto> prod = query.getResultList();
				
		DefaultTableModel tableM = new DefaultTableModel();
		
		tableM.addColumn("Produto");
		tableM.addColumn("Categoria");
		tableM.addColumn("Valor R$");
		
		if(!prod.isEmpty()){
			for(int i=0;i<prod.size();i++){
				Object [] obj1 = {prod.get(i).getDescricao().toString(), prod.get(i).getCategoria().toString(), prod.get(i).getValor().toString()};
				tableM.addRow(obj1);
			}
		}

		return tableM;
		
	}
}
//#endif