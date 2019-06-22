/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

/**
 *
 * @author sandeepkumar
 */
public class ITest {

    public static void main(String...args) {
        MA ob1 = new MA();
        boolean b1 = ob1 instanceof MH;

        MH ob2 = new MH();
        boolean b2 = ob2 instanceof MA;

        NG ob3 = new NG();
        boolean b3 = ob3 instanceof MA;

        NG ob4 = null;
        boolean b4 = ob4 instanceof MA;

        boolean b5 = ob1 instanceof Object;
        
        //boolean b6 = ob1 instanceof java.lang.Integer;
        
        
        System.out.println("" + b1 + b2 + b3 + b4 + b5);

    }
}


class MA {}

class MB extends MA {}
class MC extends MB {}
class MD extends MC {}
class ME extends MD {}
class MF extends ME {}
class MG extends MF {}
class MH extends MG {}


class NB extends MA {}
class NC extends NB {}
class ND extends NC {}
class NE extends ND {}
class NF extends NE {}
class NG extends NF {}
class NH extends NG {}
