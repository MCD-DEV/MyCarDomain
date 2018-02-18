package au.com.pnspvtltd.mcd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import au.com.pnspvtltd.mcd.domain.AdminAuto;
import au.com.pnspvtltd.mcd.repository.AdminRepository;
import au.com.pnspvtltd.mcd.service.AdminService;
import au.com.pnspvtltd.mcd.util.DomainModelUtil;
import au.com.pnspvtltd.mcd.web.model.AdminAutoVO;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DomainModelUtil domainModelUtil;

	@Override
	@Transactional(readOnly = true)
	public AdminAutoVO findUserName(String userName) {
		// TODO Auto-generated method stub
		List<AdminAuto> admins = adminRepository.findByUserName(userName);
		if (admins == null || admins.isEmpty()) {
			return null;
		}
		return domainModelUtil.fromAdmin(admins.get(0));
	}

}
