package au.com.pnspvtltd.mcd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.CarModelTemplate;
import au.com.pnspvtltd.mcd.domain.LoyalityProgAdmin;
import au.com.pnspvtltd.mcd.repository.CarModelTemplateRepository;
import au.com.pnspvtltd.mcd.repository.CountyRegPostSubRepository;
import au.com.pnspvtltd.mcd.service.CarModelTemplateService;
import au.com.pnspvtltd.mcd.service.CountyRegPostSubService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.CarModelTemplateVO;

@Service
public class CountyRegPostSubServiceImpl implements CountyRegPostSubService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountyRegPostSubServiceImpl.class);

	@Autowired
	private CountyRegPostSubRepository countyRegPostSubRepository;

	
	@Override
	public List<String> getAllCountries() {
		// TODO Auto-generated method stub
		List<String> countries = countyRegPostSubRepository.getAllCountries();
		return countries;
	}

	@Override
	public List<String> getAllStatesForCountry(String country) {
		// TODO Auto-generated method stub
		List<String> states = countyRegPostSubRepository.getAllStatesForCountry(country);
		return states;
	}

	@Override
	public List<String> getAllRegionsForCountynState(String country,String state) {
		// TODO Auto-generated method stub
		List<String> regions = countyRegPostSubRepository.getAllRegionsForCountynState(country,state);
		return regions;
	}

	@Override
	public List<Integer> getPostCodeForCSR(String country,String state,String region) {
		// TODO Auto-generated method stub
		List<Integer> postcodes = countyRegPostSubRepository.getPostCodeForCSR(country,state,region);
		return postcodes;
	}

	@Override
	public List<Integer> getPostCodeForLike(String substr) {
		// TODO Auto-generated method stub
		List<Integer> postcodes = countyRegPostSubRepository.getPostCodeForLike(substr.concat("%"));
		return postcodes;
	}

	@Override
	public boolean existsPostcodeForState(String state, int postcode) {
		// TODO Auto-generated method stub
		return countyRegPostSubRepository.existsPostcodeForState(state, postcode);
	}

	@Override
	public boolean existsPostcodeForRegion(String region, int postcode) {
		// TODO Auto-generated method stub
		return countyRegPostSubRepository.existsPostcodeForRegion(region, postcode);
	}

	@Override
	public List<String> getRegionForGivenPostCode(int postCode) {
		// TODO Auto-generated method stub
		return countyRegPostSubRepository.getRegionForGivenPostCode(postCode);
	}

	@Override
	public List<String> getRegionForCountryStates(String country, List<String> states) {
		// TODO Auto-generated method stub
		return countyRegPostSubRepository.getRegionForCountryStates(country, states);
	}

	@Override
	public List<Integer> getPostcodesForCountryStatesRegions(String country, List<String> states, List<String> regions) {
		// TODO Auto-generated method stub
		//return countyRegPostSubRepository.getPostcodesForCountryStatesRegions(country, states, regions);
		
		List<Integer> postcodes = countyRegPostSubRepository.getPostcodesForCountryStatesRegions(country, states, regions);
		return postcodes;
		/*List<Object> objects= countyRegPostSubRepository.getPostcodesForCountryStatesRegions(country, states, regions);
		List<String> strings = new ArrayList<String>();
		for (Object object : objects) {
			String convertedToString = object.toString(); 
			strings.add(convertedToString);
		}*/
		//return strings;
		
	}

}
