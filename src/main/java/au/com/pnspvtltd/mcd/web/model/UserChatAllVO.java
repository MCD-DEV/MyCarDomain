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

public class UserChatAllVO {

	

	List<UserQuotationHistoryVO> userQuotationHistoryVO;
	
	List<UserQuotationHistoryFinVO> userQuotationHistoryFinVO;
	
	List<UserQuotationHistoryInsVO> userQuotationHistoryInsVO;
	
	List<UserQuotationHistoryServVO> userQuotationHistoryServVO;
	
	List<UserQuotationHistoryTranpVO> userQuotationHistoryTranspVO;
	
	
	
	public List<UserQuotationHistoryTranpVO> getUserQuotationHistoryTranspVO() {
		return userQuotationHistoryTranspVO;
	}


	public void setUserQuotationHistoryTranspVO(List<UserQuotationHistoryTranpVO> userQuotationHistoryTranspVO) {
		this.userQuotationHistoryTranspVO = userQuotationHistoryTranspVO;
	}


	public List<UserQuotationHistoryServVO> getUserQuotationHistoryServVO() {
		return userQuotationHistoryServVO;
	}


	public void setUserQuotationHistoryServVO(List<UserQuotationHistoryServVO> userQuotationHistoryServVO) {
		this.userQuotationHistoryServVO = userQuotationHistoryServVO;
	}


	public List<UserQuotationHistoryInsVO> getUserQuotationHistoryInsVO() {
		return userQuotationHistoryInsVO;
	}


	public void setUserQuotationHistoryInsVO(List<UserQuotationHistoryInsVO> userQuotationHistoryInsVO) {
		this.userQuotationHistoryInsVO = userQuotationHistoryInsVO;
	}


	public List<UserQuotationHistoryVO> getUserQuotationHistoryVO() {
		return userQuotationHistoryVO;
	}


	public void setUserQuotationHistoryVO(
			List<UserQuotationHistoryVO> userQuotationHistoryVO) {
		this.userQuotationHistoryVO = userQuotationHistoryVO;
	}


	public List<UserQuotationHistoryFinVO> getUserQuotationHistoryFinVO() {
		return userQuotationHistoryFinVO;
	}


	public void setUserQuotationHistoryFinVO(List<UserQuotationHistoryFinVO> userQuotationHistoryFinVO) {
		this.userQuotationHistoryFinVO = userQuotationHistoryFinVO;
	}


	


}
