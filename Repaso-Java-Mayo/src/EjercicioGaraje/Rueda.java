package EjercicioGaraje;

public class Rueda {

	
	private String nombre;
	private boolean pinchada;
	
	public Rueda(String nombre, boolean pinchada) {
		
		this.nombre = nombre;
		this.pinchada = pinchada;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPinchada() {
		return pinchada;
	}

	public void setPinchada(boolean pinchada) {
		this.pinchada = pinchada;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", pinchada=" + pinchada + "]";
	}
	
}
