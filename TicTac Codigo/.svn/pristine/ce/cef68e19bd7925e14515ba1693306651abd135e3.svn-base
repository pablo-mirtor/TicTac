package negocio.factoriaSA;

import negocio.cliente.ServicioAplicacionCliente;
import negocio.competencia.ServicioAplicacionCompetencia;
import negocio.compra.ServicioAplicacionCompra;
import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.factoriaSA.imp.FactoriaServicioAplicacionImp;
import negocio.reloj.ServicioAplicacionReloj;
import negocio.trabajador.ServicioAplicacionTrabajador;

/**
 * Clase abstracta de la capa negocio que define una factoria de SA, que permite crear los
 * SA de reloj, compra y cliente
 */
public abstract class FactoriaServicioAplicacion {
	private static FactoriaServicioAplicacion factoriaSA;

	public static FactoriaServicioAplicacion getInstance(){
		if (factoriaSA == null)
			factoriaSA = new FactoriaServicioAplicacionImp();
		return factoriaSA;
	}

	public abstract ServicioAplicacionReloj createSAReloj();
	public abstract ServicioAplicacionCliente createSACliente();
	public abstract ServicioAplicacionCompra createSACompra();
	public abstract ServicioAplicacionTrabajador createSATrabajador();
	public abstract ServicioAplicacionDepartamento createSADepartamento();
	public abstract ServicioAplicacionCompetencia createSACompetencia();
}

