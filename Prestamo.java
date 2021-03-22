/*
Clase que mapea la entidad Prestamo


*/

package domain;


import java.time.LocalDate;

public class Prestamo{
	


	private int prestamoId;
	private double montoPrestado;
	private static final double  INTERES = 5;
	private LocalDate fechaDesembolso;
	private double totalAPagar;
	private double montoPagado;
	private double montoRestante;
	private double interesAcumulado;


	public Prestamo (double mo, LocalDate fe){

		this.montoPrestado = mo;
		this.fechaDesembolso = fe;

	}

	public Prestamo (int pid, double mo, LocalDate fe, double to, double mp, double mr, double ia){


		this.prestamoId =pid;
		this.montoPrestado = mo;
		this.fechaDesembolso = fe;
		this.totalAPagar = to;
		this.montoPagado = mo;
		this.montoRestante = mr;
		this.interesAcumulado = ia;

	}

	public int getPrestamoId (){

		return prestamoId;
	}

	public double getMontoPrestado (){

		return montoPrestado;
	}
	

	public LocalDate getFechaDesembolso (){

		return fechaDesembolso;
	}
	

	public double getTotalAPagar (){

		return totalAPagar;
	}
	

	public double getMontoPagado (){

		return montoPagado;
	}
	

	public double getMontoRestante (){

		return montoRestante;
	}
					

}