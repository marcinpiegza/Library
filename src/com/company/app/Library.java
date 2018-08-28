package com.company.app;


import com.company.data.Book;
import com.company.data.LibraryUser;
import com.company.data.Magazine;
import com.company.data.Publication;
import com.company.data.Publication;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

    private static final long serialVersionUID = 2995794334600947815L;

    private Map<String, Publication> publications;
    private Map<String, LibraryUser> users;

    //zwracamy rozmiar mapy
    public int getPublicationsNumber() {
        return publications.size();
    }
    //ZMIENIONY TYP
    public Map<String, Publication> getPublications() {
        return publications;
    }

    //DODANY GETTER
    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Library() {
        publications = new HashMap<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    //DODANE
    public void addUser(LibraryUser user) {
        users.put(user.getPesel(), user);
    }

    //ZMIENIONA LOGIKA
    public void removePublication(Publication pub) {
        if(publications.containsValue(pub)) {
            publications.remove(pub.getTitle());
        }
    }

    //ZMIENIONA LOGIKA I USUNIĘCIE ZWRACANEGO WYJATKU
    private void addPublication(Publication pub) {
        publications.put(pub.getTitle(), pub);
    }

    //ZMIENIONA LOGIKA PĘTLI
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Publication p: publications.values()) {
            builder.append(p);
            builder.append("\n");
        }
        return builder.toString();
    }


    //Komparatory zdefiniowaliśmy jako statyczne klasy zagnieżdżone,
    // dzięki czemu nie musimy tworzyć instancji klasy Library do
    // posługiwania się nimi.
    public static class AlphabeticalComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class DateComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();
            return -i1.compareTo(i2);
        }
    }
}