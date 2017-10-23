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
@Entity @Table(name = "vehofferdate") public class OfferDateList implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;
	

	/**
	 * 
	 */
												
		

	
	private Long offerDateListId;
	
	
	private Date offerDate;
	


	public Date getOfferDate() {
		return offerDate;
	}


	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "vehofferId") public Long getOfferDateListId() {
		return offerDateListId;
	}


	public void setOfferDateListId(Long offerDateListId) {
		this.offerDateListId = offerDateListId;
	}


	

	

	

	

	

	
		

	
	public OfferDateList() {
        super();
    }
	
	

	 	
	
}
