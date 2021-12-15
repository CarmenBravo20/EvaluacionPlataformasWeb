package ec.ups.edu.EvaluacionCliente.view;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class VentanaVehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnno;
	private VehiculoONRemote vechiculoRemote;
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
	              
	            final String lookupName = "ejb:/Evaluacion2Bravo/VehiculoON!ec.ups.edu.Evaluacion2.business.VehiculoONRemote";  
	              
	            this.vechiculoRemote = (VehiculoONRemote) context.lookup(lookupName);  
	              
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	            throw ex;  
	        }  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACA:");
		lblNewLabel.setBounds(51, 69, 46, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MARCA:");
		lblNewLabel_1.setBounds(278, 69, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MODELO:");
		lblNewLabel_2.setBounds(51, 112, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FABRICADO:");
		lblNewLabel_3.setBounds(278, 112, 82, 13);
		contentPane.add(lblNewLabel_3);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(120, 66, 96, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					String marca=String.valueOf(txtMarca.getText());
					Vehiculo ve=vechiculoRemote.buscarMarca(marca);
					
					txtPlaca.setText(ve.getPlaca());
					//txtMarca.setText(ve.getMarca());
					txtModelo.setText(ve.getModelo());
					txtAnno.setText(txtAnno.getText());
					
					
				}
			}
		});
		txtMarca.setBounds(359, 66, 96, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					String modelo=String.valueOf(txtModelo.getText());
					Vehiculo ve=vechiculoRemote.buscarModelo(modelo);
					System.out.println(modelo);
				
					txtPlaca.setText(ve.getPlaca());
					txtMarca.setText(ve.getMarca());
					//txtModelo.setText(ve.getModelo());
					txtAnno.setText(txtAnno.getText());
					
					
				}
			}
		});
		txtModelo.setBounds(120, 109, 96, 19);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAnno = new JTextField();
		txtAnno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					int anio=Integer.parseInt(txtAnno.getText());
					Vehiculo ve=vechiculoRemote.buscarAnno(anio);
					txtPlaca.setText(ve.getPlaca());
					txtMarca.setText(ve.getMarca());
					txtModelo.setText(ve.getModelo());
					//txtAnno.setText(txtAnno.getText());
					
					
				}
			}
		});
		txtAnno.setBounds(359, 109, 96, 19);
		contentPane.add(txtAnno);
		txtAnno.setColumns(10);
		
		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculo v=new Vehiculo();
				v.setPlaca(txtPlaca.getText());
				v.setMarca(txtMarca.getText());
				v.setModelo(txtModelo.getText());
				int a=Integer.parseInt(txtAnno.getText());
				v.setAnno(a);
				try {
					vechiculoRemote.insertarVehiculo(v);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(105, 173, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				mostrarVehiculo();
			}
		});
		btnNewButton_1.setBounds(311, 173, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Vehiculo");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(201, 21, 104, 13);
		contentPane.add(lblNewLabel_4);
	}
	public void mostrarVehiculo() {
		List<Vehiculo> ope=this.vechiculoRemote.getList();
		for(Vehiculo op: ope) {
			txtPlaca.setText(op.getPlaca());
			txtMarca.setText(op.getMarca());
			//txtModelo.setText(ve.getModelo());
			txtAnno.setText(txtAnno.getText());
		}
		
	}
}
