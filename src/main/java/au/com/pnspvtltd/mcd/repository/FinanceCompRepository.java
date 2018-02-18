package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.FinanceCompany;

public interface FinanceCompRepository extends JpaRepository<FinanceCompany, Long> {

	String JDBC_MAX_ROWS = "10";

	@Query("select distinct financeCompany1.financeCompany from FinanceCompany financeCompany1 order by financeCompany1.financeCompany Asc")
	public List<String> getAllFinance();

}
