package EjercicioTaller;

public class Motocicleta extends Vehiculos {

	private int cilindrada;

	public Motocicleta(String matricula, int cilindrada) {
		super(matricula);
		this.cilindrada = cilindrada;
	}

	public int getCc() {
		return cilindrada;
	}

	public void setCc(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Motocicleta [matrícula =" +getMatricula()+ ", cilindrada=" + cilindrada + "]";
	}
	
}
