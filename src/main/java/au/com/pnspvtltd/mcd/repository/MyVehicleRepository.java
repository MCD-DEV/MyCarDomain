package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.MyVehicle;

public interface MyVehicleRepository extends JpaRepository<MyVehicle, Long> {
	// MyVehicle findByEmailIgnoreCase(String emailId);

	@Query("SELECT search FROM MyVehicle search WHERE search.idp=?1")
	public List<MyVehicle> getMyVehicleByUserId(Long userid);

}
