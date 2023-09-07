package rea.webservice.vms.vms.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiclemaster", catalog ="Vehicle")
public class Vms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // private String vehicleid; // tidak ada
    // private String categoryid; // categoryCode
    // private String estateid; // tidak ada
    // private String contractorid; // tidak ada
    private String categoryname;
    private String categorycode;
    private String estatename;
    private String estatecode;
    private String contractorcode;
    private String contractorname;
    private String vhcode; // vehicleCode
    private String vhbrand; // brand
    private String vhmodel; // model
    private String vhcolor; // tidak ada
    private String active; // tidak ada
    private String dateofcommission; // sesuai
    private String chasisno; // ChasisNumber
    private String engineno; // EngineNumber
    private String regno; // registrationNumber
    private String stnk; // stnkNumber
    private String remarks; // tidak ada
    private String createdby; // sesuai
    private String createdon; //createdDate
    private String modifiedby; // tidak ada
    private String modifiedon; // tidak ada
    private String t8; // sesuai
    private String inactivedate; // tidak ada
    private String manufactureyear; // sesuai
    private Integer capacity; // tidak ada
    private Integer tare; // tidak ada
    private String stnkexpired; //stnkExpiredDate
    private Integer tanker; // tidak ada
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryname() {
        return categoryname;
    }
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public String getCategorycode() {
        return categorycode;
    }
    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }
    public String getEstatename() {
        return estatename;
    }
    public void setEstatename(String estatename) {
        this.estatename = estatename;
    }
    public String getEstatecode() {
        return estatecode;
    }
    public void setEstatecode(String estatecode) {
        this.estatecode = estatecode;
    }
    public String getContractorcode() {
        return contractorcode;
    }
    public void setContractorcode(String contractorcode) {
        this.contractorcode = contractorcode;
    }
    public String getContractorname() {
        return contractorname;
    }
    public void setContractorname(String contractorname) {
        this.contractorname = contractorname;
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
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
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
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getCreatedby() {
        return createdby;
    }
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
    public String getCreatedon() {
        return createdon;
    }
    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }
    public String getModifiedby() {
        return modifiedby;
    }
    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }
    public String getModifiedon() {
        return modifiedon;
    }
    public void setModifiedon(String modifiedon) {
        this.modifiedon = modifiedon;
    }
    public String getT8() {
        return t8;
    }
    public void setT8(String t8) {
        this.t8 = t8;
    }
    public String getInactivedate() {
        return inactivedate;
    }
    public void setInactivedate(String inactivedate) {
        this.inactivedate = inactivedate;
    }
    public String getManufactureyear() {
        return manufactureyear;
    }
    public void setManufactureyear(String manufactureyear) {
        this.manufactureyear = manufactureyear;
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
    public String getStnkexpired() {
        return stnkexpired;
    }
    public void setStnkexpired(String stnkexpired) {
        this.stnkexpired = stnkexpired;
    }
    public Integer getTanker() {
        return tanker;
    }
    public void setTanker(Integer tanker) {
        this.tanker = tanker;
    }
    @Override
    public String toString() {
        return "Vms [id=" + id + ", categoryname=" + categoryname + ", categorycode=" + categorycode + ", estatename="
                + estatename + ", estatecode=" + estatecode + ", contractorcode=" + contractorcode + ", contractorname="
                + contractorname + ", vhcode=" + vhcode + ", vhbrand=" + vhbrand + ", vhmodel=" + vhmodel + ", vhcolor="
                + vhcolor + ", active=" + active + ", dateofcommission=" + dateofcommission + ", chasisno=" + chasisno
                + ", engineno=" + engineno + ", regno=" + regno + ", stnk=" + stnk + ", remarks=" + remarks
                + ", createdby=" + createdby + ", createdon=" + createdon + ", modifiedby=" + modifiedby
                + ", modifiedon=" + modifiedon + ", t8=" + t8 + ", inactivedate=" + inactivedate + ", manufactureyear="
                + manufactureyear + ", capacity=" + capacity + ", tare=" + tare + ", stnkexpired=" + stnkexpired
                + ", tanker=" + tanker + "]";
    }
    
    
}
