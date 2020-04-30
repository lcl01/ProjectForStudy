import org.junit.Test;

public class Test01 {
    public static String str="safag";
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public void fun01(){
        System.out.println("hello");
    }
    @Test
    public void fun(){
        new Test02();
        System.out.println(Test02.fun());
    }
}
