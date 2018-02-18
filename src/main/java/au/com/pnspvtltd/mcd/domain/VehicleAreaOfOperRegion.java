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
@Table(name = "vehicleareaofoperregion")
public class VehicleAreaOfOperRegion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long vehicleDealAreaOfOperRegionId;

	private String country;
	private String state;
	private String region;
	private boolean offered;

	/* start */

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
	private boolean isFlex13;
	private boolean isFlex14;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEHICLEDEALOPERREGIONID")
	public Long getVehicleDealAreaOfOperRegionId() {
		return vehicleDealAreaOfOperRegionId;
	}

	public void setVehicleDealAreaOfOperRegionId(Long vehicleDealAreaOfOperRegionId) {
		this.vehicleDealAreaOfOperRegionId = vehicleDealAreaOfOperRegionId;
	}

	@Column(name = "REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ISOFFERED")
	public boolean isOffered() {
		return offered;
	}

	public void setOffered(boolean offered) {
		this.offered = offered;
	}

	@Column(name = "FLEX1")
	public String getFlex1() {
		return flex1;
	}

	@Column(name = "ISFLEX13")
	public boolean isFlex13() {
		return isFlex13;
	}

	public void setFlex13(boolean isFlex13) {
		this.isFlex13 = isFlex13;
	}

	@Column(name = "ISFLEX14")
	public boolean isFlex14() {
		return isFlex14;
	}

	public void setFlex14(boolean isFlex14) {
		this.isFlex14 = isFlex14;
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

	public VehicleAreaOfOperRegion() {
		super();
	}

}
