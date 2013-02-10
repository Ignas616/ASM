package com.demo.asm.model.report;

import com.demo.asm.model.location.AddressLocation;
import com.demo.asm.model.location.PhysicalLocation;

public class CardTypeReport {
	
    private PhysicalLocation physicalLocation;

    private AddressLocation addressLocation;

    private Long count;

    public PhysicalLocation getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(PhysicalLocation physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public AddressLocation getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(AddressLocation addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
