package au.com.pnspvtltd.mcd.web.model;

import java.util.List;

public class VehicleResourceDetailsTpQuoVO {

	private Long vehicleResourceDetailId;

	private String contactPerson;

	private String designation;
	private String contactNumber1;
	private String contactNumber2;
	private String email;
	private String additionalInfo;
	private String lastName;
	private String title;
	private String employeeCode;
	private String id;

	List<VehicleSocialListVO> vehicleSocialList;

	public Long getVehicleResourceDetailId() {
		return vehicleResourceDetailId;
	}

	public void setVehicleResourceDetailId(Long vehicleResourceDetailId) {
		this.vehicleResourceDetailId = vehicleResourceDetailId;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<VehicleSocialListVO> getVehicleSocialList() {
		return vehicleSocialList;
	}

	public void setVehicleSocialList(List<VehicleSocialListVO> vehicleSocialList) {
		this.vehicleSocialList = vehicleSocialList;
	}

}
