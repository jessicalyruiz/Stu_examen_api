package ec.edu.uce.repository;

import ec.edu.uce.repository.modelo.Producto;

public interface IProductoRepo {

	public void create(Producto producto);
	public void update(Producto producto);
	
	public Producto buscarCodigoBarras(String codigo);
}
