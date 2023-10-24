package org.lessons.java.books;

public class Book {
    //ATTRIBUTI
    private String title;
    private int pages;
    private String author;
    private String publisher;

    // COSTRUTTORE
    public Book(String title, int pages, String author, String publisher) {
        //controlli per titolo vuoto
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto!");
        }

        //controlli per numero di pagine <=0
        if (pages <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di 0!");
        }

        //controlli autore
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'autore non può essere vuoto!");
        }

        //controlli editore
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'editore non può essere vuoto!");
        }

        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
    }

    //GETTER E SETTER

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'editore non può essere vuoto!");
        }
        this.title = title;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
