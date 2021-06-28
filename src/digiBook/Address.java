package digiBook;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	 private String street;
	 private String city;
	 private String country;
	 private String zipcode;
	 
	//getters and setters
	 
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	 
	
	 
	 

}
