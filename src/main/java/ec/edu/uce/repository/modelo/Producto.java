package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column(name = "prod_id")
	@SequenceGenerator(allocationSize = 1,name = "seq_producto", sequenceName = "seq_producto")
	@GeneratedValue(generator = "seq_producto",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "prod_codigo_barras")
	private String codigoBarras;
	
	@Column(name = "prod_categoria")
	private String categoria;
	
	@Column(name = "prod_stock")
	private Integer stock;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@OneToOne(mappedBy = "producto", cascade = CascadeType.ALL)
	private DetalleVenta detalle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public DetalleVenta getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleVenta detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	

}
