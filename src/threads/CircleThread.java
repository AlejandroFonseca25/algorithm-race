package threads;

import javafx.application.Platform;
import model.AnimationManager;
import ui.TournamentGUI;

public class CircleThread extends Thread{
	
	private AnimationManager am;
	private TournamentGUI t;
	
	public CircleThread (AnimationManager am, TournamentGUI t) {
		this.am = am;
		this.t = t;
	}

	public void run () {

		while (true) {
			am.circleAnimation();

			Platform.runLater(new Thread() {

				public void run () {
					t.updateTimer();
				}
			});

			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
