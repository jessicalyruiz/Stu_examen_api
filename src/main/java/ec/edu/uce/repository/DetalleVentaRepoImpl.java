package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
	}

}
