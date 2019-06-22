/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Optional;

/**
 *
 * @author sandeep.kumar
 */
public class OptionalTestEx {
    public static void main(String...args) {
        Optional<String> str1 = Optional.of("asd");
        String str2 = "X1";
        String str3 = null;
        Optional<Optional<String>> str4 = Optional.of(Optional.of("def"));
        Optional<String> str5 = Optional.empty();
        
        System.out.println(str1);
        System.out.println(str1.get());
        System.out.println(str1.empty());
        
        System.out.println(Optional.ofNullable(str2));
        System.out.println(Optional.ofNullable(str3));
        
        //System.out.println(Optional.of(str3));
        //System.out.println(str5.get());
        
        System.out.println(str1.map(String::toUpperCase));
        System.out.println(str5.map(String::toUpperCase));
        System.out.println(str4.map(ob -> ob.map(String::toUpperCase)));
        System.out.println(str4.flatMap(ob -> ob.map(String::toUpperCase)));
        
        System.out.println(str1.filter(ob -> ob.equals("asd")));
        System.out.println(str1.filter(ob -> ob.contains("xyz")));
        System.out.println(str5.filter(ob -> ob.contains("xyz")));
        
        System.out.println(str1.isPresent());
        System.out.println(str5.isPresent());
        str1.ifPresent(ob -> System.out.println(ob));
        str5.ifPresent(ob -> System.out.println(ob));
        
        System.out.println(str1.orElse("X6"));
        System.out.println(str5.orElse("X7"));
        System.out.println(str1.orElseGet(() -> "X8"));
        System.out.println(str5.orElseGet(() -> "X9"));

        MobileService ms = new MobileService();
        ScreenResolution sr1 = new ScreenResolution(320, 480);
        ScreenResolution sr2 = new ScreenResolution(0, 0);
        
        DisplayFeatures df1 = new DisplayFeatures("4.7", Optional.of(sr1));
        DisplayFeatures df2 = new DisplayFeatures("5", Optional.empty());
        
        Mobile m1 = new Mobile(2929292, "iPhone", "Apple", Optional.of(df1));
        Mobile m2 = new Mobile(2929293, "Galaxy", "Samsung", Optional.of(df2));
        
        System.out.println(ms.getMobileScreenWidth(Optional.of(m1)));
        System.out.println(ms.getMobileScreenWidth(Optional.of(m2)));
    }
}

class MobileService {
    public Integer getMobileScreenWidth(Optional<Mobile> mobile) {
        return mobile
                .flatMap(Mobile::getDisplayFeature)
                .flatMap(DisplayFeatures::getResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0)
                ;
    }
}