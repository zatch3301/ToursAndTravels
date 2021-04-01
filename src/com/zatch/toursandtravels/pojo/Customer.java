package com.zatch.toursandtravels.pojo;

//pojo --> plain old Java Object.
public class Customer implements Comparable<Customer>
{
	private int custId;
	private String custName;
	private String custEmailId;
	private String custMobileNo;
	private String custPassword;
	private String custAddress;
	
	
	@Override
	public int compareTo(Customer cust) {
		return this.custId-cust.custId;
	}
	
	// To Create Empty Object.
	public Customer() {		
	}

	// To Create object with customer details without custId.
	public Customer(String custName, String custEmailId, String custMobileNo, String custPassword, String custAddress) {
		super();
		this.custName = custName;
		this.custEmailId = custEmailId;
		this.custMobileNo = custMobileNo;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
	}

	// Customer Object with CustId also.
	public Customer(int custId, String custName, String custEmailId, String custMobileNo, String custPassword,
			String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmailId = custEmailId;
		this.custMobileNo = custMobileNo;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
	}

	
	//getter and Setters
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	//To Convert object of Customer to String.
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmailId=" + custEmailId
				+ ", custMobileNo=" + custMobileNo + ", custPassword=" + custPassword + ", custAddress=" + custAddress
				+ "]";
	}
	
	
	
	
	
}
