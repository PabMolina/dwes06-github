package ejercicioInterfaces;

public class Principal {

	public static void main(String[] args) {
		ListArray la= new ListArray (5); 
		System.out.println("Intentamos eliminar el primer elemento cuando el array esta vac�o:");
		la.removeFirst();
		System.out.println("Introducimos un elemento al principio:");
		la.addFirst(3); 
		System.out.println(la.toString());
		la.addFirst(5);
		System.out.println(la.toString());
		la.addFirst(7);
		System.out.println(la.toString());
		System.out.println("Introducimos un elemento al final:");
		la.addLast(9);
		System.out.println(la.toString());
		la.addLast(2);
		System.out.println(la.toString());
		System.out.println("Introducimos un elemento al final, pero el array est� lleno:");
		la.addLast(1);
		System.out.println(la.toString());
		System.out.println("Introducimos un elemento al principio, pero el array est� lleno:");
		la.addFirst(6);
		System.out.println(la.toString());
		System.out.println("El primero es "+la.getFirst());
		System.out.println("El ultimo es "+la.getLast());
		System.out.println("El elemento 2 est� en la posici�n "+la.getIndexOf(2));
		System.out.println("El elemento 5 est� en la posici�n "+la.getIndexOf(5));
		System.out.println("El elemento 10 est� en la posici�n "+la.getIndexOf(10));
		System.out.println("Borramos el primer elemento");
		la.removeFirst();
		System.out.println(la.toString());
		System.out.println("Borramos el �ltimo");
		la.removeLast();
		System.out.println(la.toString());
		System.out.println("Introducimos el 3 en la posici�n 1:");
		la.insertAt(1, 3);
		System.out.println("Introducimos el 3 al principio:");
		la.addFirst(3);	
		System.out.println(la.toString());
		System.out.println("Borramos todos los 3");
		la.removeAll(3);
		System.out.println(la.toString());
	
		
	}

}
