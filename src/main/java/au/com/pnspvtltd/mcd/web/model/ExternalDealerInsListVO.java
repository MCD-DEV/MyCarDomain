package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExternalDealerInsListVO {

	private String category;

	private int postCode;

	List<ExternalDealerInsVO> externalDealerVO;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public List<ExternalDealerInsVO> getExternalDealerVO() {
		return externalDealerVO;
	}

	public void setExternalDealerVO(List<ExternalDealerInsVO> externalDealerVO) {
		this.externalDealerVO = externalDealerVO;
	}

}
