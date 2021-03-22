/*
Login GUI aplica la capa de vista del Caso de Uso Iniciar Sesion


*/

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import dataAccess.Db;
import domain.ControladorSesion;
import domain.Usuario;


public class LoginGUI extends JFrame{


	private JLabel usuarioEtiqueta, passEtiqueta,resultadoEtiqueta;
	private JTextField usuarioText;
	private JPasswordField passText;
	private JPanel panelLabel, panelText, panelBoton;
	private JButton loginBoton, cancelarBoton;
	private String usuario, stringPass;
	private char [] pass;
	private int correcto;
	private ControladorSesion cSesion;
	private GridLayout gLayout = new GridLayout(0,1);
	


	public LoginGUI(){

		super("Login");
		setSize(350,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();



		usuarioEtiqueta = new JLabel ("Usuario");
		passEtiqueta = new JLabel ("Contrasena");


		usuarioText = new JTextField(10);
		passText = new JPasswordField(10);

		resultadoEtiqueta = new JLabel ("       ");

		loginBoton = new JButton ("   Login   ");
		cancelarBoton = new JButton ("Cancelar");


		c.gridx =0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=3;
		c.gridheight=1;
		c.insets=new Insets (4,4,4,4);
	
		add(usuarioEtiqueta,c);

		c.gridx =0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=3;
		c.gridheight=1;
		c.insets=new Insets (4,4,4,4);



		add(passEtiqueta,c);


		c.gridx =1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth=2;


		add(usuarioText,c);

		c.gridx =1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth=2;


		add(passText,c);

		c.gridx =0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=2;
		c.gridwidth=3;	

		add	(resultadoEtiqueta, c);

		c.gridx =0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=2;
		c.gridwidth=1;

		add(loginBoton,c);


		c.gridx =1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=2;
		c.gridwidth=1;

		add(cancelarBoton,c);


		Listener list = new Listener();
		loginBoton.addActionListener(list);
		usuarioText.addActionListener(list);
		passText.addActionListener(list);
		cancelarBoton.addActionListener (list);

	
	}
	
	
	//Implementacion del listener para obtener el usuario y la contrasena del Formulario
	
	class Listener implements ActionListener{
	
		public void actionPerformed (ActionEvent ae){
		


		
			if (ae.getSource() == loginBoton){

				usuario=usuarioText.getText();
				pass= passText.getPassword();

				stringPass = String.valueOf(pass);
				cSesion = new ControladorSesion();


				//
				// Llama el metodo validarFormulario, valida si hay campos vacios
				if (validarFormulario()){

					//Llama al metodo iniciarSesion de la clase Controladora de Sesion
					// Este metodo devuleve un 1 si las credenciales son validas
					// Este metodo devuelve 0 si las credenciales son invalidas
					// Ete metodo devuleve -1 si ha ocurrido una excepcion con la base de datos


					correcto = cSesion.iniciarSesion(usuario, stringPass);
					
					
					if	(correcto==1){
					

						
						JOptionPane.showMessageDialog(null,"Conexion a BD Exitosa");
						resultadoEtiqueta.setText("Correcto");

						Arrays.fill(pass,'0');
						
						
						

						cSesion.iniciarSesion(usuario, stringPass);

						VentanaPrincipalGUI ventana = new VentanaPrincipalGUI();
						
						
						ventana.setVisible(true);
						ocultar();

						
					}
					
					else if (correcto == 0 ){
					
						
						JOptionPane.showMessageDialog(null,"Usuario o Contrasena incorrecto","Datos Incorrectos",JOptionPane.ERROR_MESSAGE);	
						resultadoEtiqueta.setText("Conexion a BD no lograda");	
						passText.selectAll();
						Arrays.fill(pass,'0');			
					
					}
					
					else if (correcto == -1 ){
					
						
						JOptionPane.showMessageDialog(null,"Una excepcion ha ocurrido con la base de datos","Error de Base de Datos",JOptionPane.ERROR_MESSAGE);		
						resultadoEtiqueta.setText("Conexion a BD no lograda");
						passText.selectAll();
						Arrays.fill(pass,'0');			
					
					}		

				}		
			
			}


			else if (ae.getSource()==cancelarBoton){

				System.exit(0);

			}
		
		}

		
	
	}


	public void ocultar (){
		
		this.setVisible(false);
		
	}
	
	public void cerrarAplicacion (){
		
	
	}


	///////////////////////////////
	///
	/// Metodo devulve False si los campos 
	/// Estan vaciones
	//////////////////////////////
	boolean validarFormulario (){


		if (usuario.equals("")||stringPass.equals("") ) {


			resultadoEtiqueta.setText("Por Favor llene los campos");
			resultadoEtiqueta.setForeground(Color.red);

			return false;

		}

		else{

			return true;
		}

			

	}




}