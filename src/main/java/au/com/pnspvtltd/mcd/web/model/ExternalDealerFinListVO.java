package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExternalDealerFinListVO {

	private String category;

	private int postCode;

	List<ExternalDealerFinVO> externalDealerVO;

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

	public List<ExternalDealerFinVO> getExternalDealerVO() {
		return externalDealerVO;
	}

	public void setExternalDealerVO(List<ExternalDealerFinVO> externalDealerVO) {
		this.externalDealerVO = externalDealerVO;
	}

}
