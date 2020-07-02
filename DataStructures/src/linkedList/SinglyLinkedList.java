package linkedList;

/**
 * 
 * @author Liam Tomson-Moylan
 * 
 * A singly-linked list data structure with a head and tail
 *
 * @param <E> The Class Type to be specified for the Linked List Data Structure
 */
public class SinglyLinkedList <E> implements LinkedListADT<E> {

	/*
	 * head.getNext always points to the first node if
	 * the list isn't empty (otherwise null).
	 * head itself should always be null and never
	 * assigned. Tracks existence of Linked List.
	 */
	private final Node<E> HEAD;
	
	private int size;
	private Node<E> tail;
	
	public SinglyLinkedList() {
		
		HEAD = new Node<E>();
		size = 0;
		tail = null;
	}
	
	@Override
	/**
	 * Adds item to the end of the List.
	 * @param item
	 *            the item to add
	 * @throws IllegalArgumentException
	 *             if item is null
	 */
	public void add(E item) {
		
		if (null == item) {
			
			throw new IllegalArgumentException("Cannot add nulls to the Singly Linked List");
		}
		else {
			
			if (size == 0) {
				
				tail = new Node<E>(item);
				HEAD.setNext(tail);
			}
			else {
				
				tail.setNext(new Node<E>(item));
				tail = tail.getNext();
			}
			
			size++;
		}
	}
	
	@Override
	 /**
	 * Adds item at position pos in the List, moving the items originally in
	 * positions pos through size() - 1 one place to the right to make room.
	 * 
	 * @param pos
	 *            the position at which to add the item
	 * @param item
	 *            the item to add
	 * @throws IllegalArgumentException
	 *             if item is null
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than size(), please check
	 *             this exception before IllegalArgumentException.
	 */
	public void add(int pos, E item) {
		
		if (pos > size) {
			
			throw new IndexOutOfBoundsException("Position is invalid, greater than Linked List Size.");
		}
		else if (pos < 0) {
			
			throw new IndexOutOfBoundsException("Position cannot be negative in a linked list.");
		}
		else if (null == item) {
			
			throw new IllegalArgumentException("Cannot add nulls to the Singly Linked List");
		}
		
		if (pos == size) {
			
			add(item);
		}
		else if (pos == 0) {
			
			Node<E> current = HEAD.getNext();
			Node<E> new_node = new Node<E>(current, item);
			HEAD.setNext(new_node);
			new_node.setNext(current);
			size++;
		}
		else {
			
			Node<E> current = HEAD.getNext();
			
			for (int i = 0; i < pos; i++) {
				
				current = current.getNext();
			}
			
			current.setNext(new Node<E>(current.getNext(), item));
			size++;
		}
	}
	
	@Override
	/**
	 * Returns the item at position pos in the List. Index range: [0,size()-1].
	 * 
	 * @param pos
	 *            the index [0,size()-1] position of the item to return
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than or equal to size()
	 */
	public E get(int pos) {
		
		return getNode(pos).getData();
	}
	
	/**
	 * 
	 * @param pos
	 * 			the index [0,size()-1] position of the DoubleNode to return
	 * @return the node at position pos
	 */
	protected Node<E> getNode(int pos) {
		
		if (pos < 0) {
			
			throw new IndexOutOfBoundsException("index " + pos + " is less than 0 and is invalid in a Linked List.");
		}
		else if (pos >= size) { // pos >= size
			
			throw new IndexOutOfBoundsException("index "+ pos + " is greater than the bounds of the Linked List.");
		}
		else {
			
			Node<E> current = HEAD.getNext();
			
			for (int i = 0; i < pos; i++) {
				
				current = current.getNext();
			}
			
			return current;
		}
	}
	
	@Override
	/**
	 * Removes and returns the item at position pos in the List, moving the
	 * items originally in positions pos+1 through size() - 1 one place to the
	 * left to fill in the gap.
	 * 
	 * @param pos
	 *            the position at which to remove the item
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException
	 *             if pos is less than 0 or greater than or equal to size()
	 */
	public E remove(int pos) {
		
		if (pos >= size) {
			
			throw new IndexOutOfBoundsException("Position [" + pos + "] is invalid, greater than or equal to Linked List Size."
													+ "Linked List uses zero-indexing.");
		}
		else if (pos < 0) {
			
			throw new IndexOutOfBoundsException("Position [" + pos + "] cannot be negative in a linked list.");
		}
		
		Node<E> current = HEAD.getNext();
		E data = current.getData();
		
		if (pos == 0) {
			
			HEAD.setNext(current.getNext());
			size--;
			
			return data;
		}
		else {
			
			for (int i = 0; i < pos-1; i++) {
				
				current = current.getNext();
			}
			
			data = current.getNext().getData();
			current.setNext(current.getNext().getNext());
			size--;
			
			if (pos == size-1) { //reset tail if necessary
				
				tail = current;
			}
			
			return data;
		}
	}

	
	@Override
	/**
	 * @param item the item to be checked if it is contained within a Node in the Linked list.
	 * @return whether the item is contained in a node within the Singly-Linked List.
	 */
	public boolean contains(E item) {
		
		Node<E> current = HEAD.getNext();
		
		if (isEmpty()) {
			
			return false;
		}
		else {
			
			while (null != current) {
				
				if (current.getData().equals(item)) {

					return true;
				}
				else {
					
					current = current.getNext();
				}
			}
		}
		
		return false;
	}
	
	@Override
	/**
	 * @return the number of items in the List
	 */
	public int size() {
		
		return size;
	}
	
	@Override
	/**
	 * @return true if the List is empty, false otherwise
	 */
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	@Override
	/**
	 * @return returns an iterator over elements of the generic type specified
	 */
	public LinkedListIterator<E> iterator() {
		
		return new LinkedListIterator<E>(HEAD);
	}
}
