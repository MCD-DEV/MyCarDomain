package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

import org.joda.time.DateTime;



public class UserQuotationHistoryInsVO {


	
	
	private Long userQuotationHistoryId;
	 
	
	
	private String comment;
	private Date creationDate;
	
	//private long idp;
	
	private String name;
	
	
	/*public long getIdp() {
		return idp;
	}


	public void setIdp(long idp) {
		this.idp = idp;
	}*/


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getUserQuotationHistoryId() {
		return userQuotationHistoryId;
	}


	public void setUserQuotationHistoryId(Long userQuotationHistoryId) {
		this.userQuotationHistoryId = userQuotationHistoryId;
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

	
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	
	

	 	
	
}
