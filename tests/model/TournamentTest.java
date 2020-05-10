package model;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	public void generateRandomNumbersTest() {
		long[] numbers = tournament.generateRandomNumbers(10);
	}
	
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
		tournament.addLinkedListRecursive(n, 0, null);
		LinkedListItem actual = tournament.getFirst();
		
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
	public void removeSearchLinkedListRecursiveTest () {
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
	
	@Test
	public void removeSearchLinkedListIterativeTest () {
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
}
