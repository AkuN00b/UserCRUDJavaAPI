package id.ac.astra.polytechnic.userapi_nim10027.repository;

import id.ac.astra.polytechnic.userapi_nim10027.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("UserJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
    User getUserById(int id);

    List<User> findAllByOrderByIdAsc();
}
