package linkedList;

public interface NodeADT<E> {
	
	/**
	 * 
	 * @return the current data of the node 
	 */
	E getData();
	
	/**
	 * 
	 * @return the next node in the sequence
	 */
	NodeADT<E> getNext();
	
	/**
	 * 
	 * @param next
	 * 			the node which this node will point to
	 * 			as next in the list
	 */
	void setNext(NodeADT<E> next);
	
	@Override
	/**
	 * @param obj
	 * 			the object to be compared
	 * @return whether 2 nodes are equal
	 */
	boolean equals(Object obj);
	
	@Override
	/**
	 * @return the hash code based on the node's data's hash code
	 */
	int hashCode();
}
