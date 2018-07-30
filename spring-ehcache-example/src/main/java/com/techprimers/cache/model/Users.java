package com.techprimers.cache.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Users implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String teamName;
    private Integer salary;

    public Users() {

    }

    public Users(String name, String teamName, Integer salary) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", salary=" + salary +
                '}';
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

    
}
