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

public class QuotaDocVO {

	// Unique Quotation id
	private Long quotId;
	
	private String typeOfQuotation;	
	
	
	public String getTypeOfQuotation() {
		return typeOfQuotation;
	}


	public void setTypeOfQuotation(String typeOfQuotation) {
		this.typeOfQuotation = typeOfQuotation;
	}


	List<UserQuotaDocVO> userQuotaDocVO;
	
	public List<UserQuotaDocVO> getUserQuotaDocVO() {
		return userQuotaDocVO;
	}


	public void setUserQuotaDocVO(
			List<UserQuotaDocVO> userQuotaDocVO) {
		this.userQuotaDocVO = userQuotaDocVO;
	}


	public Long getQuotId() {
		return quotId;
	}


	public void setQuotId(Long quotId) {
		this.quotId = quotId;
	}


	

}
