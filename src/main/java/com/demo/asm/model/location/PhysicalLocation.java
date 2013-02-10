package com.demo.asm.model.location;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "physical_location")
@SequenceGenerator(name = "physical_location_seq", sequenceName = "physical_location_seq", allocationSize = 1)
public class PhysicalLocation extends Location implements Serializable {
    private static final long serialVersionUID = -7520724946566388839L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="physical_location_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "coord_x")
    private int coordX;

    @Column(name = "coord_y")
    private int coordY;

    @Column(name = "coord_z")
    private int coordZ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public int getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(int coordZ) {
        this.coordZ = coordZ;
    }
}
