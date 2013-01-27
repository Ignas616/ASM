package com.demo.asm.model.device;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "devicetype")
@SequenceGenerator(name = "deviceType_seq", sequenceName = "deviceType_seq", allocationSize = 1)
public class DeviceType implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="deviceType_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "noofshelves")
	private int noOfShelves;	

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

	public int getNoOfShelves() {
		return noOfShelves;
	}

	public void setNoOfShelves(int noOfShelves) {
		this.noOfShelves = noOfShelves;
	}		

}
