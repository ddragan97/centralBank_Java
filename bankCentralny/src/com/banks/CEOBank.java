package com.banks;

public class CEOBank {
    private double guaranteeFundAmount;
    private double guaranteeFeeAmount = 10000;

    /** Set cash amount for guarantee fund
     *
     * @param guaranteeFeeAmount Cash value
     */
    public void setGuaranteeFeeAmount(double guaranteeFeeAmount) {
        this.guaranteeFeeAmount = guaranteeFeeAmount;
    }

    /** Get cash value of guarantee fund
     *
     * @return Return amount of collected cash
     */
    public double getGuaranteeFundAmount() {
        return guaranteeFundAmount;
    }

    /** Send cash to bank
     *
     * @param bank To which bank send cash
     * @param amount How much money send
     */
    public void addMoneyToBank(Bank bank, double amount) {
        if(guaranteeFundAmount - amount > 0) {
            bank.currentCapital += amount;
            guaranteeFundAmount -= amount;
        }
        else
            System.out.println("Brak pieniedzy");
    }

    /** Put cash to CEO Bank
     *
     * @param bank Which bank put cash to guarantee fund
     */
    public void putToGuaranteeFund(Bank bank) {
        bank.currentCapital -= guaranteeFeeAmount;
        bank.guaranteeCapital += guaranteeFeeAmount;
        guaranteeFundAmount += guaranteeFeeAmount;
    }
}
