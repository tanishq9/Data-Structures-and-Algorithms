package OOPS3;

// can have both abstract and concrete methods
abstract class Shape {
	String color;

	// abstract methods
	abstract double area();

	public abstract String toString();

	// abstract class can have a constructor
	public Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}

class Circle extends Shape {

	double radius;

	public Circle(String color, double radius) {
		// always call the parent class constructor,its a must
		super(color);
		this.radius = radius;
	}

	@Override
	double area() {
		// TODO Auto-generated method stub
		return Math.PI * this.radius;
	}

	@Override
	public String toString() {
		return "My color is " + super.color;
	}
}

class Rectangle extends Shape {
	double length;
	double width;

	public Rectangle(String color, double w, double l) {
		super(color);
		this.length = l;
		this.width = w;
	}

	@Override
	double area() {
		// TODO Auto-generated method stub
		return this.length * this.width;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "My color is " + super.color;
	}

	public void thisClassOwnMethod() {

	}

}

public class Abstraction {

}
