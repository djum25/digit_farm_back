package com.projet.ferme.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_primary_compte")
public class PrimaryCompte extends TimeModel{

    private String name;

    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primary")
    private Set<SecondaryCompte> secondaryies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
