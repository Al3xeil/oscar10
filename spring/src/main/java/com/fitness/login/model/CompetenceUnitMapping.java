package com.fitness.login.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceUnit;
import com.fitness.login.model.user.User;

@Entity
@Table(name = "competence_unit_mapping")
public class CompetenceUnitMapping {

	@Id
	@Column(name = "COUM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "COUM_Name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUM_COUN_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	private CompetenceUnit competenceUnit;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUM_COMP_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Competence competence;

	@Column(name = "COUM_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COUM_HKA_DB = "Hka";

	@Column(name = "COUM_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COUM_TSA_DB = "Tsa";

	@Column(name = "COUM_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COUM_HKN_DB = "Hkn";

	@Column(name = "COUM_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COUM_TSN_DB = "Tsn";

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompetenceUnit getCompetenceUnit() {
		return competenceUnit;
	}

	public void setCompetenceUnit(CompetenceUnit competenceUnit) {
		this.competenceUnit = competenceUnit;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

}
