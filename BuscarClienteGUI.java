/*




Clase de la interfaz grafica de la funcionalidad Buscar Cliente
*/

package view;

import domain.Prestamo;
import domain.Empeno;
import domain.Articulo;
import domain.RegistrarEmpenoController;

import dataAccess.Db;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import domain.ControladorSesion;
import domain.BuscarClienteController;
import domain.Cliente;
import domain.Direccion;
import java.time.Instant;
import java.time.LocalDate;
import java.sql.Date;
import java.time.format.DateTimeFormatter;


public class BuscarClienteGUI extends JFrame implements ActionListener{


	//Objetos de La GUI del Formulario

	private JLabel labelCedula, labelNombre, labelApellido, labelTelefono,labelCorrector, labelClienteId;
	private JLabel labelTipoArticulo, labelMarcaArticulo, labelModeloArticulo, labelNumeroSerieArticulo, labelValorEmpenoArticulo;
	private JLabel labelCalle, labelNumeroCasa, labelEdificio, labelCiudad, labelSector, labelProvincia, labelTipoDireccion, labelFecha, labelInteres, labelDescripcion;
	private JTextField textCedula, textNombre, textApellido, textTelefono, textClienteId;
	private JTextField textCalle, textNumeroCasa ,textEdificio, textCiudad, textProvincia, textSector, textTipoDireccion;
	private JTextField textTipoArticulo, textMarcaArticulo, textModeloArticulo, textNumeroSerieArticulo, textValorEmpenoArticulo, textInteres, textFecha;
	private JTextArea areaDescripcion, areaInformacionFormulario;
	private JButton guardarBoton, cancelarBoton, botonBuscarCedula;

/// Variables para instanciar los objetos dominio
	//Variables para clase Articulo
	private String tipoArticulo, marca, modelo, numeroSerie, estado, descripcion;
	private double valorEmpeno;

	// Variables para Empeno
	private double montoPrestado;


	private Articulo articulo1;
	private Empeno empeno1;
	private Prestamo prestamo1;

	private final static double INTERES = 5;
	private JPanel panelFormularioCedula, panelBotones, panelFormulario, panelAMostrar;
	private Cliente cli;
	private Direccion dir;
	private BuscarClienteController controlador;
	private RegistrarEmpenoController controladorEmpeno;

	private LocalDate fecha = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
	private Date fechaSQL = Date.valueOf(fecha);
	private String cadenaFecha = fecha.format(formatter);


	public BuscarClienteGUI (){

	     controlador = new BuscarClienteController ();


	     setSize(800,600);
	     setTitle("Buscar Cliente");
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLocationRelativeTo(null);  
	     setResizable(true) ;
	     setLayout(new BorderLayout());	




		 System.out.println(cadenaFecha);
	     
	     add(construirFormularioCedula(),BorderLayout.NORTH);

	     add(construirFormularioPrincipal(),BorderLayout.CENTER);

	     add(construirFormularioBotones(),BorderLayout.SOUTH);


	}

	JPanel construirFormularioCedula(){

		panelFormularioCedula = new JPanel();
		 panelFormularioCedula.setPreferredSize (new Dimension (600,100));
	     panelFormularioCedula.setLayout (new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();


		labelCedula = new JLabel ("Cedula");

		c.gridx =0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;
		//c.insets=new Insets (4,4,4,4);		

		panelFormularioCedula.add(labelCedula,c);


		textCedula = new JTextField(10);

		c.gridx =4;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;		

		panelFormularioCedula.add(textCedula,c);	



		botonBuscarCedula = new JButton ("Buscar Cedula");

		c.gridx =8;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;
		c.insets=new Insets (4,4,4,4);	


		panelFormularioCedula.add(botonBuscarCedula,c);


		labelClienteId = new JLabel ("Cliente ID ");

		c.gridx =0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;
			

		panelFormularioCedula.add(labelClienteId,c);


		textClienteId = new JTextField(10);
		textClienteId.setEditable(false);

		c.gridx =4;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;		

		panelFormularioCedula.add(textClienteId,c);			

			
		add(panelFormularioCedula,BorderLayout.NORTH);
		botonBuscarCedula.addActionListener(this);


		return panelFormularioCedula;
	}

	JPanel construirFormularioPrincipal(){



		panelFormulario = new JPanel();
		panelFormulario.setLayout(new GridBagLayout());
		panelFormulario.setPreferredSize (new Dimension (600,600));
		GridBagConstraints c = new GridBagConstraints();

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
		textNombre.setEditable(false);	

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
		textApellido.setEditable(false);

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
		textTelefono.setEditable(false);

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
		textCalle.setEditable(false);

		panelFormulario.add(textCalle,c);


		labelNumeroCasa= new JLabel (" Numero ");

		c.gridx =10;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;	
		panelFormulario.add(labelNumeroCasa,c);



		textNumeroCasa = new JTextField(10);

		c.gridx =12;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 1;		
		panelFormulario.add(textNumeroCasa,c);	
		textNumeroCasa.setEditable(false);

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
		textEdificio.setEditable(false);

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
		textSector.setEditable(false);


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
		textCiudad.setEditable(false);

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
		textProvincia.setEditable(false);
		panelFormulario.add(textProvincia ,c);		



		labelTipoDireccion = new JLabel (" Tipo De Direccion ");

		c.gridx =20;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	

		panelFormulario.add(labelTipoDireccion ,c);


		textTipoDireccion = new JTextField (10);

		c.gridx =24;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		textTipoDireccion.setEditable(false);

		panelFormulario.add(textTipoDireccion ,c);


		c.gridx =0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	


		panelFormulario.add(new JLabel("          ") ,c);				

		c.gridx =0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	


		panelFormulario.add(new JLabel("Informacion ") ,c);	


		c.gridx =4;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	


		panelFormulario.add(new JLabel("de Articulo") ,c);			



		c.gridx =0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;

		panelFormulario.add(new JLabel("          ") ,c);				

	



		labelTipoArticulo = new JLabel ("Tipo Articulo");

		c.gridx =0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelTipoArticulo, c);


		textTipoArticulo = new JTextField (10);

		c.gridx =4;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textTipoArticulo, c);


		labelMarcaArticulo = new JLabel ("Marca");

		c.gridx =8;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelMarcaArticulo, c);


		textMarcaArticulo = new JTextField (10);

		c.gridx =12;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textMarcaArticulo, c);


		labelModeloArticulo = new JLabel ("Modelo");

		c.gridx =16;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelModeloArticulo, c);


		textModeloArticulo = new JTextField (10);

		c.gridx =20;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textModeloArticulo, c);		


		labelNumeroSerieArticulo = new JLabel ("# Serie");

		c.gridx =0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelNumeroSerieArticulo, c);


		textNumeroSerieArticulo = new JTextField (10);

		c.gridx =4;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textNumeroSerieArticulo, c);

		labelDescripcion = new JLabel ("Descripcion");

		c.gridx =8;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelDescripcion, c);


		areaDescripcion = new JTextArea ();
		areaDescripcion.setLineWrap(true);

		c.gridx =12;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;	


		//JScrollPane scroll = new JScrollPane (areaDescripcion);
		panelFormulario.add(areaDescripcion, c);		


		c.gridx =0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;
		panelFormulario.add(new JLabel("          ") ,c);				



		c.gridx =0;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		panelFormulario.add(new JLabel("Informacion ") ,c);	


		c.gridx =4;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;	
		panelFormulario.add(new JLabel("de Prestamo") ,c);			



		c.gridx =0;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 2;
		panelFormulario.add(new JLabel("          ") ,c);	

		
		labelValorEmpenoArticulo = new JLabel ("Monto ");
		c.gridx =0;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelValorEmpenoArticulo, c);


		textValorEmpenoArticulo = new JTextField (10);

		c.gridx =4;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textValorEmpenoArticulo, c);	


		labelInteres = new JLabel ("Interes ");

		c.gridx =10;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelInteres, c);	


		String sInteres = String.valueOf(INTERES);

		textInteres = new JTextField (sInteres);

		c.gridx =12;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(textInteres, c);	
		textInteres.setEditable(false);		




		labelFecha = new JLabel ("Fecha");

		c.gridx =16;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		

		panelFormulario.add(labelFecha, c);	



		textFecha = new JTextField ();

		c.gridx =20;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.ipady=0;
		c.gridheight=1;
		c.gridwidth = 3;		
		textFecha.setText(cadenaFecha);

		panelFormulario.add(textFecha, c);	
		textFecha.setEditable(false);			

		return panelFormulario;

	}

	JPanel construirFormularioBotones(){


		JPanel panelBotones = new JPanel (new GridLayout (4,4));

		guardarBoton = new JButton ("Guardar");
		guardarBoton.addActionListener(this);
		cancelarBoton = new JButton ("Cancelar");
		cancelarBoton.addActionListener(this);



		panelBotones.add(new JLabel("                "));
		panelBotones.add(guardarBoton);
		panelBotones.add(cancelarBoton);
		panelBotones.add(new JLabel("                "));
		panelBotones.add(new JLabel("                "));

		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));
		panelBotones.add(new JLabel("               "));

		return panelBotones;
	}

	void mostrarInformacionCliente(Cliente cl){

		String clienteId = String.valueOf(cl.getClienteId());
		long  cedula = cl.getCedula();
		String nombre = cl.getNombre();
		String apellido = cl.getApellido();
		String  telefono = String.valueOf (cl.getTelefono());
		String calle = cl.getDireccion().getCalle();
		String  numeroPropiedad =String.valueOf( cl.getDireccion().getNumero());
		String edificio = cl.getDireccion().getEdificio();
		String sector = cl.getDireccion().getSector();
		String ciudad = cl.getDireccion().getCiudad();
		String provincia = cl.getDireccion().getProvincia();
		String tipoDireccion =cl.getDireccion().getTipoDireccion();

		textClienteId.setText(clienteId);
		textNombre.setText(nombre);
		textApellido.setText(apellido);
		textTelefono.setText(telefono);
		textCalle.setText(calle);
		textNumeroCasa.setText(numeroPropiedad);
		textEdificio.setText(edificio);
		textSector.setText(sector);
		textCiudad.setText(ciudad);
		textProvincia.setText(provincia);
		textTipoDireccion.setText(tipoDireccion);

	}

	void limpiarFormulario(){

		textNombre.setText("");
		textApellido.setText("");
		textTelefono.setText("");
		textCalle.setText("");
		textNumeroCasa.setText("");
		textEdificio.setText("");
		textSector.setText("");
		textCiudad.setText("");
		textProvincia.setText("");
		textTipoDireccion.setText("");
		textTipoArticulo.setText("");
		textMarcaArticulo.setText("");
		textModeloArticulo.setText("");
		textNumeroSerieArticulo.setText("");
		textValorEmpenoArticulo.setText("");

	}


	public void actionPerformed (ActionEvent ae){

		boolean resultado;

		controlador = new BuscarClienteController();


		if (ae.getSource().equals(botonBuscarCedula)){

			limpiarFormulario();

			long ced = Long.parseLong(textCedula.getText());
			resultado=controlador.clienteExiste(ced);

			if(!resultado){

				System.out.println("El Cliente no Existe");
				JOptionPane.showMessageDialog(null,"El Cliente no existe","Cliente no Existente",JOptionPane.ERROR_MESSAGE);

			}

			else {



				System.out.println("El Cliente Existe");
				cli = controlador.buscarCliente(ced);


				mostrarInformacionCliente(cli);			


			}

		}
		 

		if (ae.getSource().equals(guardarBoton)){


			if (textNombre.getText().isEmpty()){


				JOptionPane.showMessageDialog(null,"Necesita Buscar o Registrar Un Cliente","Buscar Cliente", JOptionPane.ERROR_MESSAGE);
			}

			else {


				validarFormulario();
				String info = getInformacionFormulario();

				String mensaje = "Esta seguro que desea registrar el articulo con las siguientes caracteristicas : \n\n"+info;
				areaInformacionFormulario = new JTextArea(mensaje);
				areaInformacionFormulario.setEditable(false);
				
				int opcion = JOptionPane.showOptionDialog(null, 
					areaInformacionFormulario, "Guardar Cambios",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					null);

				if(opcion != -1){

					if (opcion ==0){

						
						getObjetosFormulario();
						controladorEmpeno = new RegistrarEmpenoController();
						controladorEmpeno.registrarEmpeno(empeno1);


						///Guardar los resultados en la BD
					}

				}


			}


		}



		if (ae.getSource().equals (cancelarBoton)){


			cerrarVentana();

		}



	}	

	void cerrarVentana (){


		dispose();
		VentanaPrincipalGUI ventana = new VentanaPrincipalGUI ();
		ventana.setVisible(true);

	}	

	void validarFormulario(){


	}

	String getInformacionFormulario(){


		//Variables que tienen la informacion de Articulo
		tipoArticulo = textTipoArticulo.getText();
		marca = textMarcaArticulo.getText();
		modelo= textModeloArticulo.getText();
		numeroSerie = textNumeroSerieArticulo.getText();
		valorEmpeno = Double.parseDouble(textValorEmpenoArticulo.getText());
		descripcion = areaDescripcion.getText();


        //Variables que tienen la informacion de Prestamo
		montoPrestado = Double.parseDouble(textValorEmpenoArticulo.getText());




		String cadena = "Tipo De Articulo : " +tipoArticulo +"\nMarca : "+ marca+"\nModelo : " + modelo +"\nNumero De Serie : "+ 
		numeroSerie +"\nValor de Empeno : "+ valorEmpeno+"\nInteres : "+INTERES+"\nFecha De Empeno : "+cadenaFecha;

		System.out.println(cadena);
		return cadena;

	}

	void getObjetosFormulario(){


		getInformacionFormulario();
		articulo1 = new Articulo(tipoArticulo, marca, modelo, numeroSerie, valorEmpeno, descripcion);
		prestamo1 = new Prestamo (montoPrestado, fecha);
		empeno1 = new Empeno (fecha, prestamo1, articulo1);

		System.out.println("Imprimime fecha de Empeno : " +empeno1.getFechaEmpeno());

	}

}