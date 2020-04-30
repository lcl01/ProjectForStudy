package code;

import java.lang.reflect.Method;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        Class<TestDemo> clazz = TestDemo.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            boolean flag = method.isAnnotationPresent(MyTest.class);
            if (flag) {
                method.invoke(clazz.newInstance());
            }
        }
    }
}
