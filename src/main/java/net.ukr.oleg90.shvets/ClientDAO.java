package net.ukr.oleg90.shvets;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
public interface ClientDAO {
     void addClient(Clients clients);

     void addCount(BillDAO currency);

     BillDAO removeCount(BillDAO currency);
     void resendMoney(String cardNumber, double count);
}
