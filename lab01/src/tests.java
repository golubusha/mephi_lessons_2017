/**
 * Created by Настя on 04.10.2017.
 */
public class tests {
    public static void main (String[] args) {

        System.out.println("10 функций-тестов:");

        double eps = Math.pow(10, -3);
        double delta = Math.pow(10, -4);

        functions parabola = new parabola();//тест мин парабола
        double res1 = simmetricsearch.MinBisection(parabola, -3, 7, delta, eps);
        double res2 = simmetricsearch.MinGoldenSection(parabola, -3, 7, eps);
        System.out.println("1 деление пополам, min:" + res1);
        if (Math.abs(res1 - 0) >= eps) System.out.println("Ошибка");
        System.out.println("1 золотое сечение, min:" + res2);
        if (Math.abs(res2 - 0) >= eps) System.out.println("Ошибка");


        functions inversparabola = new inversparabola(); //тест мах инверт. парабола
        double res3 = simmetricsearch.MaxBisection(inversparabola, -2, 5, delta, eps);
        double res4 = simmetricsearch.MaxGoldenSection(inversparabola, -2, 5, eps);
        System.out.println("2 деление пополам, max:"+res3);
        if (Math.abs(res3 - 1) >= eps) System.out.println("Ошибка");
        System.out.println("2 золотое сечение, max:"+res4);
        if (Math.abs(res4 - 1) >= eps) System.out.println("Ошибка");

        functions function3 = new function3(); //тест мах и min инверт. парабола
        double res5 = simmetricsearch.MaxBisection(function3, -3, -0.5, delta, eps);
        double res6 = simmetricsearch.MaxGoldenSection(function3, -3, -0.5, eps);
        System.out.println("3 деление пополам, max:"+res5);
        if (Math.abs(res5 + 1.6334) >= eps) System.out.println("Ошибка");
        System.out.println("3 золотое сечение, max:"+res6);
        if (Math.abs(res6 + 1.6334) >= eps) System.out.println("Ошибка");
        double res7 = simmetricsearch.MinBisection(function3, 0, 1, delta, eps);
        double res8 = simmetricsearch.MinGoldenSection(function3, 0, 1, eps);
        System.out.println("3 деление пополам, min:"+res7);
        if (Math.abs(res7 - 1) >= eps) System.out.println("Ошибка");
        System.out.println("3 золотое сечение, min:"+res8);
        if (Math.abs(res8 - 1) >= eps) System.out.println("Ошибка");


        functions function4 = new function4 ();

        double res9 = simmetricsearch.MinBisection(function4, -5, -1, delta, eps);
        double res10 = simmetricsearch.MinGoldenSection(function4, -5, -1, eps);
        System.out.println("4 деление пополам, min:"+res9);
        if (Math.abs(res9 + 2.5) >= eps) System.out.println("Ошибка");
        System.out.println("4 золотое сечение, min:"+res10);
        if (Math.abs(res10 + 2.5) >= eps) System.out.println("Ошибка");


        functions function5 = new function5 ();

        double res11 = simmetricsearch.MinBisection(function5, 1, 5, delta, eps);
        double res12 = simmetricsearch.MinGoldenSection(function5, 1, 5, eps);
        System.out.println("5 деление пополам, min:"+res11);
        if (Math.abs(res11 - 3.415) >= eps) System.out.println("Ошибка");
        System.out.println("5 золотое сечение, min:"+res12);
        if (Math.abs(res12 - 3.415) >= eps) System.out.println("Ошибка");
        double res13 = simmetricsearch.MaxBisection(function5, -5, -1, delta, eps);
        double res14 = simmetricsearch.MaxGoldenSection(function5, -5, -1, eps);
        System.out.println("5 деление пополам, max:"+res13);
        if (Math.abs(res13 + 3.415) >= eps) System.out.println("Ошибка");
        System.out.println("5 золотое сечение, max:"+res14);
        if (Math.abs(res14 + 3.415) >= eps) System.out.println("Ошибка");


        functions function6 = new function6 ();

        double res15 = simmetricsearch.MinBisection(function6, 0, 2, delta, eps);
        double res16 = simmetricsearch.MinGoldenSection(function6, 0, 2, eps);
        System.out.println("6 деление пополам, min:"+res15);
        if (Math.abs(res15 - 1.023) >= eps) System.out.println("Ошибка");
        System.out.println("6 золотое сечение, min:"+res16);
        if (Math.abs(res16 - 1.023) >= eps) System.out.println("Ошибка");


        functions function7 = new function7 ();

        double res17 = simmetricsearch.MaxBisection(function7, 0, 2, delta, eps);
        double res18 = simmetricsearch.MaxGoldenSection(function7, 0, 2, eps);
        System.out.println("7 деление пополам, max:"+res17);
        if (Math.abs(res17 - 0.716) >= eps) System.out.println("Ошибка");
        System.out.println("7 золотое сечение, max:"+res18);
        if (Math.abs(res18 - 0.716) >= eps) System.out.println("Ошибка");



        functions function8 = new function8 ();

        double res19 = simmetricsearch.MinBisection(function8, 0, 2, delta, eps);
        double res20 = simmetricsearch.MinGoldenSection(function8, 0, 2, eps);
        System.out.println("8 деление пополам, min:"+res19);
        if (Math.abs(res19 - 1) >= eps) System.out.println("Ошибка");
        System.out.println("8 золотое сечение, min:"+res20);
        if (Math.abs(res20 - 1) >= eps) System.out.println("Ошибка");


        functions function9 = new function9 ();

        double res21 = simmetricsearch.MinBisection(function9, 0, -0.5, delta, eps);
        double res22 = simmetricsearch.MinGoldenSection(function9, 0, -0.5, eps);
        System.out.println("9 деление пополам, min:"+res21);
        if (Math.abs(res21 + 0.25) >= eps) System.out.println("Ошибка");
        System.out.println("9 золотое сечение, min:"+res22);
        if (Math.abs(res22 + 0.25) >= eps) System.out.println("Ошибка");


        functions function10 = new function10 ();

        double res23 = simmetricsearch.MaxBisection(function10, 0, 5, delta, eps);
        double res24 = simmetricsearch.MaxGoldenSection(function10, 0, 5, eps);
        System.out.println("10 деление пополам, max:"+res23);
        if (Math.abs(res23 - 2.601) >= eps) System.out.println("Ошибка");
        System.out.println("10 золотое сечение, max:"+res24);
        if (Math.abs(res24 - 2.601) >= eps) System.out.println("Ошибка");





    }
}
