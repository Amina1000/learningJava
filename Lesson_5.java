/**
 * java.level1.lesson2 example of homework
 *
 *
 * @auphtor Isaeva Amina
 * @version dated June 15,2019
 */

class Lesson_5 {
   public static void main(String[] args){

       /**
        * 4. Создать массив из 5 сотрудников.
        */
       Person[] persArray = new Person[5];
       persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
                                 30000, 30);
       persArray[1] = new Person("Isaev Oleg", "Programmer", "isaevol@mailbox.com", "892312318",
                                 180000.25, 42);
       persArray[2] = new Person("Sergeeva Elena", "Accountant", "sergeeva@mailbox.com", "892412318",
               150000.40, 45);
       persArray[3] = new Person("Kudrin Evgeniy", "Manager", "kudrin@mailbox.com", "892418318",
               130000.10, 25);
       persArray[4] = new Person("Mihaylov Grigoryi", "Manager", "mihaylov@mailbox.com", "892418818",
               120000.45, 43);
       persArray[4].setName("Mihaylova Maria");
       /**
        * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        */
       for (int i =0; i < persArray.length; i++){
           if (persArray[i].getAge()>40){
               persArray[i].info();
           }

       }

   }
}

/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 */
class Person{
 private String name;
 private String position;
 private String email;
 private String phone;
 private double salary;
 private int    age;

    public Person() {

    }

    /**
     * 2.Конструктор класса должен заполнять эти поля при создании объекта.
     *
     * @param name
     * @param position
     * @param email
     * @param phone
     * @param salary
     * @param age
     */
    public Person(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
     * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     */
    public void info() {
        System.out.println("Информация о сотруднике " + name +":");
        System.out.println(" Должность - "+ position);
        System.out.println(" Возвраст - "+ age);
        System.out.println(" Доход - " + salary);
        System.out.println(" Контактная информация: телефон - "+ phone + "; email - " + email+".");
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }
}