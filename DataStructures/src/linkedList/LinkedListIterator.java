package linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

	private NodeADT<T> curr;

	/**
	 * Constructs a PacketLinkedListIterator by passing a head node of
	 * PacketLinkedList.
	 * 
	 * @param head
	 *            the head node of PacketLinkedList.
	 */
	public LinkedListIterator(NodeADT<T> head) {
		
		curr = head;
	}
	
	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration
	 * @throws NoSuchElementException
	 *             if the iteration has no more elements
	 */
	@Override
	public T next() {
		
		curr = curr.getNext();
		return curr.getData();
	}
	
	/**
	 * Returns true if the iteration has more elements.
	 * 
	 * @return true if the iteration has more elements
	 */
	@Override
	public boolean hasNext() {

		if (curr.getNext() != null)
			return true;
		return false;
	}
}
