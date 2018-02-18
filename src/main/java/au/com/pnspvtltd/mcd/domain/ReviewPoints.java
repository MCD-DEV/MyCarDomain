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
@Table(name = "reviewpoints")
public class ReviewPoints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long revPointId;
	private long revId;
	private String revName;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REVPOINTID")
	public Long getRevPointId() {
		return revPointId;
	}

	public void setRevPointId(Long revPointId) {
		this.revPointId = revPointId;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public long getRevId() {
		return revId;
	}

	public void setRevId(long revId) {
		this.revId = revId;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
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
