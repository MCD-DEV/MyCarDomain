package au.com.pnspvtltd.mcd.domain;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Quoatation user History
 * 
 */
@Entity @Table(name = "transpquotareqtodrive") public class UserQuotaReqTestDriveTranp implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long userQuotationHistoryId;
	 
	
	private TranspServiceQuotation vehicleQuotation;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
		@JoinColumn(name = "TranspServQuotId")
		public TranspServiceQuotation getVehicleQuotation() {
			return vehicleQuotation;
		}

		public void setVehicleQuotation(TranspServiceQuotation vehicleQuotation) {
			this.vehicleQuotation = vehicleQuotation;
		}
	private String postCode;
	private String title;
	private String fName;
	private String lName;
	private String address;
	private String mobile;
	private Date prefDate;
	private Date creationDate;
	//private long idp;
	
	private String flex1;
	
	

	/*public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}*/

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getPrefDate() {
		return prefDate;
	}

	public void setPrefDate(Date prefDate) {
		this.prefDate = prefDate;
	}

	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "USERQUOTATIONHISTORYID")
	public Long getUserQuotationHistoryId() {
		return userQuotationHistoryId;
	}


	public void setUserQuotationHistoryId(Long userQuotationHistoryId) {
		this.userQuotationHistoryId = userQuotationHistoryId;
	}

	
	
	
	@Column(name = "CREATIONDATE") 
	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	
	

	 	
	
}
