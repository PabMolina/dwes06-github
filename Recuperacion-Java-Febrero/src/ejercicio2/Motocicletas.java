package ejercicio2;

public class Motocicletas extends Vehiculos{
	
	private int cilindrada;

	public Motocicletas(String matricula, String estado, int cilindrada) {
		super(matricula, estado);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Motocicletas [cilindrada=" + cilindrada + "]";
	}

}
