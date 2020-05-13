package model;

public class CircleModel {
	
	private double radius;
	private boolean grow;
	public static final double MAX_RADIUS = 40;
	public static final double MIN_RADIUS = 20;
	public static final double RADIUS_UNIT = 0.5;	
	
	public CircleModel (double r, boolean g) {
		radius = r;
		grow = g;
	}
	
	public void alterSize () {
		if (grow) {
			radius += RADIUS_UNIT;
		}
		else {
			radius -= RADIUS_UNIT;
		}
	}

	public double getRadius() {
		return radius;
	}

	public boolean isGrow() {
		return grow;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setGrow(boolean grow) {
		this.grow = grow;
	}
}
