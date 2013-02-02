package com.demo.asm.model.shelf;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shelftype")
@SequenceGenerator(name = "shelftype_seq", sequenceName = "shelftype_seq", allocationSize = 1)
public class ShelfType implements Serializable{
	
	private static final long serialVersionUID = -7520724946566899973L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shelftype_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "noofallowedcardslots")
	private int noOfAllowedCardSlots;

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
        ShelfType other = (ShelfType) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
