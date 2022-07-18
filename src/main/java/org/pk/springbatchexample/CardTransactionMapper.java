package org.pk.springbatchexample;

import lombok.extern.slf4j.Slf4j;
import org.pk.springbatchexample.entity.CardTransaction;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Slf4j
@Component
public class CardTransactionMapper {

    public CardTransaction cardTransactionMapper(String line) {
        log.info(line);
        var cardTransaction = new CardTransaction();
        var stringTokenizer = new StringTokenizer(line, ",");
        for (var i = 0; stringTokenizer.hasMoreTokens(); i++) {
            var token = stringTokenizer.nextToken();
            mapTokenToTransaction(i, cardTransaction, token);
        }
        return cardTransaction;
    }

    private void mapTokenToTransaction(int i, CardTransaction cardTransaction, String token) {
        if (i == 0) cardTransaction.setSeriesReference(token);
        if (i == 1) cardTransaction.setPeriod(token);
        if (i == 2) cardTransaction.setDataValue(token);
        if (i == 3) cardTransaction.setStatus(token);
        if (i == 4) cardTransaction.setUnits(token);
        if (i == 5) cardTransaction.setSubject(token);
        if (i == 6) cardTransaction.setTransactionGroup(token);
        if (i == 7) cardTransaction.setSeriesTitle1(token);
        if (i == 8) cardTransaction.setSeriesTitle2(token);
        if (i == 9) cardTransaction.setSeriesTitle3(token);
        if (i == 10) cardTransaction.setSeriesTitle4(token);
        if (i == 11) cardTransaction.setSeriesTitle5(token);
    }

}
