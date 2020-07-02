package Tree;
import java.lang.Comparable;
import java.lang.RuntimeException;

/**
 * 
 * @author Liam Tomson-Moylan
 * A generic tree node class for creating tree data structures
 */
class TreeNode {

	private int value;
	private TreeNode leftChild, rightChild;
	
	/**
	 * Instantiates a leaf tree node (no children)
	 */
	TreeNode() {
		
		leftChild = null;
		rightChild = null;
	}
	
	/**
	 * Instantiates a leef tree node (no children) with a value
	 * @param value the value of the tree node
	 */
	TreeNode(int value) {
		
		this();
		this.value = value;
	}
	
	/**
	 * Instantiates a tree node with specified children
	 * @param value the value of the tree node
	 * @param leftChild the left child tree node
	 * @param rightChild the right child tree node
	 */
	TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
		
		this(value);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	/**
	 * 
	 * @return value the value of the tree node
	 */
	int getValue() {
		
		return value;
	}
	
	/**
	 * @param obj the object the be compared to the tree node.
	 * @return returns false for null or non-tree node objects.
	 * returns true for tree node objects with the same value.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof TreeNode)) {
			
			return false;
		}
		else {
			
			TreeNode treeNode = (TreeNode) obj;
			
			if (treeNode.getValue() == this.value) {
				
				return true;
			}
			else {
				
				return false;
			}
		}
	}
	
	/**
	 * @return returns the value of a tree node as its hash code
	 */
	@Override
	public int hashCode() {
		
		return value;
	}
}
