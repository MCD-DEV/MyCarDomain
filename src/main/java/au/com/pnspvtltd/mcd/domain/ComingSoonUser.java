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
@Table(name = "comingsoonuser")
public class ComingSoonUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long comingSoonUserID;

	/* start */
	private String comingSoonUserEmail;

	private String flex1;
	private String flex2;

	private int flex3;
	private int flex4;

	private double flex5;
	private double flex6;

	/* end */

	// @Column(name = "PHOTO1")

	@Column(name = "COMINGSOONUSEREMAIL")
	public String getComingSoonUserEmail() {
		return comingSoonUserEmail;
	}

	public void setComingSoonUserEmail(String comingSoonUserEmail) {
		this.comingSoonUserEmail = comingSoonUserEmail;
	}

	@Column(name = "FLEX1")
	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Column(name = "FLEX2")
	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	@Column(name = "FLEX3")
	public int getFlex3() {
		return flex3;
	}

	public void setFlex3(int flex3) {
		this.flex3 = flex3;
	}

	@Column(name = "FLEX4")
	public int getFlex4() {
		return flex4;
	}

	public void setFlex4(int flex4) {
		this.flex4 = flex4;
	}

	@Column(name = "FLEX5")
	public double getFlex5() {
		return flex5;
	}

	public void setFlex5(double flex5) {
		this.flex5 = flex5;
	}

	@Column(name = "FLEX6")
	public double getFlex6() {
		return flex6;
	}

	public void setFlex6(double flex6) {
		this.flex6 = flex6;
	}

	public ComingSoonUser() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMINGSOONUSERID")
	public Long getComingSoonUserId() {
		return comingSoonUserID;
	}

	public void setComingSoonUserId(Long comingSoonUserID) {
		this.comingSoonUserID = comingSoonUserID;
	}

}
