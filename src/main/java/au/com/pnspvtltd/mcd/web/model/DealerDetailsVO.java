package au.com.pnspvtltd.mcd.web.model;

public class DealerDetailsVO {

	private Long dealerId;
	private String email;

	private String dealerGroupName;
	private String subscriptionType;

	private String ABNNumber;
	private String dealername;
	public Long getDealerId() {
		return dealerId;
	}
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDealerGroupName() {
		return dealerGroupName;
	}
	public void setDealerGroupName(String dealerGroupName) {
		this.dealerGroupName = dealerGroupName;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public String getABNNumber() {
		return ABNNumber;
	}
	public void setABNNumber(String aBNNumber) {
		ABNNumber = aBNNumber;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}



}
