package rea.webservice.vms.vms.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contractor", catalog = "General")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String contractortypemasterid;
    private String description;
    private String address;
    private String phone;
    private String handphone;
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContractortypemasterid() {
        return contractortypemasterid;
    }
    public void setContractortypemasterid(String contractortypemasterid) {
        this.contractortypemasterid = contractortypemasterid;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getHandphone() {
        return handphone;
    }
    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Contractor [id=" + id + ", code=" + code + ", name=" + name + ", contractortypemasterid="
                + contractortypemasterid + ", description=" + description + ", address=" + address + ", phone=" + phone
                + ", handphone=" + handphone + ", email=" + email + "]";
    }
    
}
