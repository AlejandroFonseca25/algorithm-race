package model;

public class AnimationManager {

	private CircleModel[] circles;
	//0 = circle1 (small) , 1 = circle2 (big)
	
	private TimeUnit milli;

	private TimeUnit second;
	
	private TimeUnit min;
	
	private TimeUnit hour;
	
	private boolean on;
	
	public AnimationManager (CircleModel[] cir, TimeUnit[] tim) {
		circles = cir;
		milli = tim[0];
		second = tim[1];
		min = tim[2];
		hour = tim[3];
		on = false;
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

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
