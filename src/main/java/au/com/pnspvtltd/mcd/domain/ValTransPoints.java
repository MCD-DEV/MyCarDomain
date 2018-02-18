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
@Table(name = "valtranspoints")
public class ValTransPoints implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long valTransPointId;
	private long id;
	private String typeOfTrans;
	private String name;
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
	@Column(name = "VALTRPOINTID")
	public Long getValTransPointId() {
		return valTransPointId;
	}

	public void setValTransPointId(Long valTransPointId) {
		this.valTransPointId = valTransPointId;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeOfTrans() {
		return typeOfTrans;
	}

	public void setTypeOfTrans(String typeOfTrans) {
		this.typeOfTrans = typeOfTrans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
