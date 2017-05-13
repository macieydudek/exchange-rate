package pl.com.bottega.exchangerate.infrastructure;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class JPAExchangeRateRepository implements ExchangeRateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(ExchangeRate exchangeRate) {
        entityManager.persist(exchangeRate);
    }

    @Override
    public ExchangeRate get(String date, String currency) {
        Query query = entityManager.createQuery("SELECT e FROM ExchangeRate e WHERE e.date = :date AND e.currency = :currency");
        query.setParameter("date", date);
        query.setParameter("currency", currency);
        try {
            ExchangeRate exchangeRate = (ExchangeRate) query.getSingleResult();
            return exchangeRate;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
