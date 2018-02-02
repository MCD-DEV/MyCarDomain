package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;



public class UserQuotaDocInsVO {


	
	
	private Long userQuotationHistoryId;
	 
	
	
	private String docName;
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


	public Long getUserQuotationHistoryId() {
		return userQuotationHistoryId;
	}


	public void setUserQuotationHistoryId(Long userQuotationHistoryId) {
		this.userQuotationHistoryId = userQuotationHistoryId;
	}

	
	
	
	
	
	public Timestamp getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	
	

	 	
	
}
