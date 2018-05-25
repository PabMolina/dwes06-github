package ejercicioInterfaces;

public class ListArray implements IListInt {
	int [] elementos;
	int numElem; //Atributo que cuenta los elementos introducidos en el array 
	
	public ListArray (int tamanyo) {
		this.elementos=new int [tamanyo];
		numElem=0;
	}


	public void addFirst(int newElem) {
		if (getSize()==elementos.length)
			System.out.println("El array est� lleno");
		else {
			for (int i=getSize()-1; i>=0;i--) //Desplazamos a la derecha empezando por el �ltimo 
				elementos[i+1]=elementos[i];
			elementos[0]=newElem;
			numElem++;
		}
	}

	
	public void addLast(int newElem) {
		if (getSize()<elementos.length) {
			elementos[numElem]=newElem;
			numElem++;
		}
		else 
			System.out.println("El array est� lleno");
	}

	
	public void removeFirst() {
		if (isEmpty())
			System.out.println("El array est� vac�o");
		else {
			for (int i=1; i<getSize(); i++) //Desplazamos desde el principio hacia la izquierda
				elementos[i-1]=elementos[i];
				elementos[numElem-1]=0;
				numElem--;
		}	
	}

	
	public void removeLast() {
		if (!isEmpty()) {
			elementos[numElem-1]=0;
			numElem--;
		}
		else 
			System.out.println("El array est� vac�o");
	}
	
	
	public void insertAt(int index, int newElem) {
		if (getSize()==elementos.length)
			System.out.println("El array est� lleno");
		else if (index<0 || index>=elementos.length)
			System.out.println("El �ndice est� fuera de rango, debe estar entre 0 y " + (elementos.length-1));
		else {
			for (int i=getSize()-1; i>=index;i--) //Desplazo hacia la derecha empezando por el final hasta index
				elementos[i+1]=elementos[i];
			elementos[index]=newElem;
			numElem++;
		}	
	}

	
	public boolean isEmpty() {
		return (numElem==0);
	}

	
	public boolean contains(int elem) {
		for (int i=0; i<getSize();i++)
			if(elementos[i]==elem)
				return true;
		return false;
		//return (getIndexOf(elem)==-1); tambi�n podr�a haberse hecho as�
	}

	
	public int getSize() {
		return numElem;
	}

	
	public int getIndexOf(int elem) { //Devuelve la posici�n donde est� el elemento � -1 si no lo encuentra
		for (int i=0; i<getSize();i++)
			if(elementos[i]==elem)
				return i;
		return -1;
	}

	
	public int getFirst() {
		if (!isEmpty())
			return elementos[0];
		else
			return -1;
	}

	
	public int getLast() {
		if (!isEmpty())
			return elementos[getSize()-1];
		else
			return -1;
	}

	public String toString() { //Devuelve una cadena con todo el contenido del array
		String salida="";
		for (int i=0; i<getSize(); i++) {
			salida+=elementos[i]+" ";
		}
		return salida;
	}

	public void removeAll(int elem) { //borra todos los elementos que sean iguales a elem
		if (isEmpty())
			System.out.println("El array est� vac�o");
		else 
			for (int i=0; i<getSize();i++) {
				if (elementos[i]==elem) {
					for (int j=i+1; j<getSize(); j++) 
						elementos[j-1]=elementos[j]; //Desplaza a la izquierda toda las posiciones a partir del i donde encontramos el elemento
					elementos[getSize()-1]=0; //el �ltimo elemento debemos eliminarlo, por ello, lo rellenamos con 0
					numElem--;
					i--; //Despu�s del desplazamiento hay que volver a evaluar el contenido de la posici�n i por si fuera igual a elem
				}		}		
	}

	
	public void removeAt(int index) {
		if (isEmpty())
			System.out.println("El array est� vac�o");
		else {
			for (int i=index+1; i<getSize(); i++)
				elementos[i-1]=elementos[i];
				elementos[getSize()-1]=0; //el �ltimo elemento debemos eliminarlo, por ello, lo rellenamos con 0
				numElem--;
		}	
	}



}