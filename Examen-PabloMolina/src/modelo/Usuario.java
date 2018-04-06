package modelo;

public class Usuario {

	private String login, password, nombre, direccion;
	private double gasto;
	public Usuario(String login, String password, String nombre, String direccion, double gasto) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.direccion = direccion;
		this.gasto = gasto;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public double getGasto() {
		return gasto;
	}
	public void setGasto(double gasto) {
		this.gasto = gasto;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", gasto=" + gasto + "]";
	}
	
}
