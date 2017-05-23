package com.fitness.login.model.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fitness.login.model.CompetenceRating;

@Entity
@Table(name = "User")
@org.springframework.cache.annotation.Cacheable("user")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "USER_Name")
	private String username;

	@Column(name = "USER_Firstname")
	private String firstName;

	@Column(name = "USER_Lastname")
	private String lastName;

	@Column(name = "USER_Adresse")
	private String adresse;

	@Column(name = "USER_Phone")
	private String phone;

	@Column(name = "USER_Birthday")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	@Column(name = "USER_Weight")
	private Integer weight;

	@Column(name = "USER_Password")
	private String password;

	@Column(name = "USER_Password_Confirm")
	private String passwordconFirm;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CORA_USER_ID", updatable = false, insertable = false)
	@Fetch(FetchMode.SELECT)
	private Set<CompetenceRating> competenceRating = new HashSet<>();

	@Column(name = "USER_HKA", insertable = false, updatable = false)
	private String Hka;
	public static final String USER_HKA_DB = "Hka";

	@Column(name = "USER_TSA", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsa;
	public static final String USER_TSA_DB = "Tsa";

	@Column(name = "USER_HKN", insertable = false, updatable = false)
	private String Hkn;
	public static final String USER_HKN_DB = "Hkn";

	@Column(name = "USER_TSN", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Tsn;
	public static final String USER_TSN_DB = "Tsn";

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordconFirm() {
		return passwordconFirm;
	}

	public void setPasswordconFirm(String passwordconFirm) {
		this.passwordconFirm = passwordconFirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new HashSet<>();
		}
		roles.add(role);
	}

	public Set<CompetenceRating> getCompetenceRating() {
		return competenceRating;
	}

	public void setCompetenceRating(Set<CompetenceRating> competenceRating) {
		this.competenceRating = competenceRating;
	}

	public Boolean isAdmin() {
		for (Role role : getRoles()) {
			if (Role.ROLE_ADMIN_ID.equals(role.getId())) {
				return true;
			}
		}
		return false;
	}

}
