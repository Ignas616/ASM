package com.demo.asm.model.device;

import com.demo.asm.model.location.AddressLocation;
import com.demo.asm.model.location.PhysicalLocation;
import com.demo.asm.model.shelf.Shelf;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "address_location_id")
    private AddressLocation addessLocation;
		
	@OneToOne
	@JoinColumn(name = "physical_location_id")
	private PhysicalLocation physicalLocation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
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

    public AddressLocation getAddessLocation() {
        return addessLocation;
    }

    public void setAddessLocation(AddressLocation addessLocation) {
        this.addessLocation = addessLocation;
    }

    public PhysicalLocation getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(PhysicalLocation physicalLocation) {
        this.physicalLocation = physicalLocation;
    }


}
