package model;

public class ProgressBarModel {
	private double progress;
	public static final double FINAL = 1;
	
	public ProgressBarModel () {
		progress = 0;
	}
	
	public void advanceProgress () {
		if (progress < FINAL) {
			progress += 0.01;
		}
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}
}
