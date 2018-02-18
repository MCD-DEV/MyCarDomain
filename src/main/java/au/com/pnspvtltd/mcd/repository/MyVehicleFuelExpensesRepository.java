package au.com.pnspvtltd.mcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.MyVehicleFuelExpenses;

public interface MyVehicleFuelExpensesRepository extends JpaRepository<MyVehicleFuelExpenses, Long> {
	// MyVehicle findByEmailIgnoreCase(String emailId);
}
