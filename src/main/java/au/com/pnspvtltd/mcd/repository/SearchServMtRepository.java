package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.SearchServMaint;

public interface SearchServMtRepository extends JpaRepository<SearchServMaint, Long> {

	@Query("SELECT search FROM SearchServMaint search WHERE search.idp=?1")
	public List<SearchServMaint> getServMtByUserId(Long userid);

}
