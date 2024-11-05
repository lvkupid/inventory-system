package com.mycompany.inventorysystem.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int suId;
    
    private String suName;
    private String suPhone;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
    
    public int getSuId() {
        return suId;
    }

    public void setSuId(int suId) {
        this.suId = suId;
    }

    public String getSuName() {
        return suName;
    }

    public void setSuName(String suName) {
        this.suName = suName;
    }

    public String getSuPhone() {
        return suPhone;
    }

    public void setSuPhone(String suPhone) {
        this.suPhone = suPhone;
    }

    public Supplier() {
    }

    public Supplier(int suId, String suName, String suPhone) {
        this.suId = suId;
        this.suName = suName;
        this.suPhone = suPhone;
    }

    @Override
    public String toString() {
        return suId + " - " + suName;
    }
    
}
