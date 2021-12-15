package ec.ups.edu.EvaluacionCliente.view;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.up.edu.Evaluacion2.model.Vehiculo;

import ec.ups.edu.Evaluacion2.business.VehiculoONRemote;




public class VentanaVehiculo {

	public static void main(String[] args) {
		VentanaVehiculo vtn= new VentanaVehiculo();
		try {
			vtn.conectar();
			vtn.insertarVehiculo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		// TODO Auto-generated method stub
	private VehiculoONRemote  vechiculoRemote;
	Vehiculo v=new Vehiculo();
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "evaluacion");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "evaluacion");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/Evaluacion2Bravo/VehiculoON!ec.ups.edu.Evaluacion2.business.VehiculoONRemote";  
              
            this.vechiculoRemote = (VehiculoONRemote) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	

}
		public void insertarVehiculo() throws Exception {
			v.setPlaca("ABC-452");
			v.setMarca("TOYOTA");
			v.setModelo("Hilux");
			v.setAnno(2015);
			vechiculoRemote.insertarVehiculo(v);
			
		}
		
		}

