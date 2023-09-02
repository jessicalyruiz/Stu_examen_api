package ec.edu.uce.service;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import ec.edu.uce.repository.IProductoRepo;
import ec.edu.uce.repository.modelo.Producto;
import ec.edu.uce.service.TO.ProductoTO;

@Service
public class ProductoServiceImpl implements IProductoService{

	private static final Logger LOG=LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void create(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.create(producto);
	}

	@Override
	public Producto buscarCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarCodigoBarras(codigo);
	}

	@Override
	public void ingresar(ProductoTO productoTO) {
		// TODO Auto-generated method stub
		try {
			Producto produ=this.buscarCodigoBarras(productoTO.getCodigoBarras());
			produ.setStock(produ.getStock()+productoTO.getStock());
			this.productoRepo.update(produ);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.info("*********Producto no encontrado, creando producto");
			this.create(this.convertirProducto(productoTO));
		}
		
		
		
	}
	
	
	private Producto convertirProducto(ProductoTO productoTO) {
		Producto produ=new Producto();
		produ.setCategoria(productoTO.getCategoria());
		produ.setCodigoBarras(productoTO.getCodigoBarras());
		produ.setNombre(productoTO.getNombre());
		produ.setPrecio(productoTO.getPrecio());
		produ.setStock(productoTO.getStock());
		return produ;
	}

	@Override
	public ProductoTO validarStock(ProductoTO productoTO) {
		// TODO Auto-generated method stub
		Producto produ=this.buscarCodigoBarras(productoTO.getCodigoBarras());
		if(produ.getStock()<productoTO.getStock()) {
			//stock menor al requerido, no hay (suficiente) stock
			return null;
		}else {
			return this.convertirProductoTO(produ);
		}
		
	}
	private ProductoTO convertirProductoTO(Producto producto) {
		ProductoTO produ=new ProductoTO();
		produ.setCategoria(producto.getCategoria());
		produ.setCodigoBarras(producto.getCodigoBarras());
		produ.setNombre(producto.getNombre());
		produ.setPrecio(producto.getPrecio());
		produ.setStock(producto.getStock());
		return produ;
	}

}
