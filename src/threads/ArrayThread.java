package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Tournament;
import ui.TournamentGUI;

public class ArrayThread extends Thread{
	
	private Tournament tournament;
	private int category;
	private TournamentGUI tournamentGUI;
	//category: 0 = iterative, 1 = recursive
	private int mode;
	//mode: 0 = add, 1 = search, 2 = remove
	private int elements;
	private long seed;
	private Random r;
	
	public ArrayThread(Tournament to, TournamentGUI tg, int c, int m, int e, long s) {
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
					tournament.addArrayList(n);
				}
			}
			//Search
			else if (mode == 1) {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.searchArrayListIterative(n);
				}
			}
			//Remove
			else {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.removeArrayListIterative(n);
				}
			}
			break;
			
		//Recursive
		case 1:
			//Add
			if (mode == 0) {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.addArrayList(n);
				}
			}
			
			//Search
			else if (mode == 1) {
				for (int i = 0; i < elements; i++) {

					long n = tournament.generateRandomLong(r);
					tournament.searchArrayListRecursive(n,0);
				}
			}
			
			//Remove
			else {
				for (int i = 0; i < elements; i++) {
					
					long n = tournament.generateRandomLong(r);
					tournament.removeArrayListRecursive(n,0);
				}
			}
			break;
		}
		
		Platform.runLater(new Thread() {

			public void run () {
				tournamentGUI.updateFinalArrayTime();
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