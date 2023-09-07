package rea.webservice.vms.vms.services;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rea.webservice.vms.vms.models.entities.Vms;
import rea.webservice.vms.vms.models.repos.VmsRepo;

@Service
@Transactional
public class VmsService {
    @Autowired
    private VmsRepo vmsRepo;

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

    public int jumlahAllData(){
        return vmsRepo.jumlahAllData();
    }

    public List<Vms> cekData(String vhcode){
        return vmsRepo.cekData(vhcode);
    }

    public int cekDataJumlah(String vhcode){
        return vmsRepo.cekDataJumlah(vhcode);
    }

    public String cekCategory(String categorycode){
        return vmsRepo.cekCategory(categorycode);
    }

    public String cekEstate(String businessunitcode){
        return vmsRepo.cekEstate(businessunitcode);
    }

    public String cekContractor(String contractorcode){
        return vmsRepo.cekContractor(contractorcode);
    }

    public String insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String vhcolor, Date dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, Integer capacity, Integer tare, Date stnkexpired, Integer tanker){
        return vmsRepo.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, vhcolor, dateofcommission, chasisno, engineno, regno, stnk, user, t8, manufactureyear, capacity, tare, stnkexpired, tanker );
    }
}
