package com.projet.ferme.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_operation")
public class Operation extends TimeModel{
    
    private String label;

    private String comment;

    private int amount;

    private LocalDateTime date;

    private Character subjectType;

    private Long subjectId;

    private Object object;

    @ManyToOne
    @JoinColumn(name = "secondary_id")
    private SecondaryCompte secondary;

    public Character getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Character subjectType) {
        this.subjectType = subjectType;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

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
