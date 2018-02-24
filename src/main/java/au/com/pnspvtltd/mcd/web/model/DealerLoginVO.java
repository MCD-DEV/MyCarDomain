package au.com.pnspvtltd.mcd.web.model;

public class DealerLoginVO {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userIdGen;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getUserIdGen() {
		return userIdGen;
	}

	public void setUserIdGen(String userIdGen) {
		this.userIdGen = userIdGen;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
