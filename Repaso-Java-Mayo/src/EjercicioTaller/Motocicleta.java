package EjercicioTaller;

public class Motocicleta extends Vehiculos {

	private int cilindrada;
	private String estado;

	public Motocicleta(String matricula, int cilindrada) {
		super(matricula);
		this.cilindrada = cilindrada;
		estado = "En espera";
	}

	public int getCc() {
		return cilindrada;
	}

	public void setCc(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Motocicleta [cilindrada=" + cilindrada + ", estado=" + estado + "]";
	}

	
	
}
