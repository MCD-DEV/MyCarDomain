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
@Table(name = "tempcarmodelpricing")
public class TempCarModelPricing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long tempCarModelPricingId;

	private double prices;
	private String redbookPriceGuide;
	/* start */

	private double privatePriceGuideMin;
	private double privatePriceGuideMax;
	private double tradePriceGuideMin;
	private double tradePriceGuideMax;
	private double averageKmMin;
	private double averageKmMax;
	private double priceWhenNew;
	private String state;
	private String rego;

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

	@Column(name = "PRICES")
	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	@Column(name = "REDBOOKPRICEGUIDE")
	public String getRedbookPriceGuide() {
		return redbookPriceGuide;
	}

	public void setRedbookPriceGuide(String redbookPriceGuide) {
		this.redbookPriceGuide = redbookPriceGuide;
	}

	@Column(name = "PRIVATEPRICEGUIDEMIN")
	public double getPrivatePriceGuideMin() {
		return privatePriceGuideMin;
	}

	public void setPrivatePriceGuideMin(double privatePriceGuideMin) {
		this.privatePriceGuideMin = privatePriceGuideMin;
	}

	@Column(name = "PRIVATEPRICEGUIDEMAX")
	public double getPrivatePriceGuideMax() {
		return privatePriceGuideMax;
	}

	public void setPrivatePriceGuideMax(double privatePriceGuideMax) {
		this.privatePriceGuideMax = privatePriceGuideMax;
	}

	@Column(name = "TRADEPRICEGUIDEMIN")
	public double getTradePriceGuideMin() {
		return tradePriceGuideMin;
	}

	public void setTradePriceGuideMin(double tradePriceGuideMin) {
		this.tradePriceGuideMin = tradePriceGuideMin;
	}

	@Column(name = "TRADEPRICEGUIDEMAX")
	public double getTradePriceGuideMax() {
		return tradePriceGuideMax;
	}

	public void setTradePriceGuideMax(double tradePriceGuideMax) {
		this.tradePriceGuideMax = tradePriceGuideMax;
	}

	@Column(name = "AVERAGEKMMIN")
	public double getAverageKmMin() {
		return averageKmMin;
	}

	public void setAverageKmMin(double averageKmMin) {
		this.averageKmMin = averageKmMin;
	}

	@Column(name = "AVERAGEKMMAX")
	public double getAverageKmMax() {
		return averageKmMax;
	}

	public void setAverageKmMax(double averageKmMax) {
		this.averageKmMax = averageKmMax;
	}

	@Column(name = "PRICEWHENNEW")
	public double getPriceWhenNew() {
		return priceWhenNew;
	}

	public void setPriceWhenNew(double priceWhenNew) {
		this.priceWhenNew = priceWhenNew;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "REGO")
	public String getRego() {
		return rego;
	}

	public void setRego(String rego) {
		this.rego = rego;
	}

	public TempCarModelPricing() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPCARMODELPRICINGID")
	public Long getTempCarModelPricingId() {
		return this.tempCarModelPricingId;
	}

	public void setTempCarModelPricingId(Long tempCarModelPricingId) {
		this.tempCarModelPricingId = tempCarModelPricingId;
	}

}
