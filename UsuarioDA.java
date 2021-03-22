/*

Clase que maneja el acceso a base de datos de los Usuarios





*/
package dataAccess;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import domain.Usuario;

public class UsuarioDA{

	private static ResultSet rs;
	private static Usuario us;
	
	public  UsuarioDA(){}

	
	//Como la autenticacion se hace via la base de datos solo es necesario obtener quien es el Usuario conectado a la base de datos
	//y su rol para asi permitirle operar de una manera u otra en el programa
	
	public static Usuario getUsuario(){
	
			
		String sentenciaUsuario = "values user";
		String nombreUsuario=null;
		String rol = null;
		Usuario us = null;
	

		try{
		
			
			// Este devuelve el user conectado a la DB, mediante el comando "values user"
			rs = Db.ejecutarQuery(sentenciaUsuario);		
			
			
			if (rs.next()){
				
				nombreUsuario = rs.getString(1);
				
			}




		String sentenciaUsuarioInfo = "select * from Alemania.Usuarios where nombreUsuario = '"+ nombreUsuario+"'" ;


			
			rs = Db.ejecutarQuery(sentenciaUsuarioInfo);

			
			String noUs = null ;
			String no = null ;
			String ap = null ;
			String ro= null;
			int id =0 ;
			



			if (rs.next()){
				
				id = rs.getInt("idUsuario");
				noUs = rs.getString("nombreUsuario");
				no = rs.getString("nombre");				
				ap = rs.getString("apellido");
				ro = rs.getString("rol");	
	
			}	
					
			
		  us = new Usuario (id,noUs,no,ap,ro);	



		  // Metodo setea el Rol del usuario que esta conectado


		  if (!us.getRol().equals("Owner")){


		  	setUsuarioRol(us.getRol());

		  }

		  
			
		 System.out.println("Usuario : "+us.getNombreUsuario()+" Rol : "+us.getRol());	
		 
		}

		
		
		catch (SQLException e){
		
			System.out.println(e.getMessage());
		
		}
		
		catch (Exception e){
		
			System.out.println(e.getMessage());			
		
		
		} 
		
		
		return us;
		
	}



	public void desconectarUsuario (){


		String sentencia = "disconnect";

		try {

			Db.ejecutarQuery(sentencia);

		}


		catch (SQLException e){
		
			System.out.println(e.getMessage());
		
		}
		
		catch (Exception e){
		
			System.out.println(e.getMessage());			
		
		
		} 
		

	}	


		// Metodo para "setear" el rol del usuario que esta conectado


	public static void setUsuarioRol(String usuarioRol){




			String sentencia = "set role "+usuarioRol;

			System.out.println("Setiando el Usuario : "+sentencia);


		try {

			Db.ejecutarSQL(sentencia);

		}


		catch (SQLException e){
		
			System.out.println(e.getMessage());
		
		}
		
		catch (Exception e){
		
			System.out.println(e.getMessage());			
		
		
		} 



	}
	


	
	
	


}