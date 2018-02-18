package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExternalDealerSearchVO {

	private String category;

	private int postCode;

	List<ExternalDealerVO> externalDealerVO;

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

	public List<ExternalDealerVO> getExternalDealerVO() {
		return externalDealerVO;
	}

	public void setExternalDealerVO(List<ExternalDealerVO> externalDealerVO) {
		this.externalDealerVO = externalDealerVO;
	}

}
