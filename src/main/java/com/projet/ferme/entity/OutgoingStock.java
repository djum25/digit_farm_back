package com.projet.ferme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_outgoing_stock")
public class OutgoingStock extends Stock{
	
	private String produit;
	
	private int valeur;
	
	@Column(name = "subject_id")
	private String subjectId;

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getProduit() {
		return produit;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

}
