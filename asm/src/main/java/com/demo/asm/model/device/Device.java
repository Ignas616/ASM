package com.demo.asm.model.device;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "device")
@SequenceGenerator(name = "device_seq", sequenceName = "device_seq", allocationSize = 1)
public class Device implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="device_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
		
	@OneToOne
	@JoinColumn(name = "devicetype")
	private DeviceType deviceType;

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

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}	

}
