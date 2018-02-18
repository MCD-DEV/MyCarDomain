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
@Table(name = "referencedpoints")
public class ReferencedPoints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long referPointId;
	private String referencedEmailId;
	private String referencedFirstName;
	private String referencedLastName;
	private int noOfPoints;
	private int actualPoints;
	private int divBy;
	private double audVal;
	private double rupVal;
	private double usdVal;
	private Date creationDate;
	private long idp;
	private String action;
	private boolean provStatus;
	private boolean status;
	private long refUserId;

	public long getRefUserId() {
		return refUserId;
	}

	public void setRefUserId(long refUserId) {
		this.refUserId = refUserId;
	}

	public boolean isProvStatus() {
		return provStatus;
	}

	public void setProvStatus(boolean provStatus) {
		this.provStatus = provStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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
	@Column(name = "REFERPOINTID")
	public Long getReferPointId() {
		return referPointId;
	}

	public void setReferPointId(Long referPointId) {
		this.referPointId = referPointId;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public String getReferencedEmailId() {
		return referencedEmailId;
	}

	public void setReferencedEmailId(String referencedEmailId) {
		this.referencedEmailId = referencedEmailId;
	}

	public String getReferencedFirstName() {
		return referencedFirstName;
	}

	public void setReferencedFirstName(String referencedFirstName) {
		this.referencedFirstName = referencedFirstName;
	}

	public String getReferencedLastName() {
		return referencedLastName;
	}

	public void setReferencedLastName(String referencedLastName) {
		this.referencedLastName = referencedLastName;
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
