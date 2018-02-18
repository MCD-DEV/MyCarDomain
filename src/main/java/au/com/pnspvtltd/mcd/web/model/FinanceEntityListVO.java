package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class FinanceEntityListVO {

	public FinanceEntityListVO() {

	}

	List<FinanceEntityVO> financeEntityVO;

	public List<FinanceEntityVO> getInventoryVO() {
		return financeEntityVO;
	}

	public void setInventoryVO(List<FinanceEntityVO> financeEntityVO) {
		this.financeEntityVO = financeEntityVO;
	}

}
