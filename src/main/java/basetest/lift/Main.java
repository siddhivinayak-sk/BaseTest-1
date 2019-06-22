package basetest.lift;

public class Main {
	public static void main(String...args) {
		Building b1 = new Building(1, "Tower - A");
		
		Lift l1 = Lift.getLift1();
		Lift l2 = Lift.getLift2();
		Lift l3 = Lift.getLift3();
		Lift l4 = Lift.getLift4();
		Lift l5 = Lift.getLift5();
		
		Floor f1 = new Floor(1, ":Level 1");
		Floor f2 = new Floor(2, ":Level 2");
		Floor f3 = new Floor(3, ":Level 3");
		Floor f4 = new Floor(4, ":Level 4");
		Floor f5 = new Floor(5, ":Level 5");
		
		l1.setFloor(f1);
		l2.setFloor(f1);
		l3.setFloor(f1);
		l4.setFloor(f1);
		l5.setFloor(f1);
		
		b1.getFloors().add(f1);
		b1.getFloors().add(f2);
		b1.getFloors().add(f3);
		b1.getFloors().add(f4);
		b1.getFloors().add(f5);
		
		Controller c1 = new Controller(b1.getFloors(), l1);
		c1.start();
		c1.addRequest(new Request(5, 3));
		c1.addRequest(new Request(5, 4));
		c1.addRequest(new Request(5, 1));
		c1.addRequest(new Request(2, 3));
		c1.addRequest(new Request(3, 1));
		
		
		
	}
}
