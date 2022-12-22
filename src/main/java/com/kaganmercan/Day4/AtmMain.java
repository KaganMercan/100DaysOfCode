package com.kaganmercan.Day4;

import com.kaganmercan.Day4.management.Account;

import java.io.IOException;

public class AtmMain {

    public static void main(String[] args) throws IOException {
        Account account = new Account();
        account.fillAccountList();
        account.welcomeScreen();
    }
}
