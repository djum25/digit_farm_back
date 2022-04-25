package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_secondary_compte")
public class SecondaryCompte extends TimeModel{
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "primary_id")
    private PrimaryCompte primary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryCompte getPrimary() {
        return primary;
    }

    public void setPrimary(PrimaryCompte primary) {
        this.primary = primary;
    }

}
