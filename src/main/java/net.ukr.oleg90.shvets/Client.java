package net.ukr.oleg90.shvets;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Entity
@Table(name = "Client")
public class Client implements Clients {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String password;
    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private List<Bill> bills = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bank_id")
    private Bank bank;

    public Client(String name,String password) {
        this.name = name;
        this.password = password;

    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bills=" + bills +
                '}';
    }
}
