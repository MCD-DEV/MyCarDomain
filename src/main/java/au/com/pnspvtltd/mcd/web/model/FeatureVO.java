package au.com.pnspvtltd.mcd.web.model;

public class FeatureVO {

	private long featureId;
	private String featureName;
	private String featurDescription;

	public long getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeaturDescription() {
		return featurDescription;
	}

	public void setFeaturDescription(String featurDescription) {
		this.featurDescription = featurDescription;
	}
}
