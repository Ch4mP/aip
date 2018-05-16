package rest;

public class Guard {

	private String name;
	private String pw;
	private String email;
	
	// Creates a guard
	public Guard(String name, String pw, String email) {
		this.name = name;
		this.pw = pw;
		this.email = email;
	}
	
	// Get the name of the guard
	public String getName() {
		return this.name;
	}
	
	// Get the email of the guard
	public String getEMail() {
		return this.email;
	}
	
	// Check password
	public boolean isPW(String pw) {
		return (pw == this.pw);
	}
	
	// Change the password if the old password is correct
	public boolean changePassword(String oldPW, String newPW) {
		if(this.isPW(oldPW)) {
			this.pw = newPW;
			return true;
		}else {
			return false;
		}
	}
	
	// Change the email if the password is correct
	public boolean changeEMail(String pw, String newEMail) {
		if(this.isPW(pw)) {
			this.email = newEMail;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guard other = (Guard) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
