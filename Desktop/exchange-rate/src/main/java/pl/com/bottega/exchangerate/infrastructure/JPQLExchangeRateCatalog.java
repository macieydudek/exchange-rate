package pl.com.bottega.exchangerate.infrastructure;

import pl.com.bottega.exchangerate.api.ExchangeRateCatalog;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateQuery;
import pl.com.bottega.exchangerate.domain.NoRateException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPQLExchangeRateCatalog implements ExchangeRateCatalog{

    @PersistenceContext
    EntityManager entityManager;

    private static final String BASE_QUERY = "SELECT e FROM ExchangeQuery e WHERE e.date = :date";

    @Override
    public ExchangeRate get(ExchangeRateQuery exchangeRateQuery) {
        Query query = entityManager.createQuery("SELECT e FROM ExchangeRate e WHERE e.currency = :currency AND e.date = :date");
        if (exchangeRateQuery.getFrom() == null) {
            query.setParameter("currency", exchangeRateQuery.getTo());
        } else {
            query.setParameter("currency", exchangeRateQuery.getFrom());
        }
        query.setParameter("date", exchangeRateQuery.getDate());
        try {
            ExchangeRate exchangeRate = (ExchangeRate) query.getSingleResult();
            return exchangeRate;
        } catch (NoResultException ex) {
            throw new NoRateException();
        }
    }
}
