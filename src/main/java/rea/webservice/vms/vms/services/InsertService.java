package rea.webservice.vms.vms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rea.webservice.vms.vms.models.entities.Insert;
import rea.webservice.vms.vms.models.repos.InsertRepo;

@Service
@Transactional
public class InsertService {
    @Autowired
    private InsertRepo insertRepo;
    
    public Insert save(Insert insert){
        return insertRepo.save(insert);
    }
}
