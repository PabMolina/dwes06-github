package ejercicioGasolinera;

import java.util.ArrayList;

public class Gasolinera {

	ArrayList<Surtidor> listaSurtidores;

	public Gasolinera() {

		listaSurtidores = new ArrayList<Surtidor>();
	}

	// ----------------------------------ALTA
	// COCHE-----------------------------------------------
	public void altaCoche() {

		String mat, mod, marca;
		Coche c = null;
		boolean encontrado = false;
		Surtidor sAux = null;
		Surtidor surAux = null;
		int min = 100;

		System.out.println("Introduce una matricula");
		mat = LeerTeclado.readString();
		System.out.println("Introduce un modelo");
		mod = LeerTeclado.readString();
		System.out.println("Introduce una marca");
		marca = LeerTeclado.readString();

		c = new Coche(mat, mod, marca);
		// Recorremos la lista de surtidores para buscar un surtidor libre
		for (Surtidor s : listaSurtidores) {

			if (s.isLibre()) {

				sAux = s;
				encontrado = true;
				break;
			}
		}
		if (encontrado) {

			sAux.setLibre(false);
			sAux.setCocheRespostando(c);
			System.out.println("El coche " + c.toString() + " está repostando en el surtidor " + sAux.getCodigo());

		} else { // Si no hay ninguno libre...
			System.out.println("No hay ningún surtidor libre en estos momentos.");
			// Buscamos el surtidor con la cola mas vacía, para meter el coche.
			for (Surtidor s : listaSurtidores) {

				if (s.getColaCochesSurtidor().size() < min) {
					min = s.getColaCochesSurtidor().size();
					surAux = s;

				}
			}
			surAux.colaCochesSurtidor.offerLast(c);
			System.out.println("Su coche estará esperando en la cola del surtidor " + surAux.getCodigo());

		}
	}

	public void bajaCoche() {

		String mat;
		Coche cAux = null;
		boolean encontrado = false;

		System.out.println("Introduce una matrícula.");
		mat = LeerTeclado.readString();

		for (Surtidor s : listaSurtidores) {

			if (s.getCocheRespostando().getMatricula().equalsIgnoreCase(mat)) {

				s.setCocheRespostando(null);
				encontrado = true;

				if (!s.getColaCochesSurtidor().isEmpty()) {

					cAux = s.getColaCochesSurtidor().poll();
					s.setCocheRespostando(cAux);
					System.out.println("El coche " + cAux + " ha dejado la cola y está repostando en el surtidor "
							+ s.getCodigo());

				} else {
					s.isLibre();
					System.out.println("El surtidor" + s.getCodigo()
							+ "se encuentra vacío y disponible, ya que no hay más coches en la cola.");

				}

			}

		}
		if (!encontrado) {
			System.out.println("No hay ningún coche repostando con esa matrícula");
		}

	}
	
	public void listadoGeneral() {
		
		for (Surtidor s : listaSurtidores) {
			
			System.out.println(s.toString());
			
		}
	}

	public ArrayList<Surtidor> getListaSurtidores() {
		return listaSurtidores;
	}

	public void setListaSurtidores(ArrayList<Surtidor> listaSurtidores) {
		this.listaSurtidores = listaSurtidores;
	}

	@Override
	public String toString() {
		return "Gasolinera [listaSurtidores=" + listaSurtidores + "]";
	}

}
