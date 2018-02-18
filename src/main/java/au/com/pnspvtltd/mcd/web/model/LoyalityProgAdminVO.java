package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LoyalityProgAdminVO {

	private Long loyalityProgramId;

	// review
	private String revName;
	private String revAction1;
	private String revAction2;
	private String revAction3;
	private String revAction4;
	private int revDivByAct1;
	private int revDivByAct2;
	private int revDivByAct3;
	private int revDivByAct4;
	// blog
	private String blogName;
	private String blogAction1;
	private String blogAction2;
	private String blogAction3;
	private String blogAction4;
	private int blogDivByAct1;
	private int blogDivByAct2;
	private int blogDivByAct3;
	private int blogDivByAct4;
	// referred
	private String referredName;
	private String referredAction1;
	private String referredAction2;
	private String referredAction3;
	private String referredAction4;
	private int referredDivByAct1;
	private int referredDivByAct2;
	private int referredDivByAct3;
	private int referredDivByAct4;

	// userrefer
	private String userReferName;
	private String userReferAction1;
	private String userReferAction2;
	private String userReferAction3;
	private String userReferAction4;
	private int userReferDivByAct1;
	private int userReferDivByAct2;
	private int userReferDivByAct3;
	private int userReferDivByAct4;
	// value of Trans
	private String typeOfTrans;

	// buy cars
	private String buyCarAction1;
	private String buyCarAction2;
	private String buyCarAction3;
	private String buyCarAction4;
	private int buyCarDivByAct1;
	private int buyCarDivByAct2;
	private int buyCarDivByAct3;
	private int buyCarDivByAct4;
	// sell cars
	// value of Trans
	private String typeOfSell;
	private String typeOfFin;
	private String typeOfIns;
	private String typeOfTrnp;
	private String typeOfServ;

	private String sellCarAction1;
	private String sellCarAction2;
	private String sellCarAction3;
	private String sellCarAction4;
	private int sellCarDivByAct1;
	private int sellCarDivByAct2;
	private int sellCarDivByAct3;
	private int sellCarDivByAct4;
	// buying service
	// finance
	private String finCarAction1;
	private String finCarAction2;
	private String finCarAction3;
	private String finCarAction4;
	private int finCarDivByAct1;
	private int finCarDivByAct2;
	private int finCarDivByAct3;
	private int finCarDivByAct4;

	// insurance
	private String insCarAction1;
	private String insCarAction2;
	private String insCarAction3;
	private String insCarAction4;
	private int insCarDivByAct1;
	private int insCarDivByAct2;
	private int insCarDivByAct3;
	private int insCarDivByAct4;

	// transport
	private String transpCarAction1;
	private String transpCarAction2;
	private String transpCarAction3;
	private String transpCarAction4;
	private int transpCarDivByAct1;
	private int transpCarDivByAct2;
	private int transpCarDivByAct3;
	private int transpCarDivByAct4;

	// service and Maintenance
	private String servCarAction1;
	private String servCarAction2;
	private String servCarAction3;
	private String servCarAction4;
	private int servCarDivByAct1;
	private int servCarDivByAct2;
	private int servCarDivByAct3;
	private int servCarDivByAct4;
	private boolean status;
	private Date creationDate;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTypeOfSell() {
		return typeOfSell;
	}

	public void setTypeOfSell(String typeOfSell) {
		this.typeOfSell = typeOfSell;
	}

	public String getTypeOfFin() {
		return typeOfFin;
	}

	public void setTypeOfFin(String typeOfFin) {
		this.typeOfFin = typeOfFin;
	}

	public String getTypeOfIns() {
		return typeOfIns;
	}

	public void setTypeOfIns(String typeOfIns) {
		this.typeOfIns = typeOfIns;
	}

	public String getTypeOfTrnp() {
		return typeOfTrnp;
	}

	public void setTypeOfTrnp(String typeOfTrnp) {
		this.typeOfTrnp = typeOfTrnp;
	}

	public String getTypeOfServ() {
		return typeOfServ;
	}

	public void setTypeOfServ(String typeOfServ) {
		this.typeOfServ = typeOfServ;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOYALITYPROGAMID")

	public Long getLoyalityProgramId() {
		return loyalityProgramId;
	}

	public void setLoyalityProgramId(Long loyalityProgramId) {
		this.loyalityProgramId = loyalityProgramId;
	}

	/* start */

	// Flex start
	private String flex1;

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public String getRevAction1() {
		return revAction1;
	}

	public void setRevAction1(String revAction1) {
		this.revAction1 = revAction1;
	}

	public String getRevAction2() {
		return revAction2;
	}

	public void setRevAction2(String revAction2) {
		this.revAction2 = revAction2;
	}

	public String getRevAction3() {
		return revAction3;
	}

	public void setRevAction3(String revAction3) {
		this.revAction3 = revAction3;
	}

	public String getRevAction4() {
		return revAction4;
	}

	public void setRevAction4(String revAction4) {
		this.revAction4 = revAction4;
	}

	public int getRevDivByAct1() {
		return revDivByAct1;
	}

	public void setRevDivByAct1(int revDivByAct1) {
		this.revDivByAct1 = revDivByAct1;
	}

	public int getRevDivByAct2() {
		return revDivByAct2;
	}

	public void setRevDivByAct2(int revDivByAct2) {
		this.revDivByAct2 = revDivByAct2;
	}

	public int getRevDivByAct3() {
		return revDivByAct3;
	}

	public void setRevDivByAct3(int revDivByAct3) {
		this.revDivByAct3 = revDivByAct3;
	}

	public int getRevDivByAct4() {
		return revDivByAct4;
	}

	public void setRevDivByAct4(int revDivByAct4) {
		this.revDivByAct4 = revDivByAct4;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogAction1() {
		return blogAction1;
	}

	public void setBlogAction1(String blogAction1) {
		this.blogAction1 = blogAction1;
	}

	public String getBlogAction2() {
		return blogAction2;
	}

	public void setBlogAction2(String blogAction2) {
		this.blogAction2 = blogAction2;
	}

	public String getBlogAction3() {
		return blogAction3;
	}

	public void setBlogAction3(String blogAction3) {
		this.blogAction3 = blogAction3;
	}

	public String getBlogAction4() {
		return blogAction4;
	}

	public void setBlogAction4(String blogAction4) {
		this.blogAction4 = blogAction4;
	}

	public int getBlogDivByAct1() {
		return blogDivByAct1;
	}

	public void setBlogDivByAct1(int blogDivByAct1) {
		this.blogDivByAct1 = blogDivByAct1;
	}

	public int getBlogDivByAct2() {
		return blogDivByAct2;
	}

	public void setBlogDivByAct2(int blogDivByAct2) {
		this.blogDivByAct2 = blogDivByAct2;
	}

	public int getBlogDivByAct3() {
		return blogDivByAct3;
	}

	public void setBlogDivByAct3(int blogDivByAct3) {
		this.blogDivByAct3 = blogDivByAct3;
	}

	public int getBlogDivByAct4() {
		return blogDivByAct4;
	}

	public void setBlogDivByAct4(int blogDivByAct4) {
		this.blogDivByAct4 = blogDivByAct4;
	}

	public String getReferredName() {
		return referredName;
	}

	public void setReferredName(String referredName) {
		this.referredName = referredName;
	}

	public String getReferredAction1() {
		return referredAction1;
	}

	public void setReferredAction1(String referredAction1) {
		this.referredAction1 = referredAction1;
	}

	public String getReferredAction2() {
		return referredAction2;
	}

	public void setReferredAction2(String referredAction2) {
		this.referredAction2 = referredAction2;
	}

	public String getReferredAction3() {
		return referredAction3;
	}

	public void setReferredAction3(String referredAction3) {
		this.referredAction3 = referredAction3;
	}

	public String getReferredAction4() {
		return referredAction4;
	}

	public void setReferredAction4(String referredAction4) {
		this.referredAction4 = referredAction4;
	}

	public int getReferredDivByAct1() {
		return referredDivByAct1;
	}

	public void setReferredDivByAct1(int referredDivByAct1) {
		this.referredDivByAct1 = referredDivByAct1;
	}

	public int getReferredDivByAct2() {
		return referredDivByAct2;
	}

	public void setReferredDivByAct2(int referredDivByAct2) {
		this.referredDivByAct2 = referredDivByAct2;
	}

	public int getReferredDivByAct3() {
		return referredDivByAct3;
	}

	public void setReferredDivByAct3(int referredDivByAct3) {
		this.referredDivByAct3 = referredDivByAct3;
	}

	public int getReferredDivByAct4() {
		return referredDivByAct4;
	}

	public void setReferredDivByAct4(int referredDivByAct4) {
		this.referredDivByAct4 = referredDivByAct4;
	}

	public String getUserReferName() {
		return userReferName;
	}

	public void setUserReferName(String userReferName) {
		this.userReferName = userReferName;
	}

	public String getUserReferAction1() {
		return userReferAction1;
	}

	public void setUserReferAction1(String userReferAction1) {
		this.userReferAction1 = userReferAction1;
	}

	public String getUserReferAction2() {
		return userReferAction2;
	}

	public void setUserReferAction2(String userReferAction2) {
		this.userReferAction2 = userReferAction2;
	}

	public String getUserReferAction3() {
		return userReferAction3;
	}

	public void setUserReferAction3(String userReferAction3) {
		this.userReferAction3 = userReferAction3;
	}

	public String getUserReferAction4() {
		return userReferAction4;
	}

	public void setUserReferAction4(String userReferAction4) {
		this.userReferAction4 = userReferAction4;
	}

	public int getUserReferDivByAct1() {
		return userReferDivByAct1;
	}

	public void setUserReferDivByAct1(int userReferDivByAct1) {
		this.userReferDivByAct1 = userReferDivByAct1;
	}

	public int getUserReferDivByAct2() {
		return userReferDivByAct2;
	}

	public void setUserReferDivByAct2(int userReferDivByAct2) {
		this.userReferDivByAct2 = userReferDivByAct2;
	}

	public int getUserReferDivByAct3() {
		return userReferDivByAct3;
	}

	public void setUserReferDivByAct3(int userReferDivByAct3) {
		this.userReferDivByAct3 = userReferDivByAct3;
	}

	public int getUserReferDivByAct4() {
		return userReferDivByAct4;
	}

	public void setUserReferDivByAct4(int userReferDivByAct4) {
		this.userReferDivByAct4 = userReferDivByAct4;
	}

	public String getTypeOfTrans() {
		return typeOfTrans;
	}

	public void setTypeOfTrans(String typeOfTrans) {
		this.typeOfTrans = typeOfTrans;
	}

	public String getBuyCarAction1() {
		return buyCarAction1;
	}

	public void setBuyCarAction1(String buyCarAction1) {
		this.buyCarAction1 = buyCarAction1;
	}

	public String getBuyCarAction2() {
		return buyCarAction2;
	}

	public void setBuyCarAction2(String buyCarAction2) {
		this.buyCarAction2 = buyCarAction2;
	}

	public String getBuyCarAction3() {
		return buyCarAction3;
	}

	public void setBuyCarAction3(String buyCarAction3) {
		this.buyCarAction3 = buyCarAction3;
	}

	public String getBuyCarAction4() {
		return buyCarAction4;
	}

	public void setBuyCarAction4(String buyCarAction4) {
		this.buyCarAction4 = buyCarAction4;
	}

	public int getBuyCarDivByAct1() {
		return buyCarDivByAct1;
	}

	public void setBuyCarDivByAct1(int buyCarDivByAct1) {
		this.buyCarDivByAct1 = buyCarDivByAct1;
	}

	public int getBuyCarDivByAct2() {
		return buyCarDivByAct2;
	}

	public void setBuyCarDivByAct2(int buyCarDivByAct2) {
		this.buyCarDivByAct2 = buyCarDivByAct2;
	}

	public int getBuyCarDivByAct3() {
		return buyCarDivByAct3;
	}

	public void setBuyCarDivByAct3(int buyCarDivByAct3) {
		this.buyCarDivByAct3 = buyCarDivByAct3;
	}

	public int getBuyCarDivByAct4() {
		return buyCarDivByAct4;
	}

	public void setBuyCarDivByAct4(int buyCarDivByAct4) {
		this.buyCarDivByAct4 = buyCarDivByAct4;
	}

	public String getSellCarAction1() {
		return sellCarAction1;
	}

	public void setSellCarAction1(String sellCarAction1) {
		this.sellCarAction1 = sellCarAction1;
	}

	public String getSellCarAction2() {
		return sellCarAction2;
	}

	public void setSellCarAction2(String sellCarAction2) {
		this.sellCarAction2 = sellCarAction2;
	}

	public String getSellCarAction3() {
		return sellCarAction3;
	}

	public void setSellCarAction3(String sellCarAction3) {
		this.sellCarAction3 = sellCarAction3;
	}

	public String getSellCarAction4() {
		return sellCarAction4;
	}

	public void setSellCarAction4(String sellCarAction4) {
		this.sellCarAction4 = sellCarAction4;
	}

	public int getSellCarDivByAct1() {
		return sellCarDivByAct1;
	}

	public void setSellCarDivByAct1(int sellCarDivByAct1) {
		this.sellCarDivByAct1 = sellCarDivByAct1;
	}

	public int getSellCarDivByAct2() {
		return sellCarDivByAct2;
	}

	public void setSellCarDivByAct2(int sellCarDivByAct2) {
		this.sellCarDivByAct2 = sellCarDivByAct2;
	}

	public int getSellCarDivByAct3() {
		return sellCarDivByAct3;
	}

	public void setSellCarDivByAct3(int sellCarDivByAct3) {
		this.sellCarDivByAct3 = sellCarDivByAct3;
	}

	public int getSellCarDivByAct4() {
		return sellCarDivByAct4;
	}

	public void setSellCarDivByAct4(int sellCarDivByAct4) {
		this.sellCarDivByAct4 = sellCarDivByAct4;
	}

	public String getFinCarAction1() {
		return finCarAction1;
	}

	public void setFinCarAction1(String finCarAction1) {
		this.finCarAction1 = finCarAction1;
	}

	public String getFinCarAction2() {
		return finCarAction2;
	}

	public void setFinCarAction2(String finCarAction2) {
		this.finCarAction2 = finCarAction2;
	}

	public String getFinCarAction3() {
		return finCarAction3;
	}

	public void setFinCarAction3(String finCarAction3) {
		this.finCarAction3 = finCarAction3;
	}

	public String getFinCarAction4() {
		return finCarAction4;
	}

	public void setFinCarAction4(String finCarAction4) {
		this.finCarAction4 = finCarAction4;
	}

	public int getFinCarDivByAct1() {
		return finCarDivByAct1;
	}

	public void setFinCarDivByAct1(int finCarDivByAct1) {
		this.finCarDivByAct1 = finCarDivByAct1;
	}

	public int getFinCarDivByAct2() {
		return finCarDivByAct2;
	}

	public void setFinCarDivByAct2(int finCarDivByAct2) {
		this.finCarDivByAct2 = finCarDivByAct2;
	}

	public int getFinCarDivByAct3() {
		return finCarDivByAct3;
	}

	public void setFinCarDivByAct3(int finCarDivByAct3) {
		this.finCarDivByAct3 = finCarDivByAct3;
	}

	public int getFinCarDivByAct4() {
		return finCarDivByAct4;
	}

	public void setFinCarDivByAct4(int finCarDivByAct4) {
		this.finCarDivByAct4 = finCarDivByAct4;
	}

	public String getInsCarAction1() {
		return insCarAction1;
	}

	public void setInsCarAction1(String insCarAction1) {
		this.insCarAction1 = insCarAction1;
	}

	public String getInsCarAction2() {
		return insCarAction2;
	}

	public void setInsCarAction2(String insCarAction2) {
		this.insCarAction2 = insCarAction2;
	}

	public String getInsCarAction3() {
		return insCarAction3;
	}

	public void setInsCarAction3(String insCarAction3) {
		this.insCarAction3 = insCarAction3;
	}

	public String getInsCarAction4() {
		return insCarAction4;
	}

	public void setInsCarAction4(String insCarAction4) {
		this.insCarAction4 = insCarAction4;
	}

	public int getInsCarDivByAct1() {
		return insCarDivByAct1;
	}

	public void setInsCarDivByAct1(int insCarDivByAct1) {
		this.insCarDivByAct1 = insCarDivByAct1;
	}

	public int getInsCarDivByAct2() {
		return insCarDivByAct2;
	}

	public void setInsCarDivByAct2(int insCarDivByAct2) {
		this.insCarDivByAct2 = insCarDivByAct2;
	}

	public int getInsCarDivByAct3() {
		return insCarDivByAct3;
	}

	public void setInsCarDivByAct3(int insCarDivByAct3) {
		this.insCarDivByAct3 = insCarDivByAct3;
	}

	public int getInsCarDivByAct4() {
		return insCarDivByAct4;
	}

	public void setInsCarDivByAct4(int insCarDivByAct4) {
		this.insCarDivByAct4 = insCarDivByAct4;
	}

	public String getTranspCarAction1() {
		return transpCarAction1;
	}

	public void setTranspCarAction1(String transpCarAction1) {
		this.transpCarAction1 = transpCarAction1;
	}

	public String getTranspCarAction2() {
		return transpCarAction2;
	}

	public void setTranspCarAction2(String transpCarAction2) {
		this.transpCarAction2 = transpCarAction2;
	}

	public String getTranspCarAction3() {
		return transpCarAction3;
	}

	public void setTranspCarAction3(String transpCarAction3) {
		this.transpCarAction3 = transpCarAction3;
	}

	public String getTranspCarAction4() {
		return transpCarAction4;
	}

	public void setTranspCarAction4(String transpCarAction4) {
		this.transpCarAction4 = transpCarAction4;
	}

	public int getTranspCarDivByAct1() {
		return transpCarDivByAct1;
	}

	public void setTranspCarDivByAct1(int transpCarDivByAct1) {
		this.transpCarDivByAct1 = transpCarDivByAct1;
	}

	public int getTranspCarDivByAct2() {
		return transpCarDivByAct2;
	}

	public void setTranspCarDivByAct2(int transpCarDivByAct2) {
		this.transpCarDivByAct2 = transpCarDivByAct2;
	}

	public int getTranspCarDivByAct3() {
		return transpCarDivByAct3;
	}

	public void setTranspCarDivByAct3(int transpCarDivByAct3) {
		this.transpCarDivByAct3 = transpCarDivByAct3;
	}

	public int getTranspCarDivByAct4() {
		return transpCarDivByAct4;
	}

	public void setTranspCarDivByAct4(int transpCarDivByAct4) {
		this.transpCarDivByAct4 = transpCarDivByAct4;
	}

	public String getServCarAction1() {
		return servCarAction1;
	}

	public void setServCarAction1(String servCarAction1) {
		this.servCarAction1 = servCarAction1;
	}

	public String getServCarAction2() {
		return servCarAction2;
	}

	public void setServCarAction2(String servCarAction2) {
		this.servCarAction2 = servCarAction2;
	}

	public String getServCarAction3() {
		return servCarAction3;
	}

	public void setServCarAction3(String servCarAction3) {
		this.servCarAction3 = servCarAction3;
	}

	public String getServCarAction4() {
		return servCarAction4;
	}

	public void setServCarAction4(String servCarAction4) {
		this.servCarAction4 = servCarAction4;
	}

	public int getServCarDivByAct1() {
		return servCarDivByAct1;
	}

	public void setServCarDivByAct1(int servCarDivByAct1) {
		this.servCarDivByAct1 = servCarDivByAct1;
	}

	public int getServCarDivByAct2() {
		return servCarDivByAct2;
	}

	public void setServCarDivByAct2(int servCarDivByAct2) {
		this.servCarDivByAct2 = servCarDivByAct2;
	}

	public int getServCarDivByAct3() {
		return servCarDivByAct3;
	}

	public void setServCarDivByAct3(int servCarDivByAct3) {
		this.servCarDivByAct3 = servCarDivByAct3;
	}

	public int getServCarDivByAct4() {
		return servCarDivByAct4;
	}

	public void setServCarDivByAct4(int servCarDivByAct4) {
		this.servCarDivByAct4 = servCarDivByAct4;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private String flex2;
	private String flex3;
	private String flex4;
	private int flex5;
	private int flex6;
	private double flex7;
	private double flex8;
	private double flex9;
	private double flex10;
	private Date flex11;
	private Date flex12;
	private boolean isFlex13;
	private boolean isFlex14;

	public String getFlex1() {
		return flex1;
	}

	public boolean isFlex13() {
		return isFlex13;
	}

	public void setFlex13(boolean isFlex13) {
		this.isFlex13 = isFlex13;
	}

	public boolean isFlex14() {
		return isFlex14;
	}

	public void setFlex14(boolean isFlex14) {
		this.isFlex14 = isFlex14;
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

	public int getFlex5() {
		return flex5;
	}

	public void setFlex5(int flex5) {
		this.flex5 = flex5;
	}

	public int getFlex6() {
		return flex6;
	}

	public void setFlex6(int flex6) {
		this.flex6 = flex6;
	}

	public double getFlex7() {
		return flex7;
	}

	public void setFlex7(double flex7) {
		this.flex7 = flex7;
	}

	public double getFlex8() {
		return flex8;
	}

	public void setFlex8(double flex8) {
		this.flex8 = flex8;
	}

	public double getFlex9() {
		return flex9;
	}

	public void setFlex9(double flex9) {
		this.flex9 = flex9;
	}

	public double getFlex10() {
		return flex10;
	}

	public void setFlex10(double flex10) {
		this.flex10 = flex10;
	}

	public Date getFlex11() {
		return flex11;
	}

	public void setFlex11(Date flex11) {
		this.flex11 = flex11;
	}

	public Date getFlex12() {
		return flex12;
	}

	public void setFlex12(Date flex12) {
		this.flex12 = flex12;
	}
	// End of flex

	/* end */

}
