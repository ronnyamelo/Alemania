/*



Clase que maneja el acceso a Base de datos
y metodo de insercion, selection, y actualizacion
*/


package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;


public class Db{


	private static Connection con;
	
	private static String driver = "org.apache.derby.jdbc.ClientDriver";		
	private static String nombreBaseDeDatos="AlemaniaDB";
	private static String username;
	private static String usernamePassword;
	private static String bootPassword="password1234";	
	private static PreparedStatement stat ;
	private static Statement sta ;
	private static ResultSet rs;
	public static Db objetoDb;

	/*
	
		Metodo estatico para hacer login 
		devuelve un entero 1 si la conexion es exitosa
	
	*/
	
	public Db(){}


	
	public static int login(String user, String pa){
	
	
		username=user;
		usernamePassword=pa;
		
		String connectionUrl="jdbc:derby://localhost:1527//"+nombreBaseDeDatos+";create=true;bootPassword="+bootPassword+";user="+username+";password="+usernamePassword;
		//String connectionUrl="jdbc:derby://192.168.1.40:1527//"+nombreBaseDeDatos+";create=true;bootPassword="+bootPassword+";user="+username+";password="+usernamePassword;
		
		
		try{
			
			Class.forName(driver);	
			System.out.println("Carga del Driver Exitosa");
		
		}
		
		catch(ClassNotFoundException e){
		
			System.out.println("No se encontro la clase especifica");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1;
		}

		catch (Exception e ){
		
			System.out.println("Otra Excepcion");
			System.out.println(e.getMessage());
			return -1;
		}
		
		try{
		
			con = DriverManager.getConnection(connectionUrl);
			
		
			
			System.out.println("Conexion a BD Exitosa");
			System.out.println();
			
		}
		
		
		catch (SQLException e){
		

			if (e.getSQLState().equals("08004")||e.getSQLState().equals("58009")){
			
				System.out.println("Conexion a BD no lograda");
				System.out.println("Problema de autenticacion");
				System.out.println(e.getMessage());
				return 0;
				
			}
			
			else if (e.getSQLState()!=null||e.getSQLState().length()!=0){
				
			  System.out.println("Conexion a BD no Lograda");
			  System.out.println("Otro tipo de Excepcion SQL");
			  System.out.println(e.getMessage());
			  return 0;
			  
			}
			
		}

		catch (Exception e ){
		
			System.out.println("Otro tipo de excepcion");
			System.out.println(e.getMessage());
			return -1;
		}		
			
		

		//Metodo que selecciona el Esquema de la base de datos Alemania	
		setSchema()	;

		return 1;
	
	}

	public static Connection getConexion (){
		
	
		return con;
	}

	public static void cerrarConexion(){
	
		try{


			if(!rs.isClosed()){

				rs.close();
				
				System.out.println("ResultSet Cerrado");				

			}



			if(sta!=null){

					if (!sta.isClosed()){
						sta.close();
						System.out.println("Stament Cerrado");							
					}

			}	


			if(stat!=null){

					if (!stat.isClosed()){
						stat.close();
						System.out.println("PreparedStatement Cerrado");							
					}

			

			}						


			if (!con.isClosed()){
			
				con.close();
				System.out.println("Conexion Cerrada");
			
				}
			}

		catch(SQLException e){
		
			e.printStackTrace();
		
		}			
			
			
		catch(Exception e){
		
			e.printStackTrace();
		
		}
	
	}
	
	public static ResultSet ejecutarQueryPrepared(String sentenciaSQL, Object [] parametros)throws Exception{
		
		
		try{
			
			stat = con.prepareStatement(sentenciaSQL);
			
			if(parametros != null) {
				for(int k = 0; k < parametros.length; k++){
					stat.setObject(k+1, parametros[k]);
				}
			} 
			

			int rows = stat.executeUpdate();			

		}
		
		

		catch (SQLException e){
			
			e.printStackTrace();
		
		}
			

		catch (Exception e){
			
			e.printStackTrace();
		
		}
						
		return rs;


	}
	
	
	public static ResultSet ejecutarQuery(String sentenciaSQL)throws Exception{
		
		
		try{
			
			sta = con.createStatement();

			rs=sta.executeQuery(sentenciaSQL);
			
			

		}
		
		

		catch (SQLException e){
			
			e.printStackTrace();
		
		}
			

		catch (Exception e){
			
			e.printStackTrace();
		
		}
						
		return rs;


	}
	
	public static void ejecutarUpdateArg(String sentenciaSQL, Object [] parametros)throws SQLException{
	
		stat =con.prepareStatement(sentenciaSQL);
		
        if(parametros != null) {
            for(int k = 0; k < parametros.length; k++){
                stat.setObject(k+1, parametros[k]);
            }
        }
		
		
		 stat.executeUpdate();


	}	


	public static void  ejecutarSQL(String sentenciaSQL)throws Exception{
		
		
		try{
			
			sta = con.createStatement();

			con.commit();

			sta.execute(sentenciaSQL);
			
			

		}
		
		

		catch (SQLException e){
			
			e.printStackTrace();
		
		}
			

		catch (Exception e){
			
			e.printStackTrace();
		
		}
						
		


	}


	//Metodo que selecciona el Esquema de la base de datos Alemania
	static void setSchema(){

		 String sentenciaSQL = "set schema Alemania";


		try{
			
			ejecutarSQL(sentenciaSQL);
			

		}
		
		

		catch (SQLException e){
			
			e.printStackTrace();
		
		}
			

		catch (Exception e){
			
			e.printStackTrace();
		
		}


	}
	
	
	
}