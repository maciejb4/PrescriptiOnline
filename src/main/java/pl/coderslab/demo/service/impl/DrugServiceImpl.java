package pl.coderslab.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Drug;
import pl.coderslab.demo.repository.DrugRepository;
import pl.coderslab.demo.service.DrugService;

import java.util.List;
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;


    @Override
    public Drug save(Drug p) {
        return drugRepository.save(p);
    }

    @Override
    public List<Drug> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public Drug findDrugById(Long id) {
        return drugRepository.findDrugById(id);
    }

}
