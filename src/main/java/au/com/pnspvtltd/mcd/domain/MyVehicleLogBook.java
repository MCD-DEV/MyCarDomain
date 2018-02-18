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
@Table(name = "myvehiclelogbook")
public class MyVehicleLogBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Column(name = "tripType")
	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	@Column(name = "tripDescription")
	public String getTripDescription() {
		return tripDescription;
	}

	public void setTripDescription(String tripDescription) {
		this.tripDescription = tripDescription;
	}

	@Column(name = "fromLocation")
	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	@Column(name = "toLocation")
	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	@Column(name = "odoMeterStartOfTrip")
	public String getOdoMeterStartOfTrip() {
		return odoMeterStartOfTrip;
	}

	public void setOdoMeterStartOfTrip(String odoMeterStartOfTrip) {
		this.odoMeterStartOfTrip = odoMeterStartOfTrip;
	}

	@Column(name = "odoMeterEndOfTrip")
	public String getOdoMeterEndOfTrip() {
		return odoMeterEndOfTrip;
	}

	public void setOdoMeterEndOfTrip(String odoMeterEndOfTrip) {
		this.odoMeterEndOfTrip = odoMeterEndOfTrip;
	}

	@Column(name = "routeKm")
	public int getRouteKm() {
		return routeKm;
	}

	public void setRouteKm(int routeKm) {
		this.routeKm = routeKm;
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
	@Column(name = "MYVEHICLELOGBOOKID")
	public Long getMyVehicleLogBookId() {
		return myVehicleLogBookId;
	}

	public void setMyVehicleLogBookId(Long myVehicleLogBookId) {
		this.myVehicleLogBookId = myVehicleLogBookId;
	}

}
