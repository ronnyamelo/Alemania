/*
Controlador de Sesion


*/
package domain;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import domain.Usuario;
import dataAccess.UsuarioDA;
import dataAccess.Db;



public class ControladorSesion {

	private static Usuario usuarioActual;
	private Usuario us = null;
	private int validacion;
	private UsuarioDA usd;

	// Metodo para iniciar sesion
	// Devuelve un entero "1" si la conexion ha sido establecido correctamente
	
	public int  iniciarSesion(String nombreUsuario, String clave){



		 validacion = Db.login(nombreUsuario,clave);


		 us = getUsuarioDb();

		
		
		if(us!=null){
		

			setUsuarioActual(us);


		}
		
		return validacion;
		
	}
	
	public  void setUsuarioActual (Usuario us){
	
		usuarioActual = us;
	
	}

	public Usuario getUsuarioActual (){


		 usuarioActual = getUsuarioDb();			
		 return usuarioActual;

	}

	private Usuario getUsuarioDb (){


		Usuario usu = UsuarioDA.getUsuario();

		return usu;

	}

	
	public  String getUsuarioActualRol(){
	
		return usuarioActual.getRol();
	}

	/*

		Metodo que asigna el rol correspondiente al 
		usuario que esta conectado a la base de datos
		Medida de Seguridad extra para asegurar
		que el usuario pueda hacer lo que el rol que ha sido
		"Granteado" le permita hacer

	*/

	private void setDbRole (){

		String sentencia ="set role "+this.getUsuarioActualRol();


		try {

			Db.ejecutarQuery(sentencia);

		}

		catch (SQLException e){
			
			e.printStackTrace();
		
		}
			

		catch (Exception e){
			
			e.printStackTrace();
		
		}

	}

	public void voidUsuario(){


		usuarioActual = null;

	}

	public void cerrarSesion (){


		voidUsuario();
		Db.cerrarConexion();
	}



}