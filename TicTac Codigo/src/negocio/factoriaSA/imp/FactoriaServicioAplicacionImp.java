package negocio.factoriaSA.imp;

import negocio.cliente.ServicioAplicacionCliente;
import negocio.cliente.imp.ServicioAplicacionClienteImp;
import negocio.competencia.ServicioAplicacionCompetencia;
import negocio.competencia.imp.ServicioAplicacionCompetenciaImp;
import negocio.compra.ServicioAplicacionCompra;
import negocio.compra.imp.ServicioAplicacionCompraImp;
import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.departamento.imp.ServicioAplicacionDepartamentoImp;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.reloj.ServicioAplicacionReloj;
import negocio.reloj.imp.ServicioAplicacionRelojImp;
import negocio.trabajador.ServicioAplicacionTrabajador;
import negocio.trabajador.imp.ServicioAplicacionTrabajadorImp;

/**
 * Clase de la capa negocio que implemente La FactoriaServicioAplicacion y que llama a las implementaciones de los
 * distintos servicios de implementacion
 */
public class FactoriaServicioAplicacionImp extends FactoriaServicioAplicacion {
	
	/**
	 * Metodo que devuelve una instancia de la implementacion del SAReloj
	 */
	@Override
	public ServicioAplicacionReloj createSAReloj() {
		return new ServicioAplicacionRelojImp();
	}

	/**
	 * Metodo que devuelve una instancia de la implementacion del SACliente
	 */
	@Override
	public ServicioAplicacionCliente createSACliente() {
		return new ServicioAplicacionClienteImp();
	}

	/**
	 * Metodo que devuelve una instancia de la implementacion del SACompra
	 */
	@Override
	public ServicioAplicacionCompra createSACompra() {
		return new ServicioAplicacionCompraImp();
	}
	
	@Override
	public ServicioAplicacionDepartamento createSADepartamento() {
		return new ServicioAplicacionDepartamentoImp();
	}
	
	@Override
	public ServicioAplicacionTrabajador createSATrabajador() {
		return new ServicioAplicacionTrabajadorImp();
	}

	@Override
	public ServicioAplicacionCompetencia createSACompetencia() {
		return new ServicioAplicacionCompetenciaImp();
	}
	
}

