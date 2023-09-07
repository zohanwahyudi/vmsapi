package rea.webservice.vms.vms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rea.webservice.vms.vms.models.entities.Contractor;
import rea.webservice.vms.vms.models.repos.ContractorRepo;

@Service
@Transactional
public class ContractorService {
    @Autowired
    private ContractorRepo contractorRepo;

    public Iterable<Contractor> getAllContractor(){
        return contractorRepo.getAllContractor();
    }

    public int jumlahContractor(){
        return contractorRepo.jumlahContractor();
    }

    public Iterable<Contractor> SearchContractor(String code, String name){
        return contractorRepo.SearchContractor(code, name);
    }

    public int jumlahSearchContractor(String code, String name){
        return contractorRepo.jumlahSearchContractor(code, name);
    }

}
