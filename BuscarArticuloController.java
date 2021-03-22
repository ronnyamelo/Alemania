/*



Clase controladora de la funcionalidad
Buscar Articulo

*/

package domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import domain.ControladorSesion;
import dataAccess.Db;


public class BuscarArticuloController{

	private ResultSet rs;



	public BuscarArticuloController(){	}

	/*

		Metodo devuelve un Resultset con los articulos registrados

	*/

	public ResultSet getArticulos(){

		
		String	tipoDeArticulo =null ;
		String 	numeroDeSerie = null;
		String	estado =null ;
		String 	marca =null ;
		String modelo = null ;
		String descripcion =null ;
		double 	precio=0;
		int articuloId=0;

		try{

			rs = Db.ejecutarQuery ("Select articuloId, tipoDeArticulo, numeroDeSerie, estado,marca,modelo,descripcion,valorDeEmpeno,precioDeVenta from Alemania.Articulos");
		
/*


				while(rs.next()){

				System.out.println("Un articulo");

				articuloId= rs.getInt("articuloId");
				numeroDeSerie = rs.getString ("numeroDeSerie");
				tipoDeArticulo=rs.getString("tipoDeArticulo");
				estado = rs.getString("estado");
				marca = rs.getString("marca");
				modelo= rs.getString("modelo");
				descripcion = rs.getString ("descripcion");
				precio = rs.getDouble("precio");
			}*/

		}


		catch (SQLException e){

			e.printStackTrace();

		}

		catch (Exception e){

			e.printStackTrace();

		}

		return rs;

	}







}