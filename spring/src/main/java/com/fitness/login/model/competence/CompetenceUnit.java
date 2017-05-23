package com.fitness.login.model.competence;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "competence_unit")
public class CompetenceUnit {

	@Id
	@Column(name = "COUN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "COUN_Name")
	private String name;

	@Column(name = "COUN_Description")
	private String description;

	@Column(name = "COUN_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COUN_HKA_DB = "Hka";

	@Column(name = "COUN_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COUN_TSA_DB = "Tsa";

	@Column(name = "COUN_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COUN_HKN_DB = "Hkn";

	@Column(name = "COUN_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COUN_TSN_DB = "Tsn";

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
}
