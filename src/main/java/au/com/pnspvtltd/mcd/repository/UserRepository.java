package au.com.pnspvtltd.mcd.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.pnspvtltd.mcd.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailIgnoreCase(String emailId);

	@Query("SELECT user FROM User user" + " ORDER BY user.userId")
	public List<User> getAllUser();

	@Query("SELECT user FROM User user WHERE user.email=?1" + " ORDER BY user.userId")
	public List<User> getUserEmail(String email);

	@Query("SELECT user FROM User user WHERE user.firstName=?1" + " ORDER BY user.userId")
	public List<User> getUserFirstName(String firstName);

	@Query("SELECT user FROM User user WHERE user.lastName=?1" + " ORDER BY user.userId")
	public List<User> getUserLastName(String lastName);

	@Query("SELECT user FROM User user WHERE user.creationDate=?1" + " ORDER BY user.userId")
	public List<User> getUserCreationDate(Date creationDate);

	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.lastName=?2" + " ORDER BY user.userId")
	public List<User> getUserEmaLas(String email, String lastName);

	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.firstName=?2" + " ORDER BY user.userId")
	public List<User> getUserEmaFir(String email, String firstName);

	// email, firstName, LastName
	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.firstName=?2 AND user.lastName=?3"
			+ " ORDER BY user.userId")
	public List<User> getUserEmaFirLas(String email, String firstName, String lastName);

	// email, creationDate
	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.creationDate=?2" + " ORDER BY user.userId")
	public List<User> getUserEmaCr(String email, Date creationDate);

	// email, firstName, creationDate
	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.firstName=?2 AND user.creationDate=?3"
			+ " ORDER BY user.userId")
	public List<User> getUserEmaFirsCr(String email, String firstName, Date creationDate);

	// email, lastName, creationDate
	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.lastName=?2 AND user.creationDate=?3"
			+ " ORDER BY user.userId")
	public List<User> getUserEmaLasCr(String email, String lastName, Date creationDate);

	@Query("SELECT user FROM User user WHERE user.email=?1 AND user.firstName=?2 AND user.lastName=?3 AND user.creationDate=?4"
			+ " ORDER BY user.userId")
	public List<User> getUserAllCriteria(String email, String firstName, String lastName, Date creationDate);
}
