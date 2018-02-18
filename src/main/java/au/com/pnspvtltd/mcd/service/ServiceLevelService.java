package au.com.pnspvtltd.mcd.service;

import java.util.List;

public interface ServiceLevelService {

	List<String> getAllLevels();

	List<String> existsLevel2ForLevel1(String level2);

}
