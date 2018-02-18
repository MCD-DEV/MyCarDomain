package au.com.pnspvtltd.mcd.web.model;

public class UserMyVehicleVO {

	private Long userId;
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private MyVehicleVO myVehicleVO;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public MyVehicleVO getMyVehicleVO() {
		return myVehicleVO;
	}

	public void setMyVehicleVO(MyVehicleVO myVehicleVO) {
		this.myVehicleVO = myVehicleVO;
	}

}
