package FiveOneWork;

/**
 * 4、有Student类公有属性name、age、score
 * a、创建5个Student对象存放在Student数组中
 * b、循环打印Student数组，输出学生的name、age、score
 * c、提供show(Student s),方法根据学生score输出对应语句 score小于60输出不及格，score大于等于60小于90输出及格，score大于等于90小于等于100输出优秀。
 */

public class FourthWork {
    public static void main(String[] args) {
        //创建5个Student对象存放在Student数组中
        Student[] studentArr = {new Student("张三",18,80),new Student("李四",19,90),new Student("王五",20,100)};
        for (Student s : studentArr){
            System.out.println("学生姓名："+s.getName()+", 年龄："+s.getAge()+", 分数："+s.getScore());
        }
        System.out.println("------------------------------------------");

        //show()方法调用
        System.out.println("show()方法调用");
        show(new Student("Peter",23,86));

    }

    //show()方法
    public static void show(Student s){
        int score = s.getScore();
        if (score<60)
            System.out.println("不及格！");
        else if (60<=score && score<90)
            System.out.println("及格。");
        else
            System.out.println("优秀！");
    }
}


//描述Student类
class Student{
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
