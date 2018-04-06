package HerenciaVideoclub;

import java.util.ArrayList;
import java.util.Date;

public class Videoclub {

	ArrayList<Director> listaDirectores;
	ArrayList<Pelicula> listaPeliculas;
	ArrayList<Socio> listaSocios;
	ArrayList<Alquiler> listaAlquileres;

	public Videoclub() {
		super();
		listaDirectores = new ArrayList<>();
		listaPeliculas = new ArrayList<>();
		listaSocios = new ArrayList<>();
		listaAlquileres = new ArrayList<>();
		Director dprueba = new Director("Almodovar", "España", "12/12/1992");
		Pelicula pprueba = new Pelicula("KEPASA", 10, dprueba);
		Pelicula pprueba2 = new Pelicula("HOLA", 20, dprueba);
		SocioNormal socio1 = new SocioNormal("50628221T", "Pablo", "Jose de Cadalso", 0);

		Alquiler alquiler1 = new Alquiler(socio1, pprueba, new Date(), new Date());
		listaAlquileres.add(alquiler1);
		listaDirectores.add(dprueba);
		listaPeliculas.add(pprueba);
		listaPeliculas.add(pprueba2);
		listaSocios.add(socio1);
	}

	public void altaPelicula() {

		System.out.println("Escribe el titulo de la pelicula");
		String tit = LeerTeclado.readString();

		System.out.println("Escribe el precio de la pelicula");
		double pre = LeerTeclado.readDouble();

		System.out.println("Escribe el director de la pelicula");
		String direc = LeerTeclado.readString();
		boolean encontrado = false;
		Director d1 = null;
		for (int i = 0; i < listaDirectores.size() && !encontrado; i++) {
			if (listaDirectores.get(i).getNombre().equalsIgnoreCase(direc)) {
				d1 = listaDirectores.get(i);
				encontrado = true;
			}
		}

		if (encontrado == false) {
			System.out.println("Hay que dar de alta a este director. Escribe su nacionalidad y fecha de nacimiento");

			String nac = LeerTeclado.readString();
			String fech = LeerTeclado.readString();
			d1 = new Director(direc, nac, fech);
			listaDirectores.add(d1);
		}
		Pelicula p = new Pelicula(tit, pre, d1);

		listaPeliculas.add(p);
		System.out.println("La película " + p + " se ha añadido a la lista");

	}

	public void bajaPelicula() {
		boolean encontrado = false;
		System.out.println("Elige la película a dar de baja.");
		visualizarListaPelis();
		int posicion = LeerTeclado.readInteger();
		for (int i = 0; i < listaAlquileres.size(); i++) {
			if (listaAlquileres.get(i).getPelicula().getTitulo()
					.equalsIgnoreCase(listaPeliculas.get(posicion - 1).getTitulo())) {
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("No se puede borrar esta película porque está alquilada.");
		} else {
			System.out.println("Se va a borrar la película: " + listaPeliculas.get(posicion - 1).getTitulo());
			listaPeliculas.remove(posicion - 1);
			visualizarListaPelis();
		}
	}

	public void altaSocio() {

		SocioNormal socio1;
		String dni;
		String nombre;
		String direccion;

		boolean encontrado = false;
		System.out.println("Escribe un DNI.");
		dni = LeerTeclado.readString();
		for (int i = 0; i < listaSocios.size(); i++) {
			if (listaSocios.get(i).getDni().equalsIgnoreCase(dni)) {
				encontrado = true;
			}

		}
		if (encontrado) {
			System.out.println("Este DNI ya está registrado");
		} else {
			System.out.println("Escribe un nombre.");
			nombre = LeerTeclado.readString();
			System.out.println("Escribe una direccion.");
			direccion = LeerTeclado.readString();
			socio1 = new SocioNormal(dni, nombre, direccion, 0);
			listaSocios.add(socio1);
			visualizarListaSocios();

		}
	}

	public void bajaSocio() {
		boolean encontrado = false;
		System.out.println("Elige el socio a dar de baja.");
		visualizarListaSocios();
		int posicion = LeerTeclado.readInteger();
		for (int i = 0; i < listaAlquileres.size(); i++) {
			if (listaAlquileres.get(i).getSocio().getDni().equalsIgnoreCase(listaSocios.get(posicion - 1).getDni())) {
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("No se puede borrar este socio porque tiene prestamos pendientes.");
		} else {
			System.out.println("Se va a borrar el socio con DNI: " + listaSocios.get(posicion - 1).getDni());
			listaSocios.remove(posicion - 1);
			visualizarListaSocios();
		}
	}

	public void nuevoAlquiler() {
		Alquiler alquiler1;
		SocioNormal socio1 = null;
		SocioVip socio2 = null;
		boolean encontrado = false;

		System.out.println("Introduce tu DNI");
		String dni = LeerTeclado.readString();

		for (int i = 0; i < listaSocios.size(); i++) {
			if (listaSocios.get(i) instanceof SocioNormal && listaSocios.get(i).getDni().equalsIgnoreCase(dni)) {

				socio1 = (SocioNormal) listaSocios.get(i);

			} else if (listaSocios.get(i) instanceof SocioVip && listaSocios.get(i).getDni().equalsIgnoreCase(dni)) {

				socio2 = (SocioVip) listaSocios.get(i);
			}
		}

		if (socio1 == null && socio2 == null) {

			System.out.println("Este socio no existe");

		} else if (socio1 != null) {

			if (!socio1.comprobarPeliculas()) {

				System.out.println("Este socio ya tiene 3 películas alquiladas. Ha llegado al límite");
			}

			System.out.println("Escribe el código de la película que quieras alquilar:");
			visualizarListaPelis();
			int cod = LeerTeclado.readInteger();
			for (int i = 0; i < listaAlquileres.size(); i++) {

				if (listaAlquileres.get(i).getPelicula().getCod() == cod) {

					encontrado = true;

				}
			}
				if (encontrado) {

					System.out.println("Esta película ya se encuentra en alquiler.");

				} else {

					alquiler1 = new Alquiler(socio1, listaPeliculas.get(cod-1), new Date(), new Date());
					listaAlquileres.add(alquiler1);
					for (int j = 0; j < socio1.getPeliculasSimultaneas().length; j++) {
						if (socio1.getPeliculasSimultaneas()[j] == null) {

							socio1.getPeliculasSimultaneas()[j] = listaPeliculas.get(cod-1).getTitulo();

						}

					}

				}

			

		} else {

			System.out.println("Escribe el código de la película que quieras alquilar:");
			visualizarListaPelis();
			int cod = LeerTeclado.readInteger();
			for (int i = 0; i < listaAlquileres.size(); i++) {

				if (listaAlquileres.get(i).getPelicula().getCod() == cod-1) {

					encontrado = true;

				}
				if (encontrado) {

					System.out.println("Esta película ya se encuentra en alquiler.");

				} else {

					alquiler1 = new Alquiler(socio2, listaPeliculas.get(cod-1), new Date(), new Date());
					listaAlquileres.add(alquiler1);

				}

			}
		}
	}

	public void visualizarListaPelis() {
		for (int i = 0; i < listaPeliculas.size(); i++) {
			System.out.println((i + 1) + ". " + listaPeliculas.get(i).getTitulo());
		}
	}

	public void visualizarListaSocios() {
		for (int i = 0; i < listaSocios.size(); i++) {
			System.out.println((i + 1) + ". " + listaSocios.get(i).getDni());
		}
	}
	
	public void visualizarListaAlquileres() {
		for (int i = 0; i < listaAlquileres.size(); i++) {
			System.out.println((i + 1) + ". " + listaAlquileres.get(i).getPelicula());
		}
	}


	public ArrayList<Director> getListaDirectores() {
		return listaDirectores;
	}

	public void setListaDirectores(ArrayList<Director> listaDirectores) {
		this.listaDirectores = listaDirectores;
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public ArrayList<Socio> getListaSocios() {
		return listaSocios;
	}

	public void setListaSocios(ArrayList<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}

	public ArrayList<Alquiler> getListaAlquileres() {
		return listaAlquileres;
	}

	public void setListaAlquileres(ArrayList<Alquiler> listaAlquileres) {
		this.listaAlquileres = listaAlquileres;
	}

	@Override
	public String toString() {
		return "Videoclub [listaDirectores=" + listaDirectores + ", listaPeliculas=" + listaPeliculas + ", listaSocios="
				+ listaSocios + ", listaAlquileres=" + listaAlquileres + "]";
	}

}
