public class Application {
    public static void main(String[] args) {
        double start, end, h, fl, fr, fc, f2;
        start = 6; // начальная точка
        end = 7; // конечная точка
        h = 0.2; // шаг, с которым вычисляем производную
        // приближенно вычисляем первую производную различными способами
        System.out.print("|Число  || Левая производная  ||Правая производная  ||Центральная производная||Вторая производная||");
        System.out.println();
        for (double i = start; i <= end; i += h) {
            i = Round(i);
            System.out.print("| " + i + "  |");
            {
                if (i != start) {
                    fl = (CalcExpression(i) - CalcExpression(i - h)) / h; // левая
                    System.out.print("| " + fl + " |");
                } else System.out.print("|                    |");
                if (i != end) {
                    fr = (CalcExpression(i + h) - CalcExpression(i)) / h; // правая
                    System.out.print("| " + fr + " |");
                } else System.out.print("|                    |");
                if (i == start || i == end) {
                    System.out.print("|                    ||                || ");
                } else {
                    fc = (CalcExpression(i + h) - CalcExpression(i - h)) / (2 * h); // центральная
                    System.out.print("| " + fc + " |");
                    // приближенно вычисляем вторую производную
                    f2 = (CalcExpression(i + h) - 2 * CalcExpression(i) + CalcExpression(i - h)) / (h * h);
                    System.out.print("| " + f2 + " ||");
                }
                System.out.println();

            }
        }
    }

    public static double CalcExpression(double x) {
        return x * Math.exp(x) + x;
    }

    public static double Round(double x) {
        x = x * 1000;
        int i = (int) Math.round(x);
        return (double) i / 1000;
    }
}
