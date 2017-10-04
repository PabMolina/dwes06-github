package Figuras;

public abstract class Figura {

	enum colores {rojo,azul,amarillo,verde,naranja};
	String titulo;
	private colores col;
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	
	public Figura(String titulo, colores col) {
		this.col=col;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Figura [titulo=" + titulo + "]";
	}
	
	
	
			
}
