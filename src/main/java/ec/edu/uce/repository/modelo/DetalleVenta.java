package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	
	@Id
	@Column(name = "deve_id")
	@SequenceGenerator(allocationSize = 1,name = "seq_deveucto", sequenceName = "seq_deveucto")
	@GeneratedValue(generator = "seq_deveucto",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "deve_cantidad")
	private Integer cantidad;
	
	@Column(name = "deve_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name = "deve_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deve_fk_venta_id")
	private Venta venta;
	
	
	@OneToOne
	@JoinColumn(name = "deve_fk_producto_id")
	private Producto producto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}
