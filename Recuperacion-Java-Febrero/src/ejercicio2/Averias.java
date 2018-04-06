package ejercicio2;

public class Averias {

	private int codigoAveria;
	private double costeAveria;
	private static int cont=0;
	public Averias() {
		super();
		codigoAveria = cont;
		costeAveria = (Math.random()*500+1);
		cont++;
	}
	public int getCodigoAveria() {
		return codigoAveria;
	}
	public void setCodigoAveria(int codigoAveria) {
		this.codigoAveria = codigoAveria;
	}
	public double getCosteAveria() {
		return costeAveria;
	}
	public void setCosteAveria(double costeAveria) {
		this.costeAveria = costeAveria;
	}
	public static int getCont() {
		return cont;
	}
	public static void setCont(int cont) {
		Averias.cont = cont;
	}
	@Override
	public String toString() {
		return "Averias [Codigo Avería=" + codigoAveria + ", Coste Avería=" + costeAveria + "]";
	}
	
}
