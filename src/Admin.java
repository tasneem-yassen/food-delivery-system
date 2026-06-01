public class Admin {
	protected String name;
	protected String userName;
	protected String password;
////////constructor////////////////
	public Admin(String name, String userName, String password) {
		setName(name);
		setUserName(userName);
		setPassword(password);
	}
/////////////getters and setters///////////////
	public String getName() {
		return name;
	}
	public boolean setName(String name) {
		if(InputValidation.isNotEmpty(name) && InputValidation.isOnlyLettersAndSpaces(name)) {
			name = name.trim();
			this.name = name;
			return true;
		}
		return false;
	}
	public String getUserName() {
		return userName;
	}
	public boolean setUserName(String userName) {
		if(InputValidation.isNotEmpty(userName)) {
			userName = userName.trim();
			this.userName = userName;
			return true;
		}
		return false; 
	}
	public String getPassword() {
		return password;
	}
	public boolean setPassword(String password) {
		if(InputValidation.isNotEmpty(password)) {
			password = password.trim(); 
			this.password = password;
			return true;
		}
		return false; 
	}
///////////toString/////////////////////
	@Override
	public String toString() {
		return "Admin: (name: " + name + 
				", userName: " + userName + 
				", password: " + password + ")";
	} 
///////////override the deafult equals method: 2 admins are equal if their usernames are the same 
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true; 
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false; 
		}
		Admin other = (Admin)obj;
		return this.userName.equals(other.userName);
	}
}
