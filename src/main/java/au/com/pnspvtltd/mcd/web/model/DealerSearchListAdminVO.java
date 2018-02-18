package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class DealerSearchListAdminVO {

	private Long carSearchId;

	List<DealerSearchVO> dealerSearchVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<DealerSearchVO> getDealerSearchVO() {
		return dealerSearchVO;
	}

	public void setDealerSearchVO(List<DealerSearchVO> dealerSearchVO) {
		this.dealerSearchVO = dealerSearchVO;
	}

}
