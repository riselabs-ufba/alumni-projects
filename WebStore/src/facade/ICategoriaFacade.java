package facade;


import java.util.List;

import br.com.webstore.model.Categoria;

public interface ICategoriaFacade {
	
	public Categoria insertCategoria(Categoria categoria);

	public void saveCategoria(Categoria categoria);
	
	public List<Categoria> findCategoria(Categoria query);

}
