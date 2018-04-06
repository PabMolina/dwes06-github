package ejercicio2;

public class Coches extends Vehiculos{
	
	private int nPlazas;

	public Coches(String matricula, String estado, int nPlazas) {
		super(matricula, estado);
		this.nPlazas=nPlazas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	@Override
	public String toString() {
		return "Coches [nPlazas=" + nPlazas + "]";
	}

}
