package net.ukr.oleg90.shvets;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shvets Oleg
 * @version 1.0
 */
@Entity
@Table(name = "Bank_name")
public class Bank {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private static List<Clients> listOfClients = new ArrayList<>();

    public static Bank InitializeBank(){
        return new Bank();
    }

    private Bank() {
    }

    public Clients removeClient(Clients clientInterface){
        Clients c = clientInterface;
        listOfClients.remove(clientInterface);
        return c;
    }
    public void addClient(Clients clientInterface){
        Clients c = clientInterface;
        listOfClients.add(c);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static List<Clients> getListOfClients() {
        return listOfClients;
    }

    public static void setListOfClients(List<Clients> listOfClients) {
        Bank.listOfClients = listOfClients;
    }

    @Override
    public String toString() {

        StringBuilder info = new StringBuilder();
        for(int i=0;i<listOfClients.size();i++){
            info.append(listOfClients.get(0).toString()).append("\n");
        }
        return info.toString();
    }
}
