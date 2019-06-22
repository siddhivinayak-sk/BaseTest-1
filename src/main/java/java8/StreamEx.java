/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author sandeep.kumar
 */
public class StreamEx {
    public static void main(String...args) {
        List<String> list = new ArrayList<String>();
        list.add("Gopal Kumar");
        list.add("Ram Kumar");
        list.add("Amar Kumar");
        list.add("Bahadur Kumar");
        list.add("Sonu");
        list.add("John McLine");
        list.add("Dwhene Johanson");
        list.add("Rob Millerson");
        list.add("Billi Leroy");
        
        list.stream().forEach(System.out::println);
        System.out.println("-------------------------");
        
        list.stream().filter(line -> line.contains("Kumar")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------------------");
        
        String find = list.stream().filter((line) -> line.contains("Kumar1")).findAny().orElse(null);
        System.out.println("Find : " + find);
        System.out.println("-------------------------");
        
        class Person {
            private String name;
            private Integer age;
            
            public Person() {}
            public Person(String name, Integer age) {this.name = name; this.age = age;}

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" + "name=" + name + ", age=" + age + '}';
            }
        }
;
        
        List<Person> plist = Arrays.asList(new Person("Warren Buffet", 80), new Person("Warren Hestings", 65), new Person("Rob Miller", 69), new Person("John Mclline", 65), new Person("Dwyene Johanson", 45), new Person("John Cina", 40), new Person("Robert Moore", 36), new Person("Robert Brownie Jr.", 46), new Person("Silvester Stallon", 68), new Person("Nicolas Cage", 48), new Person("Gillbert Locheart", 39));
        Person p1 = plist.stream().filter((p) -> p.getName().contains("John")).findAny().orElse(null);
        System.out.println("Person 1: " + p1);
        System.out.println("-------------------------");
        
        List<Person> plist2 = plist.stream().filter(p -> p.getName().contains("John")).collect(Collectors.toList());
        plist2.forEach(System.out::println);
        System.out.println("-------------------------");

        String p1Name = plist.stream().filter(p -> p.getName().contains("John")).map(Person::getName).findAny().orElse("");
        System.out.println("P1 Name : " + p1Name);
        System.out.println("-------------------------");

        List<String> pNameList = plist.stream().filter(p -> p.getName().contains("John")).map(Person::getName).collect(Collectors.toList());
        pNameList.forEach(System.out::println);
        System.out.println("-------------------------");
        
        
        
        Stream<String> s1 = Stream.of("A", null, "Z", "X", null, "S", "Y");
        s1.forEach(System.out::println);
        System.out.println("-------------------------");
        
        Stream<String> s2 = Stream.of("A", null, "Z", "X", null, "S", "Y");
        s2.filter(o -> null != o).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------------------");
        
        //Convert a stream to list
        List<String> tl1 = Arrays.asList("A", "X", "D", "M", "Q", "V", "W", "A", "Z");
        Stream<String> s3 = tl1.stream();
        List<String> tl2 = s3.collect(Collectors.toList());
        Stream<String> s4 = tl1.stream();
        Set<String> tl3 = s4.collect(Collectors.toSet());
        
        String[] sar = new String[] {"A", "X", "C", "B", "V"};
        Stream<String> s5 = Arrays.stream(sar);
        Stream<String> s6 = Stream.of(sar);
        
        int[] intarr = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        IntStream is1 = Arrays.stream(intarr);
        Stream<int[]> is2 = Stream.of(intarr);
        IntStream is3 = is2.flatMapToInt(x -> Arrays.stream(x));
        
        
        Supplier<Stream<String>> supplierStream = () -> Stream.of(sar);
        supplierStream.get().forEach(System.out::println);
        System.out.println("-------------------------");
        supplierStream.get().filter((e) -> e.contains("A")).forEach(System.out::println);
        System.out.println("-------------------------");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
