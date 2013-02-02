package com.demo.asm.model.shelf;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shelf")
@SequenceGenerator(name = "shelf_seq", sequenceName = "shelf_seq", allocationSize = 1)
public class Shelf implements Serializable{
	
	private static final long serialVersionUID = -752678846566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shelf_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "number")
	private int number;
		
	@OneToOne
	@JoinColumn(name = "shelftype")
	private ShelfType shelfType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShelfType getShelfType() {
        return shelfType;
    }

    public void setShelfType(ShelfType shelfType) {
        this.shelfType = shelfType;
    }
}
