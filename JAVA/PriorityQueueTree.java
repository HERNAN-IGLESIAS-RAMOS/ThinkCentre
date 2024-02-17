package estDatos;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueueTree<E> extends AbstractQueue<E> {
	private RedBlackTree<E> data;				// almacenamiento

	/**
	 * Crea una cola de prioridad vacía. La prioridad de los elementos
	 * de la cola es el orden natural del tipo E.
	 * @trhows ClassCastException si el tipo E no es Comparable
	 */
	public PriorityQueueTree() {
		this.data = new RedBlackTree<>();
	}
	
	/**
	 * Crea una cola de prioridad vacía. La prioridad de los elementos
	 * de la cola está dada por el comparador proporcionado.
	 * @param cmp establece la prioridad de esta cola
	 */
	public PriorityQueueTree(Comparator<? super E> cmp) {
		this.data = new RedBlackTree<>(cmp);
	}
	
	/**
	 * Crea una cola añadiendo a ésta los elementos de la colección
	 * colección que se especifica. Los elementos se añaden a la
	 * cola en el orden en que se obtienen al iterar la colección
	 * especificada.
	 * @param c colección que contiene los elementos a añadir a
	 * esta cola
	 * @trhows ClassCastException si el tipo E no es Comparable
	 */
	public PriorityQueueTree(Collection<? extends E> c) {
		this();
		if (c == null) {
			throw new NullPointerException();
		}
		this.addAll(c);
	}
	
	/**
	 * Crea una cola añadiendo a ésta los elementos de la colección
	 * colección que se especifica. Los elementos se añaden a la
	 * cola en el orden en que se obtienen al iterar la colección
	 * especificada.
	 * @param c colección que contiene los elementos a añadir a esta
	 * cola
	 * @param cmp establece la prioridad de esta cola 
	 */
	public PriorityQueueTree(Collection<? extends E> c,
			Comparator<? super E> cmp) {
		this(cmp);
		this.addAll(c);
	}
	
	/**
	 * Retorna el comparador que establece la prioridad de esta cola.
	 * Si la prioridad es el orden natural del tipo de los elementos
	 * de la cola, retornará {@code null}
	 * @return el comparador que establece la prioridad, {@code null}
	 * si la prioridad es el orden natural de sus elementos
	 */
	public Comparator<? super E> comparator() {
		return data.comparator();
	}

	/**
	 * @see java.util.Queue#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		this.data.add(e);
		return true;
	}

	/**
	 * @see java.util.Queue#poll()
	 */
	@Override
	public E poll() {
		if (data.isEmpty()) {
			return null;
		}
		
		Iterator<E> itr = data.iterator();
		E temp = itr.next();
		itr.remove();
		
		return temp;
	}

	/**
	 * @see java.util.Queue#peek()
	 */
	@Override
	public E peek() {
		if (data.isEmpty()) {
			return null;
		}
		
		return data.iterator().next();
	}

	/**
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return data.iterator();
	}

	/**
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return data.size();
	}

}
