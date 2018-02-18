package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtDealerSearchListAdminVO {

	private Long carSearchId;

	List<ExtDealerSearchVO> extDealerSearchVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<ExtDealerSearchVO> getExtDealerSearchVO() {
		return extDealerSearchVO;
	}

	public void setExtDealerSearchVO(List<ExtDealerSearchVO> dealerSearchVO) {
		this.extDealerSearchVO = dealerSearchVO;
	}

}
