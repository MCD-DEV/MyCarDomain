package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import au.com.pnspvtltd.mcd.domain.CarModelTemplate;
import au.com.pnspvtltd.mcd.domain.CountyRegPostSub;

public interface CountyRegPostSubRepository extends JpaRepository<CountyRegPostSub, Long> {
	



	String JDBC_MAX_ROWS = "10";

	@Query("select distinct countyRegPostSub.country from CountyRegPostSub countyRegPostSub order by countyRegPostSub.country Asc")
	public List<String> getAllCountries();

	@Query("select distinct countyRegPostSub.state from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.country=?1")
	public List<String> getAllStatesForCountry(String country);

	@Query("select distinct countyRegPostSub.region from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.country=?1 AND countyRegPostSub.state=?2")
	public List<String> getAllRegionsForCountynState(String country,String state);

	@Query("select countyRegPostSub.postCode from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.country=?1 AND countyRegPostSub.state=?2 AND countyRegPostSub.region=?3")
	public List<Integer> getPostCodeForCSR(String country,String state,String region);

	
	@Query(value= "select countyRegPostSub.postCode from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.postCode like ?1",nativeQuery = true)
	//@QueryHints(@QueryHint(name = JDBC_MAX_ROWS, value = "1"))
	public List<Integer> getPostCodeForLike(String substr);
	
	@Query("select CASE WHEN COUNT(countyRegPostSub) > 0 THEN true ELSE false END from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.state=?1 AND countyRegPostSub.postCode=?2")
	public boolean existsPostcodeForState(String state,int postcode);
	
	@Query("select CASE WHEN COUNT(countyRegPostSub) > 0 THEN true ELSE false END from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.region=?1 AND countyRegPostSub.postCode=?2")
	public boolean existsPostcodeForRegion(String region,int postcode);
	
	@Query("select distinct countyRegPostSub.region from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.postCode=?1")
	public List<String> getRegionForGivenPostCode(int postCode);
	
	
	@Query("select distinct countyRegPostSub.region from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.country=?1 AND countyRegPostSub.state in ?2")
	public List<String> getRegionForCountryStates(String country,List<String> states);
	
	
	@Query("select distinct countyRegPostSub.postCode from CountyRegPostSub countyRegPostSub WHERE countyRegPostSub.country=?1 AND countyRegPostSub.state in ?2 AND countyRegPostSub.region in ?3")
	public List<Integer> getPostcodesForCountryStatesRegions(String country,List<String> states,List<String> regions);
	
	//public List<CountyRegPostSub> findByPostCode	
	
	//public CarModelTemplate getCarModelYear();
}
