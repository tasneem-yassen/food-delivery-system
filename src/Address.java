//this class represents an address and validates if its correct 
public class Address {
	private String street;
	private String city;
	private String zipCode;
////////////constructor///////////////////
	public Address(String street, String city, String zipCode) {
		setCity(city);
		setStreet(street);
		setZipCode(zipCode);
	}
/////////////getters and setters/////////////
	public String getCity() {
		return city;
	}
	public boolean setCity(String city) {
		if(InputValidation.isNotEmpty(city) && InputValidation.isOnlyLettersAndSpaces(city)) {
			city = city.trim();
			this.city = city;
			return true; 
		}
		return false;
	}
	public String getStreet() {
		return street;
	}
	public boolean setStreet(String street) {
		if(InputValidation.isNotEmpty(street)) {
			street = street.trim();
			this.street = street;
			return true; 
		}
		return false;
	}
	public String getZipCode() {
		return zipCode;
	}
	public boolean setZipCode(String zipCode) {
		if(InputValidation.isValidZipCode(zipCode)) {
			zipCode = zipCode.trim();
			this.zipCode = zipCode;
			return true; 
		}
		return false;
	}
/////////toString///////////
	@Override
	public String toString() {
		return "Address: (street: " + street + ", city: " + city
				+ ", zipCode: " + zipCode + ")";
	} 
	
}
