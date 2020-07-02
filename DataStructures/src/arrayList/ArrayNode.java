package arrayList;

import linkedList.NodeADT;

class ArrayNode<E> implements ArrayNodeADT<E> {
	
	private ArrayNode<E> next;
	private E data;
	
	/**
	 * 
	 * @param nextNode 
	 *			the next node in the sequence
	 * @param data 
	 * 			the data to be held by the node
	 */
	public ArrayNode(ArrayNode<E> nextNode, E data) {
		
		this.next = nextNode;
		this.data = data;
	}
	
	/**
	 * 
	 * @param data 
	 * 			the data to be contained by the node
	 */
	public ArrayNode(E data) {
		
		this(null, data);
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
	public ArrayNode<E> getNext() {
		
		return next;
	}
	
	/**
	 * 
	 * @param data 
	 * 			the new data to be held by the node
	 */
	public void setData(E data) {
		
		this.data = data;
	}
	
	@Override
	/**
	 * 
	 * @param next
	 * 			the node which this node will point to
	 * 			as next in the list
	 */
	public void setNext(NodeADT<E> next) {
		
		this.next = (ArrayNode<E>)next;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (null == obj) {
			
			return false;
		}
		else if (!(obj instanceof ArrayNode)) {
			
			return false;
		}
		else {
			
			ArrayNode<E> node = (ArrayNode<E>)obj;
			
			return data.equals(node.getData());
		}
	}
	
	@Override
	public int hashCode() {
		
		return data.hashCode();
	}
}