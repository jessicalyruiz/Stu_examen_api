package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.uce.repository.IVentaRepo;
import ec.edu.uce.service.IVentaService;
import ec.edu.uce.service.TO.VentaTO;

@RestController
@RequestMapping(path = "/ventas")
@CrossOrigin
public class VentaControllerRestFull {

	
	@Autowired
	private IVentaService ventaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void realizarVenta(@RequestBody VentaTO ventaTO) {
		this.ventaService.vender(ventaTO);
	}
}
