package linkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SinglyLinkedListTest {

	@Test
	void testSinglyLinkedList() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
	}

	@Test
	void testAddNull() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
		    list.add(null);
		});
		
		String unexpectedMessage = "Position is invalid, greater than Linked List Size.";
		String expectedMessage = "Cannot add nulls to the Singly Linked List";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
		    list.add(0, null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    list.add("a");
	    assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
		    list.add(0, null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
		    list.add(1, null);
		});
	    
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testAddObjects() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add("a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals(null, list.getNode(0).getNext());
		
		list.add("b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("b", list.getNode(0).getNext().getData());
		assertEquals(null, list.getNode(1).getNext());
		
		list.add("c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
		assertEquals("b", list.getNode(0).getNext().getData());
		assertEquals("c", list.getNode(1).getNext().getData());
		assertEquals(null, list.getNode(2).getNext());
	}

	@Test
	void testAddLessThanZero() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.add(-4, "a");
		});
		
		String unexpectedMessage = "Position is invalid, greater than Linked List Size.";
		String expectedMessage = "Position cannot be negative in a linked list.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testAddOutOfBounds() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.add(1, "a");
		});
		
		String unexpectedMessage = "Position cannot be negative in a linked list.";
		String expectedMessage = "Position is invalid, greater than Linked List Size.";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		
		list.add(1, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		
		exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.add(3, "c");
		});
		
		unexpectedMessage = "Position cannot be negative in a linked list.";
		expectedMessage = "Position is invalid, greater than Linked List Size.";
	    actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testAddPositionZero() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		
		list.add(0, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(1));
		
		list.add(0, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
	}
	
	@Test
	void testAddAtArrayEnd() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		
		list.add(1, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		
		list.add(2, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}

	@Test
	void testGetLessThanZero() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int NEGATIVE_INDEX = -4;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.get(NEGATIVE_INDEX);
		});
		
		String unexpectedMessage = "index " + NEGATIVE_INDEX + " is greater than the bounds of the Linked List.";
		String expectedMessage = "index " + NEGATIVE_INDEX + " is less than 0 and is invalid in a Linked List.";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testGetOutOfBounds() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int OUTSIDE_VALUE = 1;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.get(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "index " + OUTSIDE_VALUE + " is less than 0 and is invalid in a Linked List.";
		String expectedMessage = "index " + OUTSIDE_VALUE + " is greater than the bounds of the Linked List.";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		
	    list.add(0, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(1));
		
		list.add(0, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		
		final int OUTSIDE_VALUE_2 = 3;
		
		exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.get(OUTSIDE_VALUE_2);
		});
		
		unexpectedMessage = "index " + OUTSIDE_VALUE_2 + " is less than 0 and is invalid in a Linked List.";
		expectedMessage = "index " + OUTSIDE_VALUE_2 + " is greater than the bounds of the Linked List.";
	    actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testGetZero() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int OUTSIDE_VALUE = 0;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.get(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "index " + OUTSIDE_VALUE + " is less than 0 and is invalid in a Linked List.";
		String expectedMessage = "index " + OUTSIDE_VALUE + " is greater than the bounds of the Linked List.";
	    String actualMessage = exception.getMessage();
	    
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(0));
		
	    list.add(0, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(1));
		
		list.add(0, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
	}
	
	@Test
	void testGetEnd() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(list.size()-1));
		
	    list.add(0, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(list.size()-1));
		
		list.add("b");
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(list.size()-1));
		
		list.add("c");
		assertEquals(true, list.size() == 5);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(list.size()-1));
	}
	
	@Test
	void testGet() {

		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add(0, "a");
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(list.size()-1));
		
	    list.add(0, "b");
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.add("b");
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.add("c");
		assertEquals(true, list.size() == 5);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(3));
		assertEquals("c", list.get(list.size()-1));
	}

	@Test
	void testRemoveLessThanZero() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int NEGATIVE_INDEX = -1;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(NEGATIVE_INDEX);
		});
		
		String unexpectedMessage = "Position [" + NEGATIVE_INDEX
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
		String expectedMessage = "Position [" + NEGATIVE_INDEX 
									+ "] cannot be negative in a linked list.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testRemoveOutOfBounds() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int OUTSIDE_VALUE = 1;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "Position [" + OUTSIDE_VALUE 
										+ "] cannot be negative in a linked list.";
		String expectedMessage = "Position [" + OUTSIDE_VALUE
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testRemoveEmpty() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int OUTSIDE_VALUE = 0;
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "Position [" + OUTSIDE_VALUE 
										+ "] cannot be negative in a linked list.";
		String expectedMessage = "Position [" + OUTSIDE_VALUE
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}
	
	@Test
	void testRemoveAddRemove() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		list.add(0, "a");
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("a", list.get(list.size()-1));
		
	    list.add(0, "b");
	    
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.remove(0);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.add("b");
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.add("c");
		
		assertEquals(true, list.size() == 5);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(3));
		assertEquals("c", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		final int OUTSIDE_VALUE = list.size();
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "Position [" + OUTSIDE_VALUE 
										+ "] cannot be negative in a linked list.";
		String expectedMessage = "Position [" + OUTSIDE_VALUE
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	    
	    final int NEGATIVE_INDEX = list.size()-1;
		
		exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(NEGATIVE_INDEX);
		});
		
		unexpectedMessage = "Position [" + NEGATIVE_INDEX
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
		expectedMessage = "Position [" + NEGATIVE_INDEX 
									+ "] cannot be negative in a linked list.";
	    actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}

	@Test
	void testContainsNull() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		assertFalse(list.contains(null));
		
		list.add(0, "a");
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("a", list.get(list.size()-1));
		
	    list.add(0, "b");
	    
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.remove(0);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.add("b");
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.add("c");
		
		assertEquals(true, list.size() == 5);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(3));
		assertEquals("c", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertEquals("c", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		assertFalse(list.contains(null));
	}
	
	@Test
	void testContains() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		assertFalse(list.contains(null));
		assertFalse(list.contains("a"));
		
		list.add(0, "a");
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertFalse(list.contains("b"));
		assertEquals("a", list.get(list.size()-1));
		
	    list.add(0, "b");
	    
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertFalse(list.contains("c"));
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("d"));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.remove(0);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertFalse(list.contains("c"));
		assertEquals("b", list.get(0));
		assertEquals("a", list.get(list.size()-1));
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("d"));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		
		list.add("b");
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("z"));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		
		list.add("c");
		
		assertEquals(true, list.size() == 5);
		assertEquals(false, list.isEmpty());
		assertFalse(list.contains(null));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("d"));
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(3));
		assertEquals("c", list.get(list.size()-1));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 4);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(2));
		assertEquals("b", list.get(list.size()-1));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("d"));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 3);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("a", list.get(list.size()-1));
		assertTrue(list.contains("a"));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("d"));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 2);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(0));
		assertEquals("b", list.get(list.size()-1));
		assertTrue(list.contains("b"));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("a"));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 1);
		assertEquals(false, list.isEmpty());
		assertEquals("c", list.get(list.size()-1));
		assertTrue(list.contains("c"));
		assertFalse(list.contains("b"));
		assertFalse(list.contains("a"));
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		assertFalse(list.contains("a"));
		assertFalse(list.contains("b"));
		assertFalse(list.contains("c"));
	}

	@Test
	void testSize() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		
		list.add(0, "a");
		
		assertEquals(true, list.size() == 1);
		
	    list.add(0, "b");
	    
		assertEquals(true, list.size() == 2);
		
		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		
		list.remove(0);
		
		assertEquals(true, list.size() == 2);

		list.add(0, "c");
		
		assertEquals(true, list.size() == 3);
		
		list.add("b");
		
		assertEquals(true, list.size() == 4);
		
		list.add("c");
		
		assertEquals(true, list.size() == 5);
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 4);
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 3);
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 2);
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 1);
		
		list.remove(list.size()-1);
		
		assertEquals(true, list.size() == 0);
		
		final int OUTSIDE_VALUE = list.size();
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "Position [" + OUTSIDE_VALUE 
										+ "] cannot be negative in a linked list.";
		String expectedMessage = "Position [" + OUTSIDE_VALUE
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}

	@Test
	void testIsEmpty() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertTrue(list.isEmpty());
		
		list.add(0, "a");
		
		assertFalse(list.isEmpty());
		
	    list.add(0, "b");
	    
	    assertFalse(list.isEmpty());
		
		list.add(0, "c");
		
		assertFalse(list.isEmpty());
		
		list.remove(0);
		
		assertFalse(list.isEmpty());

		list.add(0, "c");
		
		assertFalse(list.isEmpty());
		
		list.add("b");
		
		assertFalse(list.isEmpty());
		
		list.add("c");
		
		assertFalse(list.isEmpty());
		
		list.remove(list.size()-1);
		
		assertFalse(list.isEmpty());
		
		list.remove(list.size()-1);
		
		assertFalse(list.isEmpty());
		
		list.remove(list.size()-1);
		
		assertFalse(list.isEmpty());
		
		list.remove(list.size()-1);
		
		assertFalse(list.isEmpty());
		
		list.remove(list.size()-1);
		
		assertTrue(list.isEmpty());
		
		final int OUTSIDE_VALUE = list.size();
		
		Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			
			list.remove(OUTSIDE_VALUE);
		});
		
		String unexpectedMessage = "Position [" + OUTSIDE_VALUE 
										+ "] cannot be negative in a linked list.";
		String expectedMessage = "Position [" + OUTSIDE_VALUE
									+ "] is invalid, greater than or equal to Linked List Size."
									+ "Linked List uses zero-indexing.";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    assertFalse(actualMessage.contains(unexpectedMessage));
	}

	@Test
	void testIterator() {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		assertEquals(true, list.size() == 0);
		assertEquals(true, list.isEmpty());
		
		ArrayList<String> verifier = new ArrayList<String>();
		
		list.add(0, "a");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("a"));
		verifier.clear();
		
	    list.add(0, "b");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("b"));
		assertTrue(verifier.get(1).equals("a"));
		verifier.clear();
		
		list.add(0, "c");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		verifier.clear();
		
		list.remove(0);
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("b"));
		assertTrue(verifier.get(1).equals("a"));
		verifier.clear();
		
		list.add(0, "c");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		verifier.clear();
		
		list.add("b");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		assertTrue(verifier.get(3).equals("b"));
		verifier.clear();
		
		list.add("c");
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		assertTrue(verifier.get(3).equals("b"));
		assertTrue(verifier.get(4).equals("c"));
		verifier.clear();
		
		list.remove(list.size()-1);
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		assertTrue(verifier.get(3).equals("b"));
		verifier.clear();
		
		list.remove(list.size()-1);
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		assertTrue(verifier.get(2).equals("a"));
		verifier.clear();
		
		list.remove(list.size()-1);
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		assertTrue(verifier.get(1).equals("b"));
		verifier.clear();
		
		list.remove(list.size()-1);
		
		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(verifier.get(0).equals("c"));
		verifier.clear();
		
		list.remove(list.size()-1);

		for (String s: list) {
			
			verifier.add(s);
		}
		
		assertTrue(list.isEmpty());
		verifier.isEmpty();
	}
}
