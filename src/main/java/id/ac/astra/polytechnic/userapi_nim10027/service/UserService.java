package id.ac.astra.polytechnic.userapi_nim10027.service;

import id.ac.astra.polytechnic.userapi_nim10027.repository.UserJpaRepository;
import id.ac.astra.polytechnic.userapi_nim10027.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {
    @Qualifier("UserJpaRepository")
    @Autowired
    UserJpaRepository mUserJpaRepository;

    public User getUser(int id) {
        User user = mUserJpaRepository.getUserById(id);
        return user;
    }

    public List<User> getUsers() {
        List<User> userList = mUserJpaRepository.findAllByOrderByIdAsc();
        return userList;
    }

    public boolean saveUser(User user) {
        User result = mUserJpaRepository.save(user);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean updateUser(User user) {
        User result = mUserJpaRepository.getUserById(user.getId());

        if (result == null) {
            return false;
        }

        if (StringUtils.hasLength(user.getUsername())) {
            result.setUsername(user.getUsername());
        }

        mUserJpaRepository.save(result);
        return true;
    }

    public boolean deleteUser(int id) {
        User result = mUserJpaRepository.getUserById(id);

        if (result == null) {
            return false;
        }

        mUserJpaRepository.delete(result);
        return true;
    }
}
