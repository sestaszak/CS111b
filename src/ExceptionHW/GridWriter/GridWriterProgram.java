package ExceptionHW.GridWriter;

public class GridWriterProgram {
	
	public static void main(String[] args) {
		GridWriter gw1 = new GridWriter(40, 50);

		gw1.add(new MyCircle(10, 10, 9));
		gw1.add(new MyCircle(25, 20, 12));
		gw1.add(new MyCircle(25, 20, 5));

		gw1.add(new MyRectangle(25, 25, 20, 15));
		gw1.add(new MyRectangle(5, 5, 3, 4));
		gw1.add(new MyRectangle(40, 0, 10, 10));

		gw1.display();

		GridWriter gw2 = new GridWriter(40, 50);

		gw2.add(new MyCircle(10, 10, 9));
		gw2.add(new MyRectangle(40, 0, 10, 10));

		for (int i = 0; i < gw2.size(); i++) {
			System.out.println(gw2.get(i).getArea());
		}

		GridWriter gw3 = new GridWriter(40, 50);

		gw3.add(new MyCircle(10, 10, 9));
		gw3.add(new MyRectangle(40, 0, 10, 10));

		GridItem i = gw3.get(2);
		System.out.println(i.getArea());


	}
	
}