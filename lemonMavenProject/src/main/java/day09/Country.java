package day09;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 下午 01:47 20/04/28
 * @Modified By:
 */
public class Country {
    private String name;
    private Set<Province> provinces;

    public Country() {
    }

    public Country(String name, Set<Province> provinces) {
        this.name = name;
        this.provinces = provinces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

}
