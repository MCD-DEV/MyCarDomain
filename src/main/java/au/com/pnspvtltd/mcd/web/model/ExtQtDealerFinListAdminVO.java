package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtQtDealerFinListAdminVO {

	private Long carSearchId;

	List<FinanceQuotationVO> serviceMaintQuotationVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<FinanceQuotationVO> getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(List<FinanceQuotationVO> serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

}
