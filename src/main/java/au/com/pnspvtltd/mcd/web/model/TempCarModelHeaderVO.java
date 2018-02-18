package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

public class TempCarModelHeaderVO {

	private Long tempCarModelHeaderId;
	// year
	private String modelYear;
	// make
	private String modelDisplay;
	// model
	private String modelName;
	// variant
	private String modelVariant;
	// series
	private String modelSeries;
	// batch
	private String modelBatch;
	// trim
	private String modelTrim;

	private double engineSize;
	private int cylinder;
	private int noOfGears;
	// trans
	private String transimission;
	private String driveType;
	private String fuelType;
	private int modelDoors;

	private String modelBody;
	private int modelSeats;
	// manfacture year
	private String manfYear;
	private Date creationDate;
	private Date modifiedDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	// Flex start
	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;
	private int flex5;
	private int flex6;
	private double flex7;
	private double flex8;
	private double flex9;
	private double flex10;
	private Date flex11;
	private Date flex12;

	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}

	// End of flex
	public String getModelVariant() {
		return modelVariant;
	}

	public void setModelVariant(String modelVariant) {
		this.modelVariant = modelVariant;
	}

	public String getModelSeries() {
		return modelSeries;
	}

	public void setModelSeries(String modelSeries) {
		this.modelSeries = modelSeries;
	}

	public String getModelBatch() {
		return modelBatch;
	}

	public void setModelBatch(String modelBatch) {
		this.modelBatch = modelBatch;
	}

	public double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public int getNoOfGears() {
		return noOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}

	public String getTransimission() {
		return transimission;
	}

	public void setTransimission(String transimission) {
		this.transimission = transimission;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getModelDoors() {
		return modelDoors;
	}

	public void setModelDoors(int modelDoors) {
		this.modelDoors = modelDoors;
	}

	public String getModelBody() {
		return modelBody;
	}

	public void setModelBody(String modelBody) {
		this.modelBody = modelBody;
	}

	public int getModelSeats() {
		return modelSeats;
	}

	public void setModelSeats(int modelSeats) {
		this.modelSeats = modelSeats;
	}

	public String getManfYear() {
		return manfYear;
	}

	public void setManfYear(String manfYear) {
		this.manfYear = manfYear;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getModelDisplay() {
		return modelDisplay;
	}

	public void setModelDisplay(String modelDisplay) {
		this.modelDisplay = modelDisplay;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelTrim() {
		return modelTrim;
	}

	public void setModelTrim(String modelTrim) {
		this.modelTrim = modelTrim;
	}

	List<TempCarModelOverviewVO> carModel;

	List<TempCarModelPricingVO> carModel1;

	List<TempCarModelOptionalFeatureAddOnVO> carModel2;

	List<TempCarModelColourVO> carModel3;

	List<TempCarModelFullSpecEngineVO> carModel4;

	List<TempCarModelFullSpecDimensionVO> carModel5;

	List<TempCarModelFullSpecFuelVO> carModel6;

	List<TempCarModelFullSpecWarrantyVO> carModel7;

	List<TempCarModelFullSpecStandEqVO> carModel8;

	List<TempCarModelOptEqpAddOnVO> carModel9;

	List<TempCarModelRelatedModelVO> carModel10;
	List<TempCarModelPhotosVO> carModel11;

	List<TempCarModelVehReviewVO> carModel12;
	List<TempCarModelVideosVO> carModel13;

	List<TempCarModelExtFittingVO> carModel14;

	List<TempCarModelIntFittingVO> carModel15;

	List<TempCarModelUserRatingVO> carModel16;

	List<TempCarModelExpertRatingVO> carModel17;

	List<TempCarModelCountryVO> carModel18;

	List<TempCarModelFullSpecWheelVO> carModel19;

	public Long getTempCarModelHeaderId() {
		return this.tempCarModelHeaderId;
	}

	public void setTempCarModelHeaderId(Long tempCarModelHeaderId) {
		this.tempCarModelHeaderId = tempCarModelHeaderId;
	}

	public List<TempCarModelOverviewVO> getCarModel() {
		return carModel;
	}

	public void setCarModel(List<TempCarModelOverviewVO> carModel) {
		this.carModel = carModel;
	}

	public List<TempCarModelPricingVO> getCarModel1() {
		return carModel1;
	}

	public void setCarModel1(List<TempCarModelPricingVO> carModel1) {
		this.carModel1 = carModel1;
	}

	public List<TempCarModelOptionalFeatureAddOnVO> getCarModel2() {
		return carModel2;
	}

	public void setCarModel2(List<TempCarModelOptionalFeatureAddOnVO> carModel2) {
		this.carModel2 = carModel2;
	}

	public List<TempCarModelColourVO> getCarModel3() {
		return carModel3;
	}

	public void setCarModel3(List<TempCarModelColourVO> carModel3) {
		this.carModel3 = carModel3;
	}

	public List<TempCarModelFullSpecEngineVO> getCarModel4() {
		return carModel4;
	}

	public void setCarModel4(List<TempCarModelFullSpecEngineVO> carModel4) {
		this.carModel4 = carModel4;
	}

	public List<TempCarModelFullSpecDimensionVO> getCarModel5() {
		return carModel5;
	}

	public void setCarModel5(List<TempCarModelFullSpecDimensionVO> carModel5) {
		this.carModel5 = carModel5;
	}

	public List<TempCarModelFullSpecFuelVO> getCarModel6() {
		return carModel6;
	}

	public void setCarModel6(List<TempCarModelFullSpecFuelVO> carModel6) {
		this.carModel6 = carModel6;
	}

	public List<TempCarModelFullSpecWarrantyVO> getCarModel7() {
		return carModel7;
	}

	public void setCarModel7(List<TempCarModelFullSpecWarrantyVO> carModel7) {
		this.carModel7 = carModel7;
	}

	public List<TempCarModelFullSpecStandEqVO> getCarModel8() {
		return carModel8;
	}

	public void setCarModel8(List<TempCarModelFullSpecStandEqVO> carModel8) {
		this.carModel8 = carModel8;
	}

	public List<TempCarModelOptEqpAddOnVO> getCarModel9() {
		return carModel9;
	}

	public void setCarModel9(List<TempCarModelOptEqpAddOnVO> carModel9) {
		this.carModel9 = carModel9;
	}

	public List<TempCarModelRelatedModelVO> getCarModel10() {
		return carModel10;
	}

	public void setCarModel10(List<TempCarModelRelatedModelVO> carModel10) {
		this.carModel10 = carModel10;
	}

	public List<TempCarModelPhotosVO> getCarModel11() {
		return carModel11;
	}

	public void setCarModel11(List<TempCarModelPhotosVO> carModel11) {
		this.carModel11 = carModel11;
	}

	public List<TempCarModelVehReviewVO> getCarModel12() {
		return carModel12;
	}

	public void setCarModel12(List<TempCarModelVehReviewVO> carModel12) {
		this.carModel12 = carModel12;
	}

	public List<TempCarModelVideosVO> getCarModel13() {
		return carModel13;
	}

	public void setCarModel13(List<TempCarModelVideosVO> carModel13) {
		this.carModel13 = carModel13;
	}

	public List<TempCarModelExtFittingVO> getCarModel14() {
		return carModel14;
	}

	public void setCarModel14(List<TempCarModelExtFittingVO> carModel14) {
		this.carModel14 = carModel14;
	}

	public List<TempCarModelIntFittingVO> getCarModel15() {
		return carModel15;
	}

	public void setCarModel15(List<TempCarModelIntFittingVO> carModel15) {
		this.carModel15 = carModel15;
	}

	public List<TempCarModelUserRatingVO> getCarModel16() {
		return carModel16;
	}

	public void setCarModel16(List<TempCarModelUserRatingVO> carModel16) {
		this.carModel16 = carModel16;
	}

	public List<TempCarModelExpertRatingVO> getCarModel17() {
		return carModel17;
	}

	public void setCarModel17(List<TempCarModelExpertRatingVO> carModel17) {
		this.carModel17 = carModel17;
	}

	public List<TempCarModelCountryVO> getCarModel18() {
		return carModel18;
	}

	public void setCarModel18(List<TempCarModelCountryVO> carModel18) {
		this.carModel18 = carModel18;
	}

	public List<TempCarModelFullSpecWheelVO> getCarModel19() {
		return carModel19;
	}

	public void setCarModel19(List<TempCarModelFullSpecWheelVO> carModel19) {
		this.carModel19 = carModel19;
	}

}
