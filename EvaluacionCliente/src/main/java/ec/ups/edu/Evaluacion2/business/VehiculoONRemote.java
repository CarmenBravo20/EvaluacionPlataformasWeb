package ec.ups.edu.Evaluacion2.business;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import ec.up.edu.Evaluacion2.model.Vehiculo;


@Remote
public interface VehiculoONRemote {
	
	public void insertarVehiculo(Vehiculo v) throws Exception;
	public Vehiculo  buscarMarca(String marca);
	public Vehiculo buscarModelo(String Modelo);
	public Vehiculo buscarAnno(int anno);
	public List<Vehiculo>getList();
	


}
