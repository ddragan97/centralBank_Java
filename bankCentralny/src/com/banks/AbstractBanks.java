package com.banks;

import com.clients.BankAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBanks {
    protected double currentCapital;
    protected double guaranteeCapital;
    protected double borrowedMoney;
    protected String name;
    protected int startCapital;
    protected List<BankAccount> bankAccountList = new ArrayList<>();

    /** Abstract constructor of bank
     *
     * @param name Name of bank
     * @param startCapital Started capital value
     */
    public AbstractBanks(String name, int startCapital) {
        this.name = name;
        this.startCapital = startCapital;
        currentCapital = startCapital;
    }

    /** Get bank name
     *
     * @return Return bank name
     */
    public String getBankName() {
        return this.name;
    }

    /** Get current capital of bank
     *
     * @return Return current capital
     */
    public double getCurrentCapital() {
        return this.currentCapital;
    }

    /** Show informations about bank name, current capital and guarantee capital
     *
     */
    public void showInformations() {
        System.out.println("Bank: " +name+ " posiada kapital: " +currentCapital+ " oraz fundusz gwarancyjny: " +guaranteeCapital);
    }

    /** Add bank accounts to list
     *
     * @param bankAccount Bank account which is added to list
     */
    public void addBankAccountToList(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    /** Test if account is in this bank
     *
     * @param bankAccount Tested bank account
     * @return Return boolean if account is in bank
     */
    public boolean isInBankAccounts(BankAccount bankAccount) {
        return bankAccountList.contains(bankAccount);
    }

    /** Borrow money from bank to account
     *
     * @param bankAccount Account to borrow
     * @param amount Cash value
     */
    public void borrowMoney(BankAccount bankAccount, double amount) {
        if(isInBankAccounts(bankAccount) && this.currentCapital-amount>0) {
            this.currentCapital -= amount;
            this.borrowedMoney += amount;
            bankAccount.borrowCash(amount);
        }
        else
            System.out.println("Podano bledne konto!");
    }

    /** Get back borrowed money from specified bank account
     *
     * @param bankAccount Bank account to pay off the loan
     * @param amount Cash value
     */
    public void getBackBorrowedMoney(BankAccount bankAccount, double amount) {
        this.borrowedMoney -= amount;
        this.currentCapital += amount;
    }
}
