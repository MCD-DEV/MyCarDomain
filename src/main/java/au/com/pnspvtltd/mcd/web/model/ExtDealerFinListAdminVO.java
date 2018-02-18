package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtDealerFinListAdminVO {

	private Long searchServMaintId;

	List<ExtDealerSearchFinVO> extDealerSearchVO;

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}

	public List<ExtDealerSearchFinVO> getExtDealerSearchVO() {
		return extDealerSearchVO;
	}

	public void setExtDealerSearchVO(List<ExtDealerSearchFinVO> extDealerSearchVO) {
		this.extDealerSearchVO = extDealerSearchVO;
	}

}
