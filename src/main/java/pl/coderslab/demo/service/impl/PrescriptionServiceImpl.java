package pl.coderslab.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Prescription;
import pl.coderslab.demo.domain.dto.PrescriptionDto;
import pl.coderslab.demo.repository.PrescriptionRepository;
import pl.coderslab.demo.service.PrescriptionService;

import java.util.List;
import java.util.Optional;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;


//    @Override
//    public Prescription save(PrescriptionDto p) {
//        Prescription prescription = new Prescription();
//        prescription.setDrugName(p.getDrugName());
//        prescription.setDrugDose(p.getDrugDose());
//        prescription.setDrugQuantity(p.getDrugQuantity());
//        return prescriptionRepository.save(prescription);
//    }

    @Override
    public Prescription save(Prescription p) {
        return prescriptionRepository.save(p);
    }

    @Override
    public Prescription findPrescriptionById(Long id) {
         return prescriptionRepository.findById(id.longValue());
    }

    @Override
    public Prescription findByUserPesel(String pesel) {
        return null;
    }

    @Override
    public List<Prescription> findAll() {
        return null;
    }
}
