package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.InsuranceCompany;

public interface InsuranceCompRepository extends JpaRepository<InsuranceCompany, Long> {

	String JDBC_MAX_ROWS = "10";

	@Query("select distinct insuranceCompany1.insuranceCompany from InsuranceCompany insuranceCompany1 order by insuranceCompany1.insuranceCompany Asc")
	public List<String> getAllInsurance();

}
