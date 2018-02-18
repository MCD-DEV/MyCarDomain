package au.com.pnspvtltd.mcd.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.SearchServMaint;

public interface SearchServMtLeadRepository extends JpaRepository<SearchServMaint, Long> {

	@Query("SELECT search FROM SearchServMaint search" + " ORDER BY search.searchServMaintId")
	public List<SearchServMaint> getAllSearchCriteria();

	/*
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelYear=?1" +
	 * " ORDER BY search.searchServMaintId") public List<Search>
	 * getSearchYear(String year);
	 * 
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelDisplay=?1"
	 * + " ORDER BY search.searchServMaintId") public List<Search>
	 * getSearchModel(String modelDisplay);
	 * 
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelName=?1" +
	 * " ORDER BY search.searchServMaintId") public List<Search>
	 * getSearchDisp(String modelName);
	 * 
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelTrim=?1" +
	 * " ORDER BY search.searchServMaintId") public List<Search>
	 * getSearchTrim(String modelTrim);
	 */

	@Query("SELECT search FROM SearchServMaint search WHERE search.creationDate=?1"
			+ " ORDER BY search.searchServMaintId")
	public List<SearchServMaint> getSearchCreationDate(Date creationDate);

	/*
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelYear=?1 AND search.modelDisplay=?2 AND search.creationDate=?3"
	 * + " ORDER BY search.carSearchId") public List<Search>
	 * getSearchAYearDis(String modelYear, String modelDisplay, Date
	 * creationDate);
	 * 
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelYear=?1 AND search.modelDisplay=?2 AND search.modelName=?3"
	 * + " ORDER BY search.carSearchId") public List<Search>
	 * getSearchAllOtDate1(String modelYear, String modelDisplay, String
	 * modelName);
	 */

	/*
	 * @Query(
	 * "SELECT search FROM SearchServMaint search WHERE search.modelYear=?1 AND search.modelDisplay=?2 AND search.modelName=?3 AND search.modelTrim=?4"
	 * + " ORDER BY search.carSearchId") public List<Search>
	 * getSearchAllOtDate(String modelYear, String modelDisplay, String
	 * modelName, String modelTrim);
	 * 
	 * @Query(
	 * "SELECT search FROM Search search WHERE search.modelYear=?1 AND search.modelDisplay=?2 AND search.modelName=?3 AND search.modelTrim=?4 AND search.creationDate=?5"
	 * + " ORDER BY search.carSearchId") public List<Search>
	 * getSearchAllCriteria(String modelYear, String modelDisplay, String
	 * modelName, String modelTrim, Date creationDate);
	 */
}
