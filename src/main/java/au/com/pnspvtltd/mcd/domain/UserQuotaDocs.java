package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Quoatation user History
 * 
 */
@Entity
@Table(name = "userquotationdoc")
public class UserQuotaDocs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long userQuotationHistoryId;

	private VehicleQuotation vehicleQuotation;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "quotId")
	public VehicleQuotation getVehicleQuotation() {
		return vehicleQuotation;
	}

	public void setVehicleQuotation(VehicleQuotation vehicleQuotation) {
		this.vehicleQuotation = vehicleQuotation;
	}

	private String docName;
	
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private Timestamp creationDate;
	
	private String descDoc;

	

	

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDescDoc() {
		return descDoc;
	}

	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERQUOTATIONHISTORYID")
	public Long getUserQuotationHistoryId() {
		return userQuotationHistoryId;
	}

	public void setUserQuotationHistoryId(Long userQuotationHistoryId) {
		this.userQuotationHistoryId = userQuotationHistoryId;
	}

	

	@Column(name = "CREATIONDATE")
	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/* end */

}
