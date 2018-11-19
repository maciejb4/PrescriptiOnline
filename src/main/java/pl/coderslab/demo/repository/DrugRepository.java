package pl.coderslab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.demo.domain.Drug;

public interface DrugRepository extends JpaRepository<Drug,Long> {
    Drug findDrugById(Long id);
}
