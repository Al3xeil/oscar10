package com.fitness.login.model.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {
	
	public final static Integer ROLE_ADMIN_ID = 1;
	public final static Integer ROLE_STANDART = 2;
	public final static Integer ROLE_PUBLIC = 3;
	
	@Id
	@Column(name = "ROLE_ID")
    private int id;
	
	@Column(name = "ROLE_Name")
    private String name;
	
	@JsonIgnore
    private Set<User> users;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
