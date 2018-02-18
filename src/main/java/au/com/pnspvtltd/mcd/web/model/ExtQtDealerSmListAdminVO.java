package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtQtDealerSmListAdminVO {

	private Long carSearchId;

	List<ServiceMaintQuotationVO> serviceMaintQuotationVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<ServiceMaintQuotationVO> getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(List<ServiceMaintQuotationVO> serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

}
