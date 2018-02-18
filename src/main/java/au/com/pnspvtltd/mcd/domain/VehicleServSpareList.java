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
 * Entity implementation class for Entity: TEMPCARMODELOVERVIEW
 * 
 */
@Entity @Table(name = "vehicleservsparelist") public class VehicleServSpareList implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long vehicleDealServListId;
	
	
	private String desc;
	private String quantity;
	/*private double value;*/
	
	










	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "VEHICLEDEALSERVLISTID") public Long getVehicleDealServListId() {
		return vehicleDealServListId;
	}


	public void setVehicleDealServListId(Long vehicleDealServListId) {
		this.vehicleDealServListId = vehicleDealServListId;
	}


	










	
	
/*start */
	
	
	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	/*public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}*/















	
// End of flex
		
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	public VehicleServSpareList() {
        super();
    }
	
	

	 	
	
}
