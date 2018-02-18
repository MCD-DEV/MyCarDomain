package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.AdminAuto;

public interface AdminRepository extends JpaRepository<AdminAuto, Long> {

	List<AdminAuto> findByUserNameIgnoreCase(String USERNAME);

	List<AdminAuto> findByUserName(String USERNAME);
}
