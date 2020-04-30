package code;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    @Test
    public  void fun01() {
//        //1.对象.getClass();
//        Student student = new Student();
//        Class clazz = student.getClass();
        //2.类.class
//        Class<Student> clazz1 = Student.class;
//3.Class.for("全限定名")
        try {
            Class clazz2 = Class.forName("code.Student");
            String simpleName = clazz2.getSimpleName();
            System.out.println(simpleName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fun02() throws Exception {
        Class<Student> clazz = Student.class;
        Constructor<Student> constructor = clazz.getConstructor(String.class, int.class, String.class, Date.class);
        Student student =(Student) constructor.newInstance("张三", 18, "男", new Date());
        System.out.println(student.getBirth());

    }
    @Test
    public void fun03() throws Exception {
        Class<Student> clazz = Student.class;
        Field[] fields = clazz.getFields();
        System.out.println(fields.length);
        Constructor<Student> constructor = clazz.getConstructor(String.class, int.class);
        Student student = constructor.newInstance("张三", 18);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student,"李四");
        System.out.println(student.getName());

    }
    @Test
    public void fun04() throws Exception {
        Class clazz = Class.forName("code.Student");
        Student student =(Student) clazz.newInstance();
        Method method = clazz.getDeclaredMethod("speak", String.class);
        method.setAccessible(true);
        method.invoke(student,"张鑫");
    }
    @Test
    public void fun05() throws Exception {
        Student student = new Student();
        Class clazz = student.getClass();
        Method main = clazz.getDeclaredMethod("main", String[].class);
        main.invoke(null,(Object)new String[]{"asd","asd","asd"});
    }
    @Test
    public void fun06() throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","林青霞");
        map.put("gender","女");
        map.put("age","38");
        map.put("address",new String[]{"唱歌","跳舞"});
        User1 user1 = new User1();
        System.out.println("封装前：" + user1);
        BeanUtils.populate(user1,map);
        System.out.println("封装后：" + user1);

    }
}
