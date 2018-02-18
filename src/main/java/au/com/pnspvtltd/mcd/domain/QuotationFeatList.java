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
@Table(name = "quotationfeat")
public class QuotationFeatList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795828321233759004L;

	/**
	 * 
	 */

	private Long quotationFeatListId;

	private String featName;
	private String featDes;

	public String getFeatName() {
		return featName;
	}

	public void setFeatName(String featName) {
		this.featName = featName;
	}

	public String getFeatDes() {
		return featDes;
	}

	public void setFeatDes(String featDes) {
		this.featDes = featDes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUOTATIONFEATLISTID")
	public Long getQuotationFeatListId() {
		return quotationFeatListId;
	}

	public void setQuotationFeatListId(Long quotationFeatListId) {
		this.quotationFeatListId = quotationFeatListId;
	}

	public QuotationFeatList() {
		super();
	}

}
