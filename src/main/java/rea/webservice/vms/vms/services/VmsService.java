package rea.webservice.vms.vms.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rea.webservice.vms.vms.models.entities.Insert;
import rea.webservice.vms.vms.models.entities.ResponseInsert;
import rea.webservice.vms.vms.models.entities.Vms;
import rea.webservice.vms.vms.models.repos.VmsRepo;

@Service
@Transactional
public class VmsService {
    @Autowired
    private VmsRepo vmsRepo;
    /*
    public Vms save(Vms vms){
        return vmsRepo.save(vms);
    }  */

    


    public Iterable<Vms> findAll(){
        return vmsRepo.findAll();
    }
    public int jumlahFindAll(){
        return vmsRepo.jumlahFindAll();
    }
    public int JumlahSearch(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired){
        return vmsRepo.JumlahSearch(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
    }

    public List<Vms> Search(String categoryid, String estateid, String vhcode, String vhbrand, String chasisno, String engineno, String stnk, String manufactureyear, String capacity, String stnkexpired) {
        return vmsRepo.Search(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
    }

    public Iterable<Vms> getAllDataTOP(Integer fetch, Integer offset){
        return vmsRepo.getAllDataTOP(fetch, offset);
    }

    public List<Vms> cekData(String vhcode, String chasisno, String engineno){
        return vmsRepo.cekData(vhcode, chasisno, engineno);
    }

    public String cekCategory(String categorycode){
        return vmsRepo.cekCategory(categorycode);
    }

    public String cekEstate(String businessunitcode){
        return vmsRepo.cekEstate(businessunitcode);
    }

    public List<Vms> insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, String stnkexpired){
        return vmsRepo.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, dateofcommission, chasisno, engineno, regno, stnk, user, t8, manufactureyear, stnkexpired);
    }
}
