package au.com.pnspvtltd.mcd.web.model;

public class MyVehicleFuelCardStoreVO {

	private Long myVehicleId;

	private MyVehicleFuelExpensesVO myVehicleFuelExpensesVO;

	public MyVehicleFuelExpensesVO getMyVehicleFuelExpensesVO() {
		return myVehicleFuelExpensesVO;
	}

	public void setMyVehicleFuelExpensesVO(MyVehicleFuelExpensesVO myVehicleFuelExpensesVO) {
		this.myVehicleFuelExpensesVO = myVehicleFuelExpensesVO;
	}

	public Long getMyVehicleId() {
		return myVehicleId;
	}

	public void setMyVehicleId(Long myVehicleId) {
		this.myVehicleId = myVehicleId;
	}

}
