package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import au.com.pnspvtltd.mcd.domain.DealerQuotationHistory;
import au.com.pnspvtltd.mcd.domain.OfferDateList;
import au.com.pnspvtltd.mcd.domain.QuotationFeatList;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.VehQuotDoc;
import au.com.pnspvtltd.mcd.domain.VehQuotExtras;
import au.com.pnspvtltd.mcd.domain.VehQuotTerm;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetailsQuo;

public class UserQuotaAllSingleVO {

	

	VehicleQuotationVO vehicleQuotationVO;
	
	FinanceQuotationVO financeQuotationVO;
	
	InsuranceQuotationVO insuranceQuotationVO;
	
	ServiceMaintQuotationVO serviceMaintQuotationVO;
	
	TranspServiceQuotationVO transpServiceQuotationVO;

	public VehicleQuotationVO getVehicleQuotationVO() {
		return vehicleQuotationVO;
	}

	public void setVehicleQuotationVO(VehicleQuotationVO vehicleQuotationVO) {
		this.vehicleQuotationVO = vehicleQuotationVO;
	}

	public FinanceQuotationVO getFinanceQuotationVO() {
		return financeQuotationVO;
	}

	public void setFinanceQuotationVO(FinanceQuotationVO financeQuotationVO) {
		this.financeQuotationVO = financeQuotationVO;
	}

	public InsuranceQuotationVO getInsuranceQuotationVO() {
		return insuranceQuotationVO;
	}

	public void setInsuranceQuotationVO(InsuranceQuotationVO insuranceQuotationVO) {
		this.insuranceQuotationVO = insuranceQuotationVO;
	}

	public ServiceMaintQuotationVO getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(ServiceMaintQuotationVO serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

	public TranspServiceQuotationVO getTranspServiceQuotationVO() {
		return transpServiceQuotationVO;
	}

	public void setTranspServiceQuotationVO(TranspServiceQuotationVO transpServiceQuotationVO) {
		this.transpServiceQuotationVO = transpServiceQuotationVO;
	}
	
	
	


	


}
