package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_matricule")
public class Matricule extends TimeModel{
	
	private String article;

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
}
