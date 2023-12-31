package rea.webservice.vms.vms.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, Integer jumlah, String code) {
       /* Map<String, Object> detail = new HashMap<String, Object>();
         
        detail.put("vehicle_data", responseObj);
        detail.put("total_data", jumlah);     
        */
         
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("data", responseObj);
            map.put("total_data", jumlah);
            map.put("status", status.value());
            map.put("code", code);
        
            return new ResponseEntity<Object>(map,status);
    }
    
}
