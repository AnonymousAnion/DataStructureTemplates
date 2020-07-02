package linkedList;

class Node<E> implements NodeADT<E> {
	
	private Node<E> next;
	private final E data;
	
	/**
	 * 
	 * @param nextNode 
	 *			the next node in the sequence
	 * @param data 
	 * 			the data to be held by the node
	 */
	public Node(Node<E> nextNode, E data) {
		
		this.next = nextNode;
		
		if (null == data) {
			
			throw new IllegalArgumentException("Node's data cannot be null.");
		}
		else {
			
			this.data = data;
		}
	}
	
	/**
	 * 
	 * @param data 
	 * 			the data to be contained by the node
	 */
	public Node(E data) {
		
		this(null, data);
	}
	
	/**
	 * null constructor for Node.
	 */
	public Node() {
		
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
	 * @return the next node in the sequence
	 */
	public Node<E> getNext() {
		
		return next;
	}
	
	/**
	 * 
	 * @param next
	 * 			the node which this node will point to
	 * 			as next in the list
	 */
	public void setNext(NodeADT<E> next) {
		
		this.next = (Node<E>)next;
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
		else if (!(obj instanceof Node)) {
			
			return false;
		}
		else {
			
			Node<E> node = (Node<E>)obj;
			
			return data.equals(node.getData());
		}
	}
	
	@Override
	/**
	 * @return the hash code based on the node's datum's hash code
	 */
	public int hashCode() {
		
		return data.hashCode();
	}
	
	@Override
	/**
	 * @return the String representation of a Node for printouts
	 */
	public String toString() {
		
		return "Node: " + data.toString()
				+ "\t Next Node: " + getNext().getData().toString();
	}
}
