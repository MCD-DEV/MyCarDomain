package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExternalDealerTpListVO {

	private String category;

	private int postCode;

	List<ExternalDealerTpVO> externalDealerVO;

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

	public List<ExternalDealerTpVO> getExternalDealerVO() {
		return externalDealerVO;
	}

	public void setExternalDealerVO(List<ExternalDealerTpVO> externalDealerVO) {
		this.externalDealerVO = externalDealerVO;
	}

}
