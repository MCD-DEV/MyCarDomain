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
@Entity @Table(name = "vehicledealertransportdetails") public class VehicleDealerTranspDetails implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long vehicleDealerTranspDetailId;
	
	private String fromState;
	private String toState;
	private String fromRegion;
	private String toRegion;
	private String fromPost;
	private String toPost;
	private String stateRate;
	private String regionRate;
	private String postRate;
		
	private boolean isStateRoute;
	private boolean isRegionRoute;
	private boolean isPostRoute;
	
	
	
	
	

	
	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public String getFromRegion() {
		return fromRegion;
	}

	public void setFromRegion(String fromRegion) {
		this.fromRegion = fromRegion;
	}

	public String getToRegion() {
		return toRegion;
	}

	public void setToRegion(String toRegion) {
		this.toRegion = toRegion;
	}

	public String getFromPost() {
		return fromPost;
	}

	public void setFromPost(String fromPost) {
		this.fromPost = fromPost;
	}

	public String getToPost() {
		return toPost;
	}

	public void setToPost(String toPost) {
		this.toPost = toPost;
	}

	public String getStateRate() {
		return stateRate;
	}

	public void setStateRate(String stateRate) {
		this.stateRate = stateRate;
	}

	public String getRegionRate() {
		return regionRate;
	}

	public void setRegionRate(String regionRate) {
		this.regionRate = regionRate;
	}

	public String getPostRate() {
		return postRate;
	}

	public void setPostRate(String postRate) {
		this.postRate = postRate;
	}

	public boolean isStateRoute() {
		return isStateRoute;
	}

	public void setStateRoute(boolean isStateRoute) {
		this.isStateRoute = isStateRoute;
	}

	public boolean isRegionRoute() {
		return isRegionRoute;
	}

	public void setRegionRoute(boolean isRegionRoute) {
		this.isRegionRoute = isRegionRoute;
	}

	public boolean isPostRoute() {
		return isPostRoute;
	}

	public void setPostRoute(boolean isPostRoute) {
		this.isPostRoute = isPostRoute;
	}

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "VEHICLEDEALERTRANSPDETAILID") public Long getVehicleDealerTranspDetailId() {
		return vehicleDealerTranspDetailId;
	}

	public void setVehicleDealerTranspDetailId(Long vehicleDealerTranspDetailId) {
		this.vehicleDealerTranspDetailId = vehicleDealerTranspDetailId;
	}

	
	
	
	


	
	
	
		
	/*end*/
	

	

	

	

	

	
		

	
	public VehicleDealerTranspDetails() {
        super();
    }
	
	

	

	 
    
 

 	
 	
 	
 	
 	
	
}
