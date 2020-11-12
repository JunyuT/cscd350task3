package cs350f20task3;
//calculate distance and bearing

public class Coordinates {
private double xCor;
private double yCor;
	
	public Coordinates(double x, double y) {
		this.xCor = x;
		this.yCor = y;
	}
	
	public Coordinates add(Coordinates coordinates) {
		//don't just add and return current object as that'll always override the coordinates. return new object to prevent.
		return new Coordinates(this.xCor + coordinates.xCor, this.yCor + coordinates.yCor);
	}
	
	public double calculateBearing(Coordinates coordinates) {
		double rad =  Math.atan2(coordinates.getY()-this.getY(), coordinates.getX() - this.getX());
		return 90 - (180/Math.PI)*rad;
	}
	
	public double calculateDistance(Coordinates coordinates) {
		return Math.sqrt((Math.pow(this.xCor-coordinates.getX(), 2)+ Math.pow(this.yCor - coordinates.getY(), 2)));
	}
	
	public double getX() {
		return this.xCor;
	}
	
	public double getY() {
		return this.yCor;
	}
	
	public boolean isNear(Coordinates coordinates) {
		if(Math.abs(coordinates.xCor - this.getX()) <= 0.01 && Math.abs(coordinates.yCor - this.getY()) <= 0.01) {
			return true;
		}
		return false;
	}
	
	public Coordinates subtract(Coordinates coordinates) {
		return new Coordinates(this.xCor - coordinates.xCor, this.yCor - coordinates.yCor);
	}
	
	@Override
	public String toString() {
		return this.getX() + ", " + this.getY();
	}
}
