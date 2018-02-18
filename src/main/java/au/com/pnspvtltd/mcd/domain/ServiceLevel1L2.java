package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: FinanceCompany
 * 
 */
@Entity
@Table(name = "servmaintl1l2")
public class ServiceLevel1L2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long servMaintLVId;

	private String servMaintLv1;
	private String servMaintLv2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERVMAINTLVID")
	public Long getServMaintLVId() {
		return servMaintLVId;
	}

	public void setServMaintLVId(Long servMaintLVId) {
		this.servMaintLVId = servMaintLVId;
	}

	@Column(name = "SERVMAINTLV1")
	public String getServMaintLv1() {
		return servMaintLv1;
	}

	public void setServMaintLv1(String servMaintLv1) {
		this.servMaintLv1 = servMaintLv1;
	}

	@Column(name = "SERVMAINTLV2")
	public String getServMaintLv2() {
		return servMaintLv2;
	}

	public void setServMaintLv2(String servMaintLv2) {
		this.servMaintLv2 = servMaintLv2;
	}

}
