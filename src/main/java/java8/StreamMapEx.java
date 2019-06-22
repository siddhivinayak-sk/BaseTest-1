/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author sandeep.kumar
 */
public class StreamMapEx {
    public static void main(String...args) {
        List<Integer> list1 = Arrays.asList(1, 2, 6, 3, 5, 4, 9, 0, 7, 8);
        list1.stream().map(o -> o * 2).collect(Collectors.toList()).forEach(System.out::println);
        list1.stream().map(o -> o + " - Number").collect(Collectors.toList()).forEach(System.out::println);
        
        list1.stream().map(Integer::intValue).collect(Collectors.toList()).forEach(System.out::println);
        list1.stream().map(i -> ("0000000000" + i).substring(("0000000000" + i).length() - 10, ("0000000000" + i).length())).collect(Collectors.toList()).forEach(System.out::println);
        
        //Group By and counting
        List<String> list2 = Arrays.asList("Apple", "Mango", "Orange", "Banana", "Lichi", "Apple", "Banana");
        Map<String, Long> list2data = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(list2data);
        
        Map<String, Long> sortedlist2data = new LinkedHashMap<String, Long>();
        list2data.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEachOrdered(e -> sortedlist2data.put(e.getKey(), e.getValue()));
        System.out.println(sortedlist2data);
        
        class Fruit {
            private String name;
            private Double price;
            private Double stock;
            
            public Fruit(String name, Double price, Double stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
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

            public Double getStock() {
                return stock;
            }

            public void setStock(Double stock) {
                this.stock = stock;
            }

            @Override
            public String toString() {
                return "Fruit{" + "name=" + name + ", price=" + price + ", stock=" + stock + '}';
            }
        }
        
        List<Fruit> list3 = Arrays.asList(
                new Fruit("Apple", 7.99, 1.00),
                new Fruit("Mango", 8.5, 2.00),
                new Fruit("Orange", 2.99, 10.00),
                new Fruit("Banana", 25.50, 12.00),
                new Fruit("Lichi", 3.99, 2.00),
                new Fruit("Mango", 8.5, 3.00),
                new Fruit("Orange", 2.99, 1.00),
                new Fruit("Apple", 7.99, 2.00),
                new Fruit("Banana", 25.50, 10.00),
                new Fruit("Mango", 8.5, 1.00)
        );

        //Group By name and count of Fruits
        Map<String, Long> list3data1 = list3.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
        System.out.println(list3data1);
        //Group By name and sum of price
        Map<String, Double> list3data2 = list3.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.summingDouble(Fruit::getPrice)));
        System.out.println(list3data2);
        //Group by price and set of fruit names
        Map<Double, Set<String>> list3data3 = list3.stream().collect(Collectors.groupingBy(Fruit::getPrice, Collectors.mapping(Fruit::getName, Collectors.toSet())));
        System.out.println(list3data3);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
