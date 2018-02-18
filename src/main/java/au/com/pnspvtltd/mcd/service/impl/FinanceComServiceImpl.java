package au.com.pnspvtltd.mcd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.repository.FinanceCompRepository;
import au.com.pnspvtltd.mcd.service.FinanceCompanyService;

@Service
public class FinanceComServiceImpl implements FinanceCompanyService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FinanceComServiceImpl.class);

	@Autowired
	private FinanceCompRepository financeCompRepository;

	@Override
	public List<String> getAllFinance() {
		// TODO Auto-generated method stub
		List<String> levels = financeCompRepository.getAllFinance();
		return levels;
	}

}
