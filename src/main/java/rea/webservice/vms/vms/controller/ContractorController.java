package rea.webservice.vms.vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rea.webservice.vms.vms.helpers.ResponseHandler;
import rea.webservice.vms.vms.models.entities.Contractor;
import rea.webservice.vms.vms.services.ContractorService;

@Component
@RestController
@RequestMapping("api/contractor")
public class ContractorController {
    @Autowired
    private ContractorService contractorService;
    
    @GetMapping
    public ResponseEntity<Object> getAllContractor(){
        try {
        Iterable<Contractor> result = contractorService.getAllContractor();
        int jumlah = contractorService.jumlahContractor();
          return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS");    
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, 0, "ERROR");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Object> SearchContractor(@RequestParam(value = "code", defaultValue = "") String code, @RequestParam(value = "name", defaultValue = "") String name){
        try{
            if(code.isEmpty() && name.isEmpty()){
                Iterable<Contractor> result = contractorService.getAllContractor();
                int jumlah = contractorService.jumlahContractor();
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS");    
            } else {
                Iterable<Contractor> result = contractorService.SearchContractor(code, name);
                int jumlah = contractorService.jumlahSearchContractor(code, name);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result, jumlah, "SUCCESS"); 
            }
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,0, "ERROR");
        }
    }
}
