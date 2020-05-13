package model;

public class TimeUnit {
	
	private int unit;
	public static final int MILLI_MAX = 1000;
	public static final int SECOND_MAX = 60;
	public static final int MIN_MAX = 60;
	
	public TimeUnit (int u) {
		unit = u;
	}
	
	public void addTimeUnit () {
		unit += 1;
	}
	
	public void setUnit (int u) {
		unit = u;
	}
	
	public int getUnit () {
		return unit;
	}
}
