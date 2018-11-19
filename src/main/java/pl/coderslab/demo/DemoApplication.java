package pl.coderslab.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.coderslab.demo.domain.Drug;
import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.Role;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.service.DrugService;
import pl.coderslab.demo.service.PrescriptionService;
import pl.coderslab.demo.service.RoleService;
import pl.coderslab.demo.service.UserService;


import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService, RoleService roleService, PrescriptionService prescriptionService, DrugService drugService) { //funkcja ktora uruchamia sie podczas startu aplikacji (za kazdym razem)
        return (args) -> {

            if (roleService.findByName("ROLE_ADMIN") == null) { //patrzymy czy mamy role admin i jesli nie to ja tworzymy
                Role r = new Role();
                r.setName("ROLE_ADMIN");
                roleService.save(r);
            }
            if (roleService.findByName("ROLE_USER") == null) { //analogicznie do roli wyzej
                Role r = new Role();
                r.setName("ROLE_USER");
                roleService.save(r);
            }
            if (roleService.findByName("ROLE_DOCTOR") == null) { //patrzymy czy mamy role doktor i jesli nie to ja tworzymy
                Role r = new Role();
                r.setName("ROLE_DOCTOR");
                roleService.save(r);
            }
            if (roleService.findByName("ROLE_PATIENT") == null) { //patrzymy czy mamy role pacjent i jesli nie to ja tworzymy
                Role r = new Role();
                r.setName("ROLE_PATIENT");
                roleService.save(r);
            }

            if (roleService.findByName("ROLE_PHARMACIST") == null) { //patrzymy czy mamy role farmaceuta i jesli nie to ja tworzymy
                Role r = new Role();
                r.setName("ROLE_PHARMACIST");
                roleService.save(r);
            }

            if (userService.findByUsername("pharmacist") == null) { //tworze farmaceutę

                User user = new User();
                user.setFirstName("Farmaceuta");
                user.setUsername("farmaceuta1");
                user.setPassword("farmaceuta1");
                userService.savePharmacist(user);
            }
            if (userService.findByUsername("admin") == null) { //tworze admina

                User user = new User();
                user.setFirstName("Super user");
                user.setUsername("admin");
                user.setPassword("admin");
                userService.saveAdmin(user);
            }
            if (userService.findByUsername("doctor") == null) { //tworze doktora

                User user = new User();
                user.setFirstName("Doktor 1");
                user.setUsername("doktor1");
                user.setPassword("doktor1");
                userService.saveDoctor(user);
            }

            if (userService.findByUsername("Chomyszka") == null) { //tworze pacjenta

                User user = new User();
                user.setFirstName("Keanu");
                user.setLastName("Reeves");
                user.setUsername("Neo");
                user.setPassword("pacjent1");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                user.setDateOfBirth(formatter.parse("1998-02-03"));
                user.setPesel("92112904879");
                userService.savePatient(user);
            }

            if (userService.findByUsername("JanKowal") == null) { //tworze pacjenta

                User user = new User();
                user.setFirstName("Jan");
                user.setLastName("Kowalski");
                user.setUsername("JanKowal");
                user.setPassword("pacjent1");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                user.setDateOfBirth(formatter.parse("1992-04-03"));
                user.setPesel("92141201132");
                userService.savePatient(user);
            }

            if (userService.findByUsername("Jamesdean") == null) { //tworze pacjenta

                User user = new User();
                user.setFirstName("James");
                user.setLastName("Dean");
                user.setUsername("Jamesdean");
                user.setPassword("pacjent1");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                user.setDateOfBirth(formatter.parse("1980-02-03"));
                user.setPesel("19382501131");
                userService.savePatient(user);
            }

            if (prescriptionService.findPrescriptionById(1L) == null) {
                Prescription prescription = new Prescription();
                prescription.setDrugName("Laksygen");
                prescription.setDrugQuantity(200);
                prescription.setDrugDose("2 razy dziennie 1 tabletka");
                User janbart = userService.findByUsername("JanKowal");
                prescription.setUser(janbart);
                prescriptionService.save(prescription);
            }

            if (prescriptionService.findPrescriptionById(2L) == null) {
                Prescription prescription = new Prescription();
                prescription.setDrugName("Stoperan");
                prescription.setDrugQuantity(400);
                prescription.setDrugDose("3 razy dziennie 1 tabletka");
                User janbart = userService.findByUsername("JanKowal");
                prescription.setUser(janbart);
                prescriptionService.save(prescription);
            }

            Drug drug1 = new Drug();
            Drug drug2 = new Drug();
            Drug drug3 = new Drug();
            Drug drug4 = new Drug();
            Drug drug5 = new Drug();
            Drug drug6 = new Drug();
            Drug drug7 = new Drug();
            Drug drug8 = new Drug();
            Drug drug9 = new Drug();
            Drug drug10 = new Drug();
            drug1.setDrug_name("Apap");
            drug2.setDrug_name("Ibuprom");
            drug3.setDrug_name("Paracetamol");
            drug4.setDrug_name("Acatar");
            drug5.setDrug_name("Griposin");
            drug6.setDrug_name("Panadol");
            drug7.setDrug_name("Aviomarin");
            drug8.setDrug_name("Polopiryna");
            drug9.setDrug_name("IBum");
            drug10.setDrug_name("Cholinex");
            drugService.save(drug1);
            drugService.save(drug2);
            drugService.save(drug3);
            drugService.save(drug4);
            drugService.save(drug5);
            drugService.save(drug6);
            drugService.save(drug7);
            drugService.save(drug8);
            drugService.save(drug9);
            drugService.save(drug10);


        };
    }
}

//    @Bean
//    CommandLineRunner init(UserService userService, PrescriptionService prescriptionService) { //funkcja ktora uruchamia sie podczas startu aplikacji (za kazdym razem)
//        return (args) -> {
//
//            if(prescriptionService.findPrescriptionById(1L)==null) {
//                Prescription prescription = new Prescription();
//                prescription.setDrugName("narkotyk1");
//                prescription.setDrugQuantity(200);
//                prescription.setDrugDose("2 razy dziennie 1 tabletka");
//                User janbart = userService.findByUsername("Janbart");
//                prescription.setUser(janbart);
//            }
//        };
//        }
//

