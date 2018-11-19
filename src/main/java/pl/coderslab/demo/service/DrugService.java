package pl.coderslab.demo.service;

import pl.coderslab.demo.domain.Drug;

import java.util.List;

public interface DrugService {

    Drug save(Drug p);
    List<Drug> findAll();


    Drug findDrugById(Long id);
}
