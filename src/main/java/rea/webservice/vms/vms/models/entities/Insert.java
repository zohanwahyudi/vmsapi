package rea.webservice.vms.vms.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiclemaster", catalog ="Vehicle")
public class Insert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* 
    private String categoryid;
    private String estateid;
    private String contractorid;
    private String vhcode;
    private String vhbrand;
    private String vhmodel;
    private int active;
    private String dateofcommission;
    private String chasisno;
    private String engineno;
    private String regno;
    private String stnk;
    private String createdby;
    private String createdon;
    private String t8;
    private String manufactureyear;
    private String stnkexpired; */
    private String categorycode;
    private String categoryname;
    private String businessunitcode;
    private String businessunitname;
    private String vhcode;
    private String vhbrand;
    private String vhmodel;
    private String vhcolor;
    private String dateofcommission;
    private String chasisno;
    private String engineno;
    private String regno;
    private String stnk;
    private String createdby;
    private String t8;
    private String manufactureyear;
    private String stnkexpired;
    private Integer capacity;
    private Integer tare;
    private Integer tanker;
    public String getCategorycode() {
        return categorycode;
    }
    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }
    public String getCategoryname() {
        return categoryname;
    }
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public String getBusinessunitcode() {
        return businessunitcode;
    }
    public void setBusinessunitcode(String businessunitcode) {
        this.businessunitcode = businessunitcode;
    }
    public String getBusinessunitname() {
        return businessunitname;
    }
    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
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
    public String getVhcolor() {
        return vhcolor;
    }
    public void setVhcolor(String vhcolor) {
        this.vhcolor = vhcolor;
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
    public String getCreatedby() {
        return createdby;
    }
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public Integer getTare() {
        return tare;
    }
    public void setTare(Integer tare) {
        this.tare = tare;
    }
    public Integer getTanker() {
        return tanker;
    }
    public void setTanker(Integer tanker) {
        this.tanker = tanker;
    }
    @Override
    public String toString() {
        return "Insert [categorycode=" + categorycode + ", categoryname=" + categoryname + ", businessunitcode="
                + businessunitcode + ", businessunitname=" + businessunitname + ", vhcode=" + vhcode + ", vhbrand="
                + vhbrand + ", vhmodel=" + vhmodel + ", vhcolor=" + vhcolor + ", dateofcommission=" + dateofcommission
                + ", chasisno=" + chasisno + ", engineno=" + engineno + ", regno=" + regno + ", stnk=" + stnk
                + ", createdby=" + createdby + ", t8=" + t8 + ", manufactureyear=" + manufactureyear + ", stnkexpired="
                + stnkexpired + ", capacity=" + capacity + ", tare=" + tare + ", tanker=" + tanker + "]";
    }
    
}
