package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pnspvtltd.mcd.domain.CurrentOffers;

public interface CurrentOffersRepository extends JpaRepository<CurrentOffers, Long> {

	List<CurrentOffers> findAll();

}
