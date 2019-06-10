package geekbrains.Lesson_3.App;

/**
 * java.level1.lesson2 example of homework
 *
 *
 * @auphtor Isaeva Amina
 * @version dated June 08,2019
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 */

public class Lesson_3_app {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        int play = 1;
        do {
            playLevel(play);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            play = scanner.nextInt();
        } while (play!=0);

    }

    /**
     * 1.
     * Написать программу, которая загадывает случайное число от 0 до 9 и
     * пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить,
     * больше ли указанное пользователем число, чем загаданное, или меньше.
     * @param play
     */
    private static void playLevel(int play) {
        if (play==1) {
            System.out.println("Угадайте число от 0 до 9: ");
            Random random = new Random();
            int randNum = random.nextInt(10);
            for (int i = 0; i < 3; i++) {

                int a = scanner.nextInt();
                if (a == randNum) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (a > randNum) {
                    System.out.println("Загаданное число меньше заданного!");
                } else {
                    System.out.println("Загаданное число больше заданного!");
                }
            }
        }
    }
}
