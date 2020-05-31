package FiveOneWork;

/**
 * 2、编写Animal动物类，公有方法say()。 有Fox、Pig、Cow三个子类都重写了say方法。 其中Fox有特有方法eat方法。 a、多态创建Fox对象。调用say()方法。 b、使用向下转型，调用Fox对象的特有eat()。
 */

public class EighthWork {
    public static void main(String[] args) {
        //a、多态创建Fox对象。调用say()方法。
        Animal a = new Fox();
        a.say();

        // b、使用向下转型，调用Fox对象的特有eat()。
        Fox f = (Fox)a;
        f.eat();
    }
}


//编写Animal动物类
class Animal{
    public void say(){
        System.out.println("Animal说话。");
    }
}


//子类Fox继承Animal并重写say方法
class Fox extends Animal{
    @Override
    public void say() {
        System.out.println("Fox说话。");
    }

    public void eat(){
        System.out.println("Fox吃东西。");
    }
}

//子类Pig继承Animal并重写say方法
class Pig extends Animal{
    @Override
    public void say() {
        System.out.println("Pig说话。");
    }
}

//子类Cow继承Animal并重写say方法
class Cow extends Animal{
    @Override
    public void say() {
        System.out.println("Cow说话。");
    }
}