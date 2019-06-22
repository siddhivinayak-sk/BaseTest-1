package basetest.lift;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private Integer id;
	private String name;
	private List<Floor> floors;
	
	
	public Building() {
		super();
		floors = new ArrayList<Floor>();
	}


	public Building(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		floors = new ArrayList<Floor>();
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


	public List<Floor> getFloors() {
		return floors;
	}


	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}


	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", floors=" + floors + "]";
	}

	
	
}
