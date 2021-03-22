/*
Clase que mapea la instancia Empeno


*/



package domain;

import java.time.LocalDate;

public class Empeno  {
	

	private int empenoId;
	private LocalDate fechaEmpeno ;
	private Articulo articulo;
	private Prestamo prestamo;
	private int clienteId


	public Empeno (LocalDate fecha, int cid, Prestamo pre, Articulo ar){

			this.fechaEmpeno=fecha;
			this.prestamo = pre;
			this.articulo = ar;
			this.clienteId = cid;
	}

	public Empeno (int ei, LocalDate fecha, Prestamo pre, Articulo ar){

			this.empenoId =ei;
			this. fechaEmpeno=fecha;
			this. prestamo = pre;
			this.articulo = ar;
	}

	public int getEmpenoId (){


		return empenoId;
	}

	public int getClienteId (){


		return clienteId;
	}


	public LocalDate getFechaEmpeno (){


		return fechaEmpeno;
	}

	public Articulo getArticulo (){

		return articulo;

	}

	public Prestamo getPrestamo (){


		return prestamo;
	}
}

