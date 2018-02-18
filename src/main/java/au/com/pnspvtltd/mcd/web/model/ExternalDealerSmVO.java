package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExternalDealerSmVO {

	private String category;

	private int postCode;

	List<ExtDealerServMaintVO> externalDealerVO;

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

	public List<ExtDealerServMaintVO> getExternalDealerVO() {
		return externalDealerVO;
	}

	public void setExternalDealerVO(List<ExtDealerServMaintVO> externalDealerVO) {
		this.externalDealerVO = externalDealerVO;
	}

}
