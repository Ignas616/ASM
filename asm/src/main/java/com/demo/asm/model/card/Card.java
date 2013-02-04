package com.demo.asm.model.card;

import com.demo.asm.model.shelf.Shelf;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card")
@SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1)
public class Card implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="card_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
		
	@OneToOne
	@JoinColumn(name = "card_type")
	private CardType cardType;

    @ManyToOne
    @JoinTable(name = "shelf_card_rel", joinColumns = @JoinColumn(name = "card_id"), inverseJoinColumns = @JoinColumn(name = "shelf_id"))
    private Shelf shelf;

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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
