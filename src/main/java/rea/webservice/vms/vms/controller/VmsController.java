package rea.webservice.vms.vms.controller;

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
import rea.webservice.vms.vms.models.entities.ResponseInsert;
import rea.webservice.vms.vms.models.entities.Vms;
import rea.webservice.vms.vms.services.InsertService;
import rea.webservice.vms.vms.services.VmsService;

@Component
@RestController
@RequestMapping("api/")
public class VmsController {
    @Autowired
    private VmsService vmsService;
    private InsertService insertService;

    @GetMapping("vms")
    public ResponseEntity<Object> getAllDataTOP(@RequestParam(value = "FETCH", defaultValue = "100") Integer fetch, @RequestParam(value = "OFFSET", defaultValue = "0") Integer offset){
        try {
        Iterable<Vms> result = vmsService.getAllDataTOP(fetch, offset);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, fetch);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
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
    public ResponseEntity<Object> save(@RequestBody Insert insert){
        try{
            String categorycode = insert.getCategorycode();
            String categoryid = vmsService.cekCategory(categorycode);
            System.out.println(categoryid);
            if (categoryid == null) {
                return ResponseHandler.generateResponse("CategoryCode Tidak ditemukan", HttpStatus.OK, categoryid, 0);
            } else {
                String businessunitcode = insert.getBusinessunitcode();
                String estateid = vmsService.cekEstate(businessunitcode);
                System.out.println(estateid);
                if (estateid == null){
                    return ResponseHandler.generateResponse("BusinessUnitCode Tidak ditemukan", HttpStatus.OK, estateid, 0);
                } else {
                    String vhcode = insert.getVhcode();
                    String vhbrand = insert.getVhbrand();
                    String vhmodel = insert.getVhmodel();
                    String dateofcommission = insert.getDateofcommission();
                    String chasisno = insert.getChasisno();
                    String engineno = insert.getEngineno();
                    String regno = insert.getRegno();
                    String stnk = insert.getStnk();
                    String user = insert.getCreatedby();
                    String t8 = insert.getT8();
                    String manufactureyear = insert.getManufactureyear();
                    String stnkexpired = insert.getStnkexpired();
                    List<Vms> result = vmsService.insertData(categoryid, estateid, vhcode, vhbrand, vhmodel, dateofcommission, chasisno, engineno, regno, stnk, user, t8, manufactureyear, stnkexpired);
                    return ResponseHandler.generateResponse("Data Berhasil di tambahkan", HttpStatus.OK, result, 1);
                    }
            } 
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0);
        }
    }

    
    @GetMapping("vms/search")
    public ResponseEntity<Object> Search(@RequestParam(value = "categoryid", defaultValue = "") String categoryid, @RequestParam(value = "estateid", defaultValue = "") String estateid,@RequestParam(value = "vhcode", defaultValue = "") String vhcode,@RequestParam(value = "vhbrand", defaultValue = "") String vhbrand,@RequestParam(value = "chasisno", defaultValue = "") String chasisno,@RequestParam(value = "engineno", defaultValue = "") String engineno,@RequestParam(value = "stnk", defaultValue = "") String stnk,@RequestParam(value = "manufactureyear", defaultValue = "") String manufactureyear,@RequestParam(value = "capacity", defaultValue = "") String capacity,@RequestParam(value = "stnkexpired", defaultValue = "") String stnkexpired){
        try{
            if (categoryid.isEmpty() && estateid.isEmpty() && vhcode.isEmpty() && vhbrand.isEmpty() && chasisno.isEmpty() && engineno.isEmpty() && stnk.isEmpty() && manufactureyear.isEmpty() && capacity.isEmpty() && stnkexpired.isEmpty() ) {
            Iterable<Vms> result = vmsService.findAll();
            int jumlah = vmsService.JumlahSearch(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah);
        } else {
            List<Vms> result = vmsService.Search(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
            int jumlah = vmsService.JumlahSearch(categoryid, estateid, vhcode, vhbrand, chasisno, engineno, stnk, manufactureyear, capacity, stnkexpired);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah); 
        }
    } catch (Exception e) {
        return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,0);
    }
}
    
}
