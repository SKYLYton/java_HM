package hm2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String task = "Задание ";

        //-----------------------------------------------------------------------------------------
        //Задание №1
        System.out.println(task + 1);

        int[] arrInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = arrInt[i] == 0 ? 1 : 0;
        }

        System.out.println(Arrays.toString(arrInt));

        //-----------------------------------------------------------------------------------------
        //Задание №2
        System.out.println(task + 2);

        int[] arrInt2 = new int[8];

        for (int i = 0; i < arrInt2.length; i++) {
            arrInt2[i] = i * 3;
        }

        System.out.println(Arrays.toString(arrInt2));

        //-----------------------------------------------------------------------------------------
        //Задание №3
        System.out.println(task + 3);

        int[] arrInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arrInt3.length; i++) {
            if (arrInt3[i] < 6) {
                arrInt3[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(arrInt3));

        //-----------------------------------------------------------------------------------------
        //Задание №4
        System.out.println(task + 4);

        int[][] arrInt4 = new int[5][5];

        for (int i = 0; i < arrInt4.length; i++) {
            arrInt4[i][arrInt4.length - 1 - i] = 1;
            arrInt4[i][i] = 1;
        }

        printArray2d(arrInt4);

        //-----------------------------------------------------------------------------------------
        //Задание №5
        System.out.println(task + 5);

        int[] arrInt5 = new int[10];

        Random random = new Random();

        for (int i = 0; i < arrInt5.length; i++) {
            arrInt5[i] = random.nextInt(40) - 20;
        }

        int max = 0;
        int min = 0;

        for (int i = 0; i < arrInt5.length; i++) {
            if (arrInt5[max] < arrInt5[i]) {
                max = i;
            }

            if (arrInt5[min] > arrInt5[i]) {
                min = i;
            }
        }

        System.out.println(Arrays.toString(arrInt5));

        //не понял какой именно элемент нужен
        System.out.println("Максимальное число = " + arrInt5[max] + "\n" + "Минимальное число = " + arrInt5[min]);
        System.out.println("Индекс макс. числа = " + max + "\n" + "Индекс мин. числа = " + min);

        //-----------------------------------------------------------------------------------------
        //Задание №6
        System.out.println(task + 6);

        int[] arrInt6 = new int[10];

        for (int i = 0; i < arrInt6.length; i++) {
            arrInt6[i] = random.nextInt(10) - 5;
        }

        System.out.println(Arrays.toString(arrInt6));
        System.out.println(isEqualitySides(arrInt6));

        //-----------------------------------------------------------------------------------------
        //Задание №7
        System.out.println(task + 7);

        int[] arrInt7 = new int[10];

        for (int i = 0; i < arrInt7.length; i++) {
            arrInt7[i] = random.nextInt(10) - 5;
        }

        System.out.println(Arrays.toString(arrInt7));

        arrayOffset(arrInt7, 1);

        System.out.println(Arrays.toString(arrInt7));

    }

    //-----------------------------------------------------------------------------------------
    //Задание №4
    public static void printArray2d(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println(Arrays.toString(n[i]));
        }
    }

    //-----------------------------------------------------------------------------------------
    //Задание №6
    public static boolean isEqualitySides(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {

            //Как будет правильнее?
            //Два метода с массивом:

            int sumLeft = sumLeftSideArray(n, i);
            int sumRight = sumRightSideArray(n, i + 1);

            //Один метод с массивом:

            int[] arr = sumLeftRightSidesArray(n , i);

            sumLeft = arr[0];
            sumRight = arr[1];

            //Можно все в одном методе, но тогда метод будет делать несколько действий
/*
            for (int j = 0; j < n.length; j++) {
                if (j <= i) {
                    sumLeft += n[j];
                } else {
                    sumRight += n[j];
                }
            }
*/

            System.out.println(sumLeft + " " + sumRight);

            if (sumLeft == sumRight) {
                return true;
            }

        }
        return false;
    }

    public static int sumLeftSideArray(int[] n, int lastIndex) {
        int sumLeft = 0;

        for (int i = 0; i <= lastIndex; i++) {
            sumLeft += n[i];
        }

        return sumLeft;
    }

    public static int sumRightSideArray(int[] n, int firstIndex) {
        int sumRight = 0;

        for (int i = firstIndex; i < n.length; i++) {
            sumRight += n[i];
        }

        return sumRight;
    }

    public static int[] sumLeftRightSidesArray(int[] n, int index){
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < n.length; i++) {
            if (i <= index) {
                sumLeft += n[i];
            } else {
                sumRight += n[i];
            }
        }
        return new int[]{sumLeft, sumRight};
    }

    //-----------------------------------------------------------------------------------------
    //Задание №7
    public static void arrayOffset(int[] n, int count){

        int c = count;

        while (c != 0){
            int value = n[count > 0 ? n.length - 1 : 0];

            offsetByOneStep(n, count < 0);

            n[count > 0 ? 0 : n.length - 1] = value;

            c = count > 0 ? c - 1 : c + 1;

        }
    }

    public static void offsetByOneStep(int[] n, boolean isLeft){

        for (int i = 1; i < n.length; i++) {
            if(!isLeft) {
                n[n.length - i] = n[n.length - i - 1];
            } else {
                n[i - 1] = n[i];
            }
        }
    }

}
