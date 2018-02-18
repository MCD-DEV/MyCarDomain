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
@Table(name = "myvehiclefuelexpenses")
public class MyVehicleFuelExpenses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long myVehicleFuelExpensesId;
	private Date date;
	private Date Time;
	private String recordType;
	private int noOfLitres;
	private double amount;
	private String business;
	private String private2;
	private String others;
	private String photoOfInvoice;

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

	@Column(name = "noOfLitres")
	public int getNoOfLitres() {
		return noOfLitres;
	}

	public void setNoOfLitres(int noOfLitres) {
		this.noOfLitres = noOfLitres;
	}

	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "business")
	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	@Column(name = "private2")
	public String getPrivate2() {
		return private2;
	}

	public void setPrivate2(String private2) {
		this.private2 = private2;
	}

	@Column(name = "others")
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Column(name = "photoOfInvoice")
	public String getPhotoOfInvoice() {
		return photoOfInvoice;
	}

	public void setPhotoOfInvoice(String photoOfInvoice) {
		this.photoOfInvoice = photoOfInvoice;
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
	@Column(name = "MyVehicleFuelExpensesId")
	public Long getMyVehicleFuelExpensesId() {
		return myVehicleFuelExpensesId;
	}

	public void setMyVehicleFuelExpensesId(Long searchInsuranceId) {
		this.myVehicleFuelExpensesId = searchInsuranceId;
	}

}
