package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CountyRegPostSub")
public class CountyRegPostSub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int countyRegPostSubid;
	private String country;
	private String state;
	private String region;
	private int postCode;
	private String suburb;

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

	@Column(name = "REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "POSTCODE")
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Column(name = "SUBURB")
	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTYREGPOSTSUBID")
	public int getcountyRegPostSubid() {
		return this.countyRegPostSubid;
	}

	public void setcountyRegPostSubid(int countyRegPostSubid) {
		this.countyRegPostSubid = countyRegPostSubid;
	}

}
