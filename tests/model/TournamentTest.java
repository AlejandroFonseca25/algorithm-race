package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TournamentTest {
	
	private Tournament tournament;
	
	public long[] setup1() {
		long[] n = new long[] {1,2,3,4,5,6,7,8,9,10}; 
		return n;
	}
	
	@Test
	public void generateRandomNumbersTest() {
		tournament = new Tournament();
		long[] numbers = tournament.generateRandomNumbers(10);
	}
	
	@Test
	public void addLinkedListIterativeTest () {
		long[] n = setup1();
		tournament = new Tournament();
		tournament.addLinkedListIterative(n);
		Assertions.assertEquals(tournament.getFirst().getNext().getNumber() , n[1]);
	}
}
