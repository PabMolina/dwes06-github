package EjercicioTaller;


public class Coche extends Vehiculos {

	private int nPlazas;

	public Coche(String matricula, int nPlazas) {
		super(matricula);
		this.nPlazas = nPlazas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" +getMatricula()+ "nPlazas=" + nPlazas + "]";
	}
	
}
