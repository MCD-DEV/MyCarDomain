package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "templatecarmodel")
public class CarModelTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long tempModelId;
	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;
	private double mrlp;
	private double extraCost;
	private double onRoadCost;
	private double avgPrice;

	List<PhotosTemplate> photosTemplate;
	List<CountryTemplate> countryTemplate;
	List<YoutubeTemplate> youtubeTemplate;
	List<BlogTemplate> blogTemplate;
	List<UserReviewTemplate> userReviewTemplate;
	SpecificationTemplate specificationTemplate;

	@Column(name = "MODELYEAR")
	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	@Column(name = "MODELMAKE")
	public String getModelDisplay() {
		return modelDisplay;
	}

	public void setModelDisplay(String modelDisplay) {
		this.modelDisplay = modelDisplay;
	}

	@Column(name = "MODELNAME")
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Column(name = "MODELTRIM")
	public String getModelTrim() {
		return modelTrim;
	}

	public void setModelTrim(String modelTrim) {
		this.modelTrim = modelTrim;
	}

	@Column(name = "MRLP")
	public double getMrlp() {
		return mrlp;
	}

	public void setMrlp(double mrlp) {
		this.mrlp = mrlp;
	}

	@Column(name = "EXTRACOST")
	public double getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(double extraCost) {
		this.extraCost = extraCost;
	}

	@Column(name = "ONROADCOST")
	public double getOnRoadCost() {
		return onRoadCost;
	}

	public void setOnRoadCost(double onRoadCost) {
		this.onRoadCost = onRoadCost;
	}

	@Column(name = "AVGPRICE")
	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public CarModelTemplate() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPMODELID")
	public Long getTempModelId() {
		return this.tempModelId;
	}

	public void setTempModelId(Long tempModelId) {
		this.tempModelId = tempModelId;
	}

	public void setSpecificationTemplate(SpecificationTemplate specificationTemplate) {
		this.specificationTemplate = specificationTemplate;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public SpecificationTemplate getSpecificationTemplate() {
		return specificationTemplate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public List<PhotosTemplate> getPhotosTemplate() {
		return photosTemplate;
	}

	public void setPhotosTemplate(List<PhotosTemplate> photosTemplate) {
		this.photosTemplate = photosTemplate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public List<CountryTemplate> getCountryTemplate() {
		return countryTemplate;
	}

	public void setCountryTemplate(List<CountryTemplate> countryTemplate) {
		this.countryTemplate = countryTemplate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public List<YoutubeTemplate> getYoutubeTemplate() {
		return youtubeTemplate;
	}

	public void setYoutubeTemplate(List<YoutubeTemplate> youtubeTemplate) {
		this.youtubeTemplate = youtubeTemplate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public List<BlogTemplate> getBlogTemplate() {
		return blogTemplate;
	}

	public void setBlogTemplate(List<BlogTemplate> blogTemplate) {
		this.blogTemplate = blogTemplate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "tempModelId")
	public List<UserReviewTemplate> getUserReviewTemplate() {
		return userReviewTemplate;
	}

	public void setUserReviewTemplate(List<UserReviewTemplate> userReviewTemplate) {
		this.userReviewTemplate = userReviewTemplate;
	}

}
