package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.Search;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistory;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryFin;
import au.com.pnspvtltd.mcd.domain.UserQuotationHistoryIns;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.domain.VehicleResourceDetails;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;

public interface UserQuotationHistoryRepoIns extends JpaRepository<UserQuotationHistoryIns, Long> {

	 
	
	
	
	public List<UserQuotationHistoryIns> findByVehicleQuotation(InsuranceQuotation dealer);
}
