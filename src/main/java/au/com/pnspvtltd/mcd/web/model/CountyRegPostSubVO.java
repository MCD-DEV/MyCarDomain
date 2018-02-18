package au.com.pnspvtltd.mcd.web.model;

public class CountyRegPostSubVO {

	private int countyRegPostSubid;
	private String country;
	private String state;
	private String region;
	private int postCode;
	private String suburb;

	public int getCountyRegPostSubid() {
		return countyRegPostSubid;
	}

	public void setCountyRegPostSubid(int countyRegPostSubid) {
		this.countyRegPostSubid = countyRegPostSubid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

}
