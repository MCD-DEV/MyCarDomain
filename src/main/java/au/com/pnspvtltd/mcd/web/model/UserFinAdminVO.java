package au.com.pnspvtltd.mcd.web.model;

import java.sql.Date;
import java.util.List;

public class UserFinAdminVO {

	private String modelYear;
	private String modelDisplay;
	private String modelName;
	private String modelTrim;
	private Date creationDate;

	List<SearchFinanceVO> searchVO;

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getModelDisplay() {
		return modelDisplay;
	}

	public void setModelDisplay(String modelDisplay) {
		this.modelDisplay = modelDisplay;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelTrim() {
		return modelTrim;
	}

	public void setModelTrim(String modelTrim) {
		this.modelTrim = modelTrim;
	}

	public List<SearchFinanceVO> getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(List<SearchFinanceVO> searchVO) {
		this.searchVO = searchVO;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
