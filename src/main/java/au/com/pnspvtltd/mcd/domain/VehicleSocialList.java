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
@Table(name = "vehiclesociallist")
public class VehicleSocialList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long vehicleSocialListId;

	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEHICLESOCIALLISTID")
	public Long getVehicleSocialListId() {
		return vehicleSocialListId;
	}

	public void setVehicleSocialListId(Long vehicleSocialListId) {
		this.vehicleSocialListId = vehicleSocialListId;
	}

	public VehicleSocialList() {
		super();
	}

}
