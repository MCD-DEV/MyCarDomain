package au.com.pnspvtltd.mcd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.domain.RegoStateUrl;
import au.com.pnspvtltd.mcd.repository.RegoStateUrlRepository;
import au.com.pnspvtltd.mcd.service.RegoStateUrlService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.RegoStateUrlVO;

@Service
public class RegoStateUrlServiceImpl implements RegoStateUrlService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(RegoStateUrlServiceImpl.class);

	@Autowired
	private RegoStateUrlRepository regoStateUrlRepository;

	@Autowired
	private DomainModelUtil domainModelUtil;

	@Override
	public RegoStateUrlVO getRegoStateUrlFor(String modelYear, String modelDisplay) {

		RegoStateUrlVO regoStateUrlVO = new RegoStateUrlVO();

		RegoStateUrl regoStateUrl = regoStateUrlRepository.getRegoStateUrlFor(modelYear, modelDisplay);
		regoStateUrlVO = domainModelUtil.fromRegoStateUrl(regoStateUrl, true);

		return regoStateUrlVO;
	}
}
