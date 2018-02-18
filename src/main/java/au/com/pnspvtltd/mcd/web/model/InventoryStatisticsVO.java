package au.com.pnspvtltd.mcd.web.model;

public class InventoryStatisticsVO {

	public TempCarModelHeaderVO getTempCarModelHeaderVO() {
		return tempCarModelHeaderVO;
	}

	public void setTempCarModelHeaderVO(TempCarModelHeaderVO tempCarModelHeaderVO) {
		this.tempCarModelHeaderVO = tempCarModelHeaderVO;
	}

	private double priceMin;
	private double priceMax;
	private double finMin;
	private double finMax;
	private double insMin;
	private double insMax;
	private double avgSavMin;
	private double avgSavMax;
	private int noDealers;
	private int noStock;

	private TempCarModelHeaderVO tempCarModelHeaderVO;

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public double getFinMin() {
		return finMin;
	}

	public void setFinMin(double finMin) {
		this.finMin = finMin;
	}

	public double getFinMax() {
		return finMax;
	}

	public void setFinMax(double finMax) {
		this.finMax = finMax;
	}

	public double getInsMin() {
		return insMin;
	}

	public void setInsMin(double insMin) {
		this.insMin = insMin;
	}

	public double getInsMax() {
		return insMax;
	}

	public void setInsMax(double insMax) {
		this.insMax = insMax;
	}

	public double getAvgSavMin() {
		return avgSavMin;
	}

	public void setAvgSavMin(double avgSavMin) {
		this.avgSavMin = avgSavMin;
	}

	public double getAvgSavMax() {
		return avgSavMax;
	}

	public void setAvgSavMax(double avgSavMax) {
		this.avgSavMax = avgSavMax;
	}

	public int getNoDealers() {
		return noDealers;
	}

	public void setNoDealers(int noDealers) {
		this.noDealers = noDealers;
	}

	public int getNoStock() {
		return noStock;
	}

	public void setNoStock(int noStock) {
		this.noStock = noStock;
	}

}
