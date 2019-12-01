package presentacion.comandos.negocio.departamento;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.departamento.TransferDepartamento;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListarDepartamentosComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferDepartamento> lista = FactoriaServicioAplicacion.getInstance().createSADepartamento().listarDepartamentos();		
		return new Contexto(ListaComandos.MOSTRAR_LISTAR_DEPARTAMENTOS, lista);
	}

}
