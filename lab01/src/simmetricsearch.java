/**
 * Created by Настя on 02.10.2017.
 */
public class simmetricsearch {

    public static double MinBisection(functions Function, double a, double b, double delta, double eps) {
    while ((b - a) / 2 >= eps) {
        double x1 = ((a + b ) / 2) - delta;
        double x2 = ((a + b ) / 2) + delta;

        if (Function.f(x1) > Function.f(x2)) {
            a = x1;
        } else {
            b = x2;
        }
    }
    return (a + b) / 2;
}



    public static double MinGoldenSection(functions Function, double a, double b, double eps)
    {
        double phi = ((1 + Math.sqrt(5)) / 2);

        double x1 = b - (b - a) / phi;
        double x2 = a + (b - a) / phi;

        while ((b - a) / 2 >= eps) {
            if (Function.f(x1) > Function.f(x2)) {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
            } else {
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
            }
        }
        return (a + b) / 2;
    }



    public static double MaxBisection(functions Function, double a, double b, double delta, double eps) {
        while ((b - a) / 2 >= eps) {
            double x1 = ((a + b ) / 2) - delta;
            double x2 = ((a + b ) / 2) + delta;

            if (Function.f(x1) < Function.f(x2)) {
                a = x1;
            } else {
                b = x2;
            }
        }
        return (a + b) / 2;
    }



    public static double MaxGoldenSection(functions Function, double a, double b, double eps)
    {
        double phi = ((1 + Math.sqrt(5)) / 2);

        double x1 = b - (b - a) / phi;
        double x2 = a + (b - a) / phi;

        while ((b - a) / 2 >= eps) {
            if (Function.f(x1) < Function.f(x2)) {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
            } else {
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
            }
        }
        return (a + b) / 2;
    }
}

