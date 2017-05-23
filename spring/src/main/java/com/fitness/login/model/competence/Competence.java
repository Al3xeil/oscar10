package com.fitness.login.model.competence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fitness.login.model.CompetenceRating;
import com.fitness.login.model.CompetenceUnitMapping;

@Entity
@Table(name = "Competence")
public class Competence {

	@Id
	@Column(name = "COMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "COMP_Name")
	private String name;

	@Column(name = "COMP_Description")
	private String description;

	// Competence Type
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMP_COTY_ID")
	private CompetenceType type;

	// Status
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMP_COST_ID")
	private CompetenceStatus status;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUM_COMP_ID", updatable = false, insertable = false)
	@Fetch(FetchMode.SELECT)
	private Set<CompetenceUnitMapping> competenceUnitMapping = new HashSet<>();

	@Column(name = "COMP_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COMP_HKA_DB = "Hka";

	@Column(name = "COMP_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COMP_TSA_DB = "Tsa";

	@Column(name = "COMP_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COMP_HKN_DB = "Hkn";

	@Column(name = "COMP_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COMP_TSN_DB = "Tsn";

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
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

	public Set<CompetenceUnitMapping> getCompetenceUnitMapping() {
		return competenceUnitMapping;
	}

	public void setCompetenceUnitMapping(Set<CompetenceUnitMapping> competenceUnitMapping) {
		this.competenceUnitMapping = competenceUnitMapping;
	}

	public Set<CompetenceUnit> getCompetenceUnits() {
		Set<CompetenceUnit> competenceUnits = new HashSet<>();
		if (getCompetenceUnitMapping() == null) {
			return null;
		}
		for (CompetenceUnitMapping mapping : getCompetenceUnitMapping()) {
			if (mapping.getCompetenceUnit() != null) {
				competenceUnits.add(mapping.getCompetenceUnit());
			}
		}
		return competenceUnits;
	}

	public CompetenceType getType() {
		return type;
	}

	public void setType(CompetenceType type) {
		this.type = type;
	}

	public CompetenceStatus getStatus() {
		return status;
	}

	public void setStatus(CompetenceStatus status) {
		this.status = status;
	}

}
