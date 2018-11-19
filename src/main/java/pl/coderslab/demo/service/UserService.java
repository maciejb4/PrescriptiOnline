package pl.coderslab.demo.service;

import com.sun.deploy.association.RegisterFailedException;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User u);
    User saveAdmin(User u);
    User saveDoctor(User u);
    User savePatient(User u);
    User savePharmacist(User u);
    void delete(Long id);

    User update(User u);

    User findUserById(Long id);

    User findUserByPesel(String pesel);

    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto) throws RegisterFailedException;
    List<User> findByRole(String role);
}
