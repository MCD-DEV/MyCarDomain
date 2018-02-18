package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TEMPCARMODELOVERVIEW
 * 
 */
@Entity
@Table(name = "tempcarmodeloverview")
public class TempCarModelOverview implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

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

	/* end */

	@Column(name = "PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "PRICEGUIDEEGC")
	public String getPriceGuideEGC() {
		return priceGuideEGC;
	}

	public void setPriceGuideEGC(String priceGuideEGC) {
		this.priceGuideEGC = priceGuideEGC;
	}

	@Column(name = "DRIVE")
	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	@Column(name = "BADGE")
	public String getBadge() {
		return Badge;
	}

	public void setBadge(String badge) {
		Badge = badge;
	}

	@Column(name = "FUELTYPE")
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "SERIES")
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "RECOMRONRATING")
	public String getRecommendedRonRating() {
		return recommendedRonRating;
	}

	public void setRecommendedRonRating(String recommendedRonRating) {
		this.recommendedRonRating = recommendedRonRating;
	}

	@Column(name = "BODY")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Column(name = "RELYEAR")
	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "NOOFDOORS")
	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	@Column(name = "VIN")
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "SEATCAPACITY")
	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Column(name = "COUNTRYOFORIGIN")
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	@Column(name = "TRANSMISSION")
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	@Column(name = "OVERALLGREENRATING")
	public int getOverallGreenStarRating() {
		return overallGreenStarRating;
	}

	public void setOverallGreenStarRating(int overallGreenStarRating) {
		this.overallGreenStarRating = overallGreenStarRating;
	}

	@Column(name = "ANCAPSAFETYRATING")
	public int getAncapSafetyRating() {
		return ancapSafetyRating;
	}

	public void setAncapSafetyRating(int ancapSafetyRating) {
		this.ancapSafetyRating = ancapSafetyRating;
	}

	@Column(name = "NOOFGEARS")
	public int getNoOfGears() {
		return NoOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		NoOfGears = noOfGears;
	}

	@Column(name = "STEERING")
	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}

	@Column(name = "MANFYEAR")
	public String getManfYear() {
		return manfYear;
	}

	public void setManfYear(String manfYear) {
		this.manfYear = manfYear;
	}

	public TempCarModelOverview() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPCARMODELOVERVIEWID")
	public Long getTempCarModelOverviewId() {
		return this.tempCarModelOverviewId;
	}

	public void setTempCarModelOverviewId(Long tempCarModelOverviewId) {
		this.tempCarModelOverviewId = tempCarModelOverviewId;
	}

}
