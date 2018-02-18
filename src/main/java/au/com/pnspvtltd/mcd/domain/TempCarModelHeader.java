package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Employee
 * 
 */
@Entity
@Table(name = "tempcarmodelheader")
public class TempCarModelHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2199507881828796978L;
	/**
	 * 
	 */

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

	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "MODIFIEDDATE")
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

	@Column(name = "FLEX1")
	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Column(name = "FLEX2")
	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	@Column(name = "FLEX3")
	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	@Column(name = "FLEX4")
	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	@Column(name = "FLEX5")
	public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	@Column(name = "FLEX6")
	public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	@Column(name = "FLEX7")
	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	@Column(name = "FLEX8")
	public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	@Column(name = "FLEX9")
	public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	@Column(name = "FLEX10")
	public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	@Column(name = "FLEX11")
	public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	@Column(name = "FLEX12")
	public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}

	// End of flex
	@Column(name = "MODELVARIANT")
	public String getModelVariant() {
		return modelVariant;
	}

	public void setModelVariant(String modelVariant) {
		this.modelVariant = modelVariant;
	}

	@Column(name = "MODELSERIES")
	public String getModelSeries() {
		return modelSeries;
	}

	public void setModelSeries(String modelSeries) {
		this.modelSeries = modelSeries;
	}

	@Column(name = "MODELBATCH")
	public String getModelBatch() {
		return modelBatch;
	}

	public void setModelBatch(String modelBatch) {
		this.modelBatch = modelBatch;
	}

	@Column(name = "ENGINESIZE")
	public double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}

	@Column(name = "CYLINDER")
	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	@Column(name = "NOOFGEARS")
	public int getNoOfGears() {
		return noOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}

	@Column(name = "TRANSMISSION")
	public String getTransimission() {
		return transimission;
	}

	public void setTransimission(String transimission) {
		this.transimission = transimission;
	}

	@Column(name = "DRIVETYPE")
	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	@Column(name = "FUELTYPE")
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "MODELDOORS")
	public int getModelDoors() {
		return modelDoors;
	}

	public void setModelDoors(int modelDoors) {
		this.modelDoors = modelDoors;
	}

	@Column(name = "MODELBODY")
	public String getModelBody() {
		return modelBody;
	}

	public void setModelBody(String modelBody) {
		this.modelBody = modelBody;
	}

	@Column(name = "MODELSEATS")
	public int getModelSeats() {
		return modelSeats;
	}

	public void setModelSeats(int modelSeats) {
		this.modelSeats = modelSeats;
	}

	@Column(name = "MANFYEAR")
	public String getManfYear() {
		return manfYear;
	}

	public void setManfYear(String manfYear) {
		this.manfYear = manfYear;
	}

	@Column(name = "MODELYEAR")
	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	@Column(name = "MODELMAKE")
	public String getModelDisplay() {
		return modelDisplay;
	}

	public void setModelDisplay(String modelDisplay) {
		this.modelDisplay = modelDisplay;
	}

	@Column(name = "MODELNAME")
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Column(name = "MODELTRIM")
	public String getModelTrim() {
		return modelTrim;
	}

	public void setModelTrim(String modelTrim) {
		this.modelTrim = modelTrim;
	}

	List<TempCarModelOverview> carModel;

	List<TempCarModelPricing> carModel1;

	List<TempCarModelOptionalFeatureAddOn> carModel2;

	List<TempCarModelColour> carModel3;

	List<TempCarModelFullSpecEngine> carModel4;

	List<TempCarModelFullSpecDimension> carModel5;

	List<TempCarModelFullSpecFuel> carModel6;

	List<TempCarModelFullSpecWarranty> carModel7;

	List<TempCarModelFullSpecStandEq> carModel8;

	List<TempCarModelOptEqpAddOn> carModel9;

	List<TempCarModelRelatedModel> carModel10;
	List<TempCarModelPhotos> carModel11;

	List<TempCarModelVehReview> carModel12;
	List<TempCarModelVideos> carModel13;

	List<TempCarModelExtFitting> carModel14;

	List<TempCarModelIntFitting> carModel15;

	List<TempCarModelUserRating> carModel16;

	List<TempCarModelExpertRating> carModel17;

	List<TempCarModelCountry> carModel18;

	List<TempCarModelFullSpecWheel> carModel19;

	public TempCarModelHeader() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPCARMODELHEADID")
	public Long getTempCarModelHeaderId() {
		return this.tempCarModelHeaderId;
	}

	public void setTempCarModelHeaderId(Long tempCarModelHeaderId) {
		this.tempCarModelHeaderId = tempCarModelHeaderId;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelOverview> getCarModel() {
		return carModel;
	}

	public void setCarModel(List<TempCarModelOverview> carModel) {
		this.carModel = carModel;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelPricing> getCarModel1() {
		return carModel1;
	}

	public void setCarModel1(List<TempCarModelPricing> carModel1) {
		this.carModel1 = carModel1;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelOptionalFeatureAddOn> getCarModel2() {
		return carModel2;
	}

	public void setCarModel2(List<TempCarModelOptionalFeatureAddOn> carModel2) {
		this.carModel2 = carModel2;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelColour> getCarModel3() {
		return carModel3;
	}

	public void setCarModel3(List<TempCarModelColour> carModel3) {
		this.carModel3 = carModel3;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecEngine> getCarModel4() {
		return carModel4;
	}

	public void setCarModel4(List<TempCarModelFullSpecEngine> carModel4) {
		this.carModel4 = carModel4;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecDimension> getCarModel5() {
		return carModel5;
	}

	public void setCarModel5(List<TempCarModelFullSpecDimension> carModel5) {
		this.carModel5 = carModel5;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecFuel> getCarModel6() {
		return carModel6;
	}

	public void setCarModel6(List<TempCarModelFullSpecFuel> carModel6) {
		this.carModel6 = carModel6;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecWarranty> getCarModel7() {
		return carModel7;
	}

	public void setCarModel7(List<TempCarModelFullSpecWarranty> carModel7) {
		this.carModel7 = carModel7;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecStandEq> getCarModel8() {
		return carModel8;
	}

	public void setCarModel8(List<TempCarModelFullSpecStandEq> carModel8) {
		this.carModel8 = carModel8;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelOptEqpAddOn> getCarModel9() {
		return carModel9;
	}

	public void setCarModel9(List<TempCarModelOptEqpAddOn> carModel9) {
		this.carModel9 = carModel9;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelRelatedModel> getCarModel10() {
		return carModel10;
	}

	public void setCarModel10(List<TempCarModelRelatedModel> carModel10) {
		this.carModel10 = carModel10;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelPhotos> getCarModel11() {
		return carModel11;
	}

	public void setCarModel11(List<TempCarModelPhotos> carModel11) {
		this.carModel11 = carModel11;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelVehReview> getCarModel12() {
		return carModel12;
	}

	public void setCarModel12(List<TempCarModelVehReview> carModel12) {
		this.carModel12 = carModel12;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelVideos> getCarModel13() {
		return carModel13;
	}

	public void setCarModel13(List<TempCarModelVideos> carModel13) {
		this.carModel13 = carModel13;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelExtFitting> getCarModel14() {
		return carModel14;
	}

	public void setCarModel14(List<TempCarModelExtFitting> carModel14) {
		this.carModel14 = carModel14;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelIntFitting> getCarModel15() {
		return carModel15;
	}

	public void setCarModel15(List<TempCarModelIntFitting> carModel15) {
		this.carModel15 = carModel15;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelUserRating> getCarModel16() {
		return carModel16;
	}

	public void setCarModel16(List<TempCarModelUserRating> carModel16) {
		this.carModel16 = carModel16;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelExpertRating> getCarModel17() {
		return carModel17;
	}

	public void setCarModel17(List<TempCarModelExpertRating> carModel17) {
		this.carModel17 = carModel17;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelCountry> getCarModel18() {
		return carModel18;
	}

	public void setCarModel18(List<TempCarModelCountry> carModel18) {
		this.carModel18 = carModel18;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempCarModelHeaderId")
	public List<TempCarModelFullSpecWheel> getCarModel19() {
		return carModel19;
	}

	public void setCarModel19(List<TempCarModelFullSpecWheel> carModel19) {
		this.carModel19 = carModel19;
	}

}
