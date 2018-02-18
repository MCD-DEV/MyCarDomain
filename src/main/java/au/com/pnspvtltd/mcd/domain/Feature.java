package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "features")
public class Feature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long featureId;
	private String featureName;
	private String featurDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FEATUREID")
	public long getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	@Column(name = "FEATURENAME")
	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@Column(name = "FEATUREDESCRIPTION")
	public String getFeaturDescription() {
		return featurDescription;
	}

	public void setFeaturDescription(String featurDescription) {
		this.featurDescription = featurDescription;
	}
}
