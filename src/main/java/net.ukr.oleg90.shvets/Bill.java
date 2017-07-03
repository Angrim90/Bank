package net.ukr.oleg90.shvets;

import javax.persistence.*;
import java.util.Formatter;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Entity
@Table(name = "Bills")
public class Bill  implements Bills {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String cardNumber;

    @Column
    private int pinCode;

    @Column
    private int cvv2;
    @Column
    private double moneyCount;
    @Column
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clients_id")
    private Client clients;

    public Bill() {
    }

    public Bill(String cardNumber, int pinCode, int cvv2, double moneyCount,String currency) {
        if(checkCardnumber(cardNumber)){
            this.cardNumber = cardNumber;
        }
        else throw new IllegalArgumentException("Wrong format of cardnumber");
        this.pinCode = pinCode;
        this.cvv2 = cvv2;
        this.moneyCount = moneyCount;
        this.currency = currency;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private boolean checkCardnumber(String cardNumber) {
        Formatter formatter = new Formatter();
        String[] array = cardNumber.split("-");
        System.out.println(1);
        if (array.length == 4) {
            System.out.println(12);
            int[] linearray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                System.out.println(2);
                if (array[i].length() == 4) {
                    System.out.println(3);
                    linearray[i] = Integer.parseInt(array[i]);

                    formatter.format("%4d-%4d-%4d-%4d", linearray[0], linearray[1], linearray[2], linearray[3]);
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "Bill{" +
                "cardNumber='" + cardNumber + '\'' +
                ", pinCode=" + pinCode +
                ", cvv2=" + cvv2 +
                ", moneyCount=" + moneyCount +
                '}';
    }
}
