package net.ukr.oleg90.shvets;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Repository
public class ClientDaoImplementation implements ClientDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addClient(Clients clients) {
        entityManager.merge(clients);
    }

    @Override
    public void addCount(BillDAO currency) {
        entityManager.merge(currency);
    }

    @Override
    public BillDAO removeCount(BillDAO currency) {
        BillDAO billDAO= currency;
        entityManager.remove(currency);
        return billDAO;
    }

    @Override
    public void resendMoney(String cardNumber, double count) {

        Query query = entityManager.createQuery("UPDATE Bill set moneyCount = (moneyCount+count) where cardNumber = cardNumber ");
        query.executeUpdate();

    }
}
