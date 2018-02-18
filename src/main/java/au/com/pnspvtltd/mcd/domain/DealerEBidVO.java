package au.com.pnspvtltd.mcd.domain;

import au.com.pnspvtltd.mcd.web.model.DealerSearchFinanceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchInsuranceVO;
import au.com.pnspvtltd.mcd.web.model.DealerSearchVO;

public class DealerEBidVO {
	private Long userId;
	private boolean finance;
	private boolean insurance;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public DealerSearchVO getSearchLead() {
		return searchLead;
	}

	public void setSearchLead(DealerSearchVO searchLead) {
		this.searchLead = searchLead;
	}

	public DealerSearchFinanceVO getFinanceLead() {
		return financeLead;
	}

	public void setFinanceLead(DealerSearchFinanceVO financeLead) {
		this.financeLead = financeLead;
	}

	public DealerSearchInsuranceVO getInsuranceLead() {
		return insuranceLead;
	}

	public void setInsuranceLead(DealerSearchInsuranceVO insuranceLead) {
		this.insuranceLead = insuranceLead;
	}

	private DealerSearchVO searchLead;
	private DealerSearchFinanceVO financeLead;
	private DealerSearchInsuranceVO insuranceLead;
}
