package HerenciaVideoclub;

import java.util.Date;

public class SocioVip extends Socio {

	Date fechaVip;

	public SocioVip(String dni, String nombre, String direccion, int numeroPeliculas, Date fechaVip) {
		super(dni, nombre, direccion, numeroPeliculas);
		this.fechaVip = fechaVip;
	}

	public Date getFechaVip() {
		return fechaVip;
	}

	public void setFechaVip(Date fechaVip) {
		this.fechaVip = fechaVip;
	}

	@Override
	public String toString() {
		return "SocioVip [fechaVip=" + fechaVip + "]";
	}
	
}
