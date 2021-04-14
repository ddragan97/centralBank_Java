package com.clients;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClient {
    private String name;
    private String surname;
    private String pesel;
    protected List<BankAccount> clientBankAccounts = new ArrayList<>();

    /** Constructor of abstract client
     *
     * @param name Client name
     * @param surname Client surname
     */
    public AbstractClient(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
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
        double summaryMoney = 0;
        for (BankAccount bankAcc : clientBankAccounts
             ) {
            summaryMoney += bankAcc.getTotalDeposit();
        }
        System.out.println("Na kontach masz: " + summaryMoney);
    }

}
