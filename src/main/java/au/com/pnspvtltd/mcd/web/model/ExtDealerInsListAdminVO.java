package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtDealerInsListAdminVO {

	private Long searchServMaintId;

	List<ExtDealerSearchInsVO> extDealerSearchVO;

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}

	public List<ExtDealerSearchInsVO> getExtDealerSearchVO() {
		return extDealerSearchVO;
	}

	public void setExtDealerSearchVO(List<ExtDealerSearchInsVO> extDealerSearchVO) {
		this.extDealerSearchVO = extDealerSearchVO;
	}

}
