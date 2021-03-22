/*

Clase Usuario
*/

package domain;

import dataAccess.Db;

public class Usuario{


	private int idUsuario ;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String clave;
	private String rol;
	
	public Usuario (){}
	
	public Usuario (int id, String nu, String no, String ap,String ro){
		
		this.idUsuario =id;
		this.nombreUsuario = nu;
		this.nombre=no;
		this.apellido=ap;
		this.rol=ro;
		
	}
	

	public int getIdUsuario(){
	
		return idUsuario;
		
	}
	
	public String getNombreUsuario(){
	
		return nombreUsuario;
	
	}
	
	public String getNombre(){
	
	
		return nombre;
	}
	
	public String getApellido(){
	
		return apellido;
	}
	
	public String getClave (){
	
		return clave;
		
	}

	public String getRol(){
		return rol;
	
	}

	
}