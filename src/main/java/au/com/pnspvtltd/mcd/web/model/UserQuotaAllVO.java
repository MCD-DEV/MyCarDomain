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

public class UserQuotaAllVO {

	

	List<VehicleQuotationVO> vehicleQuotationVO;
	
	List<FinanceQuotationVO> financeQuotationVO;
	
	List<InsuranceQuotationVO> insuranceQuotationVO;
	
	List<ServiceMaintQuotationVO> serviceMaintQuotationVO;
	
	List<TranspServiceQuotationVO> transpServiceQuotationVO;

	public List<VehicleQuotationVO> getVehicleQuotationVO() {
		return vehicleQuotationVO;
	}

	public void setVehicleQuotationVO(List<VehicleQuotationVO> vehicleQuotationVO) {
		this.vehicleQuotationVO = vehicleQuotationVO;
	}

	public List<FinanceQuotationVO> getFinanceQuotationVO() {
		return financeQuotationVO;
	}

	public void setFinanceQuotationVO(List<FinanceQuotationVO> financeQuotationVO) {
		this.financeQuotationVO = financeQuotationVO;
	}

	public List<InsuranceQuotationVO> getInsuranceQuotationVO() {
		return insuranceQuotationVO;
	}

	public void setInsuranceQuotationVO(List<InsuranceQuotationVO> insuranceQuotationVO) {
		this.insuranceQuotationVO = insuranceQuotationVO;
	}

	public List<ServiceMaintQuotationVO> getServiceMaintQuotationVO() {
		return serviceMaintQuotationVO;
	}

	public void setServiceMaintQuotationVO(List<ServiceMaintQuotationVO> serviceMaintQuotationVO) {
		this.serviceMaintQuotationVO = serviceMaintQuotationVO;
	}

	public List<TranspServiceQuotationVO> getTranspServiceQuotationVO() {
		return transpServiceQuotationVO;
	}

	public void setTranspServiceQuotationVO(List<TranspServiceQuotationVO> transpServiceQuotationVO) {
		this.transpServiceQuotationVO = transpServiceQuotationVO;
	}
	
	
	


	


}
