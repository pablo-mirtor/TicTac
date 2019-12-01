package presentacion.dispatcher;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaReloj.VistaReloj;
import presentacion.vistas.vistaTrabajador.VistaTrabajador;
import presentacion.vistas.vistaCliente.VistaCliente;
import presentacion.vistas.vistaCompetencia.VistaCompetencia;
import presentacion.vistas.vistaCompra.VistaCompra;
import presentacion.vistas.vistaDepartamento.VistaDepartamento;
import presentacion.vistas.vistaPrincipal.VistaPrincipal;

/**
 * Clase de la capa presentacion que implementa al Dispatcher
 */
public class DispatcherImp extends Dispatcher{
	
	/**
	 * Metodo que realiza la accion necesaria en funcion del evento que le facilite el contexto
	 */
	@Override
	public void accion(Contexto contexto){
		switch(contexto.getEvento()){
		
			// Vista Principal
		
			case ListaComandos.VENTANA_PRINCIPAL:
				VistaPrincipal.getInstance().update(contexto);
				break;

			// Vista Cliente
			
			case ListaComandos.VENTANA_ALTA_CLIENTE:
			case ListaComandos.VENTANA_BAJA_CLIENTE:
			case ListaComandos.VENTANA_PRINCIPAL_CLIENTE:
			case ListaComandos.VENTANA_MOSTRAR_CLIENTE:
			case ListaComandos.VENTANA_LISTAR_CLIENTES:
			case ListaComandos.VENTANA_MODIFICAR_CLIENTE:
			case ListaComandos.MOSTRAR_ALTA_CLIENTE:	
			case ListaComandos.MOSTRAR_BAJA_CLIENTE:	
			case ListaComandos.MOSTRAR_MOSTRAR_CLIENTE:	
			case ListaComandos.MOSTRAR_LISTAR_CLIENTES:	
			case ListaComandos.MOSTRAR_MODIFICAR_CLIENTE:	
				VistaCliente.getInstance().update(contexto);
				break;
				
			// Vista Compra
			
			case ListaComandos.VENTANA_AGREGAR_PRODUCTO_COMPRA:
			case ListaComandos.VENTANA_PRINCIPAL_COMPRA:
			case ListaComandos.VENTANA_MOSTRAR_COMPRA:
			case ListaComandos.VENTANA_DEVOLUCION_COMPRA:
			case ListaComandos.VENTANA_ELIMINAR_PRODUCTO_COMPRA:
			case ListaComandos.VENTANA_GESTION_CARRITO_COMPRA:
			case ListaComandos.VENTANA_INICIAR_COMPRA:
			case ListaComandos.VENTANA_LISTAR_COMPRAS:	
			case ListaComandos.VENTANA_CANTIDAD_RELOJES_QUERY:
			case ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY:
			case ListaComandos.MOSTRAR_GESTION_CARRITO_COMPRA:
			case ListaComandos.MOSTRAR_AGREGAR_PRODUCTO_COMPRA:
			case ListaComandos.MOSTRAR_ELIMINAR_PRODUCTO_COMPRA:
			case ListaComandos.MOSTRAR_DEVOLUCION_PRODUCTO_COMPRA:
			case ListaComandos.MOSTRAR_MOSTRAR_COMPRA:
			case ListaComandos.MOSTRAR_LISTAR_COMPRAS:
			case ListaComandos.MOSTRAR_FINALIZAR_COMPRA:
			case ListaComandos.MOSTRAR_CANTIDAD_RELOJES_QUERY:
			case ListaComandos.MOSTRAR_NUMERO_CLIENTES_QUERY:
				VistaCompra.getInstance().update(contexto);
				break;				
		
			// Vista Reloj
		
			case ListaComandos.VENTANA_ALTA_RELOJ_ANALOGICO:
			case ListaComandos.VENTANA_ALTA_RELOJ_DIGITAL:
			case ListaComandos.VENTANA_BAJA_RELOJ:
			case ListaComandos.VENTANA_PRINCIPAL_RELOJ:
			case ListaComandos.VENTANA_MOSTRAR_RELOJ:
			case ListaComandos.VENTANA_LISTAR_RELOJES:
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_ANALOGICO:
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_DIGITAL:
			case ListaComandos.MOSTRAR_ALTA_RELOJ:	
			case ListaComandos.MOSTRAR_BAJA_RELOJ:	
			case ListaComandos.MOSTRAR_MOSTRAR_RELOJ:	
			case ListaComandos.MOSTRAR_LISTAR_RELOJES:	
			case ListaComandos.MOSTRAR_MODIFICAR_RELOJ:	
				VistaReloj.getInstance().update(contexto);
				break;
				
			// Vista Trabajador
			case ListaComandos.VENTANA_ALTA_TRABAJADOR:
			case ListaComandos.VENTANA_BAJA_TRABAJADOR:
			case ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR:
			case ListaComandos.VENTANA_MOSTRAR_TRABAJADOR:
			case ListaComandos.VENTANA_LISTAR_TRABAJADORES:
			case ListaComandos.VENTANA_MODIFICAR_TRABAJADOR:
			case ListaComandos.MOSTRAR_ALTA_TRABAJADOR:	
			case ListaComandos.MOSTRAR_BAJA_TRABAJADOR:	
			case ListaComandos.MOSTRAR_MOSTRAR_TRABAJADOR:	
			case ListaComandos.MOSTRAR_LISTAR_TRABAJADORES:	
			case ListaComandos.MOSTRAR_MODIFICAR_TRABAJADOR:	
				VistaTrabajador.getInstance().update(contexto);
				break;
				
			// Vista Departamento

			case ListaComandos.VENTANA_ALTA_DEPARTAMENTO:
			case ListaComandos.VENTANA_BAJA_DEPARTAMENTO:
			case ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO:
			case ListaComandos.VENTANA_MOSTRAR_DEPARTAMENTO:
			case ListaComandos.VENTANA_LISTAR_DEPARTAMENTOS:
			case ListaComandos.VENTANA_MODIFICAR_DEPARTAMENTO:
			case ListaComandos.VENTANA_CALCULAR_NOMINA_DEPARTAMENTO:
			case ListaComandos.MOSTRAR_ALTA_DEPARTAMENTO:	
			case ListaComandos.MOSTRAR_BAJA_DEPARTAMENTO:	
			case ListaComandos.MOSTRAR_MOSTRAR_DEPARTAMENTO:	
			case ListaComandos.MOSTRAR_LISTAR_DEPARTAMENTOS:	
			case ListaComandos.MOSTRAR_MODIFICAR_DEPARTAMENTO:
			case ListaComandos.MOSTRAR_CALCULAR_NOMINA_DEPARTAMENTO:
		
				VistaDepartamento.getInstance().update(contexto);
				break;
				
			// Vista Competencias
				
			case ListaComandos.VENTANA_ALTA_COMPETENCIA:
			case ListaComandos.VENTANA_BAJA_COMPETENCIA:
			case ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA:
			case ListaComandos.VENTANA_MOSTRAR_COMPETENCIA:
			case ListaComandos.VENTANA_LISTAR_COMPETENCIAS:
			case ListaComandos.VENTANA_MODIFICAR_COMPETENCIA:
			case ListaComandos.VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR:
			case ListaComandos.VENTANA_DESASIGNAR_COMPETENCIA_TRABAJADOR:
			case ListaComandos.VENTANA_ASIGNAR_NIVEL_COMPETENCIA:
			case ListaComandos.VENTANA_MOSTRAR_NIVEL_COMPETENCIA:
			case ListaComandos.MOSTRAR_ALTA_COMPETENCIA:	
			case ListaComandos.MOSTRAR_BAJA_COMPETENCIA:	
			case ListaComandos.MOSTRAR_MOSTRAR_COMPETENCIA:	
			case ListaComandos.MOSTRAR_LISTAR_COMPETENCIAS:	
			case ListaComandos.MOSTRAR_MODIFICAR_COMPETENCIA:	
			case ListaComandos.MOSTRAR_ASIGNAR_COMPETENCIA_TRABAJADOR:
			case ListaComandos.MOSTRAR_DESASIGNAR_COMPETENCIA_TRABAJADOR:
			case ListaComandos.MOSTRAR_ASIGNAR_NIVEL_COMPETENCIA:
			case ListaComandos.MOSTRAR_MOSTRAR_NIVEL_COMPETENCIA:
				VistaCompetencia.getInstance().update(contexto);
				break;
		}
	}
}