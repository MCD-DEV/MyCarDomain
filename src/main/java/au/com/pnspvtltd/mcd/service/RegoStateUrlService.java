package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.web.model.RegoStateUrlVO;

public interface RegoStateUrlService {
	RegoStateUrlVO getRegoStateUrlFor(String vehState, String vehType);
}
