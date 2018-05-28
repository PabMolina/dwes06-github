package ejercicioGasolinera;

import java.util.LinkedList;

public class Surtidor {

	private boolean libre;
	private Coche cocheRespostando;
	private int codigo;
	static int cont = 1;
	LinkedList<Coche>colaCochesSurtidor;
	
	
	

	public Surtidor() {
		
		libre = true;
		cocheRespostando = null;
		codigo = cont++;
		colaCochesSurtidor = new LinkedList<Coche>();
	
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Coche getCocheRespostando() {
		return cocheRespostando;
	}

	public void setCocheRespostando(Coche cocheRespostando) {
		this.cocheRespostando = cocheRespostando;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

	public LinkedList<Coche> getColaCochesSurtidor() {
		return colaCochesSurtidor;
	}

	public void setColaCochesSurtidor(LinkedList<Coche> colaCochesSurtidor) {
		this.colaCochesSurtidor = colaCochesSurtidor;
	}

	@Override
	public String toString() {
		return "Surtidor "+codigo+" [libre=" + libre + ", cocheRespostando=" + cocheRespostando + " colaCochesSurtidor=" + colaCochesSurtidor.toString() + "]";
	}
	
	
}
