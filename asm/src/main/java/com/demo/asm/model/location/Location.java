package com.demo.asm.model.location;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Location {

	@Column(name = "name")
	private String name;
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
