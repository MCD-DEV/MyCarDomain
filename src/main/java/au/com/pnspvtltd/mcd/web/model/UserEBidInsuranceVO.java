package au.com.pnspvtltd.mcd.web.model;

public class UserEBidInsuranceVO {

	private Long userId;

	private SearchInsuranceVO insuranceLead;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public SearchInsuranceVO getInsuranceLead() {
		return insuranceLead;
	}

	public void setInsuranceLead(SearchInsuranceVO insuranceLead) {
		this.insuranceLead = insuranceLead;
	}

}
