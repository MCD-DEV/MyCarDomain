package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templateuserreview")
public class UserReviewTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long templateUserReviewId;
	private String review1;
	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;

	@Column(name = "REVIEW1")
	public String getReview1() {
		return review1;
	}

	public void setReview1(String review1) {
		this.review1 = review1;
	}

	@Column(name = "FLEX1")
	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	@Column(name = "FLEX2")
	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	@Column(name = "FLEX3")
	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	@Column(name = "FLEX4")
	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPLATEUSERREVIEWID")
	public Long getTemplateUserReviewId() {
		return this.templateUserReviewId;
	}

	public void setTemplateUserReviewId(Long templateUserReviewId) {
		this.templateUserReviewId = templateUserReviewId;
	}

}
