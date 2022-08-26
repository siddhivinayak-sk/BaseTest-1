package basetest.validation;

import javax.validation.Valid;

public class DataBean {

	@Valid
	private Data data;
	
	public DataBean() {
		super();
	}

	public DataBean(@Valid Data data) {
		super();
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
