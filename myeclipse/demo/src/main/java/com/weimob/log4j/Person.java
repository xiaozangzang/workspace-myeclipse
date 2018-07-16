package com.weimob.log4j;

public class Person {
    //姓名
    private String name;
    //性别
    private char sex;
    //年龄
    private int age;

    //有参构造函数
    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //无惨构造函数
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char isSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}