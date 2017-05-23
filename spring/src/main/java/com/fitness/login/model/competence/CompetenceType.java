package com.fitness.login.model.competence;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="competence_type")
public class CompetenceType {
	
	@Id
	@Column(name="COTY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COTY_Name")
	private String name;
	
	@Column(name="COTY_Description")
	private String description;
	
	// Competence Category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COTY_COCA_ID")
	private CompetenceCategory category;

	
	@Column(name = "COTY_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COTY_HKA_DB = "Hka";

	@Column(name = "COTY_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COTY_TSA_DB = "Tsa";

	@Column(name = "COTY_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COTY_HKN_DB = "Hkn";

	@Column(name = "COTY_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COTY_TSN_DB = "Tsn";
	
	public Integer getId(){
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
	
	public CompetenceCategory getCategory() {
		return category;
	}

	public void setCategory(CompetenceCategory category) {
		this.category = category;
	}
}
