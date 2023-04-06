package main;

import client.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo username: ");
        String username = scanner.nextLine();
        System.out.println("Benvenuto nella chat " + username + "!");
        System.out.println("Inserisci un messaggio...");
        Client client = new Client(username);
        client.waitMessage();
    }
}
