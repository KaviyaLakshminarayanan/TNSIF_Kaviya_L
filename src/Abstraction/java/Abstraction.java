package Abstraction.java;

public class Abstraction {

		public static void main(String[] args) {
			Square sq=new Square();
			Rectangle r1=new Rectangle();
			sq.calArea();
			sq.show();
			r1.calArea();
			r1.show();
			
			System.out.println("------------------------------------------------");
			Shape shape;
			shape=new Square(12.5f);
			
			shape.calArea(); // invoked Square class calArea()
			shape.show();
			
			shape=new Rectangle(10,20);
			
			shape.calArea(); // invoked Rectangle class calArea()
			shape.show();
}
}