/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.function.Consumer;

/**
 *
 * @author sandeep.kumar
 */
public class MethodReferenceEx {
    public static void main(String...args) {
        Processer<String> p1 = new Processer<String>("A");
        p1.process(System.out::println);
    }
}

class Processer<T> {
    private T ob;
    public Processer() {};
    public Processer(T ob) {
        this.ob = ob;
    };
    public void process(Consumer<T> c) {
        c.accept(ob);
    };
}
