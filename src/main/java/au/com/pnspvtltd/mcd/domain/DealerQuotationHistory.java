package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Quoatation dealer History
 * 
 */
@Entity
@Table(name = "dealerquotationhistory")
public class DealerQuotationHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long dealQuotationHistoryId;

	private String comment;
	private Date creationDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEALQUOTATIONHISTORYID")
	public Long getDealQuotationHistoryId() {
		return dealQuotationHistoryId;
	}

	public void setDealQuotationHistoryId(Long dealQuotationHistoryId) {
		this.dealQuotationHistoryId = dealQuotationHistoryId;
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

	/* end */

}
