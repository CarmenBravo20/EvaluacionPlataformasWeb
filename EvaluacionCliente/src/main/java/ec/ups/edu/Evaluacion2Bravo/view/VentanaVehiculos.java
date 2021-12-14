package ec.ups.edu.Evaluacion2Bravo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.up.edu.Evaluacion2.model.Vehiculo;
import ec.ups.edu.Evaluacion2.business.VehiculoONRemote;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class VentanaVehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnno;
	private VehiculoONRemote vehiculRemote;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVehiculos frame = new VentanaVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public VentanaVehiculos() throws Exception {
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
              
            final String lookupName = "java:jboss/exported/Evaluacion2Bravo/VehiculoON!ec.ups.edu.Evaluacion2.business.VehiculoONRemote";  
              
            this.vehiculRemote = (VehiculoONRemote) context.lookup(lookupName);

	} catch (Exception ex) {  
        ex.printStackTrace();  
        throw ex;  
    }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACA:");
		lblNewLabel.setBounds(10, 36, 46, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MARCA:");
		lblNewLabel_1.setBounds(10, 76, 46, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MODELO:");
		lblNewLabel_2.setBounds(10, 115, 46, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AÑO:");
		lblNewLabel_3.setBounds(10, 160, 46, 13);
		contentPane.add(lblNewLabel_3);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(67, 33, 96, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(67, 73, 96, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(67, 112, 96, 19);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAnno = new JTextField();
		txtAnno.setBounds(67, 157, 96, 19);
		contentPane.add(txtAnno);
		txtAnno.setColumns(10);
		
		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculo v=new Vehiculo();
				v.setPlaca(txtPlaca.getText());
				v.setMarca(txtMarca.getText());
				v.setModelo(txtModelo.getText());
				int anno=Integer.parseInt(txtAnno.getSelectedText());
				v.setAnno(anno);
				vehiculRemote.insertarVehiculo(v);
				
				
			}
		});
		btnNewButton.setBounds(113, 203, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.setBounds(229, 203, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
