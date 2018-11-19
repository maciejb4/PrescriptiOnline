package pl.coderslab.demo.service;

import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {

    Prescription save(Prescription p);

    Prescription findPrescriptionById(Long id);

    Prescription findByUserPesel(String pesel);
    List<Prescription> findAll();
}
