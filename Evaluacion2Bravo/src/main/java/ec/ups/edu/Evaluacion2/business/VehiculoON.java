package ec.ups.edu.Evaluacion2.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.up.edu.Evaluacion2.model.Vehiculo;
import ec.ups.edu.Evaluacion2.dao.VehiculoDAO;

@Stateless
public class VehiculoON implements VehiculoONRemote{
 
@Inject	
private VehiculoDAO vehiculodao; 

public void insertarVehiculo(Vehiculo v) {
	vehiculodao.insertarVehiculo(v);
}
public void buscarMarca(String Marca) {
	vehiculodao.buscarMarca(Marca);
}
public void buscarModelo(String modelo) {
	vehiculodao.buscarModelo(modelo);
}
public void buscarAnno(String anno) {
	vehiculodao.buscarAnno(anno);
}

public List<Vehiculo> getVehiculos() {
	return vehiculodao.getList();
}
}
