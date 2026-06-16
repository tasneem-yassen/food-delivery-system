public class Customer implements Comparable<Customer> {
	private String customerCode;
	private String firstName;
	private String familyName;
	private Address address; 
	private String customerPhone;
	private String customerMail;
	private double refundBalance;
//////////constructor/////////////
	public Customer(String customerCode, String firstName, String familyName, Address address, String customerPhone,
			String customerMail, double refundBalance) {
		setCustomerCode(customerCode);
		setFirstName(firstName);
		setFamilyName(familyName);
		setAddress(address);
		setCustomerPhone(customerPhone);
		setCustomerMail(customerMail);
		setRefundBalance(refundBalance);
	}
////////////getters and setters/////////////////
	public String getCustomerCode() {
		return customerCode;
	}
	public boolean setCustomerCode(String customerCode) {
		if(InputValidation.isNotEmpty(customerCode)) {
			customerCode = customerCode.trim();
			this.customerCode = customerCode;
			return true;
		}
		return false;
	}
	public String getFirstName() {
		return firstName;
	}
	public boolean setFirstName(String firstName) {
		if(InputValidation.isNotEmpty(firstName) && InputValidation.isOnlyLetters(firstName)) {
			firstName = firstName.trim();
			this.firstName = firstName;
			return true; 
		}
		return false;
		
	}
	public String getFamilyName() {
		return familyName;
	}
	public boolean setFamilyName(String familyName) {
		if(InputValidation.isNotEmpty(familyName) && InputValidation.isOnlyLettersAndSpaces(familyName)) {
			familyName = familyName.trim();
			this.familyName = familyName;
			return true; 
		}
		return false;
		
		
	}
	public Address getAddress() {
		return address;
	}
	public boolean setAddress(Address address) {
		if(address != null) {
			this.address = address;
			return true ;
		}
		return false; 
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public boolean setCustomerPhone(String customerPhone) {
		if(InputValidation.isNotEmpty(customerPhone) && InputValidation.isOnlyDigits(customerPhone)) {
			customerPhone = customerPhone.trim();
			if(customerPhone.length()==10 && customerPhone.startsWith("05")) {
				this.customerPhone = customerPhone;
				return true;
			}
		}
		return false;
			
		
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public boolean setCustomerMail(String customerMail) {
		if(InputValidation.isValidEmail(customerMail)) {
			this.customerMail = customerMail.trim();
			return true;
		}
		return false;
		
	}
	public double getRefundBalance() {
		return refundBalance;
	}
	public boolean setRefundBalance(double refundBalance) {
		if(refundBalance >=0) {
			this.refundBalance = refundBalance;
			return true;
		}
		return false; 
	}
/////////////toString////////////////////
	@Override
	public String toString() {
		return "Customer:( Code: " + customerCode +
				", Name: " + firstName +" "+ familyName
				+", " +address.toString() + ", Phone Number: " + customerPhone + 
				", Mail: " + customerMail
				+ ", Refund Balance: " + refundBalance + ")";
	}
	//override the deafult equals method : 2 customers are equal if the codes are the same  
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer)obj;
		return this.customerCode.equals(other.customerCode);
	}
//////////////comparable function implementation///////
	@Override
	public int compareTo(Customer other) {
		return Double.compare(other.refundBalance, this.refundBalance);
	}
}
