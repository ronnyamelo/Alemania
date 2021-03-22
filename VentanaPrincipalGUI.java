/*

	Clase de la ventana principal de Aplicacion


*/

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import domain.ControladorSesion;
import dataAccess.UsuarioDA;


public class VentanaPrincipalGUI extends JFrame implements ActionListener{
	
	
	private JLabel test,emptyLabel,emptyLabel2, welcomeLabel;
	private JButton botonCerrar, botonBuscarArticulo, botonRegistrarCliente, botonBuscarCliente, botonCerrarSesion;
	private ControladorSesion cSesion;
	JPanel panelMenu;
	
	
	public VentanaPrincipalGUI (){
		
	  
	  setSize(600,600);
	  setTitle("Aplicacion para Compraventas");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocationRelativeTo(null);  
	  setResizable(true) ;

	  cSesion = new ControladorSesion ();




	  welcomeLabel= new JLabel("Bienvenido : "+cSesion.getUsuarioActual().getNombre());
	

	  emptyLabel = new JLabel("              ");
	  emptyLabel2 = new JLabel("             ");
	  

	  botonCerrar= new JButton("Cerrar Aplicacion");



	  botonBuscarArticulo = new JButton ("Buscar Articulo");
	  botonRegistrarCliente = new JButton("Registrar Cliente");
	  botonBuscarCliente = new JButton("Buscar Cliente");
	  botonCerrarSesion = new JButton("Cerrar Sesion");

	  panelMenu = new JPanel();
	  panelMenu.setLayout(new GridLayout(9,0,10,20));
	  panelMenu.setPreferredSize(new Dimension(200, 400));



	  panelMenu.add(welcomeLabel);
	  panelMenu.add(botonBuscarArticulo);
	  panelMenu.add(botonRegistrarCliente);
	  panelMenu.add(botonBuscarCliente);
	  panelMenu.add(botonCerrarSesion);
	  panelMenu.add(botonCerrar);


	  add(panelMenu,BorderLayout.CENTER);
	  add(emptyLabel,BorderLayout.WEST);
	  add(emptyLabel2,BorderLayout.EAST);

	  botonCerrar.addActionListener(this);
	  botonCerrarSesion.addActionListener(this);
	  botonBuscarArticulo.addActionListener(this);
	  botonRegistrarCliente.addActionListener(this);
	  botonBuscarCliente.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e){



		if (e.getSource() == botonBuscarArticulo){


			
			BuscarArticuloGUI buscarArticulo =new BuscarArticuloGUI();
			buscarArticulo.setVisible(true);

			this.ocultar();

		}


		if (e.getSource()== botonRegistrarCliente){


			RegistrarClienteGUI registrarCliente = new RegistrarClienteGUI();
			registrarCliente.setVisible(true);


			this.ocultar();

			
		}

		if (e.getSource()==botonBuscarCliente){

			BuscarClienteGUI buscarCliente = new BuscarClienteGUI();
			buscarCliente.setVisible(true);
			this.ocultar();
		}


		if (e.getSource()==botonCerrarSesion){


			cSesion.cerrarSesion();
			cerrarVentana();


		}



		if (e.getSource() == botonCerrar){

			cSesion.cerrarSesion();
			System.exit(0);


		}






	
	}
	
	public void mostrar(){
	
		this.setVisible (true);
	}

	public void ocultar(){
	
		this.setVisible (false);
	}	

	void cerrarVentana (){


		dispose();
		LoginGUI ventanaLogin = new LoginGUI ();
		ventanaLogin.setVisible(true);

	}
	
}