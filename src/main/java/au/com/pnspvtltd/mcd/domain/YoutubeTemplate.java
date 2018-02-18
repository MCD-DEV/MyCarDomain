package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templateyoutube")
public class YoutubeTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long templateYoutubeId;
	private String ylink1;
	private String flex1;
	private String flex2;
	private String flex3;
	private String flex4;

	@Column(name = "YLINK1")
	public String getYlink1() {
		return ylink1;
	}

	public void setYlink1(String ylink1) {
		this.ylink1 = ylink1;
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
	@Column(name = "TEMPLATEYOUTUBEID")
	public Long getTemplateYoutubeId() {
		return this.templateYoutubeId;
	}

	public void setTemplateYoutubeId(Long templateYoutubeId) {
		this.templateYoutubeId = templateYoutubeId;
	}

}
