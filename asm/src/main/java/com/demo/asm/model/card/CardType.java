package com.demo.asm.model.card;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card_type")
@SequenceGenerator(name = "card_type_seq", sequenceName = "card_type_seq", allocationSize = 1)
public class CardType implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388873L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="card_type_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "noofports")
	private int noOfPorts;

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
    public int getNoOfPorts() {
        return noOfPorts;
    }

    public void setNoOfPorts(int noOfPorts) {
        this.noOfPorts = noOfPorts;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardType other = (CardType) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
