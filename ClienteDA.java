/*



Clase de Acceso a base de datos para la clase cliente


*/



package dataAccess;

import domain.Cliente;
import domain.Direccion;
import dataAccess.Db;
import java.sql.ResultSet;
import java.sql.*;



public class ClienteDA {

	private String nombre, apellido, calle, edificio, sector, ciudad , provincia, tipoDireccion;
	private long cedula,telefono;
	private int numeroPropiedad;
	private int clienteId;
	private ResultSet rs;
	private Cliente cli;
	private Direccion dir;



	public ClienteDA(){}

	public boolean registrarCliente(Cliente cl){

		String sentenciaSQL;



		cedula = cl.getCedula();
		nombre = cl.getNombre();
		apellido = cl.getApellido();
		telefono = cl.getTelefono();
		calle = cl.getDireccion().getCalle();
		numeroPropiedad = cl.getDireccion().getNumero();
		edificio = cl.getDireccion().getEdificio();
		sector = cl.getDireccion().getSector();
		ciudad = cl.getDireccion().getCiudad();
		provincia = cl.getDireccion().getProvincia();
		tipoDireccion =cl.getDireccion().getTipoDireccion();


		sentenciaSQL = "insert into Clientes (cedula, nombre, apellido, telefono ) values (?,?,?,?)";

		Object [] parametrosCliente = new Object []{cedula,nombre,apellido,telefono};


		for (int i = 0;i<parametrosCliente.length; i++){

			System.out.println(String.valueOf(parametrosCliente [i]));
		}


		try{

			Db.ejecutarQueryPrepared(sentenciaSQL, parametrosCliente);
		}


		catch(Exception e){

			e.printStackTrace();

			return false;

		}


		String sentenciaSQL2 = "insert into Direcciones (calle, numeroPropiedad, edificio, sector, ciudad, provincia, tipoDeDireccion,cedulaCliente ) values (?,?,?,?,?,?,?,?)";

		Object [] parametrosDireccion = new Object []{calle,numeroPropiedad,edificio,sector,ciudad,provincia,tipoDireccion, cedula};


		try{

			rs = Db.ejecutarQueryPrepared(sentenciaSQL2, parametrosDireccion);


		}

		catch(Exception e){

			e.printStackTrace();
			return false;

		}

		return true;

	}

	public boolean clienteExiste(long cedula){

		boolean resultado;



		String sentenciaSQL = "select * from Clientes where cedula =" +cedula;


		try{

			rs = Db.ejecutarQuery(sentenciaSQL);



			if (rs.next()){

				return true;

			}

		}



		catch(Exception e){

			e.printStackTrace();

		}	



			return false;


	}

	public Cliente buscarCliente (long cedula){	

		

		String sentenciaSQL = "select * from Clientes join Direcciones on Clientes.cedula = Direcciones.cedulaCliente where cedula =" +cedula;

		try{

			rs = Db.ejecutarQuery(sentenciaSQL);



			if (rs.next()){

				clienteId = rs.getInt("clienteId");
				cedula = rs.getLong("cedula");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				telefono = rs.getLong("telefono");
				calle = rs.getString("calle");
				numeroPropiedad = rs.getInt("numeroPropiedad");
				edificio = rs.getString("edificio");
				sector = rs.getString("sector");
				ciudad = rs.getString("ciudad");
				provincia = rs.getString("provincia");
				tipoDireccion = rs.getString("tipoDeDireccion");

			}


			dir = new Direccion(calle,numeroPropiedad,edificio,sector,ciudad,provincia,tipoDireccion);
			
			cli = new Cliente(clienteId, nombre,apellido,cedula,telefono, dir);



		

		}



		catch(Exception e){

			e.printStackTrace();

		}	


		return cli;
	}

}