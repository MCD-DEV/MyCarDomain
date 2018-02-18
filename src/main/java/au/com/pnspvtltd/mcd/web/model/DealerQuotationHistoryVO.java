package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class DealerQuotationHistoryVO {

	private Long dealQuotationHistoryId;

	private String comment;
	private Date creationDate;

	public Long getDealQuotationHistoryId() {
		return dealQuotationHistoryId;
	}

	public void setDealQuotationHistoryId(Long dealQuotationHistoryId) {
		this.dealQuotationHistoryId = dealQuotationHistoryId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* end */

}
