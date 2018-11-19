package pl.coderslab.demo.service.impl;

import com.sun.deploy.association.RegisterFailedException;
import lombok.Builder;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.Role;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.repository.RoleRepository;
import pl.coderslab.demo.repository.UserRepository;
import pl.coderslab.demo.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //implementujemy kontrakt dla serwisu usera
    // główne zalety to łatwiejsza możliwość testowania serwisów
    // późniejsze możliwości rozwoju dzięki przesłanianiu przez interfejs
    // (możemy stworzyć nowy serwis który działa inaczej - np laczy sie z innym kontenerem danych - a dla
    // reszty aplikacji jest to przezroczyste)
    // dodatkowo mamy zapewniona separacje miedzy warstwami aplikacji (clean architecture)


    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User save(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(u);
    }

    @Override
    public User saveAdmin(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,adminRole)));
        return userRepository.save(u);
    }

    @Override
    public User saveDoctor(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,doctorRole)));
        return userRepository.save(u);
    }

    @Override
    public User savePatient(User u) {
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role patientRole = roleRepository.findByName("ROLE_PATIENT");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,patientRole)));
        return userRepository.save(u);
    }

    @Override
    public User savePharmacist(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role pharmacistRole = roleRepository.findByName("ROLE_PHARMACIST");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,pharmacistRole)));
        return userRepository.save(u);
    }

    @Override
    public void delete(Long id) {
        User userById = userRepository.findUserById(id);
        if (userById!= null){
            userRepository.delete(userById);
        }
    }

    @Override
    public User update(User u) {
     return userRepository.save(u);
    }

    @Override
    public User findUserById(Long id) {
        User userByID = userRepository.findUserById(id);
        return userByID;
    }

    @Override
    public User findUserByPesel(String pesel) {
        User userByPesel = userRepository.findUserByPesel(pesel);
        return userByPesel;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User registerUser(RegisterDto dto) throws RegisterFailedException {
        if(!dto.getPassword().equals(dto.getConfirm_password()) || dto.getPassword()==null || dto.getPassword().isEmpty()
                || dto.getConfirm_password()==null || dto.getConfirm_password().isEmpty()){
            throw new RegisterFailedException("Password incorrect");
        }
        Role userRole = roleRepository.findByName("ROLE_USER");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

        User user = null;
        try {
            user = new User(dto.getFirstName(),dto.getLastName(),dto.getUsername(),passwordEncoder.encode(dto.getPassword()),1,dto.getPesel(),formatter.parse(dto.getDateOfBirth()),dto.getAddress(),new HashSet<Role>(Arrays.asList(userRole)),new HashSet<Prescription>(dto.getPrescriptions()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> findByRole(String roles) {
        return userRepository.findUserByRoleName(roles);
    }


}
