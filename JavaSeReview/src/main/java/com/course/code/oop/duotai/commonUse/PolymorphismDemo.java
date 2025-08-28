package com.course.code.oop.duotai.commonUse;

public class PolymorphismDemo {
    public static void main(String[] args) {
        AnimalKeeper animalKeeper = new AnimalKeeper();
        Animail dog = new Dog();// 父类引用指向子类对象
        Animail cat = new Cat();

        animalKeeper.makeAnimailSpeak(dog);//输出 dog speak
        animalKeeper.makeAnimailSpeak(cat);//cat speak
    }
}
