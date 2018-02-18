package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtQtDealerInsListAdminVO {

	private Long carSearchId;

	List<InsuranceQuotationVO> serviceMaintQuotationVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<InsuranceQuotationVO> getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(List<InsuranceQuotationVO> serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

}
