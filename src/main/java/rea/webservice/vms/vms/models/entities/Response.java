package rea.webservice.vms.vms.models.entities;

public class Response {
    private int code;
    private String message;
    private Vms vms;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Vms getVms() {
        return vms;
    }
    public void setVms(Vms vms) {
        this.vms = vms;
    }
    @Override
    public String toString() {
        return "Response [code=" + code + ", message=" + message + ", vms=" + vms + "]";
    }
    
}
