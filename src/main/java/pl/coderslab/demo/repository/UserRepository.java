package pl.coderslab.demo.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.demo.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> { //repozytorium dla User (punkt styku z frameworkiem)
    User findByUsername(String name);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name=:rolename")
    List<User> findUserByRoleName(@Param("rolename") String roleName);

    User findUserById(Long id);

    User findUserByPesel(String pesel);
}
