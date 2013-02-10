package com.demo.asm.model.report;

import com.demo.asm.model.card.CardType;

import java.util.List;

public class CardTypeReportList {
	
	private CardType cardType;

    private List<PhysicalLocationReport> physicalLocationReportList;

    private List<AddressLocationReport> addressLocationReportList;

      public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public List<PhysicalLocationReport> getPhysicalLocationReportList() {
        return physicalLocationReportList;
    }

    public void setPhysicalLocationReportList(List<PhysicalLocationReport> physicalLocationReportList) {
        this.physicalLocationReportList = physicalLocationReportList;
    }

    public List<AddressLocationReport> getAddressLocationReportList() {
        return addressLocationReportList;
    }

    public void setAddressLocationReportList(List<AddressLocationReport> addressLocationReportList) {
        this.addressLocationReportList = addressLocationReportList;
    }
}
