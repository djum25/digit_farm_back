package com.projet.ferme.entity.utils;

import java.sql.Date;

public class NewDate {
    
    public Date getDate() {
		java.util.Date date = new java.util.Date();
		Date sqlStartDate = new Date(date.getTime());
		return sqlStartDate;
	}
}
