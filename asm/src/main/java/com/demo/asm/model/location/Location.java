package com.demo.asm.model.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@SequenceGenerator(name = "locations_seq", sequenceName = "locations_seq", allocationSize = 1)
public class Location implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="locations_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
		
	
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

	

}
