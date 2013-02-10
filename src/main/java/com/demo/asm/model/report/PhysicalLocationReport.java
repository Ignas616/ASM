package com.demo.asm.model.report;

import com.demo.asm.model.location.PhysicalLocation;

public class PhysicalLocationReport {

    private Long count;

    private PhysicalLocation physicalLocation;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public PhysicalLocation getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(PhysicalLocation physicalLocation) {
        this.physicalLocation = physicalLocation;
    }
}
