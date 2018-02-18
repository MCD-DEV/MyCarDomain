package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

public class UserAdminSearchVO {

	private String firstName;
	private String lastName;
	private String email;
	private int postCode;
	private Date creationDate;

	List<UserVO> userVO;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

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

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public List<UserVO> getUserVO() {
		return userVO;
	}

	public void setUserVO(List<UserVO> userVO) {
		this.userVO = userVO;
	}

}
