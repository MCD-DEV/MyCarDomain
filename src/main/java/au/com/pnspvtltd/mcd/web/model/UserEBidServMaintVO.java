package au.com.pnspvtltd.mcd.web.model;

public class UserEBidServMaintVO {

	private Long userId;

	private SearchServMaintVO servMaintLead;

	public SearchServMaintVO getServMaintLead() {
		return servMaintLead;
	}

	public void setServMaintLead(SearchServMaintVO servMaintLead) {
		this.servMaintLead = servMaintLead;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
