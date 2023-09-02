package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IDetalleVentaRepo;
import ec.edu.uce.repository.modelo.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaRepo detalleVentaRepo;
	
	@Override
	public void create(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.create(detalleVenta);
	}

}
