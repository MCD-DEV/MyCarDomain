package au.com.pnspvtltd.mcd.service;

import java.util.List;

import au.com.pnspvtltd.mcd.web.model.UserOnlyVO;
import au.com.pnspvtltd.mcd.web.model.UserVO;

public interface UserService {

	UserVO findById(Long id);

	UserVO createUser(UserVO user);

	UserVO updateUser(UserVO user);

	List<UserVO> findAllUsers();

	UserVO findUserByEmail(String email);

	UserOnlyVO findByUserOnlyId(Long id);
}
