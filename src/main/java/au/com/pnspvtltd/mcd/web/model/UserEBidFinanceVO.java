package au.com.pnspvtltd.mcd.web.model;

public class UserEBidFinanceVO {

	private Long userId;
	private SearchFinanceVO financeLead;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public SearchFinanceVO getFinanceLead() {
		return financeLead;
	}

	public void setFinanceLead(SearchFinanceVO financeLead) {
		this.financeLead = financeLead;
	}

}
