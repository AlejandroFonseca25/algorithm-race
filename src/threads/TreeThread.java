package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Tournament;
import ui.TournamentGUI;

public class TreeThread extends Thread{
	
	private Tournament tournament;
	private TournamentGUI tournamentGUI;
	private int category;
	//category: 0 = iterative, 1 = recursive
	private int mode;
	//mode: 0 = add, 1 = search, 2 = remove
	private int elements;
	private long seed;
	private Random r;
	
	public TreeThread(Tournament to,TournamentGUI tg, int c, int m, int e, long s) {
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
		try {
			switch (category) {
			//Iterative
			case 0:
				//Add
				if (mode == 0) {

					for (int i = 0; i < elements; i++) {
						long n = tournament.generateRandomLong(r);
						tournament.addBinaryTreeIterative(n);
					}
				}
				//Search
				else if (mode == 1) {
					for (int i = 0; i < elements; i++) {

						long n = tournament.generateRandomLong(r);
						tournament.searchBinaryTreeIterative(n);
					}
				}
				//Remove
				else {
					for (int i = 0; i < elements; i++) {

						long n = tournament.generateRandomLong(r);
						tournament.removeBinaryTreeIterative(n);
					}
				}
				break;
				//Recursive
			case 1:
				//Add
				if (mode == 0) {
					for (int i = 0; i < elements; i++) {

						long n = tournament.generateRandomLong(r);
						tournament.addBinaryTreeRecursive(n,tournament.getRoot());
					}
				}

				//Search
				else if (mode == 1) {
					for (int i = 0; i < elements; i++) {

						long n = tournament.generateRandomLong(r);
						tournament.searchBinaryTreeRecursive(n,tournament.getRoot());
					}
				}

				//Remove
				else {
					for (int i = 0; i < elements; i++) {

						long n = tournament.generateRandomLong(r);
						tournament.removeBinaryTreeRecursive(n,tournament.getRoot());
					}
				}
				break;
			}

			Platform.runLater(new Thread() {

				public void run () {
					tournamentGUI.updateFinalTreeTime();
				}
			});

			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (StackOverflowError soe) {
			Platform.runLater(new Thread() {

				public void run () {
					tournamentGUI.getTreeTimer().setText("DISQUALIFIED");
				}
			});
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
