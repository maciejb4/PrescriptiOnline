package pl.coderslab.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Role;
import pl.coderslab.demo.repository.RoleRepository;
import pl.coderslab.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{ //implementujemy kontrakt dla serwisu roli
                                                     // główne zalety to łatwiejsza możliwość testowania serwisów
                                                     // późniejsze możliwości rozwoju dzięki przesłanianiu przez interfejs
                                                     // (możemy stworzyć nowy serwis który działa inaczej - np laczy sie z innym kontenerem danych - a dla
                                                     // reszty aplikacji jest to przezroczyste)
                                                     // dodatkowo mamy zapewniona separacje miedzy warstwami aplikacji (clean architecture)

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
