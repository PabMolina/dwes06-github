package Figuras;

public class Circunferencia extends Figura{

	double radio;
	
	public Circunferencia(String titulo,Color color,double radio){
		super(titulo,color);
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	/**
	 * Método para calcular el área de la circunferencia
	 * @return el area de la figura 
	 */
	public double calcularArea(){
		return (Math.PI*Math.pow(radio, 2));
	}
	/**
	 * Método para calcular el perímetro de la circunferencia
	 * @return el perímetro de la circunferencia
	 */
	public double calcularPerimetro(){
		return 2*Math.PI*radio;
	}

	@Override
	public String toString() {
		return super.toString()+" Circunferencia [radio=" + radio + "]";
	}
	
	
	
}
