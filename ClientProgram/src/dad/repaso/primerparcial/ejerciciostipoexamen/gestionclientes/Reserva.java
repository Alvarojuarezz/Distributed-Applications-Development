package dad.repaso.primerparcial.ejerciciostipoexamen.gestionclientes;

public class Reserva {
	private String id_mat;
	private int cantidad;
	
	public Reserva(String id_mat, int cantidad) {
		this.id_mat = id_mat;
		this.cantidad = cantidad;
	}
	
	public String getId_mat() {
		return id_mat;
	}
	
	public void setId_mat(String id_mat) {
		this.id_mat = id_mat;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
