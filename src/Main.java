public class Main {
    public static void main(String[] args) {
        //задание №2
        int i = 120;
        long l = 923L;
        double d = 1.1283789;
        float f = 1.234234f;
        byte b = 12;
        short s = 643;
        boolean bool = true;
        char c = '4';

        //задание №3
        System.out.println(getResult(3.5f, 5.89f, 6, 3));

        //задание №4
        System.out.println(getCorrect(13, -4));

        //задание №5
        getTypeNumber(1);

        //задание №6
        System.out.println(isNegativeNumber(-3));

        //Задание №7
        printHello("Владимир");

        //Задание №8
        leapYear((short) 2000);
    }

    //задание №3
    //Возращаю double чтобы не урезать значение
    public static double getResult(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //задание №4
    public static boolean getCorrect(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //задание №5
    public static void getTypeNumber(int a) {
        //решил сделать два варианта (на всякий :))
        if (a >= 0)
            System.out.println("Число положительное");
        else System.out.println("Число отрицательное");

        System.out.println(a >= 0 ? "Число положительное" : "Число отрицательное");
    }

    //задание №6
    public static boolean isNegativeNumber(int a) {
        return a < 0;
    }

    //задание №7
    public static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //задание №8
    public static void leapYear(short year) {

        if((year % 100 != 0 && year % 4 == 0) || year % 400 == 0)
            System.out.println("Високосный");
        else System.out.println("Невисокосный");

        System.out.println((year % 100 != 0 && year % 4 == 0) || year % 400 == 0 ? "Високосный" : "Невисокосный");
    }
}
