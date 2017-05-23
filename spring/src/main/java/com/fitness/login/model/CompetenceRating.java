package com.fitness.login.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.user.User;

@Entity
@Table(name = "competence_rating")
public class CompetenceRating {

	@Id
	@Column(name = "CORA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CORA_Name")
	private String name;

	@Column(name = "CORA_Description")
	private String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CORA_USER_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CORA_COMP_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Competence competence;
	
	@Column(name = "CORA_Value")
	private Integer valueRating;
	
	@Column(name = "CORA_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String CORA_HKA_DB = "Hka";

	@Column(name = "CORA_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String CORA_TSA_DB = "Tsa";

	@Column(name = "CORA_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String CORA_HKN_DB = "Hkn";

	@Column(name = "CORA_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String CORA_TSN_DB = "Tsn";

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Integer getValueRating() {
		return valueRating;
	}

	public void setValueRating(Integer valueRating) {
		this.valueRating = valueRating;
	}

}
