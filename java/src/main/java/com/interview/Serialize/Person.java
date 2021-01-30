package com.interview.Serialize;

/**
 * @author : liushaogeng
 * create at:  2021/1/30
 * @description:
 */
import java.io.Serializable;

/**
 *
 * 测试序列化和反序列化
 * @author crazyandcoder
 * @date [2015-8-5 上午11:14:32]
 */
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
