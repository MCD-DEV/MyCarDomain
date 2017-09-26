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

/**
 * Entity implementation class for Entity: UserNotification
 * 
 */
@Entity @Table(name = "vehquodoc") public class VehQuotDoc implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long vehquodocId;
	
	
	
	private String extras1;
	private String extras2;
	private double amount;
	
	
	
	
	
	

	
	
	
/*start */
	
	
	
	public String getExtras1() {
		return extras1;
	}


	public void setExtras1(String extras1) {
		this.extras1 = extras1;
	}


	public String getExtras2() {
		return extras2;
	}


	public void setExtras2(String extras2) {
		this.extras2 = extras2;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "vehquodocId")
	public Long getVehquodocId() {
		return vehquodocId;
	}


	public void setVehquodocId(Long searchInsAddDrivId) {
		this.vehquodocId = searchInsAddDrivId;
	}

	
	 	
	
}
