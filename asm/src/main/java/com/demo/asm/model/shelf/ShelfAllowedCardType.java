package com.demo.asm.model.shelf;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shelf_allowed_card_types")
@SequenceGenerator(name = "shelf_allowed_card_types_seq", sequenceName = "shelf_allowed_card_types_seq", allocationSize = 1)
public class ShelfAllowedCardType implements Serializable{
	
	private static final long serialVersionUID = -7520724946566899973L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shelf_allowed_card_types_seq")
	@Column(name = "id")
	private int id;

    @Column(name = "shelf_type_id")
    private int shelfTypeId;

    @Column(name = "card_type_id")
    private int cardTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShelfTypeId() {
        return shelfTypeId;
    }

    public void setShelfTypeId(int shelfTypeId) {
        this.shelfTypeId = shelfTypeId;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }
}
