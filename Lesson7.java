/**
 * java.level1.lesson2 example of homework
 *
 *
 * @auphtor Isaeva Amina
 * @version dated June 22,2019
 */

public class Lesson_7 {
    public static void main(String[] args) {

        Cat[] cats = {new Cat("Barsik", 10, false), new Cat("Vasya", 18, false)};
        Plate plate = new Plate(15);
        for (Cat cat : cats){
            cat.eat(plate);
            if (cat.isFull()) {
                System.out.println("Кот наелся "+ cat.name);
            }
        }


    }
}
class Cat {
    public String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate) {
         full = plate.dicreaseFood(appetite);
    }
    boolean isFull(){return full;}

}

class Plate {
    private int food;


    Plate(int food) {
        this.food = food;
    }

    boolean dicreaseFood(int food) {
        if (food < this.food) {
            this.food -= food;
            return true;
        } else {return false;}
    }

}