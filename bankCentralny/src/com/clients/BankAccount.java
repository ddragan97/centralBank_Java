package com.clients;

import com.banks.Bank;

public class BankAccount {
    private double totalDeposit = 0;
    private double borrowedCash = 0;

    /** Constructor of new Bank Account
     *
     * @param client Which client create account
     * @param bank Which bank creates account
     */
    public BankAccount(Client client, Bank bank) {
        bank.addBankAccountToList(this);
        client.clientBankAccounts.add(this);
    }

    /** Self payout cash from account
     *
     * @param amount Cash amount
     */
    public void selfPayoutCash(double amount) {
        totalDeposit -= amount;
    }

    /** Self deposit cash to account
     *
     * @param amount Cash amount
     */
    public void selfDepositCash(double amount) {
        totalDeposit += amount;
    }

    /** Get total deposit of account
     *
     * @return Return total deposit value
     */
    public double getTotalDeposit() {
        return totalDeposit;
    }

    /** Show account deposit - cash amount
     *
     */
    public void showBankAccountDeposit() {
        System.out.println("Na tym koncie masz: " +totalDeposit);
    }

    /**
     *
     * @param amount Cash value
     */
    public void borrowCash(double amount) {
        totalDeposit += amount;
        borrowedCash += amount;
    }
}
