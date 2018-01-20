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

public class VehicleUserChatVO {

	// Unique Quotation id
	private Long quotId;
	// dealer id
	private Long dealerId;
	
	private String typeOfQuotation;
	// user id
	private Long userId;
	
	private Long dealSearchId;
	// user search lead id
	private Long carSearchId;
	// inventory reference id
	private Long refId;
			
	
	public String getTypeOfQuotation() {
		return typeOfQuotation;
	}


	public void setTypeOfQuotation(String typeOfQuotation) {
		this.typeOfQuotation = typeOfQuotation;
	}


	List<UserQuotationHistoryVO> userQuotationHistoryVO;
	
	public List<UserQuotationHistoryVO> getUserQuotationHistoryVO() {
		return userQuotationHistoryVO;
	}


	public void setUserQuotationHistoryVO(
			List<UserQuotationHistoryVO> userQuotationHistoryVO) {
		this.userQuotationHistoryVO = userQuotationHistoryVO;
	}


	public Long getQuotId() {
		return quotId;
	}


	public void setQuotId(Long quotId) {
		this.quotId = quotId;
	}


	public Long getDealerId() {
		return dealerId;
	}


	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getDealSearchId() {
		return dealSearchId;
	}


	public void setDealSearchId(Long dealSearchId) {
		this.dealSearchId = dealSearchId;
	}


	public Long getCarSearchId() {
		return carSearchId;
	}


	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}


	public Long getRefId() {
		return refId;
	}


	public void setRefId(Long refId) {
		this.refId = refId;
	}
	


}
