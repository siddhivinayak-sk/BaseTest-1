package basetest.collection;

import java.util.Arrays;
import java.util.List;

public class Collection2Test {

	public static void main(String...args) {
		Collection2Test test = new Collection2Test();
		List<Employee> employees = test.prepareData();
		Detail d = employees.stream().flatMap(emp -> emp.addressList.stream()).flatMap(address -> address.primaryAddressList.stream()).flatMap(paddress -> paddress.detailList.stream()).findFirst().orElseThrow(() -> new RuntimeException());
		System.out.println(d.getAddressLine());
	}
	
	static class Employee {
		private long id;
		private List<Address> addressList;
		public Employee(long id, List<Address> addressList) {
			super();
			this.id = id;
			this.addressList = addressList;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public List<Address> getAddressList() {
			return addressList;
		}
		public void setAddressList(List<Address> addressList) {
			this.addressList = addressList;
		}
	}
	
	static class Address {
		private List<PrimaryAddress> primaryAddressList;
		private List<SecondaryAddress> secondaryAddressList;
		public Address(List<PrimaryAddress> primaryAddressList, List<SecondaryAddress> secondaryAddressList) {
			super();
			this.primaryAddressList = primaryAddressList;
			this.secondaryAddressList = secondaryAddressList;
		}
		public List<PrimaryAddress> getPrimaryAddressList() {
			return primaryAddressList;
		}
		public void setPrimaryAddressList(List<PrimaryAddress> primaryAddressList) {
			this.primaryAddressList = primaryAddressList;
		}
		public List<SecondaryAddress> getSecondaryAddressList() {
			return secondaryAddressList;
		}
		public void setSecondaryAddressList(List<SecondaryAddress> secondaryAddressList) {
			this.secondaryAddressList = secondaryAddressList;
		}
	}
	
	static class PrimaryAddress {
		private long id;
		private List<Detail> detailList;
		public PrimaryAddress(long id, List<Detail> detailList) {
			super();
			this.id = id;
			this.detailList = detailList;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public List<Detail> getDetailList() {
			return detailList;
		}
		public void setDetailList(List<Detail> detailList) {
			this.detailList = detailList;
		}
	}

	static class SecondaryAddress {
		private long id;
		private List<Detail> detailList;
		public SecondaryAddress(long id, List<Detail> detailList) {
			super();
			this.id = id;
			this.detailList = detailList;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public List<Detail> getDetailList() {
			return detailList;
		}
		public void setDetailList(List<Detail> detailList) {
			this.detailList = detailList;
		}
	}
	
	static class Detail {
		private String pinCode;
		private String addressLine;
		
		public Detail(String pinCode, String addressLine) {
			super();
			this.pinCode = pinCode;
			this.addressLine = addressLine;
		}
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		public String getAddressLine() {
			return addressLine;
		}
		public void setAddressLine(String addressLine) {
			this.addressLine = addressLine;
		}
	}

	List<Employee> prepareData() {
		List<Detail> details1 = Arrays.asList(new Detail("E121001", "EAddress1"), new Detail("E121002", "EAddress2"), new Detail("E121003", "EAddress3"), new Detail("E121004", "EAddress4"), new Detail("E121005", "EAddress5"));
		List<Detail> details2 = Arrays.asList(new Detail("F121001", "FAddress1"), new Detail("F121002", "FAddress2"), new Detail("F121003", "FAddress3"), new Detail("F121004", "FAddress4"), new Detail("F121005", "FAddress5"));
		List<PrimaryAddress> primaryList1 = Arrays.asList(new PrimaryAddress(1, details1));
		List<PrimaryAddress> primaryList2 = Arrays.asList(new PrimaryAddress(2, details2));
		List<SecondaryAddress> secondaryList1 = Arrays.asList(new SecondaryAddress(1, details1));
		List<SecondaryAddress> secondaryList2 = Arrays.asList(new SecondaryAddress(2, details2));
		List<Address> addressList = Arrays.asList(new Address(primaryList1, secondaryList1), new Address(primaryList2, secondaryList2));
		return Arrays.asList(new Employee(1, addressList));
	}

}
