package linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestDoubleNode {
	
	@Test
	void constructNextNull() {
		
		DoubleNode<String> string_node = new DoubleNode<String>(null, "Bob");
		DoubleNode<Integer> integer_node = new DoubleNode<Integer>(null, 1);
		
		assertEquals(null, string_node.getNext());
		assertEquals(null, integer_node.getNext());
		assertEquals(null, string_node.getPrev());
		assertEquals(null, integer_node.getPrev());
	}
	
	@Test
	void constructNullDefault() {
		
		DoubleNode<String> string_node = new DoubleNode<String>("Bob");
		DoubleNode<Integer> integer_node = new DoubleNode<Integer>(1);
		
		assertEquals(null, string_node.getNext());
		assertEquals(null, integer_node.getNext());
		assertEquals(null, string_node.getPrev());
		assertEquals(null, integer_node.getPrev());
	}
	
	@Test
	void nullDataConstructor() {
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			DoubleNode<String> node1 = new DoubleNode<String>(null, null, null);
		});
		
		String unexpectedMessage = "Node's data cannot be null.";
		String expectedMessage = "DoubleNode's data cannot be null.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
	    	DoubleNode<String> node2 = new DoubleNode<String>(null, null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
	    	DoubleNode<String> node3 = new DoubleNode<String>(null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
	}

	@Test
	void hashCodeInteger() {
		
		DoubleNode<Integer> num1 = new DoubleNode<Integer>(null, 1);
		Integer num2 = 1;
		
		assertEquals(num1.hashCode(), num2.hashCode());
	}
	
	@Test
	void hashCodeString() {
		
		DoubleNode<String> node1 = new DoubleNode<String>(null, "First");
		String str = new String("First");
		
		assertEquals(node1.hashCode(), str.hashCode());
	}

	@Test
	void testGetData() {
		
		DoubleNode<String> node = new DoubleNode<String>("Earth");
		
		assertEquals(true, "Earth".equals(node.getData()));
	}

	@Test
	void testGetPrev() {
		
		DoubleNode<String> node1, node2, node3;
		
		node3 = new DoubleNode<String>(null, "Third");
		node2 = new DoubleNode<String>(node3, "Second");
		node3.setPrev(node2);
		node1 = new DoubleNode<String>(node2, "First");
		node2.setPrev(node1);
		
		assertEquals(null, node1.getPrev());
		assertEquals(node1, node2.getPrev());
		assertEquals(node2, node3.getPrev());
	}

	@Test
	void testGetNext() {

		DoubleNode<String> node2 = new DoubleNode<String>(null, "Second");
		DoubleNode<String> node1 = new DoubleNode<String>(node2, "First");
		
		assertEquals(node2, node1.getNext());
	}
	
	@Test
	void testGetPrevNext() {
		
		DoubleNode<String> node1, node2, node3;
		
		node3 = new DoubleNode<String>(null, "Third");
		node2 = new DoubleNode<String>(node3, "Second");
		node3.setPrev(node2);
		node1 = new DoubleNode<String>(node2, "First");
		node2.setPrev(node1);
		
		assertEquals(null, node1.getPrev());
		assertEquals(node1, node2.getPrev());
		assertEquals(node2, node1.getNext());
		assertEquals(node2, node3.getPrev());
		assertEquals(node3, node2.getNext());
		assertEquals(null, node3.getNext());
	}

	@Test
	void testSetNext() {
		
		DoubleNode<String> node1, node2, node3;

		node3 = new DoubleNode<String>(null, "Third");
		node2 = new DoubleNode<String>(null, "Second");
		node1 = new DoubleNode<String>(null, "First");
		
		node1.setNext(node2);
		node2.setNext(node3);
		
		assertEquals(null, node3.getNext());
		assertEquals(node3, node2.getNext());
		assertEquals(node2, node1.getNext());
	}

	@Test
	void testSetPrev() {
		
		DoubleNode<String> node1, node2, node3;

		node3 = new DoubleNode<String>(null, "Third");
		node2 = new DoubleNode<String>(null, "Second");
		node1 = new DoubleNode<String>(null, "First");
		
		node3.setPrev(node2);
		node2.setPrev(node1);
		
		assertEquals(null, node1.getPrev());
		assertEquals(node1, node2.getPrev());
		assertEquals(node2, node3.getPrev());
	}
	
	@Test
	void iterating() {
		
		DoubleNode<String> node1 = new DoubleNode<String>(null, "First");
		DoubleNode<String> node2 = new DoubleNode<String>(node1, "Second");
		
		node2 = node2.getNext();
		assertEquals(node1, node2);
	}

	@Test
	void equals() {
		
		DoubleNode<String> node1 = new DoubleNode<String>(null, "First");
		DoubleNode<String> node2 = new DoubleNode<String>(node1, "First");
		
		assertTrue(node1.equals(node2));
	}
	
	@Test
	void equalsNull() {
		
		DoubleNode<String> node1 = new DoubleNode<String>(null, "First");
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			DoubleNode<String> node2 = new DoubleNode<String>(null, null);
		});
		
		String unexpectedMessage = "Illegal argument";
		String expectedMessage = "DoubleNode's data cannot be null.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.equals(expectedMessage));
	    assertFalse(actualMessage.equals(unexpectedMessage));
		
		assertFalse(node1.equals(null));
	}
	
	@Test
	void equalsOtherClass() {
		
		DoubleNode<String> node1 = new DoubleNode<String>(null, "First");
		Node<String> node2 = new Node<String>(null, "First");
		
		assertFalse(node1.equals(node2));
	}

	@Test
	void stringPrintout() {
		
		DoubleNode<String> node2 = new DoubleNode<String>(null, "Second");
		DoubleNode<String> node1 = new DoubleNode<String>(node2, "First");
		String str = "Node: " + "First" 
						+ "\t Next Node: " + "Second";
		
		assertEquals(node1.toString(), str);
	}
	
	@Test
	void integerPrintout() {
		
		DoubleNode<Integer> node2 = new DoubleNode<Integer>(null, 2);
		DoubleNode<Integer> node1 = new DoubleNode<Integer>(node2, 1);
		String str = "Node: " + "1" 
				+ "\t Next Node: " + "2";
		
		assertEquals(node1.toString(), str);
	}
}
