package com.training.employeeinfo1.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonPropertyOrder({"Id", "Firstname", "Lastname", "Department", "Manager", "DOJ"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("Id")
	private int Id;
	@JsonProperty("Firstname")
	private String Firstname;
	@JsonProperty("Lastname")
	private String Lastname;
	@JsonProperty("Department")
	private String Department;
	@JsonProperty("Manager")
	private String Manager;
	@JsonProperty("DOJ")
	private Date DOJ;
}
