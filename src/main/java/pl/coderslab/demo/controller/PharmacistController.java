package pl.coderslab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.PrescriptionDto;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.service.PrescriptionService;
import pl.coderslab.demo.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    private UserService userService;

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping(value = "/findPatientsByPesel",method = RequestMethod.GET)
    public String findPatientsByPesel(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "findPatientsByPesel";
    }

    @RequestMapping(value = "/findPatientsByPesel", method = RequestMethod.POST)
    public String showPatientsByPesel(@ModelAttribute RegisterDto registerDto, Model model) {
        User user = userService.findUserByPesel(registerDto.getPesel());
        model.addAttribute("user",user);
        return "patientDetails2";
    }

    @RequestMapping(value = "/prescriptionDetails/{id}", method = RequestMethod.GET)
    public String prescriptionDetails(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.findPrescriptionById(id);
        model.addAttribute("prescription",prescription);
        return "prescriptionDetails2";
    }

    @RequestMapping(value = "/prescriptionDetails/{id}", method = RequestMethod.POST)
    public String prescriptionUpdate(@ModelAttribute PrescriptionDto prescriptionDto,@PathVariable Long id) {
        Prescription prescription = prescriptionService.findPrescriptionById(id);
        prescription.setFilledIn(prescriptionDto.isFilledIn());
        prescriptionService.save(prescription);
        return "redirect:/pharmacist/prescriptionDetails/{id}";
    }

}
