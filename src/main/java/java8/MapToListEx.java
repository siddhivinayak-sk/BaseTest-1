/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author sandeep.kumar
 */
public class MapToListEx {

    public static void main(String...args) {
        class Book {
            private Integer id;
            private String name;
            private Double price;
            
            public Book(Integer id, String name, Double price) {
                this.id = id;
                this.name = name;
                this.price = price;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            @Override
            public String toString() {
                return "Book{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
            }
        }
        
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "A", 10.9));
        bookList.add(new Book(2, "B", 9.1));
        bookList.add(new Book(3, "C", 8.7));
        bookList.add(new Book(4, "D", 99.9));
        bookList.add(new Book(5, "E", 56.4));
        bookList.add(new Book(6, "F", 55.3));
        bookList.add(new Book(7, "G", 12.2));
        bookList.add(new Book(8, "H", 11.7));
        bookList.add(new Book(9, "I", 9.11));
        bookList.add(new Book(10, "J", 1.98));
        
        Map<Integer, String> idNameMap = bookList.stream().collect(Collectors.toMap(Book::getId, Book::getName));
        System.out.println(idNameMap);

        Map<Integer, Book> idBookMap = bookList.stream().collect(Collectors.toMap(Book::getId, x -> x));
        System.out.println(idBookMap);
        
        Map<Integer, String> idModifiedNameMap = bookList.stream().collect(Collectors.toMap(new Function<Book, Integer>() {
            @Override
            public Integer apply(Book t) {
                return t.getId();
            }
        }, new Function<Book, String>() {
            @Override
            public String apply(Book t) {
                return t.getName();
            }
        }));
        System.out.println(idModifiedNameMap);
        
        
        //Duplicate Key
        bookList.add(new Book(1, "A1", 10.19));
        Map<Integer, String> idNameMap2 = bookList.stream().collect(Collectors.toMap(Book::getId, Book::getName, (oldValue, newValue) -> newValue));
        System.out.println(idNameMap2);
        
        //Sort and collect
        Map<Integer, String> idNameMap3 = bookList.stream().sorted(Comparator.comparing(Book::getName).reversed()).collect(Collectors.toMap(Book::getId, Book::getName, (oldValue, newValue) -> newValue, LinkedHashMap::new));
        System.out.println(idNameMap3);
        
        //Filter Map
        Map<Integer, Book> idBookMap2 = bookList.stream().collect(Collectors.toMap(book -> book.getId(), (book) -> book));
        
        
        
    }
}
