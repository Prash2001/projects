package main.java.csvparser;

public class Data {
	private String serialnum;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String address;
	public Data() {
		
	}
	public Data(String serialnum, String firstname, String lastname, String email, String mobile, String address){
		this.setAddress(address);
		this.setEmail(email);
		this.setSerialnum(serialnum);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setMobile(mobile);
	}
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Data [serialnum=" + serialnum + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", mobile=" + mobile + ", address=" + address + "]";
	}
	

}
