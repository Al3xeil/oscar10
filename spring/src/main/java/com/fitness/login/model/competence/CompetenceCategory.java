package com.fitness.login.model.competence;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="competence_category")
public class CompetenceCategory {
	
	@Id
	@Column(name="COCA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COCA_Name")
	private String name;
	
	@Column(name="COCA_Description")
	private String description;
	
	@Column(name = "COCA_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COCA_HKA_DB = "Hka";

	@Column(name = "COCA_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COCA_TSA_DB = "Tsa";

	@Column(name = "COCA_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COCA_HKN_DB = "Hkn";

	@Column(name = "COCA_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COCA_TSN_DB = "Tsn";
	
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
	
}
