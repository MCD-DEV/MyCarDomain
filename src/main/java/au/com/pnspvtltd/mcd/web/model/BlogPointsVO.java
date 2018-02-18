package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;

public class BlogPointsVO {

	private Long blogPointId;
	private long blogId;
	private String blogName;
	private int noOfPoints;
	private int actualPoints;
	private int divBy;
	private double audVal;
	private double rupVal;
	private double usdVal;
	private Date creationDate;
	private long idp;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getActualPoints() {
		return actualPoints;
	}

	public void setActualPoints(int actualPoints) {
		this.actualPoints = actualPoints;
	}

	public long getIdp() {
		return idp;
	}

	public void setIdp(long idp) {
		this.idp = idp;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getBlogPointId() {
		return blogPointId;
	}

	public void setBlogPointId(Long blogPointId) {
		this.blogPointId = blogPointId;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public void setNoOfPoints(int noOfPoints) {
		this.noOfPoints = noOfPoints;
	}

	public int getDivBy() {
		return divBy;
	}

	public void setDivBy(int divBy) {
		this.divBy = divBy;
	}

	public double getAudVal() {
		return audVal;
	}

	public void setAudVal(double audVal) {
		this.audVal = audVal;
	}

	public double getRupVal() {
		return rupVal;
	}

	public void setRupVal(double rupVal) {
		this.rupVal = rupVal;
	}

	public double getUsdVal() {
		return usdVal;
	}

	public void setUsdVal(double usdVal) {
		this.usdVal = usdVal;
	}

}
