package hw3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        selectionOfGames();

    }

    /**
     * Метод предоставляет выбор одной из двух игр на выбор.
     */
    public static void selectionOfGames() {

        int selected;

        do {

            selected = showMessageInt("Выберите игру", "1 - Угадай число | 2 - Угадай слово | 3 - Выйти");

        } while (selected <= 0 || selected >= 4);

        System.out.println();

        if (selected == 1) {
            firstGame();
        } else if (selected == 2) {
            secondGame();
        } else {
            System.out.println("Пока");
        }
    }

    /**
     * Метод спрашивает пользователя хочет ли он повторить игру.
     *
     * @param numberOfGame номер выбранной пользователем игры
     */
    public static void repeatGame(int numberOfGame) {

        int selected;
        do {

            selected = showMessageInt("Вы хотите повторить игру?", "1 - Да | 2 - Нет");

        } while (selected <= 0 || selected >= 3);

        System.out.println();

        if (selected == 1) {

            if (numberOfGame == 1) {
                firstGame();
            } else if (numberOfGame == 2) {
                secondGame();
            }

            return;
        }
        selectionOfGames();

    }

    /**
     * Метод выводит массив messages в консоль и
     * возвращает введенное пользователем число.
     *
     * @param messages массив строк
     */
    public static int showMessageInt(String... messages) {

        for (String s : messages) {
            System.out.println(s);
        }

        try {
            return scanner.nextInt();
        } catch (Exception e){
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Метод выводит массив messages в консоль и
     * возвращает введенную пользователем строку.
     *
     * @param messages массив строк
     */
    public static String showMessageLn(String... messages) {

        for (String s : messages) {
            System.out.println(s);
        }

        return scanner.nextLine();
    }

    /**
     * Метод первой игры.
     */
    public static void firstGame() {
        int hiddenNumber = random.nextInt(10);
        int attempt = 2;

        int numberOfPlayer = showMessageInt("Я загадал число от 0 до 9, попробуй угадать его!", "Если ты введешь не только числа или числа, не входящие в диапазон от 0 до 9, то это будет засчитано за неправильную на попытку");

        while (numberOfPlayer != hiddenNumber && attempt != 0) {

            numberOfPlayer = showMessageInt(String.format("Загаданное число %s введенного", numberOfPlayer > hiddenNumber ? "меньше" : "больше"),
                    String.format("Осталось попыток: %d", attempt));

            attempt--;

        }

        System.out.printf("Ты %s%n%n", numberOfPlayer == hiddenNumber ? "выйграл :)" : "проиграл :(");

        repeatGame(1);
    }

    /**
     * Метод второй игры.
     */
    public static void secondGame() {

        int attempt = 1;

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String hiddenWord = words[random.nextInt(words.length)];

        scanner.nextLine();

        String word = showMessageLn("Я загадал слово, попробуй угадать его!", "Чтобы выйти набери \"exit\"").toLowerCase();

        while (!word.equals(hiddenWord) && !word.equals("exit")) {

            int count = Math.min(word.length(), hiddenWord.length());

            StringBuilder mes = new StringBuilder();

            for (int i = 0; i < count; i++) {
                if (word.charAt(i) == hiddenWord.charAt(i)) {
                    mes.append(word.charAt(i));
                } else {
                    mes.append("#");
                }
            }

            System.out.println(String.format("%-20s", mes).replaceAll(" ", "#"));

            word = showMessageLn("Попробуй еще раз!", "Чтобы выйти набери \"exit\"").toLowerCase();

            attempt++;

        }

        System.out.println(!word.equals("exit") ? String.format("Ты выйграл!%nКол-во попыток: %d%n", attempt): "");

        repeatGame(2);

    }
}