package com.company;

import java.io.*;
import java.util.Date;


public class trapeze
{
    public static double InFunction(double x) //Подынтегральная функция
    {
        return Math.pow(x, 2);
    }
//Весь участок [a,b] делим на n равных частей

    public static double CalcIntegral(double a, double b, int n)
    {
        double x = 0;
        double sum = 0;
        double result = 0;
        double h = (b - a) / n; //шаг разбиения отрезка [a;b].

        for(int i = 1; i < n; i++)
        {
            x = a + i * h;
            sum += InFunction(x);
        }
        result = h*((InFunction(a)+InFunction(b))/2 + sum); //результат (высоту) домножить на ширину
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Date currentTime = new Date(); //начало отсчета  времени
        System.out.println("Введите кол-во интервалов разбиения:" );
        int n = Integer.parseInt(reader.readLine());
        double a = 1;
        double b = 4;
        System.out.println("Результат: "+ CalcIntegral(a,b,n));
        //Date newTime = new Date(); //закончили отсчет времени
        //long msDelay = newTime.getTime() - currentTime.getTime(); //вычислили разницу между начальным и конечным временем
        //System.out.println("Программа работала: " + msDelay + " миллисекунд");
    }
}