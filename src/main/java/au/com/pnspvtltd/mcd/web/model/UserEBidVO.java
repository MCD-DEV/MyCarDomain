package au.com.pnspvtltd.mcd.web.model;

public class UserEBidVO {

	private Long userId;
	private boolean finance;
	private boolean insurance;

	public boolean isFinance() {
		return finance;
	}

	public void setFinance(boolean finance) {
		this.finance = finance;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	private SearchVO searchLead;
	private SearchFinanceVO financeLead;
	private SearchInsuranceVO insuranceLead;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public SearchVO getSearchLead() {
		return searchLead;
	}

	public void setSearchLead(SearchVO searchLead) {
		this.searchLead = searchLead;
	}

	public SearchFinanceVO getFinanceLead() {
		return financeLead;
	}

	public void setFinanceLead(SearchFinanceVO financeLead) {
		this.financeLead = financeLead;
	}

	public SearchInsuranceVO getInsuranceLead() {
		return insuranceLead;
	}

	public void setInsuranceLead(SearchInsuranceVO insuranceLead) {
		this.insuranceLead = insuranceLead;
	}

}
