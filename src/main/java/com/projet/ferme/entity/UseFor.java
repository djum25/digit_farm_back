package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_use_for")
public class UseFor extends TimeModel{
    
    @OneToOne(optional = false)
    @JoinColumn(name="operation_id", unique=true, nullable=false, updatable=false)
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "planting_id", nullable = true)
    private Planting planting;

    @ManyToOne
    @JoinColumn(name = "bowl_id", nullable = true)
    private Bowl bowl;

    @ManyToOne
    @JoinColumn(name = "enclosure_id", nullable = true)
    private Enclosure enclosure;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Planting getPlanting() {
        return planting;
    }

    public void setPlanting(Planting planting) {
        this.planting = planting;
    }

    public Bowl getBowl() {
        return bowl;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
}
