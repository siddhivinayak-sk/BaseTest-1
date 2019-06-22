package basetest.lift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {
	private LinkedBlockingQueue<Request> path = new LinkedBlockingQueue<>();
	private List<Floor> fList;;
	private Lift lift;
	private boolean isStarted;

	public Controller(List<Floor> f, Lift l) {
		fList = f;
		lift = l;
		isStarted = false;
	}
	
	public void addRequest(Request request) {
		new Thread( () -> {
			try {
				path.put(request);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}).start();;
	}

	public void start() {
		isStarted = true;
		new Thread(() -> {
			while(isStarted) {
				try {
					Request r = path.take();
					move(r.getAtFloor(), r.getToFloor(), true, false);
				}
				catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		).start();
	}
	
	private void move(int from, int to, boolean isAvailableMiddle, boolean isSilentMove) throws InterruptedException {
		String base = "Lift: " + lift.getLiftId() + " ";
		if(false == isSilentMove) {
			if(lift.getFloor().getId() != from && isAvailableMiddle) {
				shift(from);
			}
			System.out.println(base + "Opening Doors");
			Thread.sleep(2000);
			lift.setDoorStatus(Lift.DoorStatus.OPENED);
			System.out.println(base + "Closing Doors");
			Thread.sleep(2000);
			lift.setDoorStatus(Lift.DoorStatus.CLOSED);
		}
		else {
			
		}
		int diff = from - to;
		boolean isUp = false;
		if(diff < 0) {
			isUp = true;
		}
		else {
			isUp = false;
		}
		diff = Math.abs(diff);
		if(diff > 0) {
			for(int i = 0; i < diff; i++) {
				Thread.sleep(2000);
				int cf = (isUp)?(lift.getFloor().getId() + 1):(lift.getFloor().getId() - 1);
				lift.setFloor(getFloor(cf));
				System.out.println(base + "at " + cf);
			}
		}
		if(false == isSilentMove) {
			System.out.println(base + "Opening Doors");
			lift.setDoorStatus(Lift.DoorStatus.OPENED);
			Thread.sleep(2000);
			System.out.println(base + "Closing Doors");
			Thread.sleep(2000);
			lift.setDoorStatus(Lift.DoorStatus.CLOSED);
		}
	}
	
	private void shift(int to) throws InterruptedException {
		int from = lift.getFloor().getId();
		int diff = from - to;
		boolean isUp = false;
		if(diff < 0) {
			isUp = true;
		}
		else {
			isUp = false;
		}
		List<Request> tempList = new ArrayList<>();
		if(isUp) {
			for(Request r:path) {
				int rdiff = r.getAtFloor() - r.getToFloor();
				if(r.getAtFloor() >= from && r.getAtFloor() <= to && r.getToFloor() > from && r.getToFloor() <= to && diff > 0) {
					tempList.add(r);
					path.remove(r);
				}
			}
			Collections.sort(tempList, new Comparator<Request>() {
				public int compare(Request r1, Request r2) {
					return r1.getToFloor() - r2.getToFloor();
				}
			});
		}
		else {
			for(Request r:path) {
				int rdiff = r.getAtFloor() - r.getToFloor();
				if(r.getAtFloor() <= from && r.getAtFloor() > to && r.getToFloor() <from && r.getToFloor() >= to && diff < 0) {
					tempList.add(r);
					path.remove(r);
				}
			}
			Collections.sort(tempList, new Comparator<Request>() {
				public int compare(Request r1, Request r2) {
					return r2.getToFloor() - r1.getToFloor();
				}
			});
		}
		if(!tempList.isEmpty()) {
			for(Request r:tempList) {
				move(r.getAtFloor(), r.getToFloor(), false, false);
			}
		}
		if(to != lift.getFloor().getId()) {
			move(lift.getFloor().getId(), to, false, true);
		}
	}
	
	private Floor getFloor(int i) {
		Floor tmp = null;
		for(Floor f:fList) {
			if(i == f.getId()) {
				tmp = f;
			}
		}
		return tmp;
	}

	public void stop() {
		isStarted = false;
	}
	
	public boolean getStatus() {
		return isStarted;
	}
}
