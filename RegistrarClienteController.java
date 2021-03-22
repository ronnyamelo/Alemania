/*



Registrar Cliente Controller


Clase del Controlador de la funcion Registrar Cliente

*/

package domain;

import dataAccess.Db;
import dataAccess.ClienteDA;
import domain.Cliente;
import dataAccess.ClienteDA;



public class RegistrarClienteController{


	private Cliente cli;
	private ClienteDA cliDa;


	public RegistrarClienteController(){


		cliDa = new ClienteDA ();

	}


	public boolean  registrarCliente(Cliente cl){

		boolean resultado;
		
		resultado = cliDa.registrarCliente(cl);

		return resultado;
	}

	public boolean clienteExiste(long ced) {



		if (cliDa.clienteExiste(ced)){

			return true;

		}


		else{

			return false;

		}

	}



}