package au.com.pnspvtltd.mcd.web.model;

public class AdminStatusVO {

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	private Long ID;
	private Long carSearchId;
	private boolean mobCheck;
	private boolean idCheck;
	private int VerfMob;
	private int VerfLIC;

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

	public int getVerfMob() {
		return VerfMob;
	}

	public void setVerfMob(int verfMob) {
		VerfMob = verfMob;
	}

	public int getVerfLIC() {
		return VerfLIC;
	}

	public void setVerfLIC(int verfLIC) {
		VerfLIC = verfLIC;
	}

}
