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
                int pages;
                do {
                    System.out.println("Inserisci il numero di pagine: ");
                    try {
                        pages = Integer.parseInt(scan.nextLine());
                        if (pages <= 0) {
                            throw new IllegalArgumentException("Non puoi inserire un numero di pagine inferiore a 0!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero valido per il numero di pagine!");
                        pages = -1; // Imposta un valore non valido per continuare il ciclo
                    }
                } while (pages <= 0);

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

                // istanzio il nuovo oggetto Book
                Book book = new Book(title, pages, author, publisher);
                // aggiungo l'oggetto appena creato all'array
                libri[indice] = book;
                // aumento il contatore per far ripartire il ciclo
                indice++;

                // se tutto è andato bene confermo l'inserimento del libro nell'array
                System.out.println("Libro inserito correttamente");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

    }
}
