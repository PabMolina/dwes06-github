package HerenciaVideoclub;

public class SocioNormal extends Socio {

	private String[] peliculasSimultaneas;

	public SocioNormal(String dni, String nombre, String direccion, int numeroPeliculas) {
		super(dni, nombre, direccion, numeroPeliculas);
		this.peliculasSimultaneas = new String[3];
	}

	public String[] getPeliculasSimultaneas() {
		return peliculasSimultaneas;
	}

	public void setPeliculasSimultaneas(String[] peliculasSimultaneas) {
		this.peliculasSimultaneas = peliculasSimultaneas;
	}

	public boolean comprobarPeliculas() {
		boolean encontrado = false;
		for (int i = 0; i < peliculasSimultaneas.length; i++) {
			if (peliculasSimultaneas[i] == null) {
				encontrado = true;
			}

		}
		return encontrado;
	}

	

}
