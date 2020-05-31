package FiveOneWork;

import java.util.ArrayList;
import java.util.List;

/**
 * 2、创建一个Case类，有id、name、apiId三个私有属性。
 * 创建Case类5个对象，存储到ArrayList集合中。
 * 循环判断集合中是否有apiId =3的元素，如果有存储到另外一个ArrayList集合对象wantList中。
 * 最后遍历输出wantList。
 */

public class TwelfthWork {
    public static void main(String[] args) {
        //创建Case类5个对象，存储到ArrayList集合中
        Case case1 = new Case(1, "case1", 1);
        Case case2 = new Case(2, "case2", 2);
        Case case3 = new Case(3, "case3", 3);
        Case case4 = new Case(4, "case4", 4);
        Case case5 = new Case(5, "case5", 3);

        List<Case> list1 = new ArrayList<>();
        list1.add(case1);
        list1.add(case2);
        list1.add(case3);
        list1.add(case4);
        list1.add(case5);

        //循环判断集合中是否有apiId =3的元素，如果有存储到另外一个ArrayList集合对象wantList中
        List<Case> wantList = new ArrayList<>();
        for (Case c : list1){
            if (c.getApiLd() == 3){
                wantList.add(c);
            }
        }

        //遍历wantList集合
        for (Case c : wantList){
            System.out.println(c);
        }
    }
}



//创建一个Case类
class Case{
    private int id;
    private String name;
    private int apiLd;

    public Case(int id, String name, int apiLd) {
        this.id = id;
        this.name = name;
        this.apiLd = apiLd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getApiLd() {
        return apiLd;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apiLd=" + apiLd +
                '}';
    }
}
