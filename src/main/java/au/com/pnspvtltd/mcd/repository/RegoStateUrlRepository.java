package au.com.pnspvtltd.mcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.RegoStateUrl;

public interface RegoStateUrlRepository extends JpaRepository<RegoStateUrl, Long> {

	@Query("SELECT regoStateUrl FROM RegoStateUrl regoStateUrl WHERE regoStateUrl.vehState=?1 AND regoStateUrl.flex1=?2")
	public RegoStateUrl getRegoStateUrlFor(String vehState, String vehType);

}
