package au.com.pnspvtltd.mcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

	@Query("SELECT search FROM UserNotification search WHERE search.idp=?1")
	public List<UserNotification> getUserNotByUserId(Long userid);
}
