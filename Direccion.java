/*






Clase que representa una direccion en el sistema

*/


package domain;

public class Direccion {


	private int direccionId;
	private String calle;
	private int numero;
	private String edificio;
	private String sector;
	private String ciudad;
	private String provincia;
	private String tipoDireccion;
	

   // Constructor

	public Direccion (int di, String ca, int  nu, String ed, String se, String ciu, String pro, String ti){


		direccionId = di;
		calle = ca;
		numero = nu;
		edificio =ed;
		sector = se;
		ciudad=ciu;
		provincia = pro;
		tipoDireccion = ti;

	}

	public Direccion ( String ca, int  nu, String ed, String se, String ciu, String pro, String ti){


		calle = ca;
		numero = nu;
		edificio =ed;
		sector = se;
		ciudad=ciu;
		provincia = pro;
		tipoDireccion = ti;

	}	

	public Direccion () {}


// Getters

	public int  getDireccionId (){


		return this.direccionId;
	}

	public String getCalle(){


		return this.calle;
	}

	public int  getNumero(){


		return this.numero;
	}

	public String getEdificio(){


		return this.edificio;
	}

	public String getSector(){


		return this.sector;
	}

	public String getCiudad(){

		return this.ciudad;

	}

	public String getProvincia (){

		return this.provincia;

	}

	public String getTipoDireccion(){

		return this.tipoDireccion;

	}




	//Setters 


	public void  setDireccionId (int dI){


		 this.direccionId = dI;
	}

	public void  setCalle(String ca){


		 this.calle = ca;
	}

	public void setNumero(int  nu){


		this.numero = nu;
	}

	public void setEdificio(String ed){


		 this.edificio = ed;
	}

	public void setSector(String se){


		 this.sector = se;
	}

	public void setCiudad(String ciu){

		 this.ciudad = ciu;

	}

	public void setProvincia (String pro){

		this.provincia = pro;

	}


	public void setTipoDireccion (String ti){

		this.tipoDireccion = ti;
	}


}