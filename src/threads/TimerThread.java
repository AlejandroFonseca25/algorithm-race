package threads;

import javafx.application.Platform;
import model.AnimationManager;
import ui.TournamentGUI;

public class TimerThread extends Thread{
	
	private AnimationManager am;
	private TournamentGUI tGUI;
	private ThreadManager tm;
	
	public TimerThread (AnimationManager am, TournamentGUI tGUI, ThreadManager tm) {
		this.am = am;
		this.tGUI = tGUI;
		this.tm = tm;
	}
	
	@Override
	public void run () {
		am.setOn(true);
		while (am.isOn()) {
			am.timerAnimation();

			Platform.runLater(new Thread() {

				public void run () {
					tGUI.updateTimer();
					if (!tm.getArrayThread().isAlive() && !tm.getTreeThread().isAlive() && 
							!tm.getListThread().isAlive()) {
						am.setOn(false);
					}
				}
			});

			try {
				Thread.sleep(0,200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
