package dad.repaso.primerparcial.ejerciciostipoexamen.gestionclientes;

public class Material {
	private String id;
	private int cantidad;
	private String descripcion;
	protected static int contador=0;
	
	public Material(String id, int cantidad, String descripcion) {
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
