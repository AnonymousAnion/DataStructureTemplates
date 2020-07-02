package linkedList;

/**
 * 
 * @author Liam Tomson-Moylan
 * 
 * A doubly-linked list data structure with a head and tail
 *
 * @param <E> The Class Type to be specified for the Linked List Data Structure
 */
public class DoublyLinkedList <E> implements LinkedListADT <E> {

	/*
	 * head.getNext always points to the first node if
	 * the list isn't empty (otherwise null).
	 * head itself should always be null and never
	 * assigned. Tracks existence of Linked List.
	 */
	private final DoubleNode<E> HEAD;
	
	private int size;
	private DoubleNode<E> tail;
	
	public DoublyLinkedList() {
		
		HEAD = new DoubleNode<E>();
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
			
			throw new IllegalArgumentException("Cannot add nulls to the Doubly Linked List");
		}
		else {
			
			if (size == 0) {
				
				tail = new DoubleNode<E>(item);
				HEAD.setNext(tail);
			}
			else {
				
				tail.setNext(new DoubleNode<E>(tail, null, item));
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
		
		//TODO Optimize by traversing from optimal end!
		
		if (pos > size) {
			
			throw new IndexOutOfBoundsException("Position is invalid, greater than Linked List Size.");
		}
		else if (pos < 0) {
			
			throw new IndexOutOfBoundsException("Position cannot be negative in a linked list.");
		}
		else if (null == item) {
			
			throw new IllegalArgumentException("Cannot add nulls to the Doubly Linked List");
		}
		
		if (pos == size) {
			
			add(item);
		}
		else if (pos == 0) {
			
			DoubleNode<E> current = HEAD.getNext();
			DoubleNode<E> new_node = new DoubleNode<E>(current, item);
			current.setPrev(new_node);
			HEAD.setNext(new_node);
			size++;
		}
		else {
			
			DoubleNode<E> current;
			
			//Navigate to the node from the more efficient end
			if (pos < size/2) {
				
				current = HEAD.getNext();
				
				for (int i = 0; i < pos; i++) {
					
					current = current.getNext();
				}
			}
			else {
				
				current = tail;
				
				for (int i = size-1; i > pos; i--) {
					
					current = current.getPrev();
				}
			}

			current.setNext(new DoubleNode<E>(current, current.getNext(), item));
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
	protected DoubleNode<E> getNode(int pos) {
		
		if (pos < 0) {
			
			throw new IndexOutOfBoundsException("index " + pos + " is less than 0 and is invalid in a Linked List.");
		}
		else if (pos >= size) { // pos >= size
			
			throw new IndexOutOfBoundsException("index "+ pos + " is greater than the bounds of the Linked List.");
		}
		else {
			
			DoubleNode<E> current;
			
			//Navigate to the node from the more efficient end
			if (pos < size/2) {
				
				current = HEAD.getNext();
				
				for (int i = 0; i < pos; i++) {
					
					current = current.getNext();
				}
			}
			else {
				
				current = tail;
				
				for (int i = size-1; i > pos; i--) {
					
					current = current.getPrev();
				}
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
	
	//TODO FINSIH
	public E remove(int pos) {
		
		if (pos >= size) {
			
			throw new IndexOutOfBoundsException("Position [" + pos + "] is invalid, greater than or equal to Linked List Size."
													+ "Linked List uses zero-indexing.");
		}
		else if (pos < 0) {
			
			throw new IndexOutOfBoundsException("Position [" + pos + "] cannot be negative in a linked list.");
		}
		
		DoubleNode<E> current = HEAD.getNext();
		E data = current.getData();
		
		if (pos == 0) {
			
			HEAD.setNext(current.getNext());
			
			if (size > 1) {
				
				current.getNext().setPrev((null));
			}
			
			size--;
			
			return data;
		}
		else {
			
			//Navigate to the node from the more efficient end
			if (pos < size/2) {
				
				current = HEAD.getNext();
				
				for (int i = 0; i < pos; i++) {
					
					current = current.getNext();
				}
				
				data = current.getData();
				
				if (null != current.getNext()) {
					
					current.getNext().setPrev(current.getPrev());
				}
				
				if (null != current.getPrev()) {
					
					current.getPrev().setNext(current.getNext());
				}
				
				if (pos == size-1) { //reset tail if necessary
					
					tail = current;
				}
				
				size--;
				
				return data;
			}
			else {
				
				current = tail;
				
				for (int i = size-1; i > pos; i--) {
					
					current = current.getPrev();
				}
				
				data = current.getData();
				
				if (null != current.getNext()) {
					
					current.getNext().setPrev(current.getPrev());
				}
				
				if (null != current.getPrev()) {
					
					current.getPrev().setNext(current.getNext());
				}
				
				if (pos == size-1) { //reset tail if necessary
					
					tail = current.getPrev();
				}
				
				size--;
				
				return data;
			}
		}
	}
	
	@Override
	/**
	 * @param item the item to be checked if it is contained within a Node in the Doubly Linked list.
	 * @return whether the item is contained in a node within the Doubly-Linked List.
	 */
	public boolean contains(E item) {
		
		DoubleNode<E> current = HEAD.getNext();
		
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