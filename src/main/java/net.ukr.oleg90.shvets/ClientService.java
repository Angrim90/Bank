package net.ukr.oleg90.shvets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Service
@Transactional
public class ClientService {
    @Autowired
    private BillDAO billDAO;
    @Autowired
    private ClientDAO clientDAO;

    @Transactional
    public void addMoneyOnACard(double moneysIn){
        billDAO.addMoneyOnACard(moneysIn);
    }
    @Transactional
    public  double pullOfMoneyFromTheCard(double moneysOut){
        return billDAO.pullOfMoneyFromTheCard(moneysOut);
    }
    @Transactional
    public double getMoneyCount(){
        return billDAO.getMoneyCount();
    }


    @Transactional
    public void addClient(Clients clients){
        clientDAO.addClient(clients);
    }
    @Transactional
    public void addCount(BillDAO currency){
        clientDAO.addCount(currency);
    }
    @Transactional
    public BillDAO removeCount(BillDAO currency){
        return clientDAO.removeCount(currency);
    }
    @Transactional
    public void resendMoney(String cardNumber, double count){
        clientDAO.resendMoney(cardNumber,count);
    }

}
