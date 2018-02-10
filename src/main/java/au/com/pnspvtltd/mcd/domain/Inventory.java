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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventoryrepo")
public class Inventory implements Serializable {

	private Dealer dealer;
	private Long repoId;
	private Long refId;
	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;
	private Long userId; 
	
	// newfields for wireframe
	private String extColour;
	private String intColour;
	private boolean demo;
	private boolean roadWorthIncluded;
	private boolean registrationIncluded;
	private boolean autoQuote;
	private boolean classified;
	//private double negotiablePercent;
	
	
	// New car or old car
		private boolean isNewCar;
		private String typeOfCar;
		private String vendorStockNoString;
		private String additionalDetails;

		// vehicle description by vendor
		private String vehicleDescriptin;

		// MARUTHI, AUDI
		private String make;
		// NANO, INDICA
		private String model;
		private String variant;
		private double price;
		// hash tag
		private String bodyType;
		private String transmission;
		private String fuelType;
		private String engine;
		private String regNo;
		private String driveType;
		private double kilometer;
		private String extColor;
		private String warranty;
		private Date regExpiryDate;
		private String vinNumber;
		private int vendorStockNo;
		private boolean isStockItem;
		//private int noOfDoors;
		private String intColor;
		private String wheelSize;
		private String seatMake;

		// External Fittings
		private String extFittingFlex1;
		private String extFittingFlex2;
		private String extFittingFlex3;
		private String extFittingFlex4;
		private String extFittingFlex5;
		private String extFittingFlex6;
		private String extFittingFlex7;
		private String extFittingFlex8;
		private String extFittingFlex9;
		private String extFittingFlex10;

		// Internal Fittings
		private String intFittingFlex1;
		private String intFittingFlex2;
		private String intFittingFlex3;
		private String intFittingFlex4;
		private String intFittingFlex5;
		private String intFittingFlex6;
		private String intFittingFlex7;
		private String intFittingFlex8;
		private String intFittingFlex9;
		private String intFittingFlex10;

		// sales person looking into it
		private String salePersonLooking;

		private String contName;
		//private int contPhone;
		private String contEmail;

		private boolean logBookService;
		private Date cameIntoInv;
		/*private int counterOfViewingCar;
		private int counterOfEnquiryCar;*/
		private Date saleDate;
		
		private String subsType;
		
		

		public String getSubsType() {
			return subsType;
		}

		public void setSubsType(String subsType) {
			this.subsType = subsType;
		}


		List<Feature> features;
		List<Photo> photos;
		List<QuotationFeatList> quotationFeatList;
		List<VehicleResourceDetailsInv> vehicleResourcDetails;
		
		@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
		@JoinColumn(name = "repoId")
		public List<VehicleResourceDetailsInv> getVehicleResourcDetails() {
			return vehicleResourcDetails;
		}

		public void setVehicleResourcDetails(
				List<VehicleResourceDetailsInv> vehicleResourcDetails) {
			this.vehicleResourcDetails = vehicleResourcDetails;
		}
		 @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
			@JoinColumn(name = "repoId")
			
			public List<QuotationFeatList> getQuotationFeatList() {
				return quotationFeatList;
			}


			public void setQuotationFeatList(
					List<QuotationFeatList> quotationFeatList) {
				this.quotationFeatList = quotationFeatList;
			}
		

		public String getAdditionalDetails() {
				return additionalDetails;
			}

			public void setAdditionalDetails(String additionalDetails) {
				this.additionalDetails = additionalDetails;
			}

		public String getVendorStockNoString() {
				return vendorStockNoString;
			}

			public void setVendorStockNoString(String vendorStockNoString) {
				this.vendorStockNoString = vendorStockNoString;
			}


		// kolor
		private String carColor;
		// victoria
		private String state;
		// melbourne
		private String region;
		// 7899
		//private int postCode;

		private Date yearOfMake;

		private String ausCapTer;
		// insurace

		private double insCompAmountMin;
		private double insCompAmountMax;

		// dealer
		private double dealAmountMin;
		private double dealAmountMax;

		private double insthirdInsuanceMin;
		private double insthirdInsuanceMax;

		// carMake

		// Finance

		private double finAmountMin;

	// carQuery

	public String getExtColour() {
			return extColour;
		}

		public void setExtColour(String extColour) {
			this.extColour = extColour;
		}

		public String getIntColour() {
			return intColour;
		}

		public void setIntColour(String intColour) {
			this.intColour = intColour;
		}

		public boolean isDemo() {
			return demo;
		}

		public void setDemo(boolean demo) {
			this.demo = demo;
		}

		public boolean isRoadWorthIncluded() {
			return roadWorthIncluded;
		}

		public void setRoadWorthIncluded(boolean roadWorthIncluded) {
			this.roadWorthIncluded = roadWorthIncluded;
		}

		public boolean isRegistrationIncluded() {
			return registrationIncluded;
		}

		public void setRegistrationIncluded(boolean registrationIncluded) {
			this.registrationIncluded = registrationIncluded;
		}

		public boolean isAutoQuote() {
			return autoQuote;
		}

		public void setAutoQuote(boolean autoQuote) {
			this.autoQuote = autoQuote;
		}

		public boolean isClassified() {
			return classified;
		}

		public void setClassified(boolean classified) {
			this.classified = classified;
		}

		/*public double getNegotiablePercent() {
			return negotiablePercent;
		}

		public void setNegotiablePercent(double negotiablePercent) {
			this.negotiablePercent = negotiablePercent;
		}
*/
	public Long getRefId() {
		return refId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRefId(Long dealerId) {
		this.refId = dealerId;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPOID")
	public Long getRepoId() {
		return this.repoId;
	}

	public void setRepoId(Long carMakeId) {
		this.repoId = carMakeId;
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

	

	@Column(name = "TYPEOFCAR")
	public String getTypeOfCar() {
		return typeOfCar;
	}

	public void setTypeOfCar(String typeOfCar) {
		this.typeOfCar = typeOfCar;
	}

	@Column(name = "ISNEWCAR")
	public boolean isNewCar() {
		return isNewCar;
	}

	public void setNewCar(boolean isNewCar) {
		this.isNewCar = isNewCar;
	}

	@Column(name = "VEHDESCRIPTION")
	public String getVehicleDescriptin() {
		return vehicleDescriptin;
	}

	public void setVehicleDescriptin(String vehicleDescriptin) {
		this.vehicleDescriptin = vehicleDescriptin;
	}

	@Column(name = "VARIANT")
	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	@Column(name = "PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "TRANSIMISSION")
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	@Column(name = "FUELTYPE")
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "ENGINE")
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Column(name = "DRIVETYPE")
	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	@Column(name = "KILOMETER")
	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}

	@Column(name = "EXTCOLOR")
	public String getExtColor() {
		return extColor;
	}

	public void setExtColor(String extColor) {
		this.extColor = extColor;
	}

	@Column(name = "WARRANTY")
	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Column(name = "REGDEXPIRYDATE")
	public Date getRegExpiryDate() {
		return regExpiryDate;
	}

	public void setRegExpiryDate(Date regExpiryDate) {
		this.regExpiryDate = regExpiryDate;
	}

	@Column(name = "VINNUMBER")
	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	@Column(name = "VENDORSTOCKNO")
	public int getVendorStockNo() {
		return vendorStockNo;
	}

	public void setVendorStockNo(int vendorStockNo) {
		this.vendorStockNo = vendorStockNo;
	}

	@Column(name = "ISSTOCKITEM")
	public boolean isStockItem() {
		return isStockItem;
	}

	public void setStockItem(boolean isStockItem) {
		this.isStockItem = isStockItem;
	}

	/*@Column(name = "NOOFDOORS")
	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}*/

	@Column(name = "INTCOLOR")
	public String getIntColor() {
		return intColor;
	}

	public void setIntColor(String intColor) {
		this.intColor = intColor;
	}

	@Column(name = "WHEELSIZE")
	public String getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(String wheelSize) {
		this.wheelSize = wheelSize;
	}

	@Column(name = "SEATMAKE")
	public String getSeatMake() {
		return seatMake;
	}

	public void setSeatMake(String seatMake) {
		this.seatMake = seatMake;
	}

	@Column(name = "EXTFITTINGFLEX1")
	public String getExtFittingFlex1() {
		return extFittingFlex1;
	}

	public void setExtFittingFlex1(String extFittingFlex1) {
		this.extFittingFlex1 = extFittingFlex1;
	}

	@Column(name = "EXTFITTINGFLEX2")
	public String getExtFittingFlex2() {
		return extFittingFlex2;
	}

	public void setExtFittingFlex2(String extFittingFlex2) {
		this.extFittingFlex2 = extFittingFlex2;
	}

	@Column(name = "EXTFITTINGFLEX3")
	public String getExtFittingFlex3() {
		return extFittingFlex3;
	}

	public void setExtFittingFlex3(String extFittingFlex3) {
		this.extFittingFlex3 = extFittingFlex3;
	}

	@Column(name = "EXTFITTINGFLEX4")
	public String getExtFittingFlex4() {
		return extFittingFlex4;
	}

	public void setExtFittingFlex4(String extFittingFlex4) {
		this.extFittingFlex4 = extFittingFlex4;
	}

	@Column(name = "EXTFITTINGFLEX5")
	public String getExtFittingFlex5() {
		return extFittingFlex5;
	}

	public void setExtFittingFlex5(String extFittingFlex5) {
		this.extFittingFlex5 = extFittingFlex5;
	}

	@Column(name = "EXTFITTINGFLEX6")
	public String getExtFittingFlex6() {
		return extFittingFlex6;
	}

	public void setExtFittingFlex6(String extFittingFlex6) {
		this.extFittingFlex6 = extFittingFlex6;
	}

	@Column(name = "EXTFITTINGFLEX7")
	public String getExtFittingFlex7() {
		return extFittingFlex7;
	}

	public void setExtFittingFlex7(String extFittingFlex7) {
		this.extFittingFlex7 = extFittingFlex7;
	}

	@Column(name = "EXTFITTINGFLEX8")
	public String getExtFittingFlex8() {
		return extFittingFlex8;
	}

	public void setExtFittingFlex8(String extFittingFlex8) {
		this.extFittingFlex8 = extFittingFlex8;
	}

	@Column(name = "EXTFITTINGFLEX9")
	public String getExtFittingFlex9() {
		return extFittingFlex9;
	}

	public void setExtFittingFlex9(String extFittingFlex9) {
		this.extFittingFlex9 = extFittingFlex9;
	}

	@Column(name = "EXTFITTINGFLEX10")
	public String getExtFittingFlex10() {
		return extFittingFlex10;
	}

	public void setExtFittingFlex10(String extFittingFlex10) {
		this.extFittingFlex10 = extFittingFlex10;
	}

	@Column(name = "INTFITTINGFLEX1")
	public String getIntFittingFlex1() {
		return intFittingFlex1;
	}

	public void setIntFittingFlex1(String intFittingFlex1) {
		this.intFittingFlex1 = intFittingFlex1;
	}

	@Column(name = "INTFITTINGFLEX2")
	public String getIntFittingFlex2() {
		return intFittingFlex2;
	}

	public void setIntFittingFlex2(String intFittingFlex2) {
		this.intFittingFlex2 = intFittingFlex2;
	}

	@Column(name = "INTFITTINGFLEX3")
	public String getIntFittingFlex3() {
		return intFittingFlex3;
	}

	public void setIntFittingFlex3(String intFittingFlex3) {
		this.intFittingFlex3 = intFittingFlex3;
	}

	@Column(name = "INTFITTINGFLEX4")
	public String getIntFittingFlex4() {
		return intFittingFlex4;
	}

	public void setIntFittingFlex4(String intFittingFlex4) {
		this.intFittingFlex4 = intFittingFlex4;
	}

	@Column(name = "INTFITTINGFLEX5")
	public String getIntFittingFlex5() {
		return intFittingFlex5;
	}

	public void setIntFittingFlex5(String intFittingFlex5) {
		this.intFittingFlex5 = intFittingFlex5;
	}

	@Column(name = "INTFITTINGFLEX6")
	public String getIntFittingFlex6() {
		return intFittingFlex6;
	}

	public void setIntFittingFlex6(String intFittingFlex6) {
		this.intFittingFlex6 = intFittingFlex6;
	}

	@Column(name = "INTFITTINGFLEX7")
	public String getIntFittingFlex7() {
		return intFittingFlex7;
	}

	public void setIntFittingFlex7(String intFittingFlex7) {
		this.intFittingFlex7 = intFittingFlex7;
	}

	@Column(name = "INTFITTINGFLEX8")
	public String getIntFittingFlex8() {
		return intFittingFlex8;
	}

	public void setIntFittingFlex8(String intFittingFlex8) {
		this.intFittingFlex8 = intFittingFlex8;
	}

	@Column(name = "INTFITTINGFLEX9")
	public String getIntFittingFlex9() {
		return intFittingFlex9;
	}

	public void setIntFittingFlex9(String intFittingFlex9) {
		this.intFittingFlex9 = intFittingFlex9;
	}

	@Column(name = "INTFITTINGFLEX10")
	public String getIntFittingFlex10() {
		return intFittingFlex10;
	}

	public void setIntFittingFlex10(String intFittingFlex10) {
		this.intFittingFlex10 = intFittingFlex10;
	}

	@Column(name = "SALEPERSONLOOKING")
	public String getSalePersonLooking() {
		return salePersonLooking;
	}

	public void setSalePersonLooking(String salePersonLooking) {
		this.salePersonLooking = salePersonLooking;
	}

	@Column(name = "CONTNAME")
	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	/*@Column(name = "CONTPHONE")
	public int getContPhone() {
		return contPhone;
	}

	public void setContPhone(int contPhone) {
		this.contPhone = contPhone;
	}*/

	@Column(name = "CONTEMAIL")
	public String getContEmail() {
		return contEmail;
	}

	public void setContEmail(String contEmail) {
		this.contEmail = contEmail;
	}

	@Column(name = "ISLOGBOOKSERVICE")
	public boolean isLogBookService() {
		return logBookService;
	}

	public void setLogBookService(boolean logBookService) {
		this.logBookService = logBookService;
	}

	@Column(name = "CAMEINTOINVDATE")
	public Date getCameIntoInv() {
		return cameIntoInv;
	}

	public void setCameIntoInv(Date cameIntoInv) {
		this.cameIntoInv = cameIntoInv;
	}

	/*@Column(name = "COUNTVIEW")
	public int getCounterOfViewingCar() {
		return counterOfViewingCar;
	}

	public void setCounterOfViewingCar(int counterOfViewingCar) {
		this.counterOfViewingCar = counterOfViewingCar;
	}

	@Column(name = "COUNTENQUIRY")
	public int getCounterOfEnquiryCar() {
		return counterOfEnquiryCar;
	}

	public void setCounterOfEnquiryCar(int counterOfEnquiryCar) {
		this.counterOfEnquiryCar = counterOfEnquiryCar;
	}*/

	@Column(name = "SALEDATE")
	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	@Column(name = "DEALERAMOUNTMIN")
	public double getDealAmountMin() {
		return dealAmountMin;
	}

	public void setDealAmountMin(double dealAmountMin) {
		this.dealAmountMin = dealAmountMin;
	}

	@Column(name = "DEALERAMOUNTMAX")
	public double getDealAmountMax() {
		return dealAmountMax;
	}

	public void setDealAmountMax(double dealAmountMax) {
		this.dealAmountMax = dealAmountMax;
	}

	
	// dealer

	@Column(name = "REGNO")
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Column(name = "BODYTYPE")
	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	@Column(name = "CARCOLOR")
	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/*@Column(name = "POSTCODE")
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}*/

	@Column(name = "YEAROFMAKE")
	public Date getYearOfMake() {
		return yearOfMake;
	}

	public void setYearOfMake(Date yearOfMake) {
		this.yearOfMake = yearOfMake;
	}

	@Column(name = "INSCOMPAMOUNTMIN")
	public double getInsCompAmountMin() {
		return insCompAmountMin;
	}

	public void setInsCompAmountMin(double insCompAmountMin) {
		this.insCompAmountMin = insCompAmountMin;
	}

	@Column(name = "INSCOMPAMOUNTMAX")
	public double getInsCompAmountMax() {
		return insCompAmountMax;
	}

	public void setInsCompAmountMax(double insCompAmountMax) {
		this.insCompAmountMax = insCompAmountMax;
	}

	@Column(name = "INSTHIRDINSURANCEMIN")
	public double getInsthirdInsuanceMin() {
		return insthirdInsuanceMin;
	}

	public void setInsthirdInsuanceMin(double insthirdInsuanceMin) {
		this.insthirdInsuanceMin = insthirdInsuanceMin;
	}

	@Column(name = "INSTHIRDINSURANCEMAX")
	public double getInsthirdInsuanceMax() {
		return insthirdInsuanceMax;
	}

	public void setInsthirdInsuanceMax(double insthirdInsuanceMax) {
		this.insthirdInsuanceMax = insthirdInsuanceMax;
	}

	@Column(name = "FINAMOUNTMIN")
	public double getFinAmountMin() {
		return finAmountMin;
	}

	public void setFinAmountMin(double finAmountMin) {
		this.finAmountMin = finAmountMin;
	}

	@Column(name = "AUSCAPTER")
	public String getAusCapTer() {
		return ausCapTer;
	}

	public void setAusCapTer(String ausCapTer) {
		this.ausCapTer = ausCapTer;
	}

	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "MAKE")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dealerId")
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	
}
