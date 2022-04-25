package com.projet.ferme.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_operation")
public class Operation<Subject> extends TimeModel{
    
    private String label;

    private String comment;

    private int amount;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "secondary_id")
    private SecondaryCompte secondary;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public SecondaryCompte getSecondary() {
        return secondary;
    }

    public void setSecondary(SecondaryCompte secondary) {
        this.secondary = secondary;
    }

    
}
