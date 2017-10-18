package com.company;

/**
 * Created by Настя on 16.10.2017.
 */
public class Simpson {

    public double f(double x) {
        return Math.pow(x, 2);
    }

    public double Integral(int n, double a, double b) {
        double sum = 0, sum2 = 0;
        double[] x = new double[n];
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            x[i] = a + i * h;
        }
        for (int i = 1; i < n; i++) {
            sum += f(x[i]);
            sum2 += f((x[i - 1] + x[i]) / 2);
        }
        return h / 6 * (f(a) + f(b) + 2 * sum + 4 * (sum2 + b));
    }

    public static void main(String[] args) {
        Simpson s = new Simpson();
        System.out.println(s.Integral(1000, 1, 4)); //задаю сама
        System.out.println("Разница с реальным значением: " + Math.abs(s.Integral(1000, 1, 4)-21));
    }

}