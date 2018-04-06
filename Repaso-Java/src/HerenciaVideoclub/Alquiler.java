package HerenciaVideoclub;

import java.util.Date;

public class Alquiler {

	Socio socio;
	Pelicula pelicula;
	Date fechaPrestamo, fechaDevolucion;
	public Alquiler(Socio socio, Pelicula pelicula, Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.socio = socio;
		this.pelicula = pelicula;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	@Override
	public String toString() {
		return "Alquiler [socio=" + socio + ", pelicula=" + pelicula + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
}
