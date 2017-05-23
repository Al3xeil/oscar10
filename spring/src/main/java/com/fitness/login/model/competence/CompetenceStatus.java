package com.fitness.login.model.competence;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="competence_status")
public class CompetenceStatus {
	
	public final static Integer STATUS_APPROVED_ID = 1;
	public final static Integer STATUS_SUGGESTED_ID = 2;
	
	@Id
	@Column(name="COST_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COST_Name")
	private String name;
	
	@Column(name="COST_Description")
	private String description;
	
	@Column(name = "COST_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String COST_HKA_DB = "Hka";

	@Column(name = "COST_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String COST_TSA_DB = "Tsa";

	@Column(name = "COST_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String COST_HKN_DB = "Hkn";

	@Column(name = "COST_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String COST_TSN_DB = "Tsn";
	
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
