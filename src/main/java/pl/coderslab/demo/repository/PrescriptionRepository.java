package pl.coderslab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.demo.domain.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription findByUserPesel(String pesel);

    Prescription findById(long id);
}
