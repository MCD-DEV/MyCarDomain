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
@Entity @Table(name = "userquotationhistoryins") public class UserQuotationHistoryIns implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long userQuotationHistoryId;
	 
	
	private InsuranceQuotation vehicleQuotation;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
		@JoinColumn(name = "insQuotId")
		public InsuranceQuotation getVehicleQuotation() {
			return vehicleQuotation;
		}

		public void setVehicleQuotation(InsuranceQuotation vehicleQuotation) {
			this.vehicleQuotation = vehicleQuotation;
		}
	private String comment;
	private Date creationDate;
	//private long idp;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}*/

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "USERQUOTATIONHISTORYID")
	public Long getUserQuotationHistoryId() {
		return userQuotationHistoryId;
	}


	public void setUserQuotationHistoryId(Long userQuotationHistoryId) {
		this.userQuotationHistoryId = userQuotationHistoryId;
	}

	
	@Column(name = "COMMENT") 
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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
