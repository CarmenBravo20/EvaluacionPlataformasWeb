package ec.ups.edu.Evaluacion2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.up.edu.Evaluacion2.model.Vehiculo;

@Stateless
public class VehiculoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insertarVehiculo(Vehiculo v) {
		em.persist(v);
	}
	public void buscarMarca(String Marca) {
		em.find(Vehiculo.class, Marca);
	}
	public void buscarModelo(String modelo) {
		em.find(Vehiculo.class, modelo);
	}
	public void buscarAnno(String anno) {
		em.find(Vehiculo.class, anno);
	}
	public List<Vehiculo>getList(){
			List<Vehiculo> listado=new ArrayList<Vehiculo>();
		
			String jpql="SELECT op FROM Vehiculo op"; 
			
			Query query =em.createQuery(jpql,Vehiculo.class);
			return listado=query.getResultList();
		
	}
}
