package com.libertymutual.goforcode.wimp.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Actor {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=75)
	
	
	private String firstName;
	private String lastName;
	private Long activeSinceYear;
	private Date birthDate;
}
