/*



Clase de la interfaz Grafica de la funcion Registrar Cliente
*/


package view;

import dataAccess.Db;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import domain.ControladorSesion;
import domain.RegistrarClienteController;
import domain.Cliente;
import domain.Direccion;


public class RegistrarClienteGUI extends JFrame implements ActionListener{


	//Objetos de La GUI del Formulario

	private JLabel labelCedula, labelNombre, labelApellido, labelTelefono,labelVacio1,labelVacio2, labelCorrector;
	private JLabel labelCalle, labelNumeroCasa, labelEdificio, labelCiudad, labelSector, labelProvincia, labelTipoDireccion;
	private JTextField textCedula, textNombre, textApellido, textTelefono;
	private JTextField textCalle,textEdificio, textCiudad, textProvincia, textSector, textTipoDireccion;
	private JButton guardarBoton, cancelarBoton;
	private SpinnerNumberModel snm;
	private JSpinner spinnerNumeroCasa;
	private JPanel panelFormulario, panelBotones;
	private Cliente cli;
	private Direccion dir;
	private RegistrarClienteController registrador;


	//Objetos que contendran la informacion del formulario

	private String nombre, apellido, calle, edificio, sector, ciudad , provincia, tipoDireccion;
	private int numeroPropiedad;
	private long cedula,telefono;


	public RegistrarClienteGUI (){

	     registrador = new RegistrarClienteController ();


	     setSize(800,600);
	     setTitle("Registrar Cliente");
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLocationRelativeTo(null);  
	     setResizable(true) ;
	     setLayout(new BorderLayout());		


		 panelFormulario = new JPanel();
		 panelFormulario.setPreferredSize (new Dimension (600,600));
	     panelFormulario.setLayout (new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();


		labelCedula = new JLabel ("Cedula");

		c.gridx =0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;
		c.insets=new Insets (4,4,4,4);		

		panelFormulario.add(labelCedula,c);


		textCedula = new JTextField(10);

		c.gridx =4;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;		

		panelFormulario.add(textCedula,c);	

		labelNombre= new JLabel ("Nombre");

		c.gridx =0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelNombre, c);


		textNombre = new JTextField(10);

		c.gridx =4;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;		

		panelFormulario.add(textNombre, c);

		labelApellido = new JLabel ("Apellido");

		c.gridx =12;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;			
		panelFormulario.add(labelApellido,c );


		textApellido = new JTextField(10);

		c.gridx =14;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;			
		panelFormulario.add(textApellido,c);	

	
		labelTelefono = new JLabel ("Telefono");

		c.gridx =22;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;		
		panelFormulario.add(labelTelefono,c);


		textTelefono = new JTextField(10);

		c.gridx =24;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;		
		panelFormulario.add(textTelefono,c);			

		labelCalle= new JLabel ("Calle");

		c.gridx =0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		panelFormulario.add(labelCalle,c);


		textCalle = new JTextField(10);

		c.gridx =4;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;	
		panelFormulario.add(textCalle,c);


		labelNumeroCasa= new JLabel (" # ");

		c.gridx =10;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;	
		panelFormulario.add(labelNumeroCasa,c);


        SpinnerNumberModel snm = new SpinnerNumberModel(
        new Integer(1),
        new Integer(1),
        new Integer(9999),
        new Integer(1)
		);

		spinnerNumeroCasa = new JSpinner(snm);

		c.gridx =12;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;		
		panelFormulario.add(spinnerNumeroCasa,c);	


		labelEdificio= new JLabel ("Edificio");

		c.gridx =18;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;	
		panelFormulario.add(labelEdificio,c);		


		textEdificio = new JTextField(10);

		c.gridx =20;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;			
		panelFormulario.add(textEdificio,c)	;	

		labelSector= new JLabel ("Sector");

		c.gridx =22;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;	
		panelFormulario.add(labelSector,c);


		textSector = new JTextField(10);

		c.gridx =24;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;			
		panelFormulario.add(textSector,c)	;			


		labelCiudad = new JLabel (" Ciudad ");

		c.gridx =0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		panelFormulario.add(labelCiudad,c);


		textCiudad = new JTextField(10);

		c.gridx =4;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		panelFormulario.add(textCiudad,c)	;	


		labelProvincia = new JLabel (" Provincia ");

		c.gridx =12;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;	
		panelFormulario.add(labelProvincia ,c);


		textProvincia = new JTextField(10);

		c.gridx =14;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
	
		panelFormulario.add(textProvincia ,c);		


		labelTipoDireccion = new JLabel (" Tipo De Direccion ");

		c.gridx =20;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	

		panelFormulario.add(labelTipoDireccion ,c);

		guardarBoton = new JButton ("Guardar ");
		guardarBoton.addActionListener(this);
		cancelarBoton = new JButton ("Cancelar");


		cancelarBoton = new JButton ("Cancelar");
		cancelarBoton.addActionListener(this);

		labelVacio1 = new JLabel("         ");
		labelVacio2 = new JLabel("         ");
		labelCorrector = new JLabel();


		panelBotones = new JPanel(new GridLayout(3,3));


		panelBotones.add(new JLabel("                "));
		panelBotones.add(guardarBoton);
		panelBotones.add(cancelarBoton);
		panelBotones.add(new JLabel("                "));

		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));

		//panelBotones.add(new JLabel("               "));								
		panelBotones.add(labelCorrector);
		panelBotones.add(new JLabel("               "));		
		panelBotones.add(new JLabel("               "));

		panelBotones.add(new JLabel("       "));
		panelBotones.add(new JLabel("       "));
		panelBotones.add(new JLabel("       "));
		panelBotones.add(new JLabel("       "));


		


		add(panelFormulario,BorderLayout.CENTER);
		add(panelBotones,BorderLayout.SOUTH);
		//add(guardarBoton,BorderLayout.SOUTH);
	//	add (cancelarBoton,BorderLayout.SOUTH);


	}




	public void actionPerformed (ActionEvent ae){

		boolean resultado;

		if (ae.getSource().equals(guardarBoton)){



			 if ( validarFormulario()){

		 			 cli= getInformacionFormulario();
			 		resultado = registrador.registrarCliente(cli);
			 		
			 		if (resultado){


			 			labelCorrector.setText("El cliente ha sido registrado Con Exito");
			 			labelCorrector.setForeground(Color.GREEN);
			 			JOptionPane.showMessageDialog(null,"El cliente ha sido registrado Con Exito","Registro Exitoso",JOptionPane.INFORMATION_MESSAGE);	
			 			cerrarVentana();

			 		}

				}

		}
		 



		if (ae.getSource().equals (cancelarBoton)){


			cerrarVentana();

		}



	}


	void dibujarFormulario(){

		


	}

	boolean validarFormulario (){


		long ced = Long.parseLong(textCedula.getText());

		if (registrador.clienteExiste(ced)){

			labelCorrector.setText("El Cliente ya Existe");
			labelCorrector.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null,"El cliente ya existe","Registro Invalido",JOptionPane.INFORMATION_MESSAGE);				
			return false;

		}

		else{

			return true;

		}


	}

	


	Cliente getInformacionFormulario(){

		

		cedula = Long.parseLong(textCedula.getText());
		nombre = textNombre.getText();
		apellido = textApellido.getText();
		telefono = Long.parseLong(textTelefono.getText());
		calle = textCalle.getText();
		numeroPropiedad = (Integer)spinnerNumeroCasa.getModel().getValue();
		edificio = textEdificio.getText();
		sector = textSector.getText();
		ciudad = textCiudad.getText();
		provincia = textProvincia.getText();
		tipoDireccion =" ";

		dir = new Direccion ();

		dir.setCalle(calle);
		dir.setNumero(numeroPropiedad);
		dir.setEdificio(edificio);
		dir.setSector(sector);
		dir.setCiudad(ciudad);
		dir.setProvincia(provincia);
		dir.setTipoDireccion(tipoDireccion);

		Cliente c1 = new Cliente (nombre, apellido, cedula, telefono,dir);


		return c1;
	}


	void cerrarVentana (){


		dispose();
		VentanaPrincipalGUI ventana = new VentanaPrincipalGUI ();
		ventana.setVisible(true);

	}

}