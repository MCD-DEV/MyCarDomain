package au.com.pnspvtltd.mcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.MyVehicleLogBook;

public interface MyVehicleLogBookRepository extends JpaRepository<MyVehicleLogBook, Long> {
	// MyVehicle findByEmailIgnoreCase(String emailId);
}
