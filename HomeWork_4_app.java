package geekbrains.Lesson_4.App;
/**
 * java.level1.lesson2 example of homework
 *
 *
 * @auphtor Isaeva Amina
 * @version dated June 11,2019
 */
import java.util.*;


public class Lesson4_app {

    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char [][] map;
    Scanner sc;
    Random rand;

    public static void main(String[] args) {
	// write your code here
        new Lesson4_app().game();

    }
    Lesson4_app() {
        map = new char[SIZE][SIZE];
        rand = new Random();
        sc = new Scanner(System.in);}

    void game() {
        initMap();
        while (true) {
            printMap();
            humanTurn();
            if (checkwin(DOT_X)) {
                System.out.println("U won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry iray!");
                break;
            }
            turnAI();
            if (checkwin(DOT_O)) {
                System.out.println("AI won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry iray!");
                break;
            }

        }
        printMap();

    }

     void initMap(){

        for (int i = 0; i<SIZE; i++){
            for (int j = 0; j<SIZE;j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    void printMap(){
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println(" ");
        }
    }

    void humanTurn(){
        int x,y;
        do {
            System.out.println("Enter X space Y coord [1..3]:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x,y));
        map[x][y] = DOT_X;

    }

    boolean  checkwin(char dot) {
    /**
    * 2.Переделать проверку победы, чтобы она не была реализована просто набором условий,
    * например, с использованием циклов.
    * */
       if (checkdiagonals(dot)||checkLines((dot))) return true;
       else return false;
    }

    boolean checkLines(char dot) {
        // check horizontals and verticals
        boolean horizontal, vertical;
        for (int i = 0; i < SIZE; i++){
            horizontal = true;
            vertical = true;
            for (int j = 0; j < SIZE; j++){
                vertical   &= (map[i][j] == dot);
                horizontal &= (map[j][i] == dot);
            }
            return  (horizontal || vertical);
        }
        return false;
    }

    boolean checkdiagonals(char dot) {
        // check diagonals
        boolean diagonal1, diagonal2;
        diagonal1 = true;
        diagonal2 = true;
        for (int i = 0; i < SIZE; i++) {
            diagonal1 &= (map[i][i] == dot);
            diagonal2 &= (map[i][SIZE - i - 1] == dot);
        }
        return (diagonal1 || diagonal2);

    }

    boolean isMapFull(){
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
               if (map[i][j]==DOT_EMPTY){
                   return false;
               }
            }
        }
        return true;
    }

    void turnAI(){
        int x,y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x,y));
        map[x][y] = DOT_O;
    }

    boolean isCellValid(int x, int y){
        if (x<0||y<0||x>=SIZE||y>=SIZE){
            return false;
        }
        return map[x][y] == DOT_EMPTY;

    }
}
