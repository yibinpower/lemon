package day09;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 下午 01:49 20/04/28
 * @Modified By:
 */
public class Province {
    private String name;
    private String capital;

    public Province() {
    }

    public Province(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
