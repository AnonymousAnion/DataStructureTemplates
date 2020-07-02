package linkedList;

public class DoubleNode<E> implements NodeADT<E> {

	private DoubleNode<E> prev, next;
	private final E data;
	
	/**
	 * @param prevNode
	 * 			the previous node in the sequence
	 * @param nextNode 
	 *			the next node in the sequence
	 * @param data 
	 * 			the data to be held by the node
	 */
	public DoubleNode(DoubleNode<E> prevNode,
						DoubleNode<E> nextNode,
						E data) 
	{
		this.prev = prevNode;
		this.next = nextNode;
		
		if (null == data) {
			
			throw new IllegalArgumentException("DoubleNode's data cannot be null.");
		}
		else {
			
			this.data = data;
		}
	}
	
	/**
	 * 
	 * @param nextNode 
	 *			the next node in the sequence
	 * @param data 
	 * 			the data to be held by the node
	 */
	public DoubleNode(DoubleNode<E> nextNode, E data) {
		
		this(null, nextNode, data);
	}
	
	/**
	 * 
	 * @param data 
	 * 			the data to be contained by the node
	 */
	public DoubleNode(E data) {
		
		this(null, data);
	}
	
	/**
	 * A null constructor for a double node
	 */
	public DoubleNode() {
		
		this.prev = null;
		this.next = null;
		this.data = null;
	}
	
	/**
	 * 
	 * @return the current data of the node 
	 */
	public E getData() {
		
		return data;
	}
	
	/**
	 * 
	 * @return the previous node in the sequence
	 */
	public DoubleNode<E> getPrev() {
		
		return prev;
	}
	
	/**
	 * 
	 * @return the next node in the sequence
	 */
	public DoubleNode<E> getNext() {
		
		return next;
	}
	
	/**
	 * 
	 * @param next
	 * 			the node which this node will point to
	 * 			as next in the list
	 */
	public void setNext(NodeADT<E> next) {
		
		this.next = (DoubleNode<E>)next;
	}
	
	/**
	 * 
	 * @param prev
	 * 			the node which this node will point to
	 * 			as previous in the list
	 */
	public void setPrev(DoubleNode<E> prev) {
		
		this.prev = prev;
	}
	
	@Override
	/**
	 * @param obj
	 * 			the object to be compared
	 * @return whether 2 nodes' data are equal. False otherwise.
	 */
	public boolean equals(Object obj) {
		
		if (null == obj) {
			
			return false;
		}
		else if (!(obj instanceof DoubleNode)) {
			
			return false;
		}
		else {
			
			DoubleNode<E> node = (DoubleNode<E>)obj;
			
			return data.equals(node.getData());
		}
	}
	
	@Override
	/**
	 * @return the hash code based on the double node's datum's hash code
	 */
	public int hashCode() {
		
		return data.hashCode();
	}
	
	@Override
	/**
	 * @return the String representation of a Double Node for printouts
	 */
	public String toString() {
		
		return "Node: " + data.toString()
				+ "\t Next Node: " + getNext().getData().toString();
	}
}
