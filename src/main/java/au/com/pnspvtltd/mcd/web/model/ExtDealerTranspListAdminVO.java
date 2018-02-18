package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtDealerTranspListAdminVO {

	private Long searchServMaintId;

	List<ExtDealerSearchTpVO> extDealerSearchVO;

	public Long getSearchServMaintId() {
		return searchServMaintId;
	}

	public void setSearchServMaintId(Long searchServMaintId) {
		this.searchServMaintId = searchServMaintId;
	}

	public List<ExtDealerSearchTpVO> getExtDealerSearchVO() {
		return extDealerSearchVO;
	}

	public void setExtDealerSearchVO(List<ExtDealerSearchTpVO> extDealerSearchVO) {
		this.extDealerSearchVO = extDealerSearchVO;
	}

}
