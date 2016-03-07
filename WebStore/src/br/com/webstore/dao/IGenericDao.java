package br.com.webstore.dao;

import java.util.List;

import br.com.webstore.model.Categoria;

public interface IGenericDao<T, I> {
	
	public T insert(T entity);
	
	public T update(T entity);
	
	public void remove(I id);
	
	public List<T> getList();
	
	public T find(I id);

}
