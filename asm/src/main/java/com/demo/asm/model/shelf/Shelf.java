package com.demo.asm.model.shelf;

import com.demo.asm.model.card.Card;

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
	@JoinColumn(name = "shelftype")
	private ShelfType shelfType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "shelf_card_rel", joinColumns = @JoinColumn(name = "shelf_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> cardList;

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
}
