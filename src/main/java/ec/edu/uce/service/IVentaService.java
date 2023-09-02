package ec.edu.uce.service;

import ec.edu.uce.repository.modelo.Venta;
import ec.edu.uce.service.TO.VentaTO;

public interface IVentaService {

	public void create(Venta venta);
	
	public void vender(VentaTO ventaTO);
}
