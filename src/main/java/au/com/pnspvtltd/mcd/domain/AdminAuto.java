package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CARMODEL
 * 
 */
@Entity
@Table(name = "AdminAuto")
public class AdminAuto implements Serializable {
	private static final long serialVersionUID = 2795828321233759004L;

	private Long ID;
	private String userName;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
