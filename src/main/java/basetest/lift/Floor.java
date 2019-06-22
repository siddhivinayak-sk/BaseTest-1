package basetest.lift;

public class Floor {
	private Integer id;
	private String name;
	private Lift lift1;
	private Lift lift2;
	private Lift lift3;
	private Lift lift4;
	private Lift lift5;
	
	public Floor() {
		super();
	}
	
	public Floor(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Lift getLift1() {
		return lift1;
	}

	public void setLift1(Lift lift1) {
		this.lift1 = lift1;
	}

	public Lift getLift2() {
		return lift2;
	}

	public void setLift2(Lift lift2) {
		this.lift2 = lift2;
	}

	public Lift getLift3() {
		return lift3;
	}

	public void setLift3(Lift lift3) {
		this.lift3 = lift3;
	}

	public Lift getLift4() {
		return lift4;
	}

	public void setLift4(Lift lift4) {
		this.lift4 = lift4;
	}

	public Lift getLift5() {
		return lift5;
	}

	public void setLift5(Lift lift5) {
		this.lift5 = lift5;
	}

	@Override
	public String toString() {
		return "Floor [id=" + id + ", name=" + name + ", lift1=" + lift1 + ", lift2=" + lift2 + ", lift3=" + lift3
				+ ", lift4=" + lift4 + ", lift5=" + lift5 + "]";
	}
	
	
}
