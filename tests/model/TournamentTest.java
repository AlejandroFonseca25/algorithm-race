package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TournamentTest {
	
	private Tournament tournament;
	
	public TournamentTest () {
		tournament = new Tournament();
	}
	
	public long[] setup1() {
		long[] n = new long[] {1,2,3,4,5,6,7,8,9,10}; 
		return n;
	}
	
	public long[] setup2() {
		long[] n = new long[] {50,100,0,25,-25,125,75,30}; 
		return n;
	}
	//Array List tests
	
	@Test
	public void addArrayListTest() {
		long[] numbers = setup1();
		
		for (int i = 0; i < numbers.length; i++) {
			tournament.addArrayList(numbers[i]);
		}
		
		for (int i = 0; i < tournament.getArrayList().size() ; i++) {
			Assertions.assertEquals(numbers[i], tournament.getArrayList().get(i));
		}
	}
	
	@Test 
	public void searchArrayListIterativeTest() {
		long[] numbers = setup1();
		
		for (int i = 0; i < numbers.length; i++) {
			tournament.addArrayList(numbers[i]);
		}

		Assertions.assertTrue(tournament.searchArrayListIterative(1));
		Assertions.assertTrue(tournament.searchArrayListIterative(5));
		Assertions.assertTrue(tournament.searchArrayListIterative(10));
		Assertions.assertFalse(tournament.searchArrayListIterative(50));
	}
	
	@Test 
	public void searchArrayListRecursiveTest() {
		long[] numbers = setup1();
		
		for (int i = 0; i < numbers.length; i++) {
			tournament.addArrayList(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.searchArrayListRecursive(1, 0));
		Assertions.assertTrue(tournament.searchArrayListRecursive(5, 0));
		Assertions.assertTrue(tournament.searchArrayListRecursive(10, 0));
		Assertions.assertFalse(tournament.searchArrayListRecursive(50, 0));
	}
	
	@Test
	public void removeArrayListIterativeTest () {
		long[] numbers = setup1();
		
		for (int i = 0; i < numbers.length; i++) {
			tournament.addArrayList(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.removeArrayListIterative(1));
		Assertions.assertFalse(tournament.searchArrayListIterative(1));
		Assertions.assertTrue(tournament.removeArrayListIterative(5));
		Assertions.assertFalse(tournament.searchArrayListIterative(5));
		Assertions.assertTrue(tournament.removeArrayListIterative(10));
		Assertions.assertFalse(tournament.searchArrayListIterative(10));
		
		Assertions.assertFalse(tournament.removeArrayListIterative(50));
	}
	
	@Test
	public void removeArrayListRecursiveTest () {
		long[] numbers = setup1();
		
		for (int i = 0; i < numbers.length; i++) {
			tournament.addArrayList(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.removeArrayListRecursive(1, 0));
		Assertions.assertFalse(tournament.searchArrayListRecursive(1, 0));
		Assertions.assertTrue(tournament.removeArrayListRecursive(5, 0));
		Assertions.assertFalse(tournament.searchArrayListRecursive(5, 0));
		Assertions.assertTrue(tournament.removeArrayListRecursive(10, 0));
		Assertions.assertFalse(tournament.searchArrayListRecursive(10, 0));
		
		Assertions.assertFalse(tournament.removeArrayListIterative(50));
	}
	
	
	//Linked List Tests
	@Test
	public void addLinkedListIterativeTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListIterative(numbers[i]);
		}
		
		int i = 0;
		LinkedListItem actual = tournament.getFirst();
		while (actual != null) {
			Assertions.assertEquals(actual.getNumber() , numbers[i]);
			actual = actual.getNext();
			i++;
		}
	}
	
	@Test
	public void addLinkedListRecursiveTest () {
		//Restarts the structure
		tournament.setRoot(null);
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListRecursive(numbers[i], tournament.getFirst());
		}
		
		int i = 0;
		LinkedListItem actual = tournament.getFirst();
		while (actual != null) {
			Assertions.assertEquals(actual.getNumber() , numbers[i]);
			actual = actual.getNext();
			i++;
		}
	}
	
	@Test
	public void searchLinkedListIterativeTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.searchLinkedListIterative(1));
		Assertions.assertTrue(tournament.searchLinkedListIterative(5));
		Assertions.assertTrue(tournament.searchLinkedListIterative(10));
		Assertions.assertFalse(tournament.searchLinkedListIterative(50));
		
	}
	
	@Test
	public void searchLinkedListRecursiveTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.searchLinkedListRecursive(1, tournament.getFirst()));
		Assertions.assertTrue(tournament.searchLinkedListRecursive(5,  tournament.getFirst()));
		Assertions.assertTrue(tournament.searchLinkedListRecursive(10, tournament.getFirst()));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(50, tournament.getFirst()));
	}
	
	@Test
	public void removeLinkedListIterativeTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.removeLinkedListIterative(1));
		Assertions.assertFalse(tournament.searchLinkedListIterative(1));
		
		Assertions.assertTrue(tournament.removeLinkedListIterative(5));
		Assertions.assertFalse(tournament.searchLinkedListIterative(5));
		
		Assertions.assertTrue(tournament.removeLinkedListIterative(10));
		Assertions.assertFalse(tournament.searchLinkedListIterative(10));
		
		Assertions.assertFalse(tournament.removeLinkedListIterative(50));
	}
	
	@Test
	public void removeLinkedListRecursiveTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addLinkedListIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.removeLinkedListRecursive(1, tournament.getFirst()));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(1, tournament.getFirst()));
		
		Assertions.assertTrue(tournament.removeLinkedListRecursive(5, tournament.getFirst()));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(5, tournament.getFirst()));
		
		Assertions.assertTrue(tournament.removeLinkedListRecursive(10, tournament.getFirst()));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(10, tournament.getFirst()));

		Assertions.assertFalse(tournament.removeLinkedListRecursive(50, tournament.getFirst()));
	}
	
	//Binary Tree tests
	
	@Test
	public void addBinaryTreeIterativeTest() {
		//First test
		long[] numbers = setup2();
		for (int i = 0; i < numbers.length ; i++) {
			tournament.addBinaryTreeIterative(numbers[i]);
		}
		
		String expectedTree = "-25 30 25 0 75 125 100 50 ";
		String realTree = tournament.toStringBinaryTreePostorder(tournament.getRoot(), "");
		
		Assertions.assertEquals(expectedTree, realTree);
		
		//Second test
		tournament.setRoot(null);
		numbers = setup1();
		for (int i = 0; i < numbers.length ; i++) {
			tournament.addBinaryTreeIterative(numbers[i]);
		}
		
		expectedTree = "10 9 8 7 6 5 4 3 2 1 ";
		realTree = tournament.toStringBinaryTreePostorder(tournament.getRoot(), "");
		
		Assertions.assertEquals(expectedTree, realTree);
	}
	
	@Test
	public void addBinaryTreeRecursiveTest () {
		//First test
		long[] numbers = setup2();
		for (int i = 0; i < numbers.length ; i++) {
			tournament.addBinaryTreeRecursive(numbers[i], tournament.getRoot());
		}
		
		String expectedTree = "-25 30 25 0 75 125 100 50 ";
		String realTree = tournament.toStringBinaryTreePostorder(tournament.getRoot(), "");
		
		Assertions.assertEquals(expectedTree, realTree);
		
		//Second test
		tournament.setRoot(null);
		numbers = setup1();
		for (int i = 0; i < numbers.length ; i++) {
			tournament.addBinaryTreeRecursive(numbers[i], tournament.getRoot());
		}
		
		expectedTree = "10 9 8 7 6 5 4 3 2 1 ";
		realTree = tournament.toStringBinaryTreePostorder(tournament.getRoot(), "");
		
		Assertions.assertEquals(expectedTree, realTree);
	}

	
	@Test
	public void searchBinaryTreeIterativeTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addBinaryTreeIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(1));
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(5));
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(10));
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(13));
	}
	
	@Test
	public void searchBinaryTreeRecursiveTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addBinaryTreeRecursive(numbers[i], tournament.getRoot());
		}
		
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(1, tournament.getRoot()));
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(5, tournament.getRoot()));
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(10, tournament.getRoot()));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(13, tournament.getRoot()));
	}
	
	@Test
	public void removeBinaryTreeIterativeTest () {
		long[] numbers = setup1();
		for (int i = 0; i < numbers.length; i++) {
			tournament.addBinaryTreeIterative(numbers[i]);
		}
		
		Assertions.assertTrue(tournament.removeBinaryTreeIterative(1));
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(1));
		
		Assertions.assertTrue(tournament.removeBinaryTreeIterative(5));
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(5));
		
		Assertions.assertTrue(tournament.removeBinaryTreeIterative(10));
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(10));
		
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(50));
	}
	
	@Test
	public void removeBinaryTreeRecursiveTest () {
		long[] numbers = setup2();
		for (int i = 0; i < numbers.length ; i++) {
			tournament.addBinaryTreeRecursive(numbers[i], tournament.getRoot());
		}
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(50, tournament.getRoot()));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(50, tournament.getRoot()));
		
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(25, tournament.getRoot()));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(25, tournament.getRoot()));
		
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(-25, tournament.getRoot()));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(-25, tournament.getRoot()));
		
		Assertions.assertFalse(tournament.removeBinaryTreeRecursive(13, tournament.getRoot()));
	}
}
