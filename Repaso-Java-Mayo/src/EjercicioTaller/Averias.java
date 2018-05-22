package EjercicioTaller;

public class Averias {

	private int codAveria;
	private double costeAveria;
	private static int cont=0;
	
	public Averias() {
		
		codAveria = cont;
		costeAveria = (Math.random()*500+1);
		cont++;
		
	}

	public int getCodAveria() {
		return codAveria;
	}

	public void setCodAveria(int codAveria) {
		this.codAveria = codAveria;
	}

	public double getCosteAveria() {
		return costeAveria;
	}

	public void setCosteAveria(double costeAveria) {
		this.costeAveria = costeAveria;
	}

	@Override
	public String toString() {
		return "Averias [codAveria=" + codAveria + ", costeAveria=" + costeAveria + "]";
	}
	
	
}
