package org.lessons.java.books;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Istanzio lo scanner
        Scanner scan = new Scanner(System.in);

        //creo un array di oggetti di libri
        Book[] libri = new Book[100];

        //indice per i libri
        int indice = 0;

        //istanzio ciclo while per iterare su array dei libri
        while (true) {
            try {
                // chiedere i dati del libro
                System.out.println("Inserisci i dati del libro!");


                // Titolo del Libro
                System.out.println("Inserisci il titolo del libro: ");
                String title = scan.nextLine();
                if (title.isEmpty()) {
                    throw new IllegalArgumentException("Il titolo non può essere vuoto!");
                }

                // Numero di pagine
                System.out.println("Inserisci il numero di pagine: ");
                int pages = Integer.parseInt(scan.nextLine());
                if (pages <= 0) {
                    throw new IllegalArgumentException("Non puoi inserire un numero di pagine inferiore a 0!")
                }

                // Autore
                System.out.println("Inserisci il nome dell'autore: ");
                String author = scan.nextLine();
                if (author.isEmpty()) {
                    throw new IllegalArgumentException("Il nome dell'autore non può essere vuoto");
                }

                // Editore
                System.out.println("Inserisci il nome dell'editore: ");
                String publisher = scan.nextLine();
                if (publisher.isEmpty()) {
                    throw new IllegalArgumentException("Il nome dell'editore non può essere vuoto!");
                }
            }
        }
    }
}
