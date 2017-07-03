package net.ukr.oleg90.shvets;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Repository
public class BillDaoImplementation implements BillDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addMoneyOnACard(double moneysIn) {
        entityManager.merge(moneysIn);


    }

    @Override
    public double pullOfMoneyFromTheCard(double moneysOut) {
        return 0;
    }

    @Override
    public double getMoneyCount() {
        return 0;
    }
}
