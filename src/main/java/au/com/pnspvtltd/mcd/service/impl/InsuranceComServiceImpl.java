package au.com.pnspvtltd.mcd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.repository.InsuranceCompRepository;
import au.com.pnspvtltd.mcd.service.InsuranceCompanyService;

@Service
public class InsuranceComServiceImpl implements InsuranceCompanyService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceComServiceImpl.class);

	@Autowired
	private InsuranceCompRepository insuranceCompRepository;

	@Override
	public List<String> getAllInsurnce() {
		// TODO Auto-generated method stub
		List<String> levels = insuranceCompRepository.getAllInsurance();
		return levels;
	}

}
