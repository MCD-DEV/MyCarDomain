package au.com.pnspvtltd.mcd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.pnspvtltd.mcd.repository.ServiceLevelRepository;
import au.com.pnspvtltd.mcd.service.ServiceLevelService;

@Service
public class ServiceLevelServiceImpl implements ServiceLevelService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLevelServiceImpl.class);

	@Autowired
	private ServiceLevelRepository serviceLevelRepository;

	@Override
	public List<String> getAllLevels() {
		// TODO Auto-generated method stub
		List<String> levels = serviceLevelRepository.getAllLevels();
		return levels;
	}

	@Override
	public List<String> existsLevel2ForLevel1(String level1) {
		// TODO Auto-generated method stub
		List<String> level2 = serviceLevelRepository.getAllLevel2(level1);
		return level2;
	}

}
