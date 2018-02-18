package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myvehicleservmaint")
public class MyVehicleServMaint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long myVehicleServMaintId;
	private Date date;
	private Date Time;
	private String recordType;
	private String mechanicName;
	private String companyName;
	private String typeOfServMaint;
	private String mechanicAddress;
	private String contactDetails;
	private int odoMeterKm;
	private double totalAmount;
	private int nextOdoMeterKm;
	private Date nextServDate;
	private String uploadPhoto;

	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;
	private double flex5;
	private double flex6;
	private double flex7;
	private Date flex8;
	private Date flex9;

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Time")
	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	@Column(name = "recordType")
	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	@Column(name = "mechanicName")
	public String getMechanicName() {
		return mechanicName;
	}

	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}

	@Column(name = "companyName")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "typeOfServMaint")
	public String getTypeOfServMaint() {
		return typeOfServMaint;
	}

	public void setTypeOfServMaint(String typeOfServMaint) {
		this.typeOfServMaint = typeOfServMaint;
	}

	@Column(name = "mechanicAddress")
	public String getMechanicAddress() {
		return mechanicAddress;
	}

	public void setMechanicAddress(String mechanicAddress) {
		this.mechanicAddress = mechanicAddress;
	}

	@Column(name = "contactDetails")
	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Column(name = "odoMeterKm")
	public int getOdoMeterKm() {
		return odoMeterKm;
	}

	public void setOdoMeterKm(int odoMeterKm) {
		this.odoMeterKm = odoMeterKm;
	}

	@Column(name = "totalAmount")
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "nextOdoMeterKm")
	public int getNextOdoMeterKm() {
		return nextOdoMeterKm;
	}

	public void setNextOdoMeterKm(int nextOdoMeterKm) {
		this.nextOdoMeterKm = nextOdoMeterKm;
	}

	@Column(name = "nextServDate")
	public Date getNextServDate() {
		return nextServDate;
	}

	public void setNextServDate(Date nextServDate) {
		this.nextServDate = nextServDate;
	}

	@Column(name = "uploadPhoto")
	public String getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	@Column(name = "flex1")
	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Column(name = "flex2")
	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	@Column(name = "flex3")
	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	@Column(name = "flex4")
	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	@Column(name = "flex5")
	public double getFlex5() {
		return flex5;
	}

	public void setFlex5(double flex5) {
		this.flex5 = flex5;
	}

	@Column(name = "flex6")
	public double getFlex6() {
		return flex6;
	}

	public void setFlex6(double flex6) {
		this.flex6 = flex6;
	}

	@Column(name = "flex7")
	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	@Column(name = "flex8")
	public Date getFlex8() {
		return flex8;
	}

	public void setFlex8(Date flex8) {
		this.flex8 = flex8;
	}

	@Column(name = "flex9")
	public Date getFlex9() {
		return flex9;
	}

	public void setFlex9(Date flex9) {
		this.flex9 = flex9;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "myVehicleServMaintId")
	public Long getMyVehicleServMaintId() {
		return myVehicleServMaintId;
	}

	public void setMyVehicleServMaintId(Long searchInsuranceId) {
		this.myVehicleServMaintId = searchInsuranceId;
	}
}
