package ec.ups.edu.Evaluacion2.business;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import ec.up.edu.Evaluacion2.model.Vehiculo;


@Remote
public interface VehiculoONRemote {
	
	public void insertarVehiculo(Vehiculo v);
	public void  buscarMarca(String Marca);
	public void buscarModelo(String modelo);
	public void buscarAnno(String anno);
	public List<Vehiculo>getVehiculos();
	


}
