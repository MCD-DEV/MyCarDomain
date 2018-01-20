package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import au.com.pnspvtltd.mcd.domain.DealerQuotationHistory;
import au.com.pnspvtltd.mcd.domain.OfferDateList;
import au.com.pnspvtltd.mcd.domain.QuotationFeatList;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.VehQuotDoc;
import au.com.pnspvtltd.mcd.domain.VehQuotExtras;
import au.com.pnspvtltd.mcd.domain.VehQuotTerm;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsQuo;

public class QuotaInterestVO {

	// Unique Quotation id
	private Long quotId;
	
	private boolean interest;
	
	private boolean testDrive;
			
	
	public boolean isInterest() {
		return interest;
	}


	public void setInterest(boolean interest) {
		this.interest = interest;
	}


	public boolean isTestDrive() {
		return testDrive;
	}


	public void setTestDrive(boolean testDrive) {
		this.testDrive = testDrive;
	}


	List<UserQuotaReqTestDriveVO> userQuotaReqTestDriveVO;
	
	public List<UserQuotaReqTestDriveVO> getUserQuotaReqTestDriveVO() {
		return userQuotaReqTestDriveVO;
	}


	public void setUserQuotaReqTestDriveVO(
			List<UserQuotaReqTestDriveVO> userQuotaReqTestDriveVO) {
		this.userQuotaReqTestDriveVO = userQuotaReqTestDriveVO;
	}


	public Long getQuotId() {
		return quotId;
	}


	public void setQuotId(Long quotId) {
		this.quotId = quotId;
	}


	

}
