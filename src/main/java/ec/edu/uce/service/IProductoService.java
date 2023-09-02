package ec.edu.uce.service;

import ec.edu.uce.repository.modelo.Producto;
import ec.edu.uce.service.TO.ProductoTO;

public interface IProductoService {

	public void create(Producto producto);
	
	public void ingresar(ProductoTO productoTO);
	public Producto buscarCodigoBarras(String codigo);
	
	public ProductoTO validarStock(ProductoTO productoTO);
}
