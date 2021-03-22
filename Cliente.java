/*





Clase que representa los datos de un cliente en el sistema
	
*/


package domain;

public class Cliente {


	private int clienteId;
	private String nombre;
	private String apellido;
	private long cedula;
	private long telefono;
	private Direccion direccion;

	public Cliente ( ){}

	public Cliente (int ci, String no, String ap, long ce, long tel, Direccion di){


		clienteId = ci;
		nombre = no;
		apellido = ap;
		cedula = ce;
		telefono = tel;
		direccion = di;

	}


	public Cliente (String no, String ap, long ce, long  tel, Direccion di){


		nombre = no;
		apellido = ap;
		cedula = ce;
		telefono = tel;
		direccion = di;

	}

	public int getClienteId(){


			return this.clienteId;
	}

	public String getNombre(){


		return this.nombre;
	}


	public String getApellido (){


		return this.apellido;
	}


	public long getCedula(){


		return this.cedula;
	}


	public long getTelefono (){


		return this.telefono;
	}

	public Direccion getDireccion(){


		return this.direccion;
	}

}
