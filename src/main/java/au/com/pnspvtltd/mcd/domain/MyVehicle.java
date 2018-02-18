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

@Entity
@Table(name = "myvehicle")
public class MyVehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// veh info
	private Long myVehicleId;
	private int postalCode;
	private int year;
	private String make;
	private String model;
	private String variant;

	// Reg Info
	private String vin;
	private String regNum;
	private String regState;
	private Date regExpDate;

	// Ins Info
	private String insProv;
	private String insProvMan;
	private double insPremPaid;
	private String insPremPaidFreq;
	private Date insExpiry;

	// Maintanence info

	private String odoMeter;
	private Date lastServiceDt;
	private Date nextServiceDt;
	private int nextServKms;

	// Finance indfo

	private String finProvider;
	private double loanAmt1;
	private Date loanTakenDt;
	private String loanPaidFreq;
	private double loanAmt2;
	private double loanPeriod;
	private double loanInterest;

	// Fuel card info'
	private String fuelCardProvider;
	private String valFuelCard;
	private String fuelType;

	// Photos
	private String photo1;
	private String photo2;
	private String photo3;

	// Flex

	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;
	private double flex5;
	private double flex6;
	private double flex7;
	private Date flex8;
	private Date flex9;
	private boolean insRemind;
	private boolean maiRemind;
	private boolean finRemind;
	private boolean vehIdentRego;
	private boolean vehIdentRegoRemMon;
	private boolean vehIdentRegoRemTwo;
	private boolean vehIdentRegoOne;
	private boolean vehInsRemMon;
	private boolean vehInsRemTwo;
	private boolean vehInsRemOne;
	private boolean vehFinRemMon;
	private boolean vehFinRemTwo;
	private boolean vehFinRemOne;
	private boolean vehServRemMon;
	private boolean vehServRemTwo;
	private boolean vehServRemOne;

	private long idp;

	public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}

	@Column(name = "regExpDate")
	public Date getRegExpDate() {
		return regExpDate;
	}

	public void setRegExpDate(Date regExpDate) {
		this.regExpDate = regExpDate;
	}

	public boolean isVehServRemMon() {
		return vehServRemMon;
	}

	public void setVehServRemMon(boolean vehServRemMon) {
		this.vehServRemMon = vehServRemMon;
	}

	public boolean isVehServRemTwo() {
		return vehServRemTwo;
	}

	public void setVehServRemTwo(boolean vehServRemTwo) {
		this.vehServRemTwo = vehServRemTwo;
	}

	public boolean isVehServRemOne() {
		return vehServRemOne;
	}

	public void setVehServRemOne(boolean vehServRemOne) {
		this.vehServRemOne = vehServRemOne;
	}

	public boolean isVehIdentRego() {
		return vehIdentRego;
	}

	public void setVehIdentRego(boolean vehIdentRego) {
		this.vehIdentRego = vehIdentRego;
	}

	public boolean isVehIdentRegoRemMon() {
		return vehIdentRegoRemMon;
	}

	public void setVehIdentRegoRemMon(boolean vehIdentRegoRemMon) {
		this.vehIdentRegoRemMon = vehIdentRegoRemMon;
	}

	public boolean isVehIdentRegoRemTwo() {
		return vehIdentRegoRemTwo;
	}

	public void setVehIdentRegoRemTwo(boolean vehIdentRegoRemTwo) {
		this.vehIdentRegoRemTwo = vehIdentRegoRemTwo;
	}

	public boolean isVehIdentRegoOne() {
		return vehIdentRegoOne;
	}

	public void setVehIdentRegoOne(boolean vehIdentRegoOne) {
		this.vehIdentRegoOne = vehIdentRegoOne;
	}

	public boolean isVehInsRemMon() {
		return vehInsRemMon;
	}

	public void setVehInsRemMon(boolean vehInsRemMon) {
		this.vehInsRemMon = vehInsRemMon;
	}

	public boolean isVehInsRemTwo() {
		return vehInsRemTwo;
	}

	public void setVehInsRemTwo(boolean vehInsRemTwo) {
		this.vehInsRemTwo = vehInsRemTwo;
	}

	public boolean isVehInsRemOne() {
		return vehInsRemOne;
	}

	public void setVehInsRemOne(boolean vehInsRemOne) {
		this.vehInsRemOne = vehInsRemOne;
	}

	public boolean isVehFinRemMon() {
		return vehFinRemMon;
	}

	public void setVehFinRemMon(boolean vehFinRemMon) {
		this.vehFinRemMon = vehFinRemMon;
	}

	public boolean isVehFinRemTwo() {
		return vehFinRemTwo;
	}

	public void setVehFinRemTwo(boolean vehFinRemTwo) {
		this.vehFinRemTwo = vehFinRemTwo;
	}

	public boolean isVehFinRemOne() {
		return vehFinRemOne;
	}

	public void setVehFinRemOne(boolean vehFinRemOne) {
		this.vehFinRemOne = vehFinRemOne;
	}

	@Column(name = "insRemind")
	public boolean isInsRemind() {
		return insRemind;
	}

	public void setInsRemind(boolean insRemind) {
		this.insRemind = insRemind;
	}

	@Column(name = "maiRemind")
	public boolean isMaiRemind() {
		return maiRemind;
	}

	public void setMaiRemind(boolean maiRemind) {
		this.maiRemind = maiRemind;
	}

	@Column(name = "finRemind")
	public boolean isFinRemind() {
		return finRemind;
	}

	public void setFinRemind(boolean finRemind) {
		this.finRemind = finRemind;
	}

	List<MyVehicleLogBook> myVehicleLogBook;
	List<MyVehicleFuelExpenses> myVehicleFuelExpenses;
	List<MyVehicleServMaint> myVehicleServMaint;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "myVehicleId")
	public List<MyVehicleLogBook> getMyVehicleLogBook() {
		return myVehicleLogBook;
	}

	public void setMyVehicleLogBook(List<MyVehicleLogBook> myVehicleLogBook) {
		this.myVehicleLogBook = myVehicleLogBook;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "myVehicleId")
	public List<MyVehicleFuelExpenses> getMyVehicleFuelExpenses() {
		return myVehicleFuelExpenses;
	}

	public void setMyVehicleFuelExpenses(List<MyVehicleFuelExpenses> myVehicleFuelExpenses) {
		this.myVehicleFuelExpenses = myVehicleFuelExpenses;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "myVehicleId")
	public List<MyVehicleServMaint> getMyVehicleServMaint() {
		return myVehicleServMaint;
	}

	public void setMyVehicleServMaint(List<MyVehicleServMaint> myVehicleServMaint) {
		this.myVehicleServMaint = myVehicleServMaint;
	}

	@Column(name = "postalCode")
	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "vin")
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "regNum")
	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	@Column(name = "regState")
	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	/*
	 * public String getRegExpDate() { return regExpDate; }
	 * 
	 * public void setRegExpDate(String regExpDate) { this.regExpDate =
	 * regExpDate; }
	 */
	@Column(name = "insProv")
	public String getInsProv() {
		return insProv;
	}

	public void setInsProv(String insProv) {
		this.insProv = insProv;
	}

	@Column(name = "insProvMan")
	public String getInsProvMan() {
		return insProvMan;
	}

	public void setInsProvMan(String insProvMan) {
		this.insProvMan = insProvMan;
	}

	@Column(name = "insPremPaid")
	public double getInsPremPaid() {
		return insPremPaid;
	}

	public void setInsPremPaid(double insPremPaid) {
		this.insPremPaid = insPremPaid;
	}

	@Column(name = "insPremPaidFreq")
	public String getInsPremPaidFreq() {
		return insPremPaidFreq;
	}

	public void setInsPremPaidFreq(String insPremPaidFreq) {
		this.insPremPaidFreq = insPremPaidFreq;
	}

	@Column(name = "insExpiry")
	public Date getInsExpiry() {
		return insExpiry;
	}

	public void setInsExpiry(Date insExpiry) {
		this.insExpiry = insExpiry;
	}

	@Column(name = "odoMeter")
	public String getOdoMeter() {
		return odoMeter;
	}

	public void setOdoMeter(String odoMeter) {
		this.odoMeter = odoMeter;
	}

	@Column(name = "lastServiceDt")
	public Date getLastServiceDt() {
		return lastServiceDt;
	}

	public void setLastServiceDt(Date lastServiceDt) {
		this.lastServiceDt = lastServiceDt;
	}

	@Column(name = "nextServiceDt")
	public Date getNextServiceDt() {
		return nextServiceDt;
	}

	public void setNextServiceDt(Date nextServiceDt) {
		this.nextServiceDt = nextServiceDt;
	}

	@Column(name = "nextServKms")
	public int getNextServKms() {
		return nextServKms;
	}

	public void setNextServKms(int nextServKms) {
		this.nextServKms = nextServKms;
	}

	@Column(name = "finProvider")
	public String getFinProvider() {
		return finProvider;
	}

	public void setFinProvider(String finProvider) {
		this.finProvider = finProvider;
	}

	@Column(name = "loanAmt1")
	public double getLoanAmt1() {
		return loanAmt1;
	}

	public void setLoanAmt1(double loanAmt1) {
		this.loanAmt1 = loanAmt1;
	}

	@Column(name = "loanTakenDt")
	public Date getLoanTakenDt() {
		return loanTakenDt;
	}

	public void setLoanTakenDt(Date loanTakenDt) {
		this.loanTakenDt = loanTakenDt;
	}

	@Column(name = "loanPaidFreq")
	public String getLoanPaidFreq() {
		return loanPaidFreq;
	}

	public void setLoanPaidFreq(String loanPaidFreq) {
		this.loanPaidFreq = loanPaidFreq;
	}

	@Column(name = "loanAmt2")
	public double getLoanAmt2() {
		return loanAmt2;
	}

	public void setLoanAmt2(double loanAmt2) {
		this.loanAmt2 = loanAmt2;
	}

	@Column(name = "loanPeriod")
	public double getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(double loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	@Column(name = "loanInterest")
	public double getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(double loanInterest) {
		this.loanInterest = loanInterest;
	}

	@Column(name = "fuelCardProvider")
	public String getFuelCardProvider() {
		return fuelCardProvider;
	}

	public void setFuelCardProvider(String fuelCardProvider) {
		this.fuelCardProvider = fuelCardProvider;
	}

	@Column(name = "valFuelCard")
	public String getValFuelCard() {
		return valFuelCard;
	}

	public void setValFuelCard(String valFuelCard) {
		this.valFuelCard = valFuelCard;
	}

	@Column(name = "fuelType")
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "photo1")
	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	@Column(name = "photo2")
	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	@Column(name = "photo3")
	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
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
	@Column(name = "myVehicleId")
	public Long getMyVehicleId() {
		return myVehicleId;
	}

	public void setMyVehicleId(Long myVehicleId) {
		this.myVehicleId = myVehicleId;
	}

	@Column(name = "YEAR")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "MAKE")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "VARIANT")
	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

}
