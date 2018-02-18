package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class ExtQtDealerSearchListAdminVO {

	private Long carSearchId;

	List<VehicleQuotationVO> vehicleQuotationVO;

	public Long getCarSearchId() {
		return carSearchId;
	}

	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}

	public List<VehicleQuotationVO> getVehicleQuotationVO() {
		return vehicleQuotationVO;
	}

	public void setVehicleQuotationVO(List<VehicleQuotationVO> vehicleQuotationVO) {
		this.vehicleQuotationVO = vehicleQuotationVO;
	}

}
