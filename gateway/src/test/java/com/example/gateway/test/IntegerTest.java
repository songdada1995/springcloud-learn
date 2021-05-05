package com.example.gateway.test;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = -100, b = -100, c = 150, d = 150;

        System.out.println(a == b);
        System.out.println(c == d);

        System.out.println(Demo.a);

        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        demo1.setA(3);
        demo2.setA(4);

        System.out.println(demo1.getA());
        System.out.println(demo2.getA());
    }


}
