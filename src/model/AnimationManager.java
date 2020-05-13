package model;

public class AnimationManager {

	private CircleModel[] circles;
	//0 = circle1 (small) , 1 = circle2 (big)
	
	private ProgressBarModel[] progressBars;
	//0 = Team Tree , 1 = Team List , 2 = Team Array
	
	private TimeUnit milli;

	private TimeUnit second;
	
	private TimeUnit min;
	
	private TimeUnit hour;
	
	public AnimationManager (CircleModel[] cir, ProgressBarModel[] p, TimeUnit[] tim) {
		circles = cir;
		progressBars = p;
		milli = tim[0];
		second = tim[1];
		min = tim[2];
		hour = tim[3];
	}
	
	public void circleAnimation () {
		
		for (int i = 0; i < 2 ; i++) {
			if (circles[i].getRadius() == CircleModel.MIN_RADIUS) {
				circles[i].setGrow(true);
			} 
			else if (circles[i].getRadius() == CircleModel.MAX_RADIUS) {
				circles[i].setGrow(false);
			}
			circles[i].alterSize();
		}
	}
	
	public void timerAnimation () {
		
		milli.addTimeUnit();
		
		if (milli.getUnit() == TimeUnit.MILLI_MAX) {
			second.addTimeUnit();
			milli.setUnit(0);
		}
		if (second.getUnit() == TimeUnit.SECOND_MAX) {
			min.addTimeUnit();
			second.setUnit(0);
		}
		if (min.getUnit() == TimeUnit.MIN_MAX) {
			hour.addTimeUnit();
			min.setUnit(0);
		}
	}
	
	public void progressBarAnimation (boolean yesTree, boolean yesList, boolean yesArray) {
		if (yesTree) {
			progressBars[0].advanceProgress();
		}
		if (yesList) {
			progressBars[1].advanceProgress();
		}
		if (yesArray) {
			progressBars[2].advanceProgress();
		}
	}
	
	public String toStringTime () {
		String sMilli = ":" + milli.getUnit();
		String sSecond = ":" + second.getUnit();
		String sMin = ":" + min.getUnit();
		String sHour = String.valueOf(hour.getUnit());
		if (milli.getUnit() < 10) {
			sMilli = ":0" + milli.getUnit();
		}
		if (second.getUnit() < 10) {
			sSecond = ":0" + second.getUnit();
		}
		if (min.getUnit() < 10) {
			sMin = ":0" + min.getUnit();
		}
		if (hour.getUnit() < 10) {
			sHour = "0" + hour.getUnit();
		}
		return sHour + sMin + sSecond + sMilli;
	}

	public CircleModel[] getCircles() {
		return circles;
	}

	public ProgressBarModel[] getProgressBars() {
		return progressBars;
	}

	public TimeUnit getMilli() {
		return milli;
	}

	public TimeUnit getSecond() {
		return second;
	}

	public TimeUnit getMin() {
		return min;
	}

	public TimeUnit getHour() {
		return hour;
	}

	public void setCircles(CircleModel[] circles) {
		this.circles = circles;
	}

	public void setProgressBars(ProgressBarModel[] progressBars) {
		this.progressBars = progressBars;
	}

	public void setMilli(TimeUnit milli) {
		this.milli = milli;
	}

	public void setSecond(TimeUnit second) {
		this.second = second;
	}

	public void setMin(TimeUnit min) {
		this.min = min;
	}

	public void setHour(TimeUnit hour) {
		this.hour = hour;
	}
}
