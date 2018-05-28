package EjercicioTaller;


public class Coche extends Vehiculos {

	private int nPlazas;
	private String estado;

	public Coche(String matricula, int nPlazas) {
		super(matricula);
		this.nPlazas = nPlazas;
		estado = "En espera";
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Coche [ Matrícula = "+getMatricula()+", nPlazas=" + nPlazas + ", estado=" + estado + "]";
	}


	
}
