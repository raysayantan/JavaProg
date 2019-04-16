package JavaCoding;

public class Shape {
	public void draw() {
		System.out.println("Base Class :  Shape methos called...");
	}
	
	public static void display() {
		System.out.println("Base Display");
	}
}

class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("Derivied Class :  Circle methos called...");
	}
	
	public static void display() {
		System.out.println("Circle Display");
	}
}

class Rectrangle extends Shape{
	@Override
	public void draw() {
		System.out.println("Derivied Class :  Rectrangle methos called...");
	}
	
	public static void display() {
		System.out.println("Rectrangle Display");
	}
}
