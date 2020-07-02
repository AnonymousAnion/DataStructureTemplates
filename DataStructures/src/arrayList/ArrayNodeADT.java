package arrayList;

import linkedList.NodeADT;

public interface ArrayNodeADT <E> extends NodeADT <E> {
	
	/**
	 * 
	 * @param data 
	 * 			the new data to be held by the node
	 */
	void setData(E data);

}
