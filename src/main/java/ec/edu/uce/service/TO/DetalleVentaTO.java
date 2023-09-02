package ec.edu.uce.service.TO;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleVentaTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String codigoBarras;
	private String nombreProducto;
	private Integer cantidad;
	private BigDecimal precio;
	private BigDecimal subtotal;

}
