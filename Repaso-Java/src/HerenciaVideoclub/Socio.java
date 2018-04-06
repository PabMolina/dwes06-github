package HerenciaVideoclub;

public abstract class Socio {
	
	String dni;
	String nombre, direccion;
	int numeroPeliculas;
	public Socio(String dni, String nombre, String direccion, int numeroPeliculas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroPeliculas = numeroPeliculas;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumeroPeliculas() {
		return numeroPeliculas;
	}
	public void setNumeroPeliculas(int numeroPeliculas) {
		this.numeroPeliculas = numeroPeliculas;
	}

}
