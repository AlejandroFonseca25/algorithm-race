package threads;

import javafx.application.Platform;
import model.AnimationManager;
import ui.TournamentGUI;

public class TimerThread extends Thread{
	
	private AnimationManager am;
	private TournamentGUI t;
	
	public TimerThread (AnimationManager am, TournamentGUI t) {
		this.am = am;
		this.t = t;
	}
	
	public void run () {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		while (true) {
			am.timerAnimation();

			Platform.runLater(new Thread() {

				public void run () {
					t.updateCircles();
				}
			});

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
