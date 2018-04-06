package EjercicioGaraje;

import java.util.Arrays;

import HerenciaVideoclub.LeerTeclado;

public  class Vehiculo {

	private String matricula;
	private String marca;
	private String modelo;
	private int numRuedas;
	private Rueda[] ruedas;

	public Vehiculo(String matricula, String marca, String modelo, int numRuedas) {

		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.numRuedas = numRuedas;
		ruedas = new Rueda[numRuedas];

		String n, ans;
		boolean sw = false;

		for (int i = 0; i < ruedas.length; i++) {

			System.out.println("Rueda" + (i+1));
			n ="Rueda " + (i+1);
			System.out.println("¿Está pinchada? si/no");
			ans = LeerTeclado.readString();
			if (ans.equalsIgnoreCase("si")) {
				sw = true;
			} else {
				sw = false;
			}
			ruedas[i] = new Rueda(n, sw);
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public Rueda[] getRuedas() {
		return ruedas;
	}

	public void cambiarRuedas() {

		String n;

		for (int i = 0; i < ruedas.length; i++) {
			if (ruedas[i].isPinchada() == true) {
				System.out.println("La rueda "+(i+1)+" estaba pinchada. Ha sido sustituida.");
				n = "Rueda " + (i+1);
				ruedas[i] = new Rueda(n, false);
				System.out.println(ruedas[i].toString());
				
			} else
				System.out.println(ruedas[i].toString());

		}
	}

	@Override
	public String toString() {
		return "matricula: " + matricula + ", marca: " + marca
				+ ", modelo: " + modelo + ", numRuedas: " + numRuedas
				+ ", ruedas: " + Arrays.toString(ruedas);
	}

}
