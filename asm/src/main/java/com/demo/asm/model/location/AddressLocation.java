package com.demo.asm.model.location;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address_location")
@SequenceGenerator(name = "address_location_seq", sequenceName = "address_location_seq", allocationSize = 1)
public class AddressLocation extends Location implements Serializable {
    private static final long serialVersionUID = -7520724946566388839L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_location_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "cityname")
    private String cityName;

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "houseno")
    private String houseNo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
