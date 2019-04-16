package JavaCoding;

public class Inheritance {

	public static void main(String[] args) {
		Shape sp1 = new Circle();
		/*
		 * Below call will get compilation error : As sp1 is reference to an object of type Shape
		 * even though the actual object is Circle
		 */
		//sp1.whatTypeCurve();
		
		Circle c = new Circle();
		c.whatTypeCurve();
	}

}
