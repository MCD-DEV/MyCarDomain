package au.com.pnspvtltd.mcd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.Dealer;
import au.com.pnspvtltd.mcd.domain.FinanceQuotation;
import au.com.pnspvtltd.mcd.domain.InsuranceQuotation;
import au.com.pnspvtltd.mcd.domain.Inventory;
import au.com.pnspvtltd.mcd.domain.VehicleQuotation;
import au.com.pnspvtltd.mcd.repository.InventoryRepository;
import au.com.pnspvtltd.mcd.repository.TempCarModelTemplateRepository;
import au.com.pnspvtltd.mcd.service.InventoryService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.DealerVO;
import au.com.pnspvtltd.mcd.web.model.FinanceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InsuranceQuotationVO;
import au.com.pnspvtltd.mcd.web.model.InventoryStatisticsVO;
import au.com.pnspvtltd.mcd.web.model.InventoryVO;
import au.com.pnspvtltd.mcd.web.model.TempCarModelHeaderVO;
import au.com.pnspvtltd.mcd.web.model.VehicleQuotationVO;

@Service
public class InventoryServiceImpl implements InventoryService{

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	@Autowired
	private TempCarModelTemplateServiceImpl tempCarModelTemplateServiceImpl; 

	//@Autowired
	//private TempCarModelTemplateRepository tempCarModelTemplateRepository;
	
	@Autowired
	private DomainModelUtil domainModelUtil;
	
	@Override
	public List<InventoryVO> getMinifiedInventoryFor(String modelYear, String modelDisplay, String modelName, String modelTrim) {
		
		List<InventoryVO> inventoryVOs = new ArrayList<>();
		for(Inventory inventory : inventoryRepository.getInventoryFor(modelYear, modelDisplay, modelName, modelTrim)){
			inventoryVOs.add(domainModelUtil.fromInventory(inventory, true));
		}
		return inventoryVOs;
	}

	@Override
	public List<InventoryVO> getPriceAndVendorStockInventoryFor(String modelYear, String modelDisplay, String modelName) {
		return inventoryRepository.getPriceAndVendorStockInventoryFor(modelYear, modelDisplay, modelName);
	}

	@Override
	public InventoryStatisticsVO getStatisticsFor(String modelYear, String modelDisplay, String modelName,
			 String autoscoopTrim) {
		
		InventoryStatisticsVO inventoryStatisticsVO = new InventoryStatisticsVO();
		List<InventoryVO> inventoryVOsSortedByPrice = getPriceAndVendorStockInventoryFor(modelYear, modelDisplay, modelName);
		// retrieve from tempcarModelHeader
		TempCarModelHeaderVO tempCarHeaderVO = tempCarModelTemplateServiceImpl.getCarModelTemplateForAutoTrim(autoscoopTrim);
		
		inventoryStatisticsVO.setTempCarModelHeaderVO(tempCarHeaderVO);
		int vendorStockCount = 0;
		
		for(InventoryVO inventoryVO : inventoryVOsSortedByPrice){
			vendorStockCount += inventoryVO.getVendorStockNo(); 
		}
		
		if(inventoryVOsSortedByPrice.size() > 0){
			inventoryStatisticsVO.setPriceMin(inventoryVOsSortedByPrice.get(0).getPrice());
			inventoryStatisticsVO.setPriceMax(inventoryVOsSortedByPrice.get(inventoryVOsSortedByPrice.size() - 1).getPrice());
			inventoryStatisticsVO.setNoStock(vendorStockCount);
			inventoryStatisticsVO.setNoDealers(inventoryVOsSortedByPrice.size());
		}
		
		
				
		return inventoryStatisticsVO;
	}
	
	@Override
	@Transactional(readOnly = true)
	public InventoryVO findById(Long id) {
		Inventory dealer = inventoryRepository.findOne(id);
		InventoryVO dealerVO = null;
		if(dealer != null){
			dealerVO = domainModelUtil.fromInventoryFull(dealer,false);
			
			

			
		}
		return dealerVO;
	}

	
}
