package HerenciaVideoclub;

public class Pelicula {

	int cod;
	String titulo;
	double precio;
	Director dir;
	static int cont=1;
	
	
	public Pelicula(String titulo, double precio, Director dir) {
		super();
		
		cod = cont;
		this.titulo = titulo;
		this.precio = precio;
		this.dir = dir;
		cont++;
	}


	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Director getDir() {
		return dir;
	}

	public void setDir(Director dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Pelicula [cod=" + cod + ", titulo=" + titulo + ", precio=" + precio + ", dir=" + dir.getNombre() + "]";
	}
}
