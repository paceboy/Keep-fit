package com.interview.Serialize;

/**
 * @author : liushaogeng
 * create at:  2021/1/30
 * @description:
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * 测试序列化和反序列化
 * @author crazyandcoder
 * @date [2015-8-5 上午11:16:14]
 */
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
     * @author crazyandcoder
     * @Title: 序列化Person对象，将其存储到 E:/hello.txt文件中
     * @param
     * @return void
     * @throws
     * @date [2015-8-5 上午11:21:27]
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
     * @author crazyandcoder
     * @Title: DeserializePerson
     * @param @return
     * @return Person
     * @throws
     * @date [2015-8-5 下午1:30:12]
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
