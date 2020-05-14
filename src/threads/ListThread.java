package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Tournament;
import ui.TournamentGUI;

public class ListThread extends Thread{
	
	private Tournament tournament;
	private TournamentGUI tournamentGUI;
	private int category;
	//category: 0 = iterative, 1 = recursive
	private int mode;
	//mode: 0 = add, 1 = search, 2 = remove
	private int elements;
	private long seed;
	private Random r;
	
	public ListThread(Tournament to,TournamentGUI tg, int c, int m, int e, long s) {
		tournament = to;
		tournamentGUI = tg;
		category = c;
		mode = m;
		elements = e;
		seed = s;
		r = new Random(seed);
	}
	
	@Override
	public void run () {
		switch (category) {
		//Iterative
		case 0:
			//Add
			if (mode == 0) {
				
				for (int i = 0; i < elements; i++) {
					long n = tournament.generateRandomLong(r);
					tournament.addLinkedListIterative(n);
				}
			}
			//Search
			else if (mode == 1) {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.searchLinkedListIterative(n);
				}
			}
			//Remove
			else {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.removeLinkedListIterative(n);
				}
			}
			break;
		//Recursive
		case 1:
			//Add
			if (mode == 0) {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.addLinkedListRecursive(n,tournament.getFirst());
				}
			}
			
			//Search
			else if (mode == 1) {
				for (int i = 0; i < elements; i++) {

					long n = tournament.generateRandomLong(r);
					tournament.searchLinkedListRecursive(n,tournament.getFirst());
				}
			}
			
			//Remove
			else {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.removeLinkedListRecursive(n,tournament.getFirst());
				}
			}
			break;
		}
		
		Platform.runLater(new Thread() {

			public void run () {
				tournamentGUI.updateFinalListTime();
			}
		});
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (StackOverflowError soe) {
			tournamentGUI.getListTimer().setText("DISQUALIFIED");
		}
	}

	public int getCategory() {
		return category;
	}

	public int getMode() {
		return mode;
	}
	
	public int getElements() {
		return elements;
	}

	public long getSeed() {
		return seed;
	}
}