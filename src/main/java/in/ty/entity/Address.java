package in.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private int addressId;
	private String houseno;
	private String street;
	private String city;
	private String state;
	private int pincode;
	
	
	@OneToOne(mappedBy = "address")
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address{id="+addressId+", city="+city+"}";
	}

}
