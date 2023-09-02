package ec.edu.uce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.uce.service.IProductoService;
import ec.edu.uce.service.TO.ProductoTO;





@RestController
@RequestMapping(path = "/productos")
@CrossOrigin
public class ProductoControllerRestFull {

	private static final Logger LOG=LoggerFactory.getLogger(ProductoControllerRestFull.class);
	@Autowired
	private IProductoService productoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ingresarProducto(@RequestBody ProductoTO productoTO) {
		LOG.info("producto************"+productoTO.getNombre());
		this.productoService.ingresar(productoTO);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductoTO validarStockProd(@RequestBody ProductoTO productoTO) {
		return this.productoService.validarStock(productoTO);
	}
}
