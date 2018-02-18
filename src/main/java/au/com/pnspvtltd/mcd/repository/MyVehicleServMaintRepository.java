package au.com.pnspvtltd.mcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.MyVehicleServMaint;

public interface MyVehicleServMaintRepository extends JpaRepository<MyVehicleServMaint, Long> {
	// MyVehicle findByEmailIgnoreCase(String emailId);
}
