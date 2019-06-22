package basetest.lift;

public class Request {
	private int atFloor;
	private int toFloor;
	
	
	
	public Request(int atFloor, int toFloor) {
		super();
		this.atFloor = atFloor;
		this.toFloor = toFloor;
	}
	
	public int getAtFloor() {
		return atFloor;
	}
	public void setAtFloor(int atFloor) {
		this.atFloor = atFloor;
	}
	public int getToFloor() {
		return toFloor;
	}
	public void setToFloor(int toFloor) {
		this.toFloor = toFloor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atFloor;
		result = prime * result + toFloor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (atFloor != other.atFloor)
			return false;
		if (toFloor != other.toFloor)
			return false;
		return true;
	}
	

}
