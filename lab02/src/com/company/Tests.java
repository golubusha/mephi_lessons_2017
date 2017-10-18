package com.company;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void testR1() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(-4, 4, 1000, 1);


        System.out.println("Интеграл по методу прямоугольника f1:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(-4, 4, 1000, 1) - 401.6) <= eps);
    }


    @Test
    public void testT1() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Trapeze(-4, 4, 1000, 1);


        System.out.println("Интеграл по методу трапеции f1:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(-4, 4, 1000, 1) - 401.6) <= eps);
    }


    @Test
    public void testS1() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Simpson(-4, 4, 1000, 1);


        System.out.println("Интеграл по методу Симпсона f1:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(-4, 4, 1000, 1) - 401.6) <= eps);
    }

    @Test
    public void testR2() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(2, 6, 1000, 2);


        System.out.println("Интеграл по методу прямоугольника f2:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(2, 6, 1000, 2) - 1.3710) <= eps);
    }


    @Test
    public void testT2() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Trapeze(2, 6, 1000, 2);


        System.out.println("Интеграл по методу трапеции f2:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(2, 6, 1000, 2) - 1.3710) <= eps);
    }

    @Test
    public void testS2() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(2, 6, 1000, 2);


        System.out.println("Интеграл по методу Симпсона f2:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(2, 6, 1000, 2) - 1.3710) <= eps);
    }


    @Test
    public void testR3() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(1, 4, 1000, 3);


        System.out.println("Интеграл по методу прямоугольника f3:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(1, 5, 1000, 3) - 4) <= eps);
    }


    @Test
    public void testT3() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(1, 4, 1000, 3);


        System.out.println("Интеграл по методу трапеции f3:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(1, 5, 1000, 3) - 4) <= eps);
    }


    @Test
    public void testS3() {

        Main m = new Main();

        double eps = 0.4;
        double result = m.Rectangle(1, 4, 1000, 3);


        System.out.println("Интеграл по методу Симпсона f3:" + result);

        Assert.assertTrue(Math.abs(m.Rectangle(1, 5, 1000, 3) - 4) <= eps);
    }
}

