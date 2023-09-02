package ec.edu.uce.service.TO;

import java.io.Serializable;
import java.util.List;

public class VentaTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numeroVenta;
	private String cedulaCliente;
	private List<ProductoVentaTO> productoVentaTO;
	
	
	public String getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public List<ProductoVentaTO> getProductoVentaTO() {
		return productoVentaTO;
	}
	public void setProductoVentaTO(List<ProductoVentaTO> productoVentaTO) {
		this.productoVentaTO = productoVentaTO;
	}

}
