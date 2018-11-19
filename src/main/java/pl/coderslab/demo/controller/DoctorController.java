package pl.coderslab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.Drug;
import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.PrescriptionDto;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.service.DrugService;
import pl.coderslab.demo.service.PrescriptionService;
import pl.coderslab.demo.service.UserService;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private UserService userService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/listPatients",method = RequestMethod.GET)
    public String ListPatients(Model model) {
        List<User> patients = userService.findByRole("ROLE_PATIENT");
        model.addAttribute("patients",patients);
        return "listPatients";
    }

    @RequestMapping(value = "/deletePatient{id}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable Long id) {
        userService.delete(id);

        return "redirect:listPatients";
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    public String addPatientForm(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "addPatient";
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute RegisterDto registerDto) {
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUsername(registerDto.getUsername());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            user.setDateOfBirth(formatter.parse(registerDto.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPesel(registerDto.getPesel());
        userService.savePatient(user);
        return "redirect:listPatients";
    }

    @RequestMapping(value="/updatePatient/{id}",method = RequestMethod.GET)
    public String update(Model model,@PathVariable Long id) {
        User user = userService.findUserById(id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            String dateOfBirthString = user.getDateOfBirthString();
            user.setDateOfBirth(formatter.parse(dateOfBirthString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("user",user);
        return "updatePatient";
    }

    @RequestMapping(value = "/updatePatient/{id}", method = RequestMethod.POST)
    public String updated(@PathVariable Long id,@ModelAttribute RegisterDto registerDto) {
        User user = userService.findUserById(id);
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUsername(registerDto.getUsername());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            user.setDateOfBirth(formatter.parse(registerDto.getDateOfBirthString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPesel(registerDto.getPesel());
        userService.update(user);
        return "redirect:../listPatients";

    }

    @RequestMapping(value = "/patientDetails/{id}",method = RequestMethod.GET)
    public String patientDetails(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "patientDetails";
    }

    @RequestMapping(value = "/prescriptionDetails/{id}", method = RequestMethod.GET)
    public String prescriptionDetails(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.findPrescriptionById(id);
        model.addAttribute("prescription",prescription);
        return "prescriptionDetails";
    }

    @RequestMapping(value = "/prescriptionAdd/{id}",method = RequestMethod.GET)
    public String prescriptionAdd(@PathVariable Long id, Model model) {
        Prescription prescription = new Prescription();
        model.addAttribute("prescription",prescription);
        model.addAttribute("id",id);
        return "prescriptionAdd";

    }

    @RequestMapping(value = "/prescriptionAdd/{id}",method = RequestMethod.POST)
    public String prescriptionAdded(@PathVariable Long id, @ModelAttribute PrescriptionDto prescriptionDto) {
        Prescription prescription = new Prescription();
        Drug drugById = drugService.findDrugById(Long.valueOf(prescriptionDto.getDrugs()));
        prescription.setDrugName(drugById.getDrug_name());
        prescription.setDrugQuantity(prescriptionDto.getDrugQuantity());
        prescription.setDrugDose(prescriptionDto.getDrugDose());
        prescription.setUser(userService.findUserById(id));
        prescriptionService.save(prescription);
        return "redirect:../patientDetails/{id}";
    }

    @ModelAttribute("drugs")
    public List<Drug> getDrugs() {

        List<Drug> all = drugService.findAll();
        return all;
    }

    }



