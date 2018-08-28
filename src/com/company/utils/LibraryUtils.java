package com.company.utils;

import com.company.app.Library;
import com.company.data.Book;
import com.company.data.Magazine;

public class LibraryUtils {
//lib.getPublications().values().stream() zwraca nam strumień
// utworzony na podstawie zbioru wartości zwróconego
// przez metodę values() mapy publikacji z klasy Library

    public static void printBooks(Library lib) {
printPublication(lib, Book.class);
    }

    public static void printMagazines(Library lib) {
printPublication(lib,Magazine.class);
    }

private static void printPublication (Library lib, Class cl){
    long countMagazines = lib.getPublications().values()
            .stream()
            .filter(cl::isInstance)
            .sorted(new Library.AlphabeticalComparator())
            .peek(System.out::println)
            .count();

    if (countMagazines == 0) {
        System.out.println("W bibliotece nie znaleziono publikacji typu " + cl.getSimpleName());
    }
}
    public static void printUsers(Library lib){
      lib.getUsers()
              .values()
              .stream()
              .sorted((a,b)-> a.getLastName().compareTo(b.getLastName()))
              .forEach(System.out::println);
        }
    }


    //Poprzednio używaliśmy do tego operatora instanceof, który tym razem zastąpiliśmy referencją do metody isInstance() klasy Class.Jest to klasa, która pozwala pozwala uzyskać informację o klasie (nie obiekcie klasy), czyli np. ile dana klasa ma metod, konstruktorów, jaka jest jej nazwy itp. Metoda isInstance() sprawdza, czy obiekt przekazany jako argument jest obiektem tej klasy.
//
//Dwa poniższe zapisy są sobie równoważne:
//
//.filter(Magazine.class::isInstance)
//.filter(x -> x instanceof Magazine)

