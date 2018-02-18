package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class MyVehicleServMaintVO {

	/*
	 * Mapping "carColor" : $("carColor").val(),
	 * "postCode":$('#postCode').val(), "make":$('#seats').val(),
	 * "bodyType":$('#driveType').val(), "state":$('#fuelType').val(),
	 * "region":$('#freetext').val(), "ausCapTer":$('#vehiclePurpose').val(),
	 * "region":$('#transmission').val(), "sMake":$('#extraExternal1').val(),
	 */

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

	public Long getMyVehicleServMaintId() {
		return myVehicleServMaintId;
	}

	public void setMyVehicleServMaintId(Long myVehicleServMaintId) {
		this.myVehicleServMaintId = myVehicleServMaintId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getMechanicName() {
		return mechanicName;
	}

	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTypeOfServMaint() {
		return typeOfServMaint;
	}

	public void setTypeOfServMaint(String typeOfServMaint) {
		this.typeOfServMaint = typeOfServMaint;
	}

	public String getMechanicAddress() {
		return mechanicAddress;
	}

	public void setMechanicAddress(String mechanicAddress) {
		this.mechanicAddress = mechanicAddress;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public int getOdoMeterKm() {
		return odoMeterKm;
	}

	public void setOdoMeterKm(int odoMeterKm) {
		this.odoMeterKm = odoMeterKm;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getNextOdoMeterKm() {
		return nextOdoMeterKm;
	}

	public void setNextOdoMeterKm(int nextOdoMeterKm) {
		this.nextOdoMeterKm = nextOdoMeterKm;
	}

	public Date getNextServDate() {
		return nextServDate;
	}

	public void setNextServDate(Date nextServDate) {
		this.nextServDate = nextServDate;
	}

	public String getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public double getFlex5() {
		return flex5;
	}

	public void setFlex5(double flex5) {
		this.flex5 = flex5;
	}

	public double getFlex6() {
		return flex6;
	}

	public void setFlex6(double flex6) {
		this.flex6 = flex6;
	}

	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	public Date getFlex8() {
		return flex8;
	}

	public void setFlex8(Date flex8) {
		this.flex8 = flex8;
	}

	public Date getFlex9() {
		return flex9;
	}

	public void setFlex9(Date flex9) {
		this.flex9 = flex9;
	}

}
