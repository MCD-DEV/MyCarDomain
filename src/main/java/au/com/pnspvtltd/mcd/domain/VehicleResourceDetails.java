package au.com.pnspvtltd.mcd.domain;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TEMPCARMODELOVERVIEW
 * 
 */
@Entity @Table(name = "vehicledealerresource") public class VehicleResourceDetails implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
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
	
	List<VehicleSocialList> vehicleSocialList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "vehicleResourceDetailId")
	public List<VehicleSocialList> getVehicleSocialList() {
		return vehicleSocialList;
	}

	public void setVehicleSocialList(
			List<VehicleSocialList> vehicleSocialList) {
		this.vehicleSocialList = vehicleSocialList;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "VEHICLERESOURCEDETAILID") public Long getVehicleResourceDetailId() {
		return vehicleResourceDetailId;
	}

	public void setVehicleResourceDetailId(Long vehicleResourceDetailId) {
		this.vehicleResourceDetailId = vehicleResourceDetailId;
	}

	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	public VehicleResourceDetails() {
        super();
    }
	
	

	 	
	
}
