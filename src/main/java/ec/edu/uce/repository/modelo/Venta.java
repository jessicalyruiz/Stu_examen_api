package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@Column(name = "vent_id")
	@SequenceGenerator(allocationSize = 1,name = "seq_ventrio", sequenceName = "seq_ventrio")
	@GeneratedValue(generator = "seq_ventrio", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "vent_numero")
	private String numero;
	
	@Column(name = "vent_cedula_cliente")
	private String cedulaCliente;
	
	@Column(name = "vent_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
	private List<DetalleVenta> detalles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
