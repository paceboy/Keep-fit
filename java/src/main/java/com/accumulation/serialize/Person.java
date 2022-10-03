package com.accumulation.serialize;

/**
 * @author : liushaogeng
 * create at:  2021/1/30
 * @description:
 */
import java.io.Serializable;

public class Person  implements Serializable {

    private int age;
    // private String name;
    //序列化ID
    private static final long serialVersionUID = -5809782578272943999L;

    public Person() {}

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }

}
