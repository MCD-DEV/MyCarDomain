package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class InventoryListVO {

	public InventoryListVO() {

	}

	List<InventoryVO> inventoryVO;

	public List<InventoryVO> getInventoryVO() {
		return inventoryVO;
	}

	public void setInventoryVO(List<InventoryVO> inventoryVO) {
		this.inventoryVO = inventoryVO;
	}

}
