package EjercicioGaraje;

public class Garaje {

	private String direccion;
	private int capacidad;
	private Vehiculo[] coches;

	public Garaje(String direccion, int capacidad) {

		this.direccion = direccion;
		this.capacidad = capacidad;
		this.coches = new Vehiculo[capacidad];

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Vehiculo[] getCoches() {
		return coches;
	}

	public void setCoches(Vehiculo[] coches) {
		this.coches = coches;
	}

	public void aparcar(Vehiculo v) {

		for (int i = 0; i < coches.length; i++) {

			if (coches[i] == null) {
				coches[i] = v;
				System.out.println("El coche " + v + " se ha aparcado en la plaza número " + (i + 1) + ".");
				break;
			}

		}
		v.cambiarRuedas();

	}

	public void salir(String v) {

		Vehiculo s = null;

		for (int i = 0; i < coches.length; i++) {

			if (coches[i] != null) {
				if (coches[i].getMatricula().equalsIgnoreCase(v)) {

					s = coches[i];
					coches[i] = null;
					System.out.println("El coche " + s + " ha salido del garaje y ha dejado libre la plaza " + (i + 1));
					break;
				}
			}else
				System.out.println("El coche no existe");
		}

	}
	public Vehiculo buscar(String matricula) {

		Vehiculo v = null;

		for (int i = 0; i < coches.length; i++) {

			if (coches[i] != null) {
				if (coches[i].getMatricula().equalsIgnoreCase(matricula)) {
					v = coches[i];

				}
			}
		}
		return v;
	}
	
	

}
