package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class MyVehicleLogBookVO {

	/*
	 * Mapping "carColor" : $("carColor").val(),
	 * "postCode":$('#postCode').val(), "make":$('#seats').val(),
	 * "bodyType":$('#driveType').val(), "state":$('#fuelType').val(),
	 * "region":$('#freetext').val(), "ausCapTer":$('#vehiclePurpose').val(),
	 * "region":$('#transmission').val(), "sMake":$('#extraExternal1').val(),
	 */

	private Long myVehicleLogBookId;
	private Date date;
	private Date Time;
	private String recordType;
	private String tripType;
	private String tripDescription;
	private String fromLocation;
	private String toLocation;
	private String odoMeterStartOfTrip;
	private String odoMeterEndOfTrip;
	private int routeKm;

	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;
	private double flex5;
	private double flex6;
	private double flex7;
	private Date flex8;
	private Date flex9;

	public Long getMyVehicleLogBookId() {
		return myVehicleLogBookId;
	}

	public void setMyVehicleLogBookId(Long myVehicleLogBookId) {
		this.myVehicleLogBookId = myVehicleLogBookId;
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

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public String getTripDescription() {
		return tripDescription;
	}

	public void setTripDescription(String tripDescription) {
		this.tripDescription = tripDescription;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getOdoMeterStartOfTrip() {
		return odoMeterStartOfTrip;
	}

	public void setOdoMeterStartOfTrip(String odoMeterStartOfTrip) {
		this.odoMeterStartOfTrip = odoMeterStartOfTrip;
	}

	public String getOdoMeterEndOfTrip() {
		return odoMeterEndOfTrip;
	}

	public void setOdoMeterEndOfTrip(String odoMeterEndOfTrip) {
		this.odoMeterEndOfTrip = odoMeterEndOfTrip;
	}

	public int getRouteKm() {
		return routeKm;
	}

	public void setRouteKm(int routeKm) {
		this.routeKm = routeKm;
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
