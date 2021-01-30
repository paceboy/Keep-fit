package com.interview.Serialize;

/**
 * @author : liushaogeng
 * create at:  2021/1/30
 * @description: java序列化和反序列化以及序列化ID的作用分析 https://blog.csdn.net/baidu_37107022/article/details/76860371?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjSerializeAndDeserializeTest {
    private static final String file = "/Users/liushaogeng/baidu/test/hello.txt";
    public static void main(String[] args) {

        //将Person对象序列化
        // SerializePerson();

        //反序列化生成Person对象
        Person person=DeserializePerson();
        // System.out.println("name :"+person.getName());
        // System.out.println("age  :"+person.getAge());
    }

    /**
     *
     * @Title: 序列化Person对象，将其存储到 E:/hello.txt文件中
     * @param
     * @return void
     * @throws
     */
    private static void SerializePerson() {
        Person person =new Person();
        person.setAge(30);
        // person.setName("SerializePerson");
        ObjectOutputStream outputStream = null;
        try {
            outputStream=new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(person);
            System.out.println("序列化成功。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行反序列化过程生产Person对象
     * @Title: DeserializePerson
     * @param @return
     * @return Person
     * @throws
     */
    private static Person DeserializePerson() {

        Person person=null;
        ObjectInputStream inputStream=null;
        try {
            inputStream=new ObjectInputStream(new FileInputStream(file));
            try {
                person=(Person)inputStream.readObject();
                System.out.println("执行反序列化过程成功。");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return person;
    }
}
