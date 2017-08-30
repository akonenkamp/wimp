package com.libertymutual.goforcode.wimp.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length = 300, nullable = false)
	private String title;
	private Date releaseDate;
	private Long budget;
	@Column(length=500, nullable = false)
	private String distributor;
	public long getId() {
		return id;
	}
	
	@ManyToMany 
	private List<Actor> actors;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	public Movie() {}
	
    public Movie(String title, long budget, String distributor, List<Actor> actors) {

        this.title = title;

        this.budget = budget;

        this.distributor = distributor;

        this.actors = actors;

    }
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
