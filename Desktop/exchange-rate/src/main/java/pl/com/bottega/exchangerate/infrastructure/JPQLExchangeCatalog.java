package pl.com.bottega.exchangerate.infrastructure;

import pl.com.bottega.exchangerate.api.ExchangeRateCatalog;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateQuery;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPQLExchangeCatalog implements ExchangeRateCatalog{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ExchangeRate get(ExchangeRateQuery exchangeRateQuery) {
        Query query = entityManager.createQuery("SELECT e FROM ExchangeQuery e WHERE e.currency = :currency AND e.date = :date");
        query.setParameter("currency", exchangeRateQuery.getTo());
        query.setParameter("date", exchangeRateQuery.getDate());
        try {
            ExchangeRate exchangeRate = (ExchangeRate) query.getSingleResult();
            return exchangeRate;
        } catch (NoResultException ex) {
            throw new RuntimeException();
        }
    }
}
