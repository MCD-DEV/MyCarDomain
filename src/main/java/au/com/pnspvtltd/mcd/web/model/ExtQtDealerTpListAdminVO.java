package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtQtDealerTpListAdminVO {

	private Long carSearchId;

	List<TranspServiceQuotationVO> serviceMaintQuotationVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<TranspServiceQuotationVO> getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(List<TranspServiceQuotationVO> serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

}
