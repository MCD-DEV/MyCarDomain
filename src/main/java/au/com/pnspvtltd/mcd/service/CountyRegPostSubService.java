package au.com.pnspvtltd.mcd.service;

import java.util.List;

public interface CountyRegPostSubService {

	List<String> getAllCountries();

	List<String> getAllStatesForCountry(String modelYear);

	List<String> getAllRegionsForCountynState(String modelDisplay, String modelYear);

	List<Integer> getPostCodeForCSR(String modelName, String modelDisplay, String modelYear);

	List<Integer> getPostCodeForLike(String substr);

	boolean existsPostcodeForState(String state, int postcode);

	boolean existsPostcodeForRegion(String region, int postcode);

	List<String> getRegionForGivenPostCode(int postCode);

	List<String> getRegionForCountryStates(String country, List<String> states);

	List<Integer> getPostcodesForCountryStatesRegions(String country, List<String> states, List<String> regions);
}
