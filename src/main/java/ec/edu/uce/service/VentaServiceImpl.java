package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IVentaRepo;
import ec.edu.uce.repository.modelo.DetalleVenta;
import ec.edu.uce.repository.modelo.Producto;
import ec.edu.uce.repository.modelo.Venta;
import ec.edu.uce.service.TO.ProductoVentaTO;
import ec.edu.uce.service.TO.VentaTO;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Autowired
	private IProductoService productoService;
	
	@Override
	public void create(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.create(venta);
	}

	@Override
	public void vender(VentaTO ventaTO) {
		// TODO Auto-generated method stub
		Venta venta=new Venta();
		venta.setCedulaCliente(ventaTO.getCedulaCliente());
		venta.setNumero(ventaTO.getNumeroVenta());
		
		List<ProductoVentaTO> listaProductos=ventaTO.getProductoVentaTO();
		//detalles
		List<DetalleVenta> detalles = new ArrayList<>();
		
		
		for (ProductoVentaTO p : listaProductos) {
			Producto produ=this.productoService.buscarCodigoBarras(p.getCodigoBarras());
			produ.setStock(produ.getStock()-p.getCantidad());//resto la cantidad comprada del stock
			DetalleVenta detalle=new DetalleVenta();
			detalle.setCantidad(p.getCantidad());
			detalle.setPrecioUnitario(produ.getPrecio());
			detalle.setProducto(produ);
			detalle.setSubtotal(produ.getPrecio().multiply(new BigDecimal(p.getCantidad())) );
			detalle.setVenta(venta);
			detalles.add(detalle);
			
		}
		
		venta.setDetalles(detalles);
		venta.setTotalVenta(detalles.stream().map(DetalleVenta::getSubtotal).reduce(BigDecimal.ZERO,BigDecimal::add));
		this.ventaRepo.create(venta);
	}

}
