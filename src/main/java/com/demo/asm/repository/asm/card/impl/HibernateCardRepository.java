package com.demo.asm.repository.asm.card.impl;

import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.CardTypeReport;
import com.demo.asm.repository.asm.card.CardRepository;
import com.demo.asm.repository.impl.HibernateBaseRepository;
import com.demo.asm.services.location.AddressLocationService;
import com.demo.asm.services.location.PhysicalLocationService;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateCardRepository extends HibernateBaseRepository implements CardRepository {


    @Autowired
    private AddressLocationService addressLocationService;

    @Autowired
    private PhysicalLocationService physicalLocationService;

    @Override
    public List<CardType> getAllCardTypes() {
        return getHibernateTemplate().loadAll(CardType.class);
    }

    @Override
    public CardType loadCardTypeById(int id) {
        return getHibernateTemplate().get(CardType.class, id);
    }

    @Override
    public List<CardTypeReport> getCardTypeReport(int cardTypeId) {

        final List<CardTypeReport> cardReports = new ArrayList<CardTypeReport>();

        final int cardTypeIdLocal = cardTypeId;

        Session session = getSession(true);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) {
                try {
                    String sql = "SELECT * from get_card_type_report(" + cardTypeIdLocal + ");";
                    ResultSet res = connection.createStatement().executeQuery(sql);

                    while (res.next()) {
                        CardTypeReport cardReport = new CardTypeReport();


                        Integer physicalId = res.getInt("physicalid");
                        if (physicalId != null) {
                            cardReport.setPhysicalLocation(physicalLocationService.getById(physicalId));
                        }

                        Integer addressId = res.getInt("addressid");
                        if (addressId != null) {
                            cardReport.setAddressLocation(addressLocationService.getById(addressId));
                        }

                        Long count = res.getLong("count");
                        cardReport.setCount(count);
                        cardReports.add(cardReport);
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        session.disconnect();

        return cardReports;
    }
}
