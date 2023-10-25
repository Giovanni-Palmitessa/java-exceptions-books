package org.lessons.java.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Istanzio lo scanner
        Scanner scan = new Scanner(System.in);

        // Chiedere all'utente quanti libri si vogliono inserire
        System.out.print("Quanti libri vuoi inserire? ");
        int numeroLibri = Integer.parseInt(scan.nextLine());

        //creo un array di oggetti di libri
        Book[] libri = new Book[numeroLibri];

        //indice per i libri
        int indice = 0;

        // ciclo while per chiedere all'utente di inserire un libro
        while (indice < libri.length) {
            try {
                System.out.println("Inserisci i dati del " + (indice + 1) + "° libro." );

                // Chiedo il Titolo
                System.out.print("Titolo: ");
                String title = scan.nextLine();

                //Chiedo il numero di pagine
                System.out.print("Numero di pagine: ");
                int pages = Integer.parseInt(scan.nextLine());

                // Chiedo l'Autore
                System.out.print("Autore: ");
                String author = scan.nextLine();

                // Chiedo l'Editore
                System.out.print("Editore: ");
                String publisher = scan.nextLine();

                // Crea un nuovo oggetto Book e inseriscilo nell'array
                libri[indice] = new Book(title, pages, author, publisher);
                indice++;

                System.out.println("Libro inserito correttamente.");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido per il numero di pagine!");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        // Stampa il catalogo dei libri
        System.out.println("Catalogo dei libri:");
        for (int i = 0; i < indice; i++) {
            System.out.println("Libro " + (i + 1));
            System.out.println("Titolo: " + libri[i].getTitle());
            System.out.println("Numero di pagine: " + libri[i].getPages());
            System.out.println("Autore: " + libri[i].getAuthor());
            System.out.println("Editore: " + libri[i].getPublisher());
            System.out.println();
        }

        // lo scrivo su file
        try (FileWriter fileWriter = new FileWriter("./resources/books.txt");) {
            //scrivo una riga per ogni book
            for (Book book : libri) {
                fileWriter.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Impossibile scrivere file!");;
        }

        //leggo il file
        System.out.println("Leggo il file!");
        try(Scanner fileReader = new Scanner(new File("./resources/books.txt"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile leggere file!");
        }
    }
}
