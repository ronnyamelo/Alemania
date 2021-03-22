/*

Clase que representa la entidad Articulo
*/

package domain;

public class Articulo{
	

	private int articuloId ;
	private String tipoDeArticulo ;
	private String estado ;
	private String marca ;
	private String modelo ;
	private double valorDeEmpeno ;
	private String numeroDeSerie ;
	private double precioDeVenta ;
	private String descripcion ;

	public Articulo (String ti, String ma, String mo,String nu, double va, String de ){

		this.tipoDeArticulo =ti;
		this.marca=ma;
		this.modelo =mo;
		this.numeroDeSerie=nu;
		this.valorDeEmpeno =va;
		this.descripcion=de;

	}

	public Articulo (int ar, String ti, String es, String ma, String mo,String nu, double va, double pr, String de ){

		this.articuloId=ar;
		this.tipoDeArticulo =ti;
		this.estado = es;
		this.marca=ma;
		this.modelo =mo;
		this.numeroDeSerie=nu;
		this.valorDeEmpeno =va;
		this.precioDeVenta = pr;
		this.descripcion = de;

	}

	public void setArticuloId (int ar){

		this.articuloId = ar;

	}

	public void setTipoDeArticulo (String ti){

		this.tipoDeArticulo = ti;

	}

	public void setEstado (String es){

		this.estado = es;


	}

	public void setMarca (String ma){

		this.marca = ma;
	

	}

	public void setModelo (String mo){

		this.modelo = mo;
	

	}

	public void setValorDeEmpeno (double va){

		this.valorDeEmpeno =  va;
	

	}

	public void setNumeroDeSerie (String nu){

		this.numeroDeSerie = nu;
	

	}

	public void setPrecioDeVenta (double pr){

		this.precioDeVenta = pr;
	

	}

	public void setDescripcion (String de){

		this.descripcion = de;
	

	}


	public int getArticuloId(){

		return articuloId;

	}

	public String getTipoDeArticulo(){

		return tipoDeArticulo;

	}

	public String getEstado(){

		return estado;

	}

	
	public String getMarca(){

		return marca;

	}

	
	public String getModelo(){

		return modelo;

	}

	public double getValorDeEmpeno(){

		return valorDeEmpeno;

	}


	public String getNumeroDeSerie(){

		return numeroDeSerie;

	}	

	public double precioDeVenta(){

		return precioDeVenta;

	}

	public String getDescripcion(){

		return descripcion;

	}


}