package threads;

import javafx.application.Platform;
import model.AnimationManager;
import ui.TournamentGUI;

public class CircleThread extends Thread{
	
	private AnimationManager am;
	private TournamentGUI tGUI;
	private ThreadManager tm;
	
	public CircleThread (AnimationManager am, TournamentGUI tGUI, ThreadManager tm) {
		this.am = am;
		this.tGUI = tGUI;
		this.tm = tm;
	}
	
	@Override
	public void run () {
		
		while (am.isOn()) {
			am.circleAnimation();

			Platform.runLater(new Thread() {

				public void run () {
					tGUI.updateCircles();
					if (!tm.getArrayThread().isAlive() && !tm.getTreeThread().isAlive() && 
							!tm.getListThread().isAlive()) {
						am.setOn(false);
					}
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
