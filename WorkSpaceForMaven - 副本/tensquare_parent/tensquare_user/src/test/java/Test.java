public class Test {
    @org.junit.Test
    public void test(){
        int i=10;
        if (i++==10) {
            ++i;
            --i;
        }
        System.out.println(i);
    }
}
