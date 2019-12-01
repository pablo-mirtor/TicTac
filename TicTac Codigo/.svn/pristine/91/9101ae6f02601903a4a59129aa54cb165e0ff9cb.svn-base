package negocio.compra;

import java.util.ArrayList;

import presentacion.controlador.Contexto;

/**
 * Interfaz de la capa Negocio que define el SA de Compra
 */
public interface ServicioAplicacionCompra {
	public TransferCompra iniciarCompra(int id);
	public TransferLineaDeCompra agregarProducto(Contexto producto);
	public int finalizarCompra(TransferCompra tCompra);
	public int devolverProducto(TransferLineaDeCompra tLineaCompra);
	public TransferCompra mostrarCompra(int id);
	public ArrayList<TransferCompra> listarCompras();
}

