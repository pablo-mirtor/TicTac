 package presentacion.comandos;

/**
 * Esta clase permite la agrupacion de los enumerados que permiten gestionar los eventos de la capa presentacion, dandoles un nombre descriptivo.
 */
public class ListaComandos {
	// Vista Principal
	
    public static final int VENTANA_PRINCIPAL		 				= 101;
    
    // Vistas Reloj
    
    public static final int VENTANA_ALTA_RELOJ_ANALOGICO			= 201;
    public static final int VENTANA_ALTA_RELOJ_DIGITAL				= 202;
    public static final int VENTANA_BAJA_RELOJ						= 203;
    public static final int VENTANA_PRINCIPAL_RELOJ					= 204;
    public static final int VENTANA_MOSTRAR_RELOJ					= 205;
    public static final int VENTANA_LISTAR_RELOJES 					= 206;
    public static final int VENTANA_MODIFICAR_RELOJ_ANALOGICO 		= 207;
    public static final int VENTANA_MODIFICAR_RELOJ_DIGITAL			= 208;
    
    // Vista Cliente
    
    public static final int VENTANA_ALTA_CLIENTE		 			= 301;
    public static final int VENTANA_BAJA_CLIENTE					= 302;
    public static final int VENTANA_PRINCIPAL_CLIENTE	 			= 303;
    public static final int VENTANA_MOSTRAR_CLIENTE 				= 304;
    public static final int VENTANA_LISTAR_CLIENTES	 				= 305;
    public static final int VENTANA_MODIFICAR_CLIENTE				= 306;
    
    // Vista Compra
    
    public static final int VENTANA_AGREGAR_PRODUCTO_COMPRA 		= 401;
    public static final int VENTANA_PRINCIPAL_COMPRA				= 402;
    public static final int VENTANA_MOSTRAR_COMPRA 					= 403;
    public static final int VENTANA_DEVOLUCION_COMPRA 				= 404;
    public static final int VENTANA_ELIMINAR_PRODUCTO_COMPRA		= 405;
    public static final int VENTANA_FINALIZAR_COMPRA				= 406;
    public static final int VENTANA_GESTION_CARRITO_COMPRA			= 407;
    public static final int VENTANA_INICIAR_COMPRA 					= 408;
    public static final int VENTANA_LISTAR_COMPRAS 					= 409;
    public static final int VENTANA_CANTIDAD_RELOJES 				= 410;
    public static final int VENTANA_NUMERO_CLIENTES					= 411;
    
    

    // Negocio Reloj
    
    public static final int NEGOCIO_ALTA_RELOJ						= 211;
    public static final int NEGOCIO_ALTA_RELOJ_ANALOGICO			= 212;
    public static final int NEGOCIO_ALTA_RELOJ_DIGITAL				= 213;
    public static final int NEGOCIO_BAJA_RELOJ						= 214;
    public static final int NEGOCIO_MOSTRAR_RELOJ					= 215;
    public static final int NEGOCIO_LISTAR_RELOJES					= 216;
    public static final int NEGOCIO_MODIFICAR_RELOJ					= 217;
    public static final int NEGOCIO_MODIFICAR_RELOJ_ANALOGICO		= 218;
    public static final int NEGOCIO_MODIFICAR_RELOJ_DIGITAL			= 219;
   
    // Negocio Cliente
    
    public static final int NEGOCIO_ALTA_CLIENTE 					= 311;
    public static final int NEGOCIO_BAJA_CLIENTE 					= 312;
    public static final int NEGOCIO_MOSTRAR_CLIENTE					= 313;
    public static final int NEGOCIO_LISTAR_CLIENTES 				= 314;
    public static final int NEGOCIO_MODIFICAR_CLIENTE				= 315;
   
    // Negocio Compra
    
    public static final int NEGOCIO_AGREGAR_PRODUCTO_COMPRA 		= 412;
    public static final int NEGOCIO_MOSTRAR_COMPRA 					= 413;
    public static final int NEGOCIO_DEVOLUCION_COMPRA 				= 414;
    public static final int NEGOCIO_ELIMINAR_PRODUCTO_COMPRA		= 415;
    public static final int NEGOCIO_GESTION_CARRITO_COMPRA	    	= 416;
    public static final int NEGOCIO_INICIAR_COMPRA					= 417;
    public static final int NEGOCIO_LISTAR_COMPRAS 					= 418;
    public static final int NEGOCIO_FINALIZAR_COMPRA				= 419;

    // Mostrar Reloj
    
    public static final int MOSTRAR_ALTA_RELOJ			 			= 221;
    public static final int MOSTRAR_BAJA_RELOJ						= 222;
    public static final int MOSTRAR_MOSTRAR_RELOJ					= 223;
    public static final int MOSTRAR_LISTAR_RELOJES	 				= 224;
    public static final int MOSTRAR_MODIFICAR_RELOJ			 		= 225;
    
    // Mostrar Cliente
    
    public static final int MOSTRAR_ALTA_CLIENTE		 			= 321;
    public static final int MOSTRAR_BAJA_CLIENTE					= 322;
    public static final int MOSTRAR_MOSTRAR_CLIENTE 				= 323;
    public static final int MOSTRAR_LISTAR_CLIENTES 				= 324;
    public static final int MOSTRAR_MODIFICAR_CLIENTE				= 325;
    
    // Mostrar Compra
    public static final int MOSTRAR_INICIAR_COMPRA					= 431;
    public static final int MOSTRAR_AGREGAR_PRODUCTO_COMPRA			= 432;
    public static final int MOSTRAR_ELIMINAR_PRODUCTO_COMPRA		= 433;
    public static final int MOSTRAR_DEVOLUCION_PRODUCTO_COMPRA		= 434;
    public static final int MOSTRAR_BAJA_COMPRA						= 435;
    public static final int MOSTRAR_MOSTRAR_COMPRA					= 436;
    public static final int MOSTRAR_GESTION_CARRITO_COMPRA			= 437;
    public static final int MOSTRAR_LISTAR_COMPRAS 					= 438;
    public static final int MOSTRAR_FINALIZAR_COMPRA				= 439;
    
    
    // Vista Query
    
    public static final int VENTANA_NUMERO_CLIENTES_QUERY			= 501;
    public static final int VENTANA_CANTIDAD_RELOJES_QUERY			= 502;
    
    // Negocio query
    
    public static final int NEGOCIO_NUMERO_CLIENTES_QUERY			= 511;
    public static final int NEGOCIO_CANTIDAD_RELOJES_QUERY			= 512;
    
    // Mostrar Query
    
    public static final int MOSTRAR_NUMERO_CLIENTES_QUERY			= 531;
    public static final int MOSTRAR_CANTIDAD_RELOJES_QUERY			= 532;
    
    
// Modulo JPA
    
    // Vista Departamento
    
    public static final int VENTANA_ALTA_DEPARTAMENTO	 			= 601;
    public static final int VENTANA_BAJA_DEPARTAMENTO				= 602;
    public static final int VENTANA_PRINCIPAL_DEPARTAMENTO	 		= 603;
    public static final int VENTANA_MOSTRAR_DEPARTAMENTO 			= 604;
    public static final int VENTANA_LISTAR_DEPARTAMENTOS			= 605;
    public static final int VENTANA_MODIFICAR_DEPARTAMENTO	 		= 606;
    public static final int VENTANA_CALCULAR_NOMINA_DEPARTAMENTO	= 607;
    
    // Vista Trabajador
    
    public static final int VENTANA_ALTA_TRABAJADOR			 		= 701;
    public static final int VENTANA_BAJA_TRABAJADOR					= 703;
    public static final int VENTANA_PRINCIPAL_TRABAJADOR 			= 704;
    public static final int VENTANA_MOSTRAR_TRABAJADOR 				= 705;
    public static final int VENTANA_LISTAR_TRABAJADORES				= 706;
    public static final int VENTANA_MODIFICAR_TRABAJADOR			= 707;
    
    // Vista Competencia
    
    public static final int VENTANA_ALTA_COMPETENCIA			 		= 801;
    public static final int VENTANA_BAJA_COMPETENCIA					= 802;
    public static final int VENTANA_PRINCIPAL_COMPETENCIA 				= 803;
    public static final int VENTANA_MOSTRAR_COMPETENCIA					= 804;
    public static final int VENTANA_LISTAR_COMPETENCIAS					= 805;
    public static final int VENTANA_MODIFICAR_COMPETENCIA				= 806;
    public static final int VENTANA_ASIGNAR_COMPETENCIA 				= 807;
    public static final int VENTANA_DESASIGNAR_COMPETENCIA				= 808;
    public static final int VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR		= 809;
    public static final int VENTANA_DESASIGNAR_COMPETENCIA_TRABAJADOR	= 810;
    public static final int VENTANA_ASIGNAR_NIVEL_COMPETENCIA			= 811;
    public static final int VENTANA_MOSTRAR_NIVEL_COMPETENCIA			= 812;
    public static final int VENTANA_LISTAR_NIVEL_COMPETENCIAS			= 813;
    
    // Negocio Departamento
    
    public static final int NEGOCIO_ALTA_DEPARTAMENTO				= 611;
    public static final int NEGOCIO_BAJA_DEPARTAMENTO				= 612;
    public static final int NEGOCIO_MOSTRAR_DEPARTAMENTO 			= 613;
    public static final int NEGOCIO_LISTAR_DEPARTAMENTOS			= 614;
    public static final int NEGOCIO_MODIFICAR_DEPARTAMENTO			= 615;
    public static final int NEGOCIO_CALCULAR_NOMINA_DEPARTAMENTO	= 616;
    
    // Negocio Trabajador
    
    public static final int NEGOCIO_ALTA_TRABAJADOR		 			= 711;
    public static final int NEGOCIO_BAJA_TRABAJADOR					= 712;
    public static final int NEGOCIO_MOSTRAR_TRABAJADOR 				= 713;
    public static final int NEGOCIO_LISTAR_TRABAJADORES				= 714;
    public static final int NEGOCIO_MODIFICAR_TRABAJADOR			= 715;
    
    // Negocio Competencia
    
    public static final int NEGOCIO_ALTA_COMPETENCIA 					= 821;
    public static final int NEGOCIO_BAJA_COMPETENCIA					= 822;
    public static final int NEGOCIO_MOSTRAR_COMPETENCIA					= 823;
    public static final int NEGOCIO_LISTAR_COMPETENCIAS					= 824;
    public static final int NEGOCIO_MODIFICAR_COMPETENCIA				= 825;
    public static final int NEGOCIO_ASIGNAR_COMPETENCIA_TRABAJADOR		= 826;
    public static final int NEGOCIO_DESASIGNAR_COMPETENCIA_TRABAJADOR	= 827;
    public static final int NEGOCIO_ASIGNAR_NIVEL_COMPETENCIA			= 828;
    public static final int NEGOCIO_MOSTRAR_NIVEL_COMPETENCIA			= 829;
    public static final int NEGOCIO_LISTAR_NIVEL_COMPETENCIAS			= 830;
    
    // Mostrar Departamento
    
    public static final int MOSTRAR_ALTA_DEPARTAMENTO	 			= 621;
    public static final int MOSTRAR_BAJA_DEPARTAMENTO				= 622;
    public static final int MOSTRAR_MOSTRAR_DEPARTAMENTO 			= 623;
    public static final int MOSTRAR_LISTAR_DEPARTAMENTOS 			= 624;
    public static final int MOSTRAR_MODIFICAR_DEPARTAMENTO		 	= 625;
    public static final int MOSTRAR_CALCULAR_NOMINA_DEPARTAMENTO 	= 626;
    
    // Mostrar Trabajador
    
    public static final int MOSTRAR_ALTA_TRABAJADOR		 			= 721;
    public static final int MOSTRAR_BAJA_TRABAJADOR					= 722;
    public static final int MOSTRAR_MOSTRAR_TRABAJADOR 				= 723;
    public static final int MOSTRAR_LISTAR_TRABAJADORES 			= 724;
    public static final int MOSTRAR_MODIFICAR_TRABAJADOR			= 725;
    public static final int MOSTRAR_CALCULAR_NOMINA_TRABAJADOR	 	= 726;
    
    // Mostrar Competencia
    
    public static final int MOSTRAR_ALTA_COMPETENCIA 					= 841;
    public static final int MOSTRAR_BAJA_COMPETENCIA					= 842;
    public static final int MOSTRAR_MOSTRAR_COMPETENCIA					= 843;
    public static final int MOSTRAR_LISTAR_COMPETENCIAS					= 844;
    public static final int MOSTRAR_MODIFICAR_COMPETENCIA				= 845;
    public static final int MOSTRAR_ASIGNAR_COMPETENCIA 				= 846;
    public static final int MOSTRAR_DESASIGNAR_COMPETENCIA				= 847;
    public static final int MOSTRAR_ASIGNAR_COMPETENCIA_TRABAJADOR		= 848;
    public static final int MOSTRAR_DESASIGNAR_COMPETENCIA_TRABAJADOR	= 849;
    public static final int MOSTRAR_ASIGNAR_NIVEL_COMPETENCIA			= 850;   
    public static final int MOSTRAR_MOSTRAR_NIVEL_COMPETENCIA			= 851;
    public static final int MOSTRAR_LISTAR_NIVEL_COMPETENCIAS			= 852;

    
}
