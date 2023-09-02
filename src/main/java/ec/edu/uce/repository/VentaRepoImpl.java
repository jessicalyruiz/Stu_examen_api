package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

}
