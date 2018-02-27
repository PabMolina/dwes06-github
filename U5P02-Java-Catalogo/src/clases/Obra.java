package clases;

public class Obra {
	
	private int idObra;
	private String titulo;
	private int año;
	private int idAutor;
	private String imagen;
	
	public Obra(int idObra, String titulo, int año, int idAutor, String imagen) {
		super();
		this.idObra = idObra;
		this.titulo = titulo;
		this.año = año;
		this.idAutor = idAutor;
		this.imagen = imagen;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Obra [idObra=" + idObra + ", titulo=" + titulo + ", año=" + año + ", idAutor=" + idAutor + ", imagen="
				+ imagen + "]";
	}

}
