package rea.webservice.vms.vms.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rea.webservice.vms.vms.helpers.ResponseHandler;
import rea.webservice.vms.vms.models.entities.Insert;
import rea.webservice.vms.vms.models.entities.Vms;
import rea.webservice.vms.vms.services.VmsService;

@Component
@RestController
@RequestMapping("api/")
public class VmsController {
    @Autowired
    private VmsService vmsService;

    @GetMapping("vms")
    public ResponseEntity<Object> getAllDataTOP(@RequestParam(value = "FETCH", defaultValue = "100") Integer fetch, @RequestParam(value = "PAGE", defaultValue = "1") Integer page){
        try {
            Integer offset = 0;
            if(page == 0 || page == 1){
                offset = 0;
            } else {
                offset = ((page - 1) * fetch);
            }
        Iterable<Vms> result = vmsService.getAllDataTOP(fetch, offset);
        int jumlah = vmsService.jumlahAllData();
        if( jumlah <= fetch ) {
          return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS");  
        } else {
           return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, fetch, "SUCCESS");   
        }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0, "ERROR");
        }
    
    /* 
    @GetMapping("vms")
    public ResponseEntity<Object> getAllDataTOP(@RequestParam(value = "jumlah", defaultValue = "100") Integer jumlah){
        try {
        Iterable<Vms> result = vmsService.getAllDataTOP(jumlah);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
        }
    
    public ResponseEntity<Object> findAll(){
        try {
        Iterable<Vms> result = vmsService.findAll();
        int jumlah = vmsService.jumlahFindAll();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
        } */
    }  

    /* 
    @PostMapping("vms")
    public ResponseEntity<Object> save(@RequestBody Vms vms){
        try{
            Vms result = vmsService.save(vms);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, 1);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
        }
    } 
    
    @Async
    @PostMapping("vms")
    public void insertData(@RequestParam(value = "CategoryCode") String categorycode, @RequestParam(value = "CategoryName") String categoryname, @RequestParam(value = "BusinessUnitCode") String businessunitcode, @RequestParam(value = "BusinessUnitName") String businessunitname, @RequestParam(value = "VehicleCode") String vhcode, @RequestParam(value = "DateOfCommision") String dateofcommision, @RequestParam(value = "ManufactureYear") String manufactureyear, @RequestParam(value = "Brand") String vhbrand, @RequestParam(value = "Model") String vhmodel, @RequestParam(value = "ChasisNumber") String chasisno, @RequestParam(value = "EngineNumber") String engineno, @RequestParam(value = "RegistrationNumber") String regno, @RequestParam(value = "STNKNumber") String stnk, @RequestParam(value = "STNKExpiredDate") String stnkexpiredDate, @RequestParam(value = "T8") String t8, @RequestParam(value = "CreatedBy") String user ){
        try {
        String categoryid = vmsService.cekCategory(categorycode);
        System.out.println(categoryid);
        if (categoryid.isEmpty()) {
            
        } else {
            String estateid = vmsService.cekEstate(businessunitcode);
            System.out.println(estateid);
            if (estateid.isEmpty()){
                 
            } else {
                List<Insert> hasil = vmsService.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, dateofcommision, chasisno, engineno, regno, stnk, user, t8, manufactureyear, stnkexpiredDate);
                System.out.println(hasil);
                return;
                 
            }
        }
        } catch (Exception e) {
            
        }
    }
*/
    

    @Async
    @PostMapping("vms")
    public ResponseEntity<Object> insertData(@RequestBody Insert insert){
        try{
            String categorycode = insert.getCategorycode();
            String categoryname = insert.getCategoryname();
            String businessunitcode = insert.getBusinessunitcode();
            String businessunitname = insert.getBusinessunitname();
            String vhcode = insert.getVhcode();
            String vhbrand = insert.getVhbrand();
            String vhmodel = insert.getVhmodel();
            String vhcolor = insert.getVhcolor();
            Date dateofcommission = insert.getDateofcommission();
            String regno = insert.getRegno();
            String stnk = insert.getStnk();
            String user = insert.getCreatedby();
            String t8 = insert.getT8();
            String manufactureyear = insert.getManufactureyear();
            Date stnkexpired = insert.getStnkexpired();
            String chasisno = insert.getChasisno();
            String engineno = insert.getEngineno();
            Integer capacity = insert.getCapacity();
            Integer tare = insert.getTare();
            Integer tanker = insert.getTanker();
            if(categorycode.isEmpty() || categorycode == null) {
               return ResponseHandler.generateResponse("categorycode harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID"); 
            } else if(categoryname.isEmpty() || categorycode == null) {
               return ResponseHandler.generateResponse("categoryname harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID"); 
            } else if(businessunitcode.isEmpty() || businessunitcode == null) {
               return ResponseHandler.generateResponse("businessunitcode harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID"); 
            } else if(businessunitname.isEmpty() || businessunitname == null) {
               return ResponseHandler.generateResponse("businessunitname harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID"); 
            } else if (vhcode.isEmpty() || vhcode == null) {
                return ResponseHandler.generateResponse("VHcode harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID");
            } else if (user.isEmpty() || user == null) {
                return ResponseHandler.generateResponse("User harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID");
            } else if (t8.isEmpty() || t8 == null) {
                return ResponseHandler.generateResponse("T8 harus di isi", HttpStatus.OK, null, 0, "INPUT_INVALID");
            } else if (capacity == 0) {
                return ResponseHandler.generateResponse("Capacity tidak boleh di isi 0", HttpStatus.OK, null, 0, "INPUT_INVALID");
            } else {
                List<Vms> resultData = vmsService.cekData(vhcode); 
                System.out.println(resultData);;
                int jumlah = vmsService.cekDataJumlah(vhcode);
                System.out.println(jumlah);
                if (jumlah != 0) {
                    return ResponseHandler.generateResponse("Kendaraan Telah di Daftarkan Sebelumnya", HttpStatus.OK, resultData, jumlah, "VIHICLE_REGISTERED");
                } else {
                    
                    System.out.println(categorycode);
                    String categoryid = vmsService.cekCategory(categorycode);
                    System.out.println(categoryid);
                    if (categoryid == null) {
                        return ResponseHandler.generateResponse("CategoryCode Tidak ditemukan", HttpStatus.OK, categoryid, 0, "CAT_NOTFOUND");
                    } else {
                        
                        String estateid = vmsService.cekEstate(businessunitcode);
                        System.out.println(estateid);
                        if (estateid == null){
                            return ResponseHandler.generateResponse("BusinessUnitCode Tidak ditemukan", HttpStatus.OK, estateid, 0, "BU_NOTFOUND");
                        } else {
                            String result = vmsService.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, vhcolor, dateofcommission, chasisno, engineno, regno, stnk, user, t8, manufactureyear, capacity, tare, stnkexpired, tanker);
                            return ResponseHandler.generateResponse("Data Berhasil di tambahkan", HttpStatus.OK, result, 1, "SUCCESS");
                        } 
                    }
                } 
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0, "ERROR");
        }
    }

    @Async
    @GetMapping("vms/search")
    public ResponseEntity<Object> Search(@RequestParam(value = "categorycode", defaultValue = "") String categorycode, @RequestParam(value = "businessunitcode", defaultValue = "") String businessunitcode,  @RequestParam(value = "vhcode", defaultValue = "") String vhcode,@RequestParam(value = "vhbrand", defaultValue = "") String vhbrand,@RequestParam(value = "chasisno", defaultValue = "") String chasisno,@RequestParam(value = "engineno", defaultValue = "") String engineno,@RequestParam(value = "stnk", defaultValue = "") String stnk,@RequestParam(value = "manufactureyear", defaultValue = "") String manufactureyear,@RequestParam(value = "capacity", defaultValue = "") String capacity,@RequestParam(value = "stnkexpired", defaultValue = "") String stnkexpired){
        try{
            if (categorycode.isEmpty() && businessunitcode.isEmpty() && vhcode.isEmpty() && vhbrand.isEmpty() && chasisno.isEmpty() && engineno.isEmpty() && stnk.isEmpty() && manufactureyear.isEmpty() && capacity.isEmpty() && stnkexpired.isEmpty() ) {
            Iterable<Vms> result = vmsService.findAll();
            int jumlah = vmsService.jumlahFindAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS");
        } else {
            String categoryid = vmsService.cekCategory(categorycode);
            System.out.println(categoryid);
            if (categoryid == null) {
                categoryid = "";
            } 
            String estateid = vmsService.cekEstate(businessunitcode);
            if (estateid == null) {
                estateid = "";
            } 
            System.out.println(estateid);
            // String contractorid = vmsService.cekEstate(contractorcode);  
            List<Vms> result = vmsService.Search(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
            int jumlah = vmsService.JumlahSearch(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
            System.out.println(jumlah);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS"); 
        }
    } catch (Exception e) {
        return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,0, "ERROR");
    }
}
    
}
