package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtDealerServMtListAdminVO {

	private Long searchServMaintId;

	List<ExtDealServMaintr1VO> extDealerSearchVO;

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}

	public List<ExtDealServMaintr1VO> getExtDealerSearchVO() {
		return extDealerSearchVO;
	}

	public void setExtDealerSearchVO(List<ExtDealServMaintr1VO> extDealerSearchVO) {
		this.extDealerSearchVO = extDealerSearchVO;
	}

}
