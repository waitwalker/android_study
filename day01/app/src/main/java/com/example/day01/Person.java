package com.example.day01;

import android.util.Log;

public class Person {

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 构造方法
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    void info() {
        Dog dog = new Dog();
        dog.animalType();
        Log.d("1","name:"+ this.name + "\n" + "age:" + this.age);
    }
}

class Student {
    final int age;
    final String name;
    public Student(){
        this.age = 10;
        this.name = "张三";
    }
}

abstract class Animal {
    abstract void animalType();
}

class Dog extends Animal {
    @Override
    void animalType() {
        Log.d("123","animal is dog");
    }
}

interface Thing {
    public static final int AGE = 12;
    public int thingType();
}

// 接口
interface Nation {
    public String comeFrom();
}

class Boat extends Animal implements Thing, Nation {

    @Override
    void animalType() {

    }

    @Override
    public int thingType() {
        return 12;
    }

    @Override
    public String comeFrom() {
        return "China";
    }
}

class Father {
    public String money;

    void save() {

    }
}

class Son extends Father {

    void moneyCount() {
        Log.d("", "" + money);
    }

    @Override
    void save() {
        super.save();
    }
}
