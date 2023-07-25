package rea.webservice.vms.vms.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ResponseInsert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryid;
    private String estateid;
    private String vhcode;
    private String vhbrand;
    private String vhmodel;
    private String dateofcommission;
    private String chasisno;
    private String engineno;
    private String regno;
    private String stnk;
    private String user;
    private String t8;
    private String manufactureyear;
    private String stnkexpired;
    public String getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
    public String getEstateid() {
        return estateid;
    }
    public void setEstateid(String estateid) {
        this.estateid = estateid;
    }
    public String getVhcode() {
        return vhcode;
    }
    public void setVhcode(String vhcode) {
        this.vhcode = vhcode;
    }
    public String getVhbrand() {
        return vhbrand;
    }
    public void setVhbrand(String vhbrand) {
        this.vhbrand = vhbrand;
    }
    public String getVhmodel() {
        return vhmodel;
    }
    public void setVhmodel(String vhmodel) {
        this.vhmodel = vhmodel;
    }
    public String getDateofcommission() {
        return dateofcommission;
    }
    public void setDateofcommission(String dateofcommission) {
        this.dateofcommission = dateofcommission;
    }
    public String getChasisno() {
        return chasisno;
    }
    public void setChasisno(String chasisno) {
        this.chasisno = chasisno;
    }
    public String getEngineno() {
        return engineno;
    }
    public void setEngineno(String engineno) {
        this.engineno = engineno;
    }
    public String getRegno() {
        return regno;
    }
    public void setRegno(String regno) {
        this.regno = regno;
    }
    public String getStnk() {
        return stnk;
    }
    public void setStnk(String stnk) {
        this.stnk = stnk;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getT8() {
        return t8;
    }
    public void setT8(String t8) {
        this.t8 = t8;
    }
    public String getManufactureyear() {
        return manufactureyear;
    }
    public void setManufactureyear(String manufactureyear) {
        this.manufactureyear = manufactureyear;
    }
    public String getStnkexpired() {
        return stnkexpired;
    }
    public void setStnkexpired(String stnkexpired) {
        this.stnkexpired = stnkexpired;
    }
    @Override
    public String toString() {
        return "ResponseInsert [categoryid=" + categoryid + ", estateid=" + estateid + ", vhcode=" + vhcode
                + ", vhbrand=" + vhbrand + ", vhmodel=" + vhmodel + ", dateofcommission=" + dateofcommission
                + ", chasisno=" + chasisno + ", engineno=" + engineno + ", regno=" + regno + ", stnk=" + stnk
                + ", user=" + user + ", t8=" + t8 + ", manufactureyear=" + manufactureyear + ", stnkexpired="
                + stnkexpired + "]";
    }
    
}
