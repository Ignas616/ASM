package com.demo.asm.model.shelf;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.device.Device;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
	@JoinColumn(name = "shelf_type")
	private ShelfType shelfType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="shelf_id")
    private List<Card> cardList;

    @ManyToOne
    @JoinColumn(name="device_id")
    private Device device;

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

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
