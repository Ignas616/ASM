package com.demo.asm.controller.report.impl;

import com.demo.asm.controller.report.ReportController;
import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.AddressLocationReport;
import com.demo.asm.model.report.CardTypeReport;
import com.demo.asm.model.report.CardTypeReportList;
import com.demo.asm.model.report.CardTypeReportList;
import com.demo.asm.model.report.PhysicalLocationReport;
import com.demo.asm.services.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller("reportController")
@Scope("session")
public class ReportControllerImpl implements ReportController {

    @Autowired
    private CardService service;

    private List<CardTypeReportList> cardReportListArray;

    public CardService getService() {
        return service;
    }

    public void setService(CardService service) {
        this.service = service;
    }

    public List<CardTypeReportList> getCardTypeReportListArray() {
        return cardReportListArray;
    }

    public void setCardTypeReportListArray(List<CardTypeReportList> cardReportListArray) {
        this.cardReportListArray = cardReportListArray;
    }

    @Override
    public void getCardTypeReport() {
        setCardTypeReportListArray(new ArrayList<CardTypeReportList>());

        for (CardType cardType : service.getAllCardTypes()) {
            CardTypeReportList cardTypeReportList = new CardTypeReportList();
            cardTypeReportList.setAddressLocationReportList(new ArrayList<AddressLocationReport>());
            cardTypeReportList.setPhysicalLocationReportList(new ArrayList<PhysicalLocationReport>());
            cardTypeReportList.setCardType(cardType);

            List<CardTypeReport> cardTypeReports = service.getCardTypeReport(cardType.getId());
            for (CardTypeReport cardTypeReport : cardTypeReports) {
                if(cardTypeReport.getAddressLocation() != null){
                    AddressLocationReport addressLocationReport=  new AddressLocationReport();
                    addressLocationReport.setAddressLocation(cardTypeReport.getAddressLocation());
                    addressLocationReport.setCount(cardTypeReport.getCount());
                    cardTypeReportList.getAddressLocationReportList().add(addressLocationReport);
                }
                if(cardTypeReport.getPhysicalLocation() != null){
                    PhysicalLocationReport physicalLocationReport =  new PhysicalLocationReport();
                    physicalLocationReport.setPhysicalLocation(cardTypeReport.getPhysicalLocation());
                    physicalLocationReport.setCount(cardTypeReport.getCount());
                    cardTypeReportList.getPhysicalLocationReportList().add(physicalLocationReport);
                }
            }

            getCardTypeReportListArray().add(cardTypeReportList);
        }
    }
}
