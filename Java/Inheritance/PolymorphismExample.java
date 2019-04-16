/**
 * 
 */
package JavaCoding;

/**
 * @author sayray
 *
 */
public class PolymorphismExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape sp = new Shape();
		Shape cir = new Circle();
		Shape rec = new Rectrangle();
		
		//Polymorphic call - Dynamic binding
		sp.draw();
		cir.draw();
		rec.draw();
		
		//Static Binding
		sp.display();
		cir.display();
		rec.display();
		
		Circle c = new Circle();
		//Calls Circle's method
		c.display();

	}

}
