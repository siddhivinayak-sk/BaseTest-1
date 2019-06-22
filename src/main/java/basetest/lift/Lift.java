package basetest.lift;

final public class Lift {
	private static volatile Lift lift1 = null;
	private static volatile Lift lift2 = null;
	private static volatile Lift lift3 = null;
	private static volatile Lift lift4 = null;
	private static volatile Lift lift5 = null;
	
	private Lift() {};

	private Integer liftId;
	private LiftStatus liftStatus;
	private DoorStatus doorStatus;
	private Floor floor;
	
	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId = liftId;
	}

	public LiftStatus getLiftStatus() {
		return liftStatus;
	}

	public void setLiftStatus(LiftStatus liftStatus) {
		this.liftStatus = liftStatus;
	}

	public DoorStatus getDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(DoorStatus doorStatus) {
		this.doorStatus = doorStatus;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	
	@Override
	public String toString() {
		return "Lift [liftId=" + liftId + ", liftStatus=" + liftStatus + ", doorStatus=" + doorStatus + ", floor="
				+ floor + "]";
	}

	public static Lift getLift1() {
		if(null == lift1) {
			synchronized(Lift.class) {
				if(null == lift1) {
					lift1 = new Lift();
					lift1.setLiftId(1);
					lift1.setFloor(null);
					lift1.setDoorStatus(DoorStatus.CLOSED);
					lift1.setLiftStatus(LiftStatus.IDEAL);
				}
			}
		}
		return lift1;
	}

	public static Lift getLift2() {
		if(null == lift2) {
			synchronized(Lift.class) {
				if(null == lift2) {
					lift2 = new Lift();
					lift2.setLiftId(2);
					lift2.setFloor(null);
					lift2.setDoorStatus(DoorStatus.CLOSED);
					lift2.setLiftStatus(LiftStatus.IDEAL);
				}
			}
		}
		return lift2;
	}

	public static Lift getLift3() {
		if(null == lift3) {
			synchronized(Lift.class) {
				if(null == lift3) {
					lift3 = new Lift();
					lift3.setLiftId(1);
					lift3.setFloor(null);
					lift3.setDoorStatus(DoorStatus.CLOSED);
					lift3.setLiftStatus(LiftStatus.IDEAL);
				}
			}
		}
		return lift3;
	}

	public static Lift getLift4() {
		if(null == lift4) {
			synchronized(Lift.class) {
				if(null == lift4) {
					lift4 = new Lift();
					lift4.setLiftId(1);
					lift4.setFloor(null);
					lift4.setDoorStatus(DoorStatus.CLOSED);
					lift4.setLiftStatus(LiftStatus.IDEAL);
				}
			}
		}
		return lift4;
	}

	public static Lift getLift5() {
		if(null == lift5) {
			synchronized(Lift.class) {
				if(null == lift5) {
					lift5 = new Lift();
					lift5.setLiftId(1);
					lift5.setFloor(null);
					lift5.setDoorStatus(DoorStatus.CLOSED);
					lift5.setLiftStatus(LiftStatus.IDEAL);
				}
			}
		}
		return lift5;
	}

	public enum LiftStatus {IDEAL, RUNNING, MAINTENANCE, OUTOFORDER};
	public enum DoorStatus {OPENED, CLOSED};
}
