/*



BuscarArticulo GUI

Vista de la Funcionalidad Buscar Articulo

*/

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import domain.ControladorSesion;
import domain.BuscarArticuloController;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




class BuscarArticuloGUI extends JFrame implements ActionListener{
	

	BuscarArticuloController buController ;
	ResultSet rs;
	JTable tabla;
	
	JButton buscaBoton;
	JButton cancelarBoton;
	JButton registrarPagoBoton;
	JButton registrarVentaBoton;
	
	public BuscarArticuloGUI (){


	  setTitle("BuscarArticulo");
	  setSize(600,600);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocationRelativeTo(null);  
	  setResizable(true) ;
	  setLayout(new FlowLayout());

	  
	  buscaBoton = new JButton ("BuscarArticulo");
	  registrarPagoBoton = new JButton ("Registrar Pago");
	  registrarVentaBoton = new JButton ("Registrar Venta");
	  cancelarBoton = new JButton("Cancelar");

	  registrarPagoBoton.setEnabled(false);
	  registrarPagoBoton.addActionListener(new RegistrarPagoListener());


	  registrarVentaBoton.setEnabled(false);	  
	  registrarVentaBoton.addActionListener(new RegistrarVentaListener());

	  cancelarBoton.addActionListener(this);

	  add(buscaBoton);
	  add(registrarPagoBoton);
	  add(registrarVentaBoton);
	  add(cancelarBoton);

	  buscaBoton.addActionListener(this);

		try{

			
			buController = new BuscarArticuloController();

			rs = buController.getArticulos();

			String [] nombreColumnasTablas = {"articuloID","numeroDeSerie","tipoDeArticulo","estado","marca","modelo","valorDeEmpeno","precioDeVenta","descripcion"};
		 

			DefaultTableModel aModel = new DefaultTableModel();
			aModel.setColumnIdentifiers(nombreColumnasTablas);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();

			/*
			int colNo = rsmd.getColumnCount();

			System.out.println("El numero de Columnas es : "+colNo);

		while(rs.next()){


				Object []  objects = new Object [colNo];
				for (int i=0;i<colNo;i++){

					objects [i]=rs.getObject(i+1);


				}*/

			int columnCount = getColumnCount(rs);

			//System.out.println("Imprime Numero de columnas "+columnCount+"Numero de Filas "+rowCount);

			Object [] data = new Object [columnCount] ;


			int i =0;

			while (rs.next()) {

				System.out.println("Un Articulo");

				int j = 0;


				

				data[j++] = rs.getInt("articuloID");
				data[j++] = rs.getString("numeroDeSerie");
				data[j++] = rs.getString("tipoDeArticulo");
				data[j++] = rs.getString("estado");
				data[j++] = rs.getString("marca");
				data[j++] = rs.getString("modelo");
				data[j++] = rs.getDouble("valorDeEmpeno");
				data[j++] = rs.getDouble("precioDeVenta");
				data[j++] = rs.getString("descripcion");					


				aModel.addRow(data);

			}		

			 tabla = new JTable(aModel);

///////////// Anadiendo el listener 
			 // Y configurando la tabla para que nos permite escuchar
			 // cuando seleccionemos una fila


			 ///Si la fila que seleccionamos, el articulo esta empenado o perdido
			 /// nos permite selecionar el boton Registrar pago o Registrar Venta respectivamente

			  ListSelectionModel modeloLista = tabla.getSelectionModel();
			  modeloLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  modeloLista.addListSelectionListener(new ListSelectionListener() {

			      public void valueChanged(ListSelectionEvent e) {
			        String estadoArticulo = null;

			        int selectedRow = tabla.getSelectedRow();
			        
			          for (int j = 0; j < columnCount; j++) {
			            estadoArticulo = (String) tabla.getValueAt(selectedRow, 3);
			          }

			          if (estadoArticulo.equals("Empenado")||estadoArticulo.equals ("empenado")){

			          	registrarPagoBoton.setEnabled(true);
			          	registrarVentaBoton.setEnabled(false);
			          }

			          else if (estadoArticulo.equals ("Perdido")||estadoArticulo.equals("perdido")){

			          	registrarPagoBoton.setEnabled(false);
			          	registrarVentaBoton.setEnabled(true);

			          }

			          else {


			          	registrarPagoBoton.setEnabled(false);
						registrarVentaBoton.setEnabled(false);

			          }
			       
			        System.out.println("Imprime Seleccion: " + estadoArticulo);
			      }

    });			 


			  tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  tabla.setColumnSelectionAllowed(false);
			  tabla.setCellSelectionEnabled(false);
			  tabla.setRowSelectionAllowed(true);
			  tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			 JScrollPane scrollablePane = new JScrollPane (tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


			 JPanel panelTabla = new JPanel(new BorderLayout());


			 panelTabla.add(tabla.getTableHeader(), BorderLayout.NORTH);

			 panelTabla.add(scrollablePane, BorderLayout.CENTER);		

			 add( panelTabla );

		}

			

		

		catch (SQLException e){

			e.printStackTrace();

		}		

		catch (Exception e){

			e.printStackTrace();

		}

		
	


	}
	
	
	public void actionPerformed(ActionEvent ae){


		if (ae.getSource().equals(cancelarBoton)){


			cerrarVentana();
		}

	}	
	
	

	void ocultar (){

		this.setVisible(false);

	}

	void mostrar (){


		this.setVisible(true);

	}




		


	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}	





	class RegistrarPagoListener implements ActionListener{


		public void actionPerformed (ActionEvent ae){


				
			}

	}


	class RegistrarVentaListener implements ActionListener{


		public void actionPerformed (ActionEvent ae){


				
			}

	}


	void cerrarVentana (){


		dispose();
		VentanaPrincipalGUI ventana = new VentanaPrincipalGUI ();
		ventana.setVisible(true);

	}

	
	
}





