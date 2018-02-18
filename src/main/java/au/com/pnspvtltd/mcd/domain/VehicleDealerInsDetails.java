package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TEMPCARMODELOVERVIEW
 * 
 */
@Entity
@Table(name = "vehicledealerInsdetails1")
public class VehicleDealerInsDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long vehicleDealerFinInsDetailId;

	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEHICLEDEALERFININSDETAILID")
	public Long getVehicleDealerFinInsDetailId() {
		return vehicleDealerFinInsDetailId;
	}

	public void setVehicleDealerFinInsDetailId(Long vehicleDealerFinInsDetailId) {
		this.vehicleDealerFinInsDetailId = vehicleDealerFinInsDetailId;
	}

	/* end */

	public VehicleDealerInsDetails() {
		super();
	}

}
