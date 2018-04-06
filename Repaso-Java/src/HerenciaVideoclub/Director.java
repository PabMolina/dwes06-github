package HerenciaVideoclub;

public class Director {

	String nombre, nacionalidad;
	String fechaNacimiento;
	public Director(String nombre, String nacionalidad, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
