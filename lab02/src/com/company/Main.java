package com.company;

public class Main
{
        double f(double x, int count) //Подынтегральная функция
    {
        switch (count)
        {
            case 1: return Math.pow(x, 4)-1;
            case 2: return Math.cos(x +3);
            case 3: return 5*Math.pow(x,-2);
            default:return Math.pow(x, 2);
        }
    }
//Весь участок [a,b] делим на n равных частей

    public double Rectangle(double a, double b, int n, int count )
    {

        double result = 0;
        double h = (b - a) / n; //шаг разбиения отрезка [a;b].

        for(int i = 0; i < n; i++)
        {
            result += f(a + h*(i + 0.5), count); //Определяем значение yi подынтегральной функции f(x) в каждой части деления.
        }
        result *= h; //результат (высоту) домножить на ширину
        return result;
    }

    public double Simpson(double a, double b, int n, int count) {
        double sum = 0, sum2 = 0;
        double[] x = new double[n];
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            x[i] = a + i * h;
        }
        for (int i = 1; i < n; i++) {
            sum += f(x[i], count);
            sum2 += f((x[i - 1] + x[i]) / 2, count);
        }
        return h / 6 * (f(a, count) + f(b, count) + 2 * sum + 4 * (sum2 + b));// заменили функцию интерполяционным полиномом второй степени. делим на 6 так как в 2 раза больше точек.
    }

    public double Trapeze(double a, double b, int n, int count)
    {
        double x = 0;
        double sum = 0;
        double result = 0;
        double h = (b - a) / n; //шаг разбиения отрезка [a;b].

        for(int i = 1; i < n; i++)
        {
            x = a + i * h;
            sum += f(x, count);
        }
        result = h*((f(a, count)+f(b, count))/2 + sum); //результат (высоту) домножить на ширину
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        Main m = new Main();
        System.out.println("Интеграл по методу прямоугольника: " + m.Rectangle(1, 4, 1000, 0));
        System.out.println("Интеграл по методу трапеции: " + m.Trapeze(1, 4, 1000,0));
        System.out.println("Интеграл по методу Симпсона: " + m.Simpson(1, 4, 1000,0));
        System.out.println("Разница с реальным значением по методу прямоугольника: " + Math.abs(m.Rectangle(1, 4, 1000,0)-21));
        System.out.println("Разница с реальным значением по методу трапеции: " + Math.abs(m.Trapeze(1, 4, 1000,0)-21));
        System.out.println("Разница с реальным значением по методу Симпсона: " + Math.abs(m.Simpson(1, 4, 1000,0)-21));
    }
}




