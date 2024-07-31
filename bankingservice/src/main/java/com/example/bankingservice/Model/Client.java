package com.example.bankingservice.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String occupation;
    private float annualIncome;
    private String maritalStatus;
    private Date customerSince;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public void setClientId(int id) {
        this.clientId = id;
    }

    public int getClientId() {
        return clientId;
    }
}
