package net.ukr.oleg90.shvets;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
public interface BillDAO {
    void addMoneyOnACard(double moneysIn);
    double pullOfMoneyFromTheCard(double moneysOut);
    double getMoneyCount();
}
