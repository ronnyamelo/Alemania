/*



Clase controlador de la funcionalidad Buscar Cliente
*/

package domain;

import dataAccess.Db;
import dataAccess.ClienteDA;
import domain.Cliente;
import dataAccess.ClienteDA;
import domain.Direccion;


public class BuscarClienteController{

	private ClienteDA cliDa = new ClienteDA ();;

	public BuscarClienteController(){


	}

	public boolean clienteExiste(long ced){

		boolean resultado;

		

		resultado =cliDa.clienteExiste(ced);

		return resultado;
	}

	public Cliente buscarCliente (long ced ){

		Cliente cli = cliDa.buscarCliente(ced);

		return cli;


	}


}