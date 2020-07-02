package linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestNode {

	@Test
	void constructNextNull() {
		
		Node<String> string_node = new Node<String>(null, "Bob");
		Node<Integer> integer_node = new Node<Integer>(null, 1);
		
		assertEquals(null, string_node.getNext());
		assertEquals(null, integer_node.getNext());
	}
	
	@Test
	void constructNullDefault() {
		
		Node<String> string_node = new Node<String>("Bob");
		Node<Integer> integer_node = new Node<Integer>(1);
		
		assertEquals(null, string_node.getNext());
		assertEquals(null, integer_node.getNext());
	}
	
	@Test
	void nullDataConstructor() {
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Node<String> node1 = new Node<String>(null, null);
		});
		
		String unexpectedMessage = "Illegal argument";
		String expectedMessage = "Node's data cannot be null.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
	    	Node<String> node2 = new Node<String>(null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
	}
	
	@Test
	void getNext() {
		
		Node<String> node2 = new Node<String>(null, "Second");
		Node<String> node1 = new Node<String>(node2, "First");
		
		assertEquals(node2, node1.getNext());
	}
	
	@Test
	void getData() {
		
		Node<String> node = new Node<String>("Earth");
		
		assertEquals(true, "Earth".equals(node.getData()));
	}

	@Test
	void setNext() {
		
		Node<String> node1 = new Node<String>(null, "First");
		Node<String> node2 = new Node<String>(node1, "Second");
		
		assertEquals(node1, node2.getNext());
		assertEquals(node1.getData(), node2.getNext().getData());
		
		node2.setNext(null);
		assertEquals(null, node2.getNext());
		
		Node<String> node3 = new Node<String>(null, "Third");
		node2.setNext(node3);
		
		assertEquals(node3, node2.getNext());
		assertEquals(node3.getData(), node2.getNext().getData());
	}
	
	@Test
	void iterating() {
		
		Node<String> node1 = new Node<String>(null, "First");
		Node<String> node2 = new Node<String>(node1, "Second");
		
		node2 = node2.getNext();
		assertEquals(node1, node2);
	}
	
	@Test
	void equals() {
		
		Node<String> node1 = new Node<String>(null, "First");
		Node<String> node2 = new Node<String>(node1, "First");
		
		assertTrue(node1.equals(node2));
	}
	
	@Test
	void equalsNull() {
		
		Node<String> node1 = new Node<String>(null, "First");
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Node<String> node2 = new Node<String>(null, null);
		});
		
		String unexpectedMessage = "Illegal argument";
		String expectedMessage = "Node's data cannot be null.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
		
		assertFalse(node1.equals(null));
	}
	
	@Test
	void equalsOtherClass() {
		
		Node<String> node1 = new Node<String>(null, "First");
		DoubleNode<String> node2 = new DoubleNode<String>(null, "First");
		
		assertFalse(node1.equals(node2));
	}
	
	@Test
	void hashCodeInteger() {
		
		Node<Integer> num1 = new Node<Integer>(null, 1);
		Integer num2 = 1;
		
		assertEquals(num1.hashCode(), num2.hashCode());
	}
	
	@Test
	void hashCodeString() {
		
		Node<String> node1 = new Node<String>(null, "First");
		String str = new String("First");
		
		assertEquals(node1.hashCode(), str.hashCode());
	}
	
	@Test
	void stringPrintout() {
		
		Node<String> node2 = new Node<String>(null, "Second");
		Node<String> node1 = new Node<String>(node2, "First");
		String str = "Node: " + "First" 
						+ "\t Next Node: " + "Second";
		
		assertEquals(node1.toString(), str);
	}
	
	@Test
	void integerPrintout() {
		
		Node<Integer> node2 = new Node<Integer>(null, 2);
		Node<Integer> node1 = new Node<Integer>(node2, 1);
		String str = "Node: " + "1" 
				+ "\t Next Node: " + "2";
		
		assertEquals(node1.toString(), str);
	}
}
