package com;

import com.banks.Bank;
import com.banks.CEOBank;
import com.clients.BankAccount;
import com.clients.Client;

public class Main {

    public static void main(String[] args) {

        Bank b1 = new Bank("PKO", 100000);
        System.out.println("Nazwa banku: "+b1.getBankName());
        System.out.println("Aktualny kapital: "+b1.getCurrentCapital());
        b1.showInformations();

        Client c1 = new Client("Jan", "Kowalski");
        System.out.println("Klient: "+c1.getNameAndSurname());

        BankAccount bankAccount1 = new BankAccount(c1,b1);
        bankAccount1.showBankAccountDeposit();
        BankAccount bankAccount2 = new BankAccount(c1,b1);


//        b1.borrowMoney(bankAccount1, 125);
//        b1.borrowMoney(bankAccount2, 250);
        System.out.println("Aktualny kapital: "+b1.getCurrentCapital());

        bankAccount1.showBankAccountDeposit();

        CEOBank ceoBank = new CEOBank();
        ceoBank.setGuaranteeFeeAmount(10000);
        ceoBank.addMoneyToBank(b1,15000);
        ceoBank.putToGuaranteeFund(b1);
        System.out.println("Fundusz gwarancyjny posiada: "+ceoBank.getGuaranteeFundAmount());

        b1.showInformations();

        ceoBank.setGuaranteeFeeAmount(25000);
        ceoBank.putToGuaranteeFund(b1);
        System.out.println("Fundusz gwarancyjny posiada: "+ceoBank.getGuaranteeFundAmount());

        b1.showInformations();

        c1.summaryMoney();

    }
}
