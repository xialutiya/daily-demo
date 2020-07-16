package xilalu.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private List<String> lists;

    public Person() {
        this.lists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}
