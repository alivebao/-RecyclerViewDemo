package com.miao.administrator.recyclerviewdemo;

/**
 * Created by Administrator on 2015/10/29.
 */
public class Person {
    private int age;
    private String name;

    public Person() {

    }

    public Person(int i, String n) {
        age = i;
        name = n;
    }

    public void setAge(int i) {
        age = i;
    }

    public void setName(String s) {
        name = s;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
