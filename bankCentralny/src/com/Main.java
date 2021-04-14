package com;

import com.banks.Bank;
import com.banks.CEOBank;
import com.clients.BankAccount;
import com.clients.Client;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CEOBank ceoBank = new CEOBank();
        ceoBank.setGuaranteeFeeAmount(10000);

        Bank pko = new Bank("PKO", 500000);
        Bank santander = new Bank("Santander", 1000000);
        Bank pocztowy = new Bank("Bank Pocztowy", 750000);

        Client client1 = new Client("Adam", "Nowak", "11111111111");
        Client client2 = new Client("Jan", "Kowalski", "22222222222");

        BankAccount bankAccount1 = new BankAccount(client1, pko);
        BankAccount bankAccount2 = new BankAccount(client1, santander);
        BankAccount bankAccount3 = new BankAccount(client2, pocztowy);

        ceoBank.putToGuaranteeFund(pko);
        ceoBank.putToGuaranteeFund(santander);
        ceoBank.putToGuaranteeFund(pocztowy);
        ceoBank.addMoneyToBank(pko, 5000);
        System.out.println("CEO Bank posiada fundusz w kwocie: " +ceoBank.getGuaranteeFundAmount());

        System.out.println("Pierwszy klient to: " +client1.getNameAndSurname());
        System.out.println("Pierwszy bank to: " +pko.getBankName());
        System.out.println("Bank PKO ma kapital: " +pko.getCurrentCapital());

        bankAccount1.selfDepositCash(12000);
        bankAccount2.selfDepositCash(5000);
        bankAccount3.selfDepositCash(10000);
        bankAccount3.selfPayoutCash(2500);

        pocztowy.borrowMoney(bankAccount3, 2000);

        bankAccount3.payOffTheLoan(1500);
        bankAccount3.showBankAccountDeposit();

        pko.showInformations();
        client1.summaryMoney();
        client2.summaryMoney();
    }
}
