package com.demo.asm.model.device;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.Shelf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	@JoinColumn(name = "device_type")
	private DeviceType deviceType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "device_shelf_rel", joinColumns = @JoinColumn(name = "device_id"), inverseJoinColumns = @JoinColumn(name = "shelf_id"))
    private List<Shelf> shelfList;

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

    public List<Shelf> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<Shelf> shelfList) {
        this.shelfList = shelfList;
    }
}
