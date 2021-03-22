/*
Clase que controla el Registro de un Empeno



*/

package domain;

import domain.Articulo;
import domain.Empeno;
import domain.Prestamo;
import dataAccess.EmpenoDA;


public class RegistrarEmpenoController{
		

	private  Articulo articulo;
	private  Prestamo prestamo;
	private  Empeno empeno;
	private EmpenoDA empenoDA;

	public  void registrarEmpeno (Empeno em){

		empenoDA = new EmpenoDA();
		empenoDA.registrarEmpeno(em);

	}


}