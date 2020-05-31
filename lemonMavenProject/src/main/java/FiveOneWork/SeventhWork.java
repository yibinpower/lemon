package FiveOneWork;

/**
 * 1、定义Person类，公有属性name、age、私有属性sex，公有方法play(),私有方法study()
 * a、编写Teacher继承Person，调用公有方法和属性会不会成功，调用私有方法和属性会不会成功。
 * b、编写JavaTeacher继承Teacher类，调用公有方法和属性会不会成功，调用私有方法和属性会不会成功。
 * c、在Teacher类中重写play方法，以多态的方式创建Teacher对象，调用play方法。
 */

public class SeventhWork {
    public static void main(String[] args) {
        /*
            a、编写Teacher继承Person，调用公有方法和属性会不会成功，调用私有方法和属性会不会成功。
         */
        Teacher teacher = new Teacher("Johne",32,"男");
        //调用公有的属性 成功
        System.out.println(teacher.name);
        System.out.println(teacher.age);
        //调用私有的属性 失败
//        System.out.println(teacher.sex);

        //调用公有方法 成功
        teacher.play();
        //调用私有方法 失败
//        teacher.study();
        System.out.println("----------------------");

        /*
            b、编写JavaTeacher继承Teacher类，调用公有方法和属性会不会成功，调用私有方法和属性会不会成功。
         */
        JavaTeacher javaTeacher = new JavaTeacher("Lily", 25, "女");
        //调用公有的属性 成功
        System.out.println(javaTeacher.name);
        System.out.println(javaTeacher.age);
        //调用私有的属性 失败
//        System.out.println(javaTeacher.sex);

        //调用公有方法 成功
        javaTeacher.play();
        //调用私有方法 失败
//        javaTeacher.study();
        System.out.println("----------------------");

        /*
            c、在Teacher类中重写play方法，以多态的方式创建Teacher对象，调用play方法
         */
        Person p = new Teacher("Caty",24,"sex");
        p.play();
        System.out.println("----------------------");
    }
}


//定义Person类
class Person{
    public String name;
    public int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void play(){
        System.out.println("Person在游戏。");
    }
    private void study(){
        System.out.println("Person在学习。");
    }
}


//编写Teacher继承Person
class Teacher extends Person{
    public Teacher(String name, int age, String sex) {
        super(name, age, sex);
    }

    //重写play方法
    @Override
    public void play() {
        System.out.println("Teacher在游戏。");
    }
}


//编写JavaTeacher继承Teacher类
class JavaTeacher extends Teacher{
    public JavaTeacher(String name, int age, String sex) {
        super(name, age, sex);
    }
}
