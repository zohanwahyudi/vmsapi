package rea.webservice.vms.vms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rea.webservice.vms.vms.models.entities.ResponseInsert;
import rea.webservice.vms.vms.models.entities.Vms;
import rea.webservice.vms.vms.models.repos.InsertRepo;

@Service
@Transactional
public class InsertService {
    private InsertRepo insertRepo;
public List<ResponseInsert> insertData(String categoryid, String estateid, String vhcode, String vhbrand, String vhmodel, String vhcolor, String dateofcommission, String chasisno, String engineno, String regno, String stnk, String user, String t8, String manufactureyear, int capacity, int tare, String stnkexpired, int tanker){
        return insertRepo.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, vhcolor, dateofcommission, chasisno, engineno, regno, stnk, user, t8, manufactureyear, capacity, tare, stnkexpired, tanker );
    }

    public String cekCategory(String categorycode){
        return insertRepo.cekCategory(categorycode);
    }

    public String cekEstate(String businessunitcode){
        return insertRepo.cekEstate(businessunitcode);
    }

        public List<Vms> cekData(String chasisno, String engineno, String vhcode, String regno){
        return insertRepo.cekData(chasisno, engineno, vhcode, regno);
    }

    public int cekDataJumlah(String chasisno, String engineno, String vhcode, String regno){
        return insertRepo.cekDataJumlah(chasisno, engineno, vhcode, regno);
    }

}
