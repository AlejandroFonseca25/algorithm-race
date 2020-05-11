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
	
	//Linked List Tests
	@Test
	public void addLinkedListIterativeTest () {
		long[] n = setup1();
		tournament = new Tournament();
		tournament.addLinkedListIterative(n);
		LinkedListItem actual = tournament.getFirst();
		int i = 0;
		while (actual != null) {
			Assertions.assertEquals(actual.getNumber() , n[i]);
			actual = actual.getNext();
			i++;
		}
	}
	
	@Test
	public void addLinkedListRecursiveTest () {
		long[] n = setup1();
		tournament.addLinkedListRecursive(n, 0, null);
		LinkedListItem actual = tournament.getFirst();
		
		int i = 0;
		while (actual != null) {
			Assertions.assertEquals(actual.getNumber() , n[i]);
			actual = actual.getNext();
			i++;
		}
	}
	
	@Test
	public void searchLinkedListIterativeTest () {
		long[] n = setup1();
		tournament.addLinkedListIterative(n);
		
		//Linked List 
		Assertions.assertTrue(tournament.searchLinkedListIterative(1));
		Assertions.assertTrue(tournament.searchLinkedListIterative(5));
		Assertions.assertTrue(tournament.searchLinkedListIterative(10));
		Assertions.assertFalse(tournament.searchLinkedListIterative(13));
		
	}
	
	
	public void searchLinkedListRecursiveTest () {
		long[] n = setup1();
		tournament.addLinkedListRecursive(n, 0, null);
		LinkedListItem actual = tournament.getFirst();
		
		Assertions.assertTrue(tournament.searchLinkedListRecursive(1, actual));
		Assertions.assertTrue(tournament.searchLinkedListRecursive(5, actual));
		Assertions.assertTrue(tournament.searchLinkedListRecursive(10, actual));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(13, actual));
	}
	
	@Test
	public void removeLinkedListIterativeTest () {
		long[] n = setup1();
		tournament.addLinkedListRecursive(n, 0, null);
		
		//Linked List
		Assertions.assertTrue(tournament.searchLinkedListIterative(1));
		Assertions.assertTrue(tournament.removeLinkedListIterative(1));
		Assertions.assertFalse(tournament.searchLinkedListIterative(1));
		
		Assertions.assertTrue(tournament.searchLinkedListIterative(5));
		Assertions.assertTrue(tournament.removeLinkedListIterative(5));
		Assertions.assertFalse(tournament.searchLinkedListIterative(5));
		
		Assertions.assertTrue(tournament.searchLinkedListIterative(10));
		Assertions.assertTrue(tournament.removeLinkedListIterative(10));
		Assertions.assertFalse(tournament.searchLinkedListIterative(10));
		
		Assertions.assertFalse(tournament.removeLinkedListIterative(13));
		Assertions.assertFalse(tournament.searchLinkedListIterative(13));
	}
	
	@Test
	public void removeLinkedListRecursiveTest () {
		long[] n = setup1();
		tournament.addLinkedListRecursive(n, 0, null);
		LinkedListItem actual = tournament.getFirst();
		
		Assertions.assertFalse(tournament.searchLinkedListRecursive(13, actual));
		Assertions.assertFalse(tournament.removeLinkedListRecursive(13, actual));
		
		Assertions.assertTrue(tournament.searchLinkedListRecursive(10, actual));
		Assertions.assertTrue(tournament.removeLinkedListRecursive(10, actual));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(10, actual));
		
		Assertions.assertTrue(tournament.searchLinkedListRecursive(5, actual));
		Assertions.assertTrue(tournament.removeLinkedListRecursive(5, actual));
		Assertions.assertFalse(tournament.searchLinkedListRecursive(5, actual));
		
		Assertions.assertTrue(tournament.searchLinkedListRecursive(1, actual));
		Assertions.assertTrue(tournament.removeLinkedListRecursive(1, actual));
		actual = tournament.getFirst();
		Assertions.assertFalse(tournament.searchLinkedListRecursive(1, actual));
	}
	
	//Binary Tree tests
	
	@Test
	public void searchAndAddBinaryTreeRecursiveTest () {
		long[] n = setup1();
		tournament.addBinaryTreeRecursive(n, 0, null);
		TreeItem root = tournament.getRoot();
		
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(1, root));
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(5, root));
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(10, root));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(13, root));
	}

	
	@Test
	public void searchBinaryTreeIterativeTest () {
		long[] n = setup1();
		tournament.addBinaryTreeIterative(n);
		
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(1));
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(5));
		Assertions.assertTrue(tournament.searchBinaryTreeIterative(10));
		Assertions.assertFalse(tournament.searchBinaryTreeIterative(13));
	}
	
	@Test
	public void removeBinaryTreeRecursiveTest () {
		long[] n = setup2();
		tournament.addBinaryTreeRecursive(n, 0, null);
		String temp = "";
		
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(13, tournament.getRoot()));
		Assertions.assertFalse(tournament.removeBinaryTreeRecursive(13, tournament.getRoot()));
		System.out.println("1." + tournament.toStringBinaryTreePostorder(tournament.getRoot(), temp));
		
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(50, tournament.getRoot()));
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(50, tournament.getRoot()));
		System.out.println("2." + tournament.toStringBinaryTreePostorder(tournament.getRoot(), temp));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(50, tournament.getRoot()));
		
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(25, tournament.getRoot()));
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(25, tournament.getRoot()));
		System.out.println("3." + tournament.toStringBinaryTreePostorder(tournament.getRoot(), temp));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(25, tournament.getRoot()));
		
		Assertions.assertTrue(tournament.searchBinaryTreeRecursive(-25, tournament.getRoot()));
		Assertions.assertTrue(tournament.removeBinaryTreeRecursive(-25, tournament.getRoot()));
		Assertions.assertFalse(tournament.searchBinaryTreeRecursive(-25, tournament.getRoot()));
		System.out.println("4." + tournament.toStringBinaryTreePostorder(tournament.getRoot(), temp));
	}
}
