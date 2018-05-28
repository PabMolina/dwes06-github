package ejercicioGasolinera;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ColaCoches {

	Queue<Coche> colaCoches;
	public ColaCoches() {
		
		colaCoches = new Queue<Coche>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Iterator<Coche> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(Collection<? extends Coche> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Coche remove() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Coche poll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Coche peek() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean offer(Coche e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Coche element() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean add(Coche e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	
	
}
