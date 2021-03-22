/*

Clase que maneja el acceso a base de datos 
para registrar un empeno



*/


package dataAccess;



import domain.Articulo;
import domain.Empeno;
import domain.Prestamo;


import java.sql.*;

public class EmpenoDA{
	
	private  Articulo articulo;
	private   Prestamo prestamo;
	private  Empeno empeno;	
	private Date fechaSQL ;

	public  int registrarEmpeno (Empeno em){

		String sentenciaSQL;
		Object [] parametrosArticulo;
		Object [] parametrosPrestamo;
		Object [] parametrosEmpeno;

		articulo = em.getArticulo();
		prestamo = em.getPrestamo();

//Insercion en la tabla Articulos

		sentenciaSQL = "insert into Articulos (tipoDeArticulo, NumeroDeSerie, Marca, Modelo, ValorDeEmpeno, Descripcion) values (?,?,?,?,?,?)";
		parametrosArticulo = new Object [] {articulo.getTipoDeArticulo(), articulo.getNumeroDeSerie(), articulo.getMarca(), articulo.getModelo(), articulo.getValorDeEmpeno(), articulo.getDescripcion()};

		try{


			Db.ejecutarQueryPrepared(sentenciaSQL,parametrosArticulo);

		}


		catch (SQLException e){

			e.printStackTrace();

		}

		catch (Exception e){

			e.printStackTrace();

		}



//Insercion en la tabla Prestamos

		sentenciaSQL = "insert into Prestamos (montoPrestado, fechaDesembolso) values (?,?)";
		fechaSQL = Date.valueOf(prestamo.getFechaDesembolso());


		parametrosArticulo = new Object [] {prestamo.getMontoPrestado(), fechaSQL};

		try{


			Db.ejecutarQueryPrepared(sentenciaSQL,parametrosArticulo);

		}


		catch (SQLException e){

			e.printStackTrace();

		}

		catch (Exception e){

			e.printStackTrace();

		}
		

		return 0;

	}


}