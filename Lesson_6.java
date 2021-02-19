/**
 * java.level1.lesson2 example of homework
 *
 *
 * @auphtor Isaeva Amina
 * @version dated June 22,2019
 */
public class Lesson_6 {
    public static void main(String[] args) {
        Animals[] animals = {new Cat(250, 2,4.2), new Dog(400, 0.5f, 10,5)};
        for (Animals animal : animals)
        /**
         * 4. При попытке животного выполнить одно из этих действий,
         *  оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
         */
            System.out.println(
                    animal.getClass().getName() +
                    "\r\nrun: " + animal.run(200) +
                    "\r\njump: " + animal.jump(1.5f) +
                    "\r\nswim: " + animal.swim(5) +
                    "\r\nsleep:" + animal.sleep(5));
    }


}
/**
 *  2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
 *  В качестве параметра каждому методу передается величина, означающая или длину препятствия
 *  (для бега и плавания), или высоту (для прыжков).
 */
interface Animals {
    boolean run(int distance);
    boolean jump(float height);
    boolean swim(int distance);
    boolean sleep (double time);
}
abstract class Animal implements Animals{
    protected int run_limit;
    protected float jump_limit;
    protected int swim_limit;
    protected double sleep_Limit;

    Animal(int run_limit, float jump_limit, int swim_limit, double sleep_Limit){
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
        this.swim_limit = swim_limit;
        this.sleep_Limit = sleep_Limit;
    }

    /**
     * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
     * прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
      * @param distance
     * @return
     */
    public boolean run(int distance) {
        return distance <= run_limit;
    }
    public boolean jump(float height)  {
        return height <= jump_limit;
    }
    public boolean swim(int distance) {
        return distance <= swim_limit;
    }
    public boolean sleep(double time){
        return time <= sleep_Limit;
    }

}

/**
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 */
class Cat extends Animal {

    Cat(int run_limit, float jump_limit, int swim_limit, double sleep_Limit) {
        super(run_limit, jump_limit, swim_limit, sleep_Limit);
    }
    Cat(int run_limit, float jump_limit, double sleep_Limit) {

        super(run_limit, jump_limit, -1, sleep_Limit);
    }
    @Override
    public boolean swim(int distance) {
        return false; // cats cannot swim (by the condition of task)
    }
}

class Dog extends Animal {
    Dog(int run_limit, float jump_limit, int swim_limit, double sleep_Limit) {

        super(run_limit, jump_limit, swim_limit, sleep_Limit);
    }
}