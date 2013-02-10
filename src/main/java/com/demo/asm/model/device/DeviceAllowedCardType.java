package com.demo.asm.model.device;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device_allowed_shelf_types")
@SequenceGenerator(name = "device_allowed_shelf_types_seq", sequenceName = "device_allowed_shelf_types_seq", allocationSize = 1)
public class DeviceAllowedCardType implements Serializable{

	private static final long serialVersionUID = -623454356566899973L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="device_allowed_shelf_types_seq")
	@Column(name = "id")
	private int id;

    @Column(name = "shelf_type")
    private int shelfTypeId;

    @Column(name = "device_type")
    private int deviceTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShelfTypeId() {
        return shelfTypeId;
    }

    public void setShelfTypeId(int shelfTypeId) {
        this.shelfTypeId = shelfTypeId;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }
}
