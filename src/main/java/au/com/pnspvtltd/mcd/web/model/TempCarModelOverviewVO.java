package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class TempCarModelOverviewVO {

	private Long tempCarModelOverviewId;

	private double price;
	private String priceGuideEGC;
	/* start */
	private String drive;
	private String Badge;
	private String fuelType;
	private String series;
	private String recommendedRonRating;
	private String body;
	private int releaseYear;
	private int noOfDoors;
	private String vin;
	private int seatCapacity;
	private String countryOfOrigin;
	private String transmission;
	private int overallGreenStarRating;
	private int ancapSafetyRating;
	private int NoOfGears;
	private String steering;
	// manfacture year
	private String manfYear;

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

	/* end */

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPriceGuideEGC() {
		return priceGuideEGC;
	}

	public void setPriceGuideEGC(String priceGuideEGC) {
		this.priceGuideEGC = priceGuideEGC;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getBadge() {
		return Badge;
	}

	public void setBadge(String badge) {
		Badge = badge;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getRecommendedRonRating() {
		return recommendedRonRating;
	}

	public void setRecommendedRonRating(String recommendedRonRating) {
		this.recommendedRonRating = recommendedRonRating;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getOverallGreenStarRating() {
		return overallGreenStarRating;
	}

	public void setOverallGreenStarRating(int overallGreenStarRating) {
		this.overallGreenStarRating = overallGreenStarRating;
	}

	public int getAncapSafetyRating() {
		return ancapSafetyRating;
	}

	public void setAncapSafetyRating(int ancapSafetyRating) {
		this.ancapSafetyRating = ancapSafetyRating;
	}

	public int getNoOfGears() {
		return NoOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		NoOfGears = noOfGears;
	}

	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}

	public String getManfYear() {
		return manfYear;
	}

	public void setManfYear(String manfYear) {
		this.manfYear = manfYear;
	}

	public Long getTempCarModelOverviewId() {
		return this.tempCarModelOverviewId;
	}

	public void setTempCarModelOverviewId(Long tempCarModelOverviewId) {
		this.tempCarModelOverviewId = tempCarModelOverviewId;
	}

}
