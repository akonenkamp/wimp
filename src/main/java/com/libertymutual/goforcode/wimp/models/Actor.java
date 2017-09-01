package com.libertymutual.goforcode.wimp.models;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonIdentityInfo(

generator = ObjectIdGenerators.PropertyGenerator.class,
property="id")

@Entity 
public class Actor {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=75)
	private String firstName;
	@Column(length=75)
	private String lastName;
	private Long activeSinceYear;
	private Date birthDate;
	public long getId() {
		return id;
	}
	
//	@JsonIgnore
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getActiveSinceYear() {
		return activeSinceYear;
	}
	public void setActiveSinceYear(Long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Actor() {}
	


    public Actor(String firstName, String lastName, long activeSinceYear) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.activeSinceYear = activeSinceYear;

    }
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
