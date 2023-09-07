package rea.webservice.vms.vms.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandlerGet {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, Integer jumlah, String code) {
        Map<String, Object> detail = new HashMap<String, Object>();
            detail.put("total_data", jumlah);
            detail.put("vehicle_data", responseObj); 

        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("jumlah", jumlah);
            map.put("data", detail);
            map.put("code", code);

            return new ResponseEntity<Object>(map,status);
    }
}
