package au.com.pnspvtltd.mcd.web.model;

public class AdminVerifyVO {
	
	private Long carSearchId;
	private boolean mobCheck;
	private boolean idCheck;
	private String mobile;
	private int landLine;
	private String drivingLicense;
	private String email;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getLandLine() {
		return landLine;
	}
	public void setLandLine(int landLine) {
		this.landLine = landLine;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCarSearchId() {
		return carSearchId;
	}
	public void setCarSearchId(Long carSearchId) {
		this.carSearchId = carSearchId;
	}
	public boolean isMobCheck() {
		return mobCheck;
	}
	public void setMobCheck(boolean mobCheck) {
		this.mobCheck = mobCheck;
	}
	public boolean isIdCheck() {
		return idCheck;
	}
	public void setIdCheck(boolean idCheck) {
		this.idCheck = idCheck;
	}
	
	

}
