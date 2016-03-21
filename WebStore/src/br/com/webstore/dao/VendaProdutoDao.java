//#if ${VendaProduto} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.VendaProduto;;

public class VendaProdutoDao extends GenericDao<VendaProduto, Integer>{
	
	public VendaProdutoDao() {
		super(VendaProduto.class);
	}

}
//#endif