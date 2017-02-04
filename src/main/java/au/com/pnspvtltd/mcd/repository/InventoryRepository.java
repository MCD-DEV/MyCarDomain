package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	@Query("SELECT inv.dealer FROM Inventory inv WHERE inv.modelYear=?1 AND inv.modelDisplay=?2 AND inv.modelName=?3 AND inv.modelTrim=?4")
	public List<Dealer> getDealersForTheInventory(String modelYear, String modelDisplay, String modelName, String modelTrim);
	
	@Query("SELECT inv FROM Inventory inv WHERE inv.modelYear=?1 AND inv.modelDisplay=?2 AND inv.modelName=?3 AND inv.modelTrim=?4")
	public List<Inventory> getInventoryFor(String modelYear, String modelDisplay, String modelName, String modelTrim);

	@Query("SELECT NEW au.com.pnspvtltd.mcd.web.model.InventoryVO (inv.price, inv.vendorStockNo) FROM Inventory inv WHERE inv.modelYear=?1 AND inv.modelDisplay=?2 AND inv.modelName=?3 AND inv.modelTrim=?4" +
	" ORDER BY inv.price")
	public List<InventoryVO> getPriceAndVendorStockInventoryFor(String modelYear, String modelDisplay, String modelName,
			String modelTrim);
}
