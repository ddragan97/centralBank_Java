package com.clients;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClient {
    private String name;
    private String surname;
    protected List<BankAccount> clientBankAccounts = new ArrayList<>();
    private double summaryMoney = 0;

    /** Constructor of abstract client
     *
     * @param name Client name
     * @param surname Client surname
     */
    public AbstractClient(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /** Get name and surname of client
     *
     * @return Return string- name and surname of client
     */
    public String getNameAndSurname() {
        return name + " " + surname;
    }

    /** Print summary client deposits from all of his bank accounts
     *
     */
    public void summaryMoney() {
        for (BankAccount bankAcc : clientBankAccounts
             ) {
            summaryMoney += bankAcc.getTotalDeposit();
        }
        System.out.println("Na kontach masz: " + summaryMoney);
    }

}
