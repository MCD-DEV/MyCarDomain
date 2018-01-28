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

public class UserTransportSlotVO {

	// Unique Quotation id
	private Long quotId;
	
			
	List<UserQuotaReqBookSlotTranpVO> userQuotaReqBookSlotTranpVO;
	
	

	public Long getQuotId() {
		return quotId;
	}


	public void setQuotId(Long quotId) {
		this.quotId = quotId;
	}


	public List<UserQuotaReqBookSlotTranpVO> getUserQuotaReqBookSlotTranpVO() {
		return userQuotaReqBookSlotTranpVO;
	}


	public void setUserQuotaReqBookSlotTranpVO(List<UserQuotaReqBookSlotTranpVO> userQuotaReqBookSlotTranpVO) {
		this.userQuotaReqBookSlotTranpVO = userQuotaReqBookSlotTranpVO;
	}


	

}
