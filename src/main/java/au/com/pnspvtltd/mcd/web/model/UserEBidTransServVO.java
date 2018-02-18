package au.com.pnspvtltd.mcd.web.model;

public class UserEBidTransServVO {

	private Long userId;

	private SearchTranspVO searchTranspLead;

	public SearchTranspVO getSearchTranspLead() {
		return searchTranspLead;
	}

	public void setSearchTranspLead(SearchTranspVO searchTranspLead) {
		this.searchTranspLead = searchTranspLead;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
