package presentacion.comandos;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.comandos.negocio.cliente.NegocioAltaClienteComando;
import presentacion.comandos.negocio.cliente.NegocioBajaClienteComando;
import presentacion.comandos.negocio.cliente.NegocioListarClientesComando;
import presentacion.comandos.negocio.cliente.NegocioModificarClienteComando;
import presentacion.comandos.negocio.cliente.NegocioMostrarClienteComando;
import presentacion.comandos.negocio.compra.NegocioAgregarProductoCompraComando;
import presentacion.comandos.negocio.compra.NegocioCantidadRelojesComando;
import presentacion.comandos.negocio.compra.NegocioDevolucionCompraComando;
import presentacion.comandos.negocio.compra.NegocioEliminarProductoCompraComando;
import presentacion.comandos.negocio.compra.NegocioFinalizarCompraComando;
import presentacion.comandos.negocio.compra.NegocioGestionCarritoCompraComando;
import presentacion.comandos.negocio.compra.NegocioListarComprasComando;
import presentacion.comandos.negocio.compra.NegocioMostrarCompraComando;
import presentacion.comandos.negocio.compra.NegocioNumeroClientesComando;
import presentacion.comandos.negocio.reloj.NegocioAltaRelojComando;
import presentacion.comandos.negocio.reloj.NegocioBajaRelojComando;
import presentacion.comandos.negocio.reloj.NegocioListarRelojesComando;
import presentacion.comandos.negocio.reloj.NegocioModificarRelojComando;
import presentacion.comandos.negocio.reloj.NegocioMostrarRelojComando;
import presentacion.comandos.vistas.VistaVentanaPrincipalComando;
import presentacion.comandos.vistas.cliente.VistaAltaClienteComando;
import presentacion.comandos.vistas.cliente.VistaBajaClienteComando;
import presentacion.comandos.vistas.cliente.VistaListarClientesComando;
import presentacion.comandos.vistas.cliente.VistaModificarClienteComando;
import presentacion.comandos.vistas.cliente.VistaMostrarClienteComando;
import presentacion.comandos.vistas.cliente.VistaPrincipalClienteComando;
import presentacion.comandos.vistas.compra.VistaAgregarProductoCompraComando;
import presentacion.comandos.vistas.compra.VistaCantidadRelojesQueryComando;
import presentacion.comandos.vistas.compra.VistaDevolucionCompraComando;
import presentacion.comandos.vistas.compra.VistaEliminarProductoCompraComando;
import presentacion.comandos.vistas.compra.VistaGestionCarritoCompraComando;
import presentacion.comandos.vistas.compra.VistaIniciarCompraComando;
import presentacion.comandos.vistas.compra.VistaListarComprasComando;
import presentacion.comandos.vistas.compra.VistaMostrarCompraComando;
import presentacion.comandos.vistas.compra.VistaNumeroClientesQueryComando;
import presentacion.comandos.vistas.compra.VistaPrincipalCompraComando;
import presentacion.comandos.vistas.reloj.VistaAltaRelojAnalogicoComando;
import presentacion.comandos.vistas.reloj.VistaAltaRelojDigitalComando;
import presentacion.comandos.vistas.reloj.VistaBajaRelojComando;
import presentacion.comandos.vistas.reloj.VistaListarRelojesComando;
import presentacion.comandos.vistas.reloj.VistaModificarRelojAnalogicoComando;
import presentacion.comandos.vistas.reloj.VistaModificarRelojDigitalComando;
import presentacion.comandos.vistas.reloj.VistaMostrarRelojComando;
import presentacion.comandos.vistas.reloj.VistaPrincipalRelojComando;



import presentacion.comandos.negocio.competencia.NegocioAltaCompetenciaComando;
import presentacion.comandos.negocio.competencia.NegocioAsignarCompetenciaTrabajadorComando;
import presentacion.comandos.negocio.competencia.NegocioAsignarNivelCompetenciaComando;
import presentacion.comandos.negocio.competencia.NegocioBajaCompetenciaComando;
import presentacion.comandos.negocio.competencia.NegocioDesasignarCompetenciaTrabajadorComando;
import presentacion.comandos.negocio.competencia.NegocioListarCompetenciasComando;
import presentacion.comandos.negocio.competencia.NegocioModificarCompetenciaComando;
import presentacion.comandos.negocio.competencia.NegocioMostrarCompetenciaComando;
import presentacion.comandos.negocio.competencia.NegocioMostrarNivelCompetenciaComando;
import presentacion.comandos.negocio.departamento.NegocioAltaDepartamentoComando;
import presentacion.comandos.negocio.departamento.NegocioBajaDepartamentoComando;
import presentacion.comandos.negocio.departamento.NegocioCalcularNominaDepartamentoComando;
import presentacion.comandos.negocio.departamento.NegocioListarDepartamentosComando;
import presentacion.comandos.negocio.departamento.NegocioModificarDepartamentoComando;
import presentacion.comandos.negocio.departamento.NegocioMostrarDepartamentoComando;
import presentacion.comandos.negocio.trabajador.NegocioAltaTrabajadorComando;
import presentacion.comandos.negocio.trabajador.NegocioBajaTrabajadorComando;
import presentacion.comandos.negocio.trabajador.NegocioListarTrabajadoresComando;
import presentacion.comandos.negocio.trabajador.NegocioModificarTrabajadorComando;
import presentacion.comandos.negocio.trabajador.NegocioMostrarTrabajadorComando;
import presentacion.comandos.vistas.competencia.VistaAltaCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaAsignarCompetenciaTrabajadorComando;
import presentacion.comandos.vistas.competencia.VistaAsignarNivelCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaBajaCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaDesasignarCompetenciaTrabajadorComando;
import presentacion.comandos.vistas.competencia.VistaListarCompetenciasComando;
import presentacion.comandos.vistas.competencia.VistaListarNivelCompetenciasComando;
import presentacion.comandos.vistas.competencia.VistaModificarCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaMostrarCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaMostrarNivelCompetenciaComando;
import presentacion.comandos.vistas.competencia.VistaPrincipalCompetenciaComando;
import presentacion.comandos.vistas.departamento.VistaAltaDepartamentoComando;
import presentacion.comandos.vistas.departamento.VistaBajaDepartamentoComando;
import presentacion.comandos.vistas.departamento.VistaCalcularNominaDepartamentoComando;
import presentacion.comandos.vistas.departamento.VistaListarDepartamentosComando;
import presentacion.comandos.vistas.departamento.VistaModificarDepartamentoComando;
import presentacion.comandos.vistas.departamento.VistaMostrarDepartamentoComando;
import presentacion.comandos.vistas.departamento.VistaPrincipalDepartamentoComando;
import presentacion.comandos.vistas.trabajador.VistaAltaTrabajadorComando;
import presentacion.comandos.vistas.trabajador.VistaBajaTrabajadorComando;
import presentacion.comandos.vistas.trabajador.VistaListarTrabajadoresComando;
import presentacion.comandos.vistas.trabajador.VistaModificarTrabajadorComando;
import presentacion.comandos.vistas.trabajador.VistaMostrarTrabajadorComando;
import presentacion.comandos.vistas.trabajador.VistaPrincipalTrabajadorComando;

/**
 * Clase de la capa presentación que permite llamar a la vista correspondiente en funcion del evento recibido.
 */
public class FactoriaDeComandosImp extends FactoriaDeComandos{
	
	/**
	 * Metodo que elige la vista correcta en funcion del evento que le llega
	 */
	@Override
	public Comando getComando(int event){
		Comando comando = null;
		switch(event){
		
			// Principal
			case ListaComandos.VENTANA_PRINCIPAL:
				comando = new VistaVentanaPrincipalComando();
				break;

				
			// Vistas Cliente	
			
			case ListaComandos.VENTANA_ALTA_CLIENTE:
				comando = new VistaAltaClienteComando();
				break;
			case ListaComandos.VENTANA_BAJA_CLIENTE:
				comando = new VistaBajaClienteComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_CLIENTE:
				comando = new VistaPrincipalClienteComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_CLIENTE:
				comando = new VistaMostrarClienteComando();
				break;
			case ListaComandos.VENTANA_LISTAR_CLIENTES:
				comando = new VistaListarClientesComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_CLIENTE:
				comando = new VistaModificarClienteComando();
				break;
			case ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY:
				comando = new VistaNumeroClientesQueryComando();
				break;				
				
			// Vistas Compra
				
			case ListaComandos.VENTANA_AGREGAR_PRODUCTO_COMPRA:
				comando = new VistaAgregarProductoCompraComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_COMPRA:
				comando = new VistaPrincipalCompraComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_COMPRA:
				comando = new VistaMostrarCompraComando();
				break;
			case ListaComandos.VENTANA_DEVOLUCION_COMPRA:
				comando = new VistaDevolucionCompraComando();
				break;
			case ListaComandos.VENTANA_ELIMINAR_PRODUCTO_COMPRA:
				comando = new VistaEliminarProductoCompraComando();
				break;
			case ListaComandos.VENTANA_GESTION_CARRITO_COMPRA:
				comando = new VistaGestionCarritoCompraComando();
				break;
			case ListaComandos.VENTANA_INICIAR_COMPRA:
				comando = new VistaIniciarCompraComando();
				break;
			case ListaComandos.VENTANA_LISTAR_COMPRAS:
				comando = new VistaListarComprasComando();
				break;
				
			// Vistas Reloj	
			
			case ListaComandos.VENTANA_ALTA_RELOJ_DIGITAL:
				comando = new VistaAltaRelojDigitalComando();
				break;
			case ListaComandos.VENTANA_ALTA_RELOJ_ANALOGICO:
				comando = new VistaAltaRelojAnalogicoComando();
				break;
			case ListaComandos.VENTANA_BAJA_RELOJ:
				comando = new VistaBajaRelojComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_RELOJ:
				comando = new VistaPrincipalRelojComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_RELOJ:
				comando = new VistaMostrarRelojComando();
				break;
			case ListaComandos.VENTANA_LISTAR_RELOJES:
				comando = new VistaListarRelojesComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_DIGITAL:
				comando = new VistaModificarRelojDigitalComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_ANALOGICO:
				comando = new VistaModificarRelojAnalogicoComando();
				break;
			case ListaComandos.VENTANA_CANTIDAD_RELOJES_QUERY:
				comando = new VistaCantidadRelojesQueryComando();
				break;
				
			// Vistas Competencia
				
			case ListaComandos.VENTANA_ALTA_COMPETENCIA:
				comando = new VistaAltaCompetenciaComando();
				break;
			case ListaComandos.VENTANA_BAJA_COMPETENCIA:
				comando = new VistaBajaCompetenciaComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA:
				comando = new VistaPrincipalCompetenciaComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_COMPETENCIA:
				comando = new VistaMostrarCompetenciaComando();
				break;
			case ListaComandos.VENTANA_LISTAR_COMPETENCIAS:
				comando = new VistaListarCompetenciasComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_COMPETENCIA:
				comando = new VistaModificarCompetenciaComando();
				break;
			case ListaComandos.VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR:
				comando = new VistaAsignarCompetenciaTrabajadorComando();
				break;
			case ListaComandos.VENTANA_DESASIGNAR_COMPETENCIA_TRABAJADOR:
				comando = new VistaDesasignarCompetenciaTrabajadorComando();
				break;
			case ListaComandos.VENTANA_ASIGNAR_NIVEL_COMPETENCIA:
				comando = new VistaAsignarNivelCompetenciaComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_NIVEL_COMPETENCIA:
				comando = new VistaMostrarNivelCompetenciaComando();
				break;
			case ListaComandos.VENTANA_LISTAR_NIVEL_COMPETENCIAS:
				comando = new VistaListarNivelCompetenciasComando();
				break;	
				
			// Vistas Departamento	
				
			case ListaComandos.VENTANA_ALTA_DEPARTAMENTO:
				comando = new VistaAltaDepartamentoComando();
				break;
			case ListaComandos.VENTANA_BAJA_DEPARTAMENTO:
				comando = new VistaBajaDepartamentoComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO:
				comando = new VistaPrincipalDepartamentoComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_DEPARTAMENTO:
				comando = new VistaMostrarDepartamentoComando();
				break;
			case ListaComandos.VENTANA_LISTAR_DEPARTAMENTOS:
				comando = new VistaListarDepartamentosComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_DEPARTAMENTO:
				comando = new VistaModificarDepartamentoComando();
				break;
			case ListaComandos.VENTANA_CALCULAR_NOMINA_DEPARTAMENTO:
				comando = new VistaCalcularNominaDepartamentoComando();
				break;	
				
				
			// Vistas Trabajador
			
			case ListaComandos.VENTANA_ALTA_TRABAJADOR:
				comando = new VistaAltaTrabajadorComando();
				break;
			case ListaComandos.VENTANA_BAJA_TRABAJADOR:
				comando = new VistaBajaTrabajadorComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR:
				comando = new VistaPrincipalTrabajadorComando();
				break;
			case ListaComandos.VENTANA_MOSTRAR_TRABAJADOR:
				comando = new VistaMostrarTrabajadorComando();
				break;
			case ListaComandos.VENTANA_LISTAR_TRABAJADORES:
				comando = new VistaListarTrabajadoresComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_TRABAJADOR:
				comando = new VistaModificarTrabajadorComando();
				break;
					
					
			// Negocio	Cliente
				
			case ListaComandos.NEGOCIO_ALTA_CLIENTE:
				comando = new NegocioAltaClienteComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_CLIENTE:
				comando = new NegocioBajaClienteComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_CLIENTE:
				comando = new NegocioMostrarClienteComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_CLIENTES:
				comando = new NegocioListarClientesComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_CLIENTE:
				comando = new NegocioModificarClienteComando();
				break;	
			case ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY:
				comando = new NegocioNumeroClientesComando();
				break;
				
			// Negocio	Compra
				
			case ListaComandos.NEGOCIO_GESTION_CARRITO_COMPRA:
				comando = new NegocioGestionCarritoCompraComando();
				break;
			case ListaComandos.NEGOCIO_AGREGAR_PRODUCTO_COMPRA:
				comando = new NegocioAgregarProductoCompraComando();
				break;
			case ListaComandos.NEGOCIO_ELIMINAR_PRODUCTO_COMPRA:
				comando = new NegocioEliminarProductoCompraComando();
				break;
			case ListaComandos.NEGOCIO_FINALIZAR_COMPRA:
				comando = new NegocioFinalizarCompraComando();
				break;
			case ListaComandos.NEGOCIO_DEVOLUCION_COMPRA:
				comando = new NegocioDevolucionCompraComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_COMPRA:
				comando = new NegocioMostrarCompraComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_COMPRAS:
				comando = new NegocioListarComprasComando();
				break;
				
			// Negocio	Reloj
			
			case ListaComandos.NEGOCIO_ALTA_RELOJ:
				comando = new NegocioAltaRelojComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_RELOJ:
				comando = new NegocioBajaRelojComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_RELOJ:
				comando = new NegocioMostrarRelojComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_RELOJES:
				comando = new NegocioListarRelojesComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_RELOJ:
				comando = new NegocioModificarRelojComando();
				break;
			case ListaComandos.NEGOCIO_CANTIDAD_RELOJES_QUERY:
				comando = new NegocioCantidadRelojesComando();
				break;
				
			// Negocio Competencia
				
			case ListaComandos.NEGOCIO_ALTA_COMPETENCIA:
				comando = new NegocioAltaCompetenciaComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_COMPETENCIA:
				comando = new NegocioBajaCompetenciaComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_COMPETENCIA:
				comando = new NegocioMostrarCompetenciaComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_COMPETENCIAS:
				comando = new NegocioListarCompetenciasComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_COMPETENCIA:
				comando = new NegocioModificarCompetenciaComando();
				break;
			case ListaComandos.NEGOCIO_ASIGNAR_COMPETENCIA_TRABAJADOR:
				comando = new NegocioAsignarCompetenciaTrabajadorComando();
				break;
			case ListaComandos.NEGOCIO_DESASIGNAR_COMPETENCIA_TRABAJADOR:
				comando = new NegocioDesasignarCompetenciaTrabajadorComando();
				break;
			case ListaComandos.NEGOCIO_ASIGNAR_NIVEL_COMPETENCIA:
				comando = new NegocioAsignarNivelCompetenciaComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_NIVEL_COMPETENCIA:
				comando = new NegocioMostrarNivelCompetenciaComando();
				break;
			// Negocio Departamento	
			
			case ListaComandos.NEGOCIO_ALTA_DEPARTAMENTO:
				comando = new NegocioAltaDepartamentoComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_DEPARTAMENTO:
				comando = new NegocioBajaDepartamentoComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_DEPARTAMENTO:
				comando = new NegocioMostrarDepartamentoComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_DEPARTAMENTOS:
				comando = new NegocioListarDepartamentosComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_DEPARTAMENTO:
				comando = new NegocioModificarDepartamentoComando();
				break;
			case ListaComandos.NEGOCIO_CALCULAR_NOMINA_DEPARTAMENTO:
				comando = new NegocioCalcularNominaDepartamentoComando();
				break;		
				
			// Negocio Trabajador
				
			case ListaComandos.NEGOCIO_ALTA_TRABAJADOR:
				comando = new NegocioAltaTrabajadorComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_TRABAJADOR:
				comando = new NegocioBajaTrabajadorComando();
				break;
			case ListaComandos.NEGOCIO_MOSTRAR_TRABAJADOR:
				comando = new NegocioMostrarTrabajadorComando();
				break;
			case ListaComandos.NEGOCIO_LISTAR_TRABAJADORES:
				comando = new NegocioListarTrabajadoresComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_TRABAJADOR:
				comando = new NegocioModificarTrabajadorComando();
				break;
				
				
		}
		
		return comando;
	}
}
